package Layout;

import javax.swing.*;

import Button.*;
import Factory.Factory;

public class ButtonsPanel extends JPanel {

    static ButtonBase curButton = null;
    public ButtonsPanel() {
        setLayout(Factory.setGridLayout());

        for (int i = 0; i < Factory.gridRows; i++) {
            add(Factory.createButton(Factory.buttonType[i]));
        }
//        add(new SelectButton("src/IconImg/selectIcon.png"));
//        add(new AssociationLineButton("src/IconImg/associationLineIcon.png"));
//        add(new GeneralizationLineButton("src/IconImg/generalizationLineIcon.png"));
//        add(new CompositionLineButton("src/IconImg/compositionLineIcon.png"));
//        add(new ClassButton("src/IconImg/classIcon.png"));
//        add(new UseCaseButton("src/IconImg/useCaseIcon.png"));
    }

    public static void setCurButton(ButtonBase button) {
        curButton = button;
    }

    public static ButtonBase getCurButton() {
        return curButton;
    }

}
