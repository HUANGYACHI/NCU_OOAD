package Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import Layout.CanvasArea;
import Object.*;

public class GroupActionListener implements ActionListener {

    CanvasArea canvasArea;
    ObjBase groupObj;

    public GroupActionListener(CanvasArea canvasArea) {
        this.canvasArea = canvasArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<ObjBase> selectObjContainer = new ArrayList<ObjBase>();

        for (ObjBase obj : canvasArea.getObjs()) {
            if (obj.getSelect()) {
                obj.setSelect(false);
                selectObjContainer.add(obj);
            }
        }

        if (selectObjContainer.size() == 0) {
            JOptionPane.showMessageDialog(canvasArea, "No select Obj", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (selectObjContainer.size() == 1) {
            JOptionPane.showMessageDialog(canvasArea, "Only select one Obj", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        }

        groupObj = new GroupObj();
        for (ObjBase obj : selectObjContainer) {
            groupObj.addObj(obj);
//            obj.addMouseListener(new SelectObjListener(canvasArea));
        }
        groupObj.addMouseListener(new SelectObjListener(canvasArea));

        canvasArea.addObj(groupObj);

    }

}
