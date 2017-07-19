/**
 * ***************************************************************************** Copyright (c)
 * 2012-2017 Codenvy, S.A. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * <p>Contributors: Codenvy, S.A. - initial API and implementation
 * *****************************************************************************
 */
package org.eclipse.che.ide.terminal;

import com.google.gwt.core.client.JavaScriptObject;

/** @author Alexander Andrienko */
public class TerminalGeometryJso extends JavaScriptObject {

  protected TerminalGeometryJso() {}

  public final native int getCols() /*-{
        return this.cols;
    }-*/;

  public final native int getRows() /*-{
        return this.rows;
    }-*/;
}
