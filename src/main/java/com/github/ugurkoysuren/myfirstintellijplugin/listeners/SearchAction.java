package com.github.ugurkoysuren.myfirstintellijplugin.listeners;

import com.github.ugurkoysuren.myfirstintellijplugin.services.TextApiClient;
import com.intellij.ide.BrowserUtil;
import com.intellij.lang.Language;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;

import javax.swing.*;

public class SearchAction extends AnAction {
    /**
     * Convert selected text to a URL friendly string.
     * @param e
     */
    @Override
    public void actionPerformed(AnActionEvent e)
    {
        final Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        CaretModel caretModel = editor.getCaretModel();

        // For searches from the editor, we should also get file type information
        // to help add scope to the search using the Stack overflow search syntax.
        //
        // https://stackoverflow.com/help/searching

        JButton testButton = new JButton();
        testButton.addActionListener(actionEvent -> {
            if (new SampleDialogWrapper().showAndGet()) {
                // user pressed OK
            }
        });

        String languageTag = "";
        PsiFile file = e.getData(CommonDataKeys.PSI_FILE);
        if(file != null)
        {
            Language lang = e.getData(CommonDataKeys.PSI_FILE).getLanguage();
            languageTag = "+[" + lang.getDisplayName().toLowerCase() + "]";
        }

        // The update method below is only called periodically so need
        // to be careful to check for selected text
        if(caretModel.getCurrentCaret().hasSelection())
        {
            String query = caretModel.getCurrentCaret().getSelectedText().replace(' ', '+') + languageTag;
            BrowserUtil.browse("https://stackoverflow.com/search?q=" + query);
        }
    }

    /**
     * Only make this action visible when text is selected.
     * @param e
     */
    @Override
    public void update(AnActionEvent e)
    {
        final Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        CaretModel caretModel = editor.getCaretModel();
        e.getPresentation().setEnabledAndVisible(caretModel.getCurrentCaret().hasSelection());
    }
}
