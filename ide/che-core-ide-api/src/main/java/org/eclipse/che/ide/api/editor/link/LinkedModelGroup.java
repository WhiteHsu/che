/**
 * ***************************************************************************** Copyright (c)
 * 2012-2017 Codenvy, S.A. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * <p>Contributors: Codenvy, S.A. - initial API and implementation
 * *****************************************************************************
 */
package org.eclipse.che.ide.api.editor.link;

import java.util.List;
import org.eclipse.che.ide.api.editor.text.Position;

/** @author Evgen Vidolob */
public interface LinkedModelGroup {

  void setData(LinkedModelData data);

  void setPositions(List<Position> positions);
}
