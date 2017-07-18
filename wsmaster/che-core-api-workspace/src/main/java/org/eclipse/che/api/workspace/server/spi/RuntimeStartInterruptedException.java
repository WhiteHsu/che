package org.eclipse.che.api.workspace.server.spi;

/**
 * @author Anton Korneta
 */
public class RuntimeStartInterruptedException extends InfrastructureException {

    public RuntimeStartInterruptedException(String workspaceId) {
        super(String.format("Workspace '%s' start is interrupted", workspaceId));
    }
}
