package Action;

import Factory.Factory;
import Layout.CanvasArea;
import Object.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawLineListener extends MouseAdapter {

    private ObjBase obj1, obj2;
    private Port p1, p2;
    private CanvasArea canvasArea;
    private String lineType;

    public DrawLineListener(CanvasArea canvasArea, String lineType) {
        super();
        this.canvasArea = canvasArea;
        this.lineType = lineType;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // 取得第一個obj
        obj1 = canvasArea.getObj(e.getPoint());
        System.out.println(obj1);
        if (obj1 != null)
            p1 = obj1.getNearestPort(e.getPoint());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // 取得第二個obj
        obj2 = canvasArea.getObj(e.getPoint());
        System.out.println(obj2);
        if (obj2 != null)
            p2 = obj2.getNearestPort(e.getPoint());

        if (p1 == null || p2 == null || obj1 == obj2 || obj1 == null || obj2 == null)
            return;

        // draw line
        canvasArea.addLine(Factory.createLine(lineType, p1, p2));
//        if (lineType == "Association")
//            canvasArea.addLine(new AssociationLine(p1, p2));
//        else if (lineType == "Generalization")
//            canvasArea.addLine(new GeneralizationLine(p1, p2));
//        else
//            canvasArea.addLine(new CompositionLine(p1, p2));
    }

}
