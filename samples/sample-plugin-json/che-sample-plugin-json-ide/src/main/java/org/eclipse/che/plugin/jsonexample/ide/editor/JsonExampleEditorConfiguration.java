/**
 * ***************************************************************************** Copyright (c)
 * 2012-2017 Codenvy, S.A. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * <p>Contributors: Codenvy, S.A. - initial API and implementation
 * *****************************************************************************
 */
package org.eclipse.che.plugin.jsonexample.ide.editor;

import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.che.ide.api.editor.codeassist.CodeAssistProcessor;
import org.eclipse.che.ide.api.editor.editorconfig.DefaultTextEditorConfiguration;
import org.eclipse.che.ide.api.editor.partition.DocumentPartitioner;

public class JsonExampleEditorConfiguration extends DefaultTextEditorConfiguration {

  private Map<String, CodeAssistProcessor> codeAssist;

  public JsonExampleEditorConfiguration(
      JsonExampleCodeAssistProcessor jsonExampleCodeAssistProcessor) {
    codeAssist = new LinkedHashMap<>();

    codeAssist.put(DocumentPartitioner.DEFAULT_CONTENT_TYPE, jsonExampleCodeAssistProcessor);
  }

  @Override
  public Map<String, CodeAssistProcessor> getContentAssistantProcessors() {
    return codeAssist;
  }
}
