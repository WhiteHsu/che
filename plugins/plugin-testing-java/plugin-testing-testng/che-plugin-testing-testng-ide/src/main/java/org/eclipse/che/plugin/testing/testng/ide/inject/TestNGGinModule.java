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
package org.eclipse.che.plugin.testing.testng.ide.inject;

import com.google.gwt.inject.client.AbstractGinModule;

import org.eclipse.che.ide.api.extension.ExtensionGinModule;

/**
 *
 * @author Mirage Abeysekara
 */
@ExtensionGinModule
public class TestNGGinModule extends AbstractGinModule {
    @Override
    protected void configure() {
    }
}
