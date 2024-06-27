package Action;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import Layout.CanvasArea;
import Object.*;

public class SelectGroupListener extends MouseAdapter {

    private CanvasArea canvasArea;
    private Point prePoint = new Point(), draPoint;
    private List<ObjBase> objContainer;
    private SelectRect chooseRect;

    public SelectGroupListener(CanvasArea canvasArea) {
        super();
        this.canvasArea = canvasArea;
        objContainer = new ArrayList<ObjBase>();
        chooseRect = new SelectRect();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // 取消所有select
        for (ObjBase obj : canvasArea.getObjs())
            obj.setSelect(false);
        objContainer.clear();

        // 不屬於任何物件範圍
        if (canvasArea.getObj(e.getPoint()) != null)
            return;
        prePoint = e.getPoint();
        canvasArea.setSelectRecP(prePoint);
        chooseRect.setBounds(prePoint.x, prePoint.y, 0, 0);
        canvasArea.setSelectRect(chooseRect);
        canvasArea.addObj(chooseRect);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int w, h;
        Point leftTopP = new Point();
        prePoint = canvasArea.getSelectRecP();
        draPoint = e.getPoint();
        leftTopP.setLocation(prePoint.x <= draPoint.x ? prePoint.x : draPoint.x,
                prePoint.y <= draPoint.y ? prePoint.y : draPoint.y);
        w = Math.abs(draPoint.x - prePoint.x);
        h = Math.abs(draPoint.y - prePoint.y);
//        System.out.println("w: " + w + " h: " + h);

        chooseRect = canvasArea.getselectRect();
        chooseRect.setBounds(leftTopP.x, leftTopP.y, w, h);

        checkObjInside(canvasArea.getObjs());

        canvasArea.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        int w, h;
//        draPoint = e.getPoint();
//        w = draPoint.x - prePoint.x;
//        h = draPoint.y - prePoint.y;
//        chooseRect.setBounds(prePoint.x, prePoint.y, w, h);
//        checkObjInside(canvasArea.getObjs());
        // 結束 刪掉obj
        canvasArea.removeObj(chooseRect);
    }

    public void checkObjInside(List<ObjBase> objs) {
        for (ObjBase obj : objs) {
            if (obj.getX() >= chooseRect.getX() && obj.getX() + obj.getWidth() <= chooseRect.getX() + chooseRect.getWidth() &&
                    obj.getY() >= chooseRect.getY() && obj.getY() + obj.getHeight() <= chooseRect.getY() + chooseRect.getHeight())
                obj.setSelect(true);
            else
                obj.setSelect(false);
        }
    }

}
