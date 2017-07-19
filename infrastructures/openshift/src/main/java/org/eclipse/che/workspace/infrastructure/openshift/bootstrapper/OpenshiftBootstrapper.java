/*******************************************************************************
 * Copyright (c) 2012-2017 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.workspace.infrastructure.openshift.bootstrapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.assistedinject.Assisted;

import org.eclipse.che.api.core.model.workspace.runtime.RuntimeIdentity;
import org.eclipse.che.api.core.notification.EventService;
import org.eclipse.che.api.installer.server.model.impl.InstallerImpl;
import org.eclipse.che.api.workspace.server.bootstrap.AbstractBootstrapper;
import org.eclipse.che.api.workspace.server.spi.InfrastructureException;
import org.eclipse.che.workspace.infrastructure.openshift.OpenshiftMachine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Bootstraps installers in openshift machine.
 *
 * @author Sergii Leshchenko
 */
public class OpenshiftBootstrapper extends AbstractBootstrapper {
    private static final Logger LOG = LoggerFactory.getLogger(OpenshiftBootstrapper.class);

    private static final Gson GSON = new GsonBuilder().disableHtmlEscaping()
                                                      .create();

    private static final String BOOTSTRAPPER_BASE_DIR = "/tmp/";
    private static final String BOOTSTRAPPER_DIR      = BOOTSTRAPPER_BASE_DIR + "bootstrapper/";
    private static final String BOOTSTRAPPER_FILE     = "bootstrapper";
    private static final String CONFIG_FILE           = "config.json";

    private final String              machineName;
    private final RuntimeIdentity     runtimeIdentity;
    private final List<InstallerImpl> installers;
    private final int                 serverCheckPeriodSeconds;
    private final int                 installerTimeoutSeconds;
    private final OpenshiftMachine    openshiftMachine;
    private final String              bootstrapperBinaryUrl;

    @Inject
    public OpenshiftBootstrapper(@Assisted String machineName,
                                 @Assisted RuntimeIdentity runtimeIdentity,
                                 @Assisted List<InstallerImpl> installers,
                                 @Assisted OpenshiftMachine openshiftMachine,
                                 @Named("che.infra.openshift.che_server_websocket_endpoint_base") String websocketBaseEndpoint,
                                 @Named("che.infra.openshift.bootstrapper_binary_url") String bootstrapperBinaryUrl,
                                 @Named("che.infra.openshift.bootstrapper.timeout_min") int bootstrappingTimeoutMinutes,
                                 @Named("che.infra.openshift.bootstrapper.installer_timeout_sec") int installerTimeoutSeconds,
                                 @Named("che.infra.openshift.bootstrapper.server_check_period_sec") int serverCheckPeriodSeconds,
                                 EventService eventService) {
        super(machineName, runtimeIdentity, bootstrappingTimeoutMinutes, websocketBaseEndpoint, eventService);
        this.bootstrapperBinaryUrl = bootstrapperBinaryUrl;
        this.machineName = machineName;
        this.runtimeIdentity = runtimeIdentity;
        this.installers = installers;
        this.serverCheckPeriodSeconds = serverCheckPeriodSeconds;
        this.installerTimeoutSeconds = installerTimeoutSeconds;
        this.openshiftMachine = openshiftMachine;
    }

    @Override
    protected void doBootstrapAsync(String installerWebsocketEndpoint,
                                    String outputWebsocketEndpoint) throws InfrastructureException {
        injectBootstrapper();

        openshiftMachine.exec("sh", "-c", BOOTSTRAPPER_DIR + BOOTSTRAPPER_FILE +
                                          " -machine-name " + machineName +
                                          " -runtime-id " + String.format("%s:%s:%s", runtimeIdentity.getWorkspaceId(),
                                                                          runtimeIdentity.getEnvName(),
                                                                          runtimeIdentity.getOwner()) +
                                          " -push-endpoint " + installerWebsocketEndpoint +
                                          " -push-logs-endpoint " + outputWebsocketEndpoint +
                                          " -server-check-period " + Integer.toString(serverCheckPeriodSeconds) +
                                          " -installer-timeout " + Integer.toString(installerTimeoutSeconds) +
                                          " -file " + BOOTSTRAPPER_DIR + CONFIG_FILE);
    }

    private void injectBootstrapper() throws InfrastructureException {
        LOG.info("Creating folder for bootstrapper");
        openshiftMachine.exec("mkdir", "-p", BOOTSTRAPPER_DIR);
        LOG.info("Downloading bootstrapper binary");
        openshiftMachine.exec("curl", "-o", BOOTSTRAPPER_DIR + BOOTSTRAPPER_FILE, bootstrapperBinaryUrl);
        openshiftMachine.exec("chmod", "+x", BOOTSTRAPPER_DIR + BOOTSTRAPPER_FILE);

        LOG.info("Creating bootstrapper config file");
        openshiftMachine.exec("sh", "-c", "cat > " + BOOTSTRAPPER_DIR + CONFIG_FILE + " << 'EOF'\n"
                                          + GSON.toJson(installers)
                                          + "\nEOF");
    }
}
