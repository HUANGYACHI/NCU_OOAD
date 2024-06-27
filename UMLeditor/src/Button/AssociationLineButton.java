package Button;

import Action.DrawLineListener;
import Layout.CanvasArea;
import Layout.MainWindow;

public class AssociationLineButton extends ButtonBase{
    public AssociationLineButton(String path) {
        super(path);
    }

    @Override
    public void onClicked() {
        CanvasArea canvasArea = MainWindow.getCanvasArea();
        super.removeAllMouseListener();
        canvasArea.addMouseListener(new DrawLineListener(canvasArea, "Association"));
    }
}
