package Button;

import Action.CreateObjClicked;
import Layout.CanvasArea;
import Layout.MainWindow;
import Object.*;

public class ClassButton extends ButtonBase{
    public ClassButton(String path) {
        super(path);
    }

    @Override
    public void onClicked() {
        CanvasArea canvasArea = MainWindow.getCanvasArea();
        super.removeAllMouseListener();
        canvasArea.addMouseListener(new CreateObjClicked(canvasArea, "Class"));
    }
}
