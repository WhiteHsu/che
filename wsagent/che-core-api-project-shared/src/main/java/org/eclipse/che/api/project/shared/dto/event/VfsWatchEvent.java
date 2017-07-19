/**
 * ***************************************************************************** Copyright (c)
 * 2012-2017 Codenvy, S.A. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * <p>Contributors: Codenvy, S.A. - initial API and implementation
 * *****************************************************************************
 */
package org.eclipse.che.api.project.shared.dto.event;

import org.eclipse.che.api.core.notification.EventOrigin;
import org.eclipse.che.dto.shared.DTO;

/** @author gazarenkov */
@EventOrigin("vfs")
@DTO
public interface VfsWatchEvent {

  String VFS_CHANNEL = "vfs";

  String getPath();

  VfsWatchEvent withPath(String path);

  FileWatcherEventType getType();

  VfsWatchEvent withType(FileWatcherEventType type);

  boolean isFile();

  VfsWatchEvent withFile(boolean isFile);
}
