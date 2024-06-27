package Button;

import Action.SelectGroupListener;
import Action.SelectObjListener;
import Layout.CanvasArea;
import Layout.MainWindow;
import Object.ObjBase;

public class SelectButton extends ButtonBase{
    public SelectButton(String path) {
        super(path);
    }

    @Override
    public void onClicked() {
        CanvasArea canvasArea = MainWindow.getCanvasArea();
        super.removeAllMouseListener();
//        canvasArea.addMouseListener(new SelectObjListener(canvasArea));
        for (ObjBase obj : canvasArea.getObjs())
            obj.addMouseListener((new SelectObjListener(canvasArea)));
        canvasArea.addMouseListener(new SelectGroupListener(canvasArea));
        canvasArea.addMouseMotionListener(new SelectGroupListener(canvasArea));
    }
}
