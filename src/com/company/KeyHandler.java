package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyHandler {

    public static void addKeyBinding(JComponent comp, int keyCode, String id, ActionListener actionListener,boolean release){
        InputMap im = comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = comp.getActionMap();

            im.put(KeyStroke.getKeyStroke(keyCode,0,release),id);
            am.put(id, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    actionListener.actionPerformed(e);
                }
            });
        }
}
