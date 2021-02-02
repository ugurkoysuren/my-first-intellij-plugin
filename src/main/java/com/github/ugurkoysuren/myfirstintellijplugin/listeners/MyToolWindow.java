// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.github.ugurkoysuren.myfirstintellijplugin.listeners;

import com.github.ugurkoysuren.myfirstintellijplugin.services.TextApiClient;
import com.intellij.openapi.wm.ToolWindow;
import javax.swing.*;

public class MyToolWindow {

  private JButton sendToolWindowButton;
  private JButton hideToolWindowButton;
  private JLabel textA;
  private JLabel textB;
  private JLabel textC;
  private JPanel myToolWindowContent;
  private JTextField jTextField;
  private TextApiClient textApiClient;

  public MyToolWindow(ToolWindow toolWindow) {
    hideToolWindowButton.addActionListener(e -> toolWindow.hide(null));
    sendToolWindowButton.addActionListener(e -> addOne());
    this.textApiClient = new TextApiClient();
    this.currentDateTime();
  }

  public void currentDateTime() {

    textA.setText("0");
    textB.setText("Test");
    textC.setText("Ugur");
  }

  public void addOne() {
    textA.setText(textApiClient.getRest());
  }

  public JPanel getContent() {
    return myToolWindowContent;
  }


}
