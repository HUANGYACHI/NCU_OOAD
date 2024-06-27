package Action;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ListIterator;

import Layout.CanvasArea;
import Object.ObjBase;

public class SelectObjListener extends MouseAdapter {

    private CanvasArea canvasArea;
    private Point prePoint, relPoint;
    private ObjBase selectObj;

    public SelectObjListener(CanvasArea canvasArea) {
        super();
        this.canvasArea = canvasArea;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        prePoint = e.getPoint();
        // 取消所有select
        for (ObjBase obj : canvasArea.getObjs())
            obj.setSelect(false);

        // select obj
//        if (canvasArea.getObj(e.getPoint()) != null)
//            canvasArea.getObj(e.getPoint()).setSelect(true);
        selectObj = (ObjBase) e.getSource();
        selectObj.setSelect(true);

        canvasArea.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        relPoint = e.getPoint();
        // 相同位置不動作
        if (prePoint.getX() == relPoint.getX() && prePoint.getY() == relPoint.getY())
            return;

        int diffx = relPoint.x - prePoint.x;
        int diffy = relPoint.y - prePoint.y;
        // 新位置
//        if (canvasArea.getObj(prePoint) != null)
//            canvasArea.getObj(prePoint).setLocation(relPoint);
        selectObj.setLocation(selectObj.getX()+diffx, selectObj.getY()+diffy);

        canvasArea.repaint();
    }

}
