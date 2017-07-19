/**
 * ***************************************************************************** Copyright (c)
 * 2012-2017 Codenvy, S.A. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * <p>Contributors: Codenvy, S.A. - initial API and implementation
 * *****************************************************************************
 */
package org.eclipse.che.ide.ext.java.shared.dto;

import java.util.List;
import org.eclipse.che.dto.shared.DTO;

/** Result of Organize import request. */
@DTO
public interface OrganizeImportResult {

  /**
   * The list of organize imports conflicts.
   *
   * @return the organize import conflicts
   */
  List<ConflictImportDTO> getConflicts();

  void setConflicts(List<ConflictImportDTO> conflicts);

  /**
   * The changes that should be apply on organize imports
   *
   * @return the change list
   */
  List<Change> getChanges();

  void setChanges(List<Change> changes);
}
