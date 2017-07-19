/**
 * ***************************************************************************** Copyright (c)
 * 2012-2017 Codenvy, S.A. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * <p>Contributors: Codenvy, S.A. - initial API and implementation
 * *****************************************************************************
 */
package org.eclipse.che.ide.workspace;

import javax.validation.constraints.NotNull;
import org.eclipse.che.ide.api.parts.PartStack;
import org.eclipse.che.ide.api.parts.PartStackView;

/**
 * Gin factory for PartStack
 *
 * @author Evgen Vidolob
 * @author Dmitry Shnurenko
 */
public interface PartStackPresenterFactory {
  /**
   * Creates new instance of {@link PartStack}. Each call of this method returns new object.
   *
   * @param view special view which is required for creating part stack
   * @param workBenchPartController controller which is used by part stack
   * @return an instance of {@link PartStack}
   */
  PartStack create(
      @NotNull PartStackView view, @NotNull WorkBenchPartController workBenchPartController);
}
