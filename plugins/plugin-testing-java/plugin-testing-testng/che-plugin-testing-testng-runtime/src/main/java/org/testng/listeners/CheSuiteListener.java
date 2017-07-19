/**
 * ***************************************************************************** Copyright (c)
 * 2012-2017 Codenvy, S.A. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * <p>Contributors: Codenvy, S.A. - initial API and implementation
 * *****************************************************************************
 */
package org.testng.listeners;

import org.testng.CheTestNGListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;

/**
 * {@link ISuiteListener} implementation, delegate all events to {@link
 * org.testng.CheTestNGListener}
 */
public class CheSuiteListener implements ISuiteListener {

  private final CheTestNGListener delegate;

  public CheSuiteListener(CheTestNGListener delegate) {
    this.delegate = delegate;
  }

  @Override
  public void onStart(ISuite suite) {
    delegate.onSuiteStart(suite);
  }

  @Override
  public void onFinish(ISuite suite) {
    delegate.onSuiteFinish(suite);
  }
}
