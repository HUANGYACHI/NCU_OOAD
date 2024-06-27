package Action;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Factory.Factory;
import Layout.CanvasArea;

public class CreateObjClicked extends MouseAdapter {

    private CanvasArea canvasArea;
    private String objType;
//    private int classW = 120, classH = 150;
//    private int useCaseW = 150, useCaseH = 100;

    public CreateObjClicked(CanvasArea canvasArea, String objType) {
        super();
        this.canvasArea = canvasArea;
        this.objType = objType;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        canvasArea.addObj(Factory.createObj(objType, e));
//        if (objType == "Class")
//            canvasArea.addObj(new ClassObj(e.getX(), e.getY(), classW, classH, "Class"));
//        else
//            canvasArea.addObj(new UseCaseObj(e.getX(), e.getY(), useCaseW, useCaseH, "UseCase"));
    }

}
