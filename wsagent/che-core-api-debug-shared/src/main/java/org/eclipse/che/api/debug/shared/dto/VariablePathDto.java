/**
 * ***************************************************************************** Copyright (c)
 * 2012-2017 Codenvy, S.A. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * <p>Contributors: Codenvy, S.A. - initial API and implementation
 * *****************************************************************************
 */
package org.eclipse.che.api.debug.shared.dto;

import java.util.List;
import org.eclipse.che.api.debug.shared.model.VariablePath;
import org.eclipse.che.dto.shared.DTO;

/** @author andrew00x */
@DTO
public interface VariablePathDto extends VariablePath {
  List<String> getPath();

  void setPath(List<String> path);

  VariablePathDto withPath(List<String> path);
}
