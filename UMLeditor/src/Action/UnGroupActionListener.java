package Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import Layout.CanvasArea;
import Object.ObjBase;

import javax.swing.*;

public class UnGroupActionListener implements ActionListener {

    CanvasArea canvasArea;
    List<ObjBase> removeObjContainer;

    public UnGroupActionListener(CanvasArea canvasArea) {
        this.canvasArea = canvasArea;
        removeObjContainer = new ArrayList<ObjBase>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (ObjBase obj : canvasArea.getObjs()) {
            if (obj.getObjCount() > 1 && obj.getSelect())
                removeObjContainer.add(obj);
        }

        if (removeObjContainer.size() == 0) {
            JOptionPane.showMessageDialog(canvasArea, "No select group", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (removeObjContainer.size() > 1) {
            JOptionPane.showMessageDialog(canvasArea, "Select Over one Obj", "WARNING", JOptionPane.WARNING_MESSAGE);
            removeObjContainer.clear();
            return;
        }

        for (ObjBase obj : removeObjContainer)
            canvasArea.removeObj(obj);
        removeObjContainer.clear();
    }

}
