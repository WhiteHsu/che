/**
 * ***************************************************************************** Copyright (c)
 * 2012-2017 Codenvy, S.A. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * <p>Contributors: Codenvy, S.A. - initial API and implementation
 * *****************************************************************************
 */
package org.eclipse.che.ide.command.toolbar.commands.button;

import org.eclipse.che.api.core.model.machine.Machine;
import org.eclipse.che.ide.api.command.CommandGoal;
import org.eclipse.che.ide.api.command.CommandImpl;
import org.eclipse.che.ide.ui.menubutton.MenuItem;

/** Factory for {@link MenuItem}s for {@link ExecuteCommandButton}. */
public interface MenuItemsFactory {

  GuideItem newGuideItem(CommandGoal goal);

  CommandItem newCommandItem(CommandImpl command);

  MachineItem newMachineItem(CommandImpl command, Machine machine);

  MachineItem newMachineItem(MachineItem item);
}
