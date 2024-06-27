package Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Layout.CanvasArea;
import Object.ObjBase;

public class RenameActionListener implements ActionListener {

    private CanvasArea canvasArea;

    public RenameActionListener(CanvasArea canvasArea) {
        this.canvasArea = canvasArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // rename 視窗
        String name = JOptionPane.showInputDialog("Enter new name:");

        // cancel
        if (name == null)
            return;

        // rename
        for (ObjBase obj : canvasArea.getObjs()) {
            if (obj.getSelect())
                obj.setName(name);
        }
        canvasArea.repaint();
    }
}
