/**
 * ***************************************************************************** Copyright (c)
 * 2012-2017 Codenvy, S.A. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * <p>Contributors: Codenvy, S.A. - initial API and implementation
 * *****************************************************************************
 */
package org.eclipse.che.api.debug.shared.model.action;

import java.util.List;
import org.eclipse.che.api.debug.shared.model.Breakpoint;

/** @author Anatoliy Bazko */
public interface StartAction extends Action {
  List<? extends Breakpoint> getBreakpoints();
}
