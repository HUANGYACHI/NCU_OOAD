package Action;

import Button.ButtonBase;
import Layout.ButtonsPanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtonClicked extends MouseAdapter {

    public ButtonClicked() {
        super();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ButtonBase preButton = ButtonsPanel.getCurButton();
        ButtonBase curButton = (ButtonBase) e.getSource();

        if (preButton != null && preButton != curButton)
            preButton.setBackground(Color.white);

        curButton.setBackground(Color.DARK_GRAY);
        curButton.onClicked();

        ButtonsPanel.setCurButton(curButton);
    }

}
