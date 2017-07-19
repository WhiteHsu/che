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
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

/**
 * Listener for invoking before and after method actions by TestNG. This listener will only be
 * invoked for configuration and test methods.
 */
public class CheInvokedMethodListener implements IInvokedMethodListener {

  private final CheTestNGListener delegate;

  public CheInvokedMethodListener(CheTestNGListener delegate) {
    this.delegate = delegate;
  }

  @Override
  public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
    synchronized (delegate) {
      if (!testResult.getMethod().isTest()) {
        delegate.onConfigurationStart(testResult);
      }
    }
  }

  @Override
  public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
    //ignore
  }
}
