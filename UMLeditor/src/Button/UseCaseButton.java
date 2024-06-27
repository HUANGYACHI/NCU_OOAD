package Button;

import Action.CreateObjClicked;
import Layout.CanvasArea;
import Layout.MainWindow;

public class UseCaseButton extends ButtonBase{
    public UseCaseButton(String path) {
        super(path);
    }

    @Override
    public void onClicked() {
        CanvasArea canvasArea = MainWindow.getCanvasArea();
        super.removeAllMouseListener();
        canvasArea.addMouseListener(new CreateObjClicked(canvasArea, "UseCase"));
    }
}
