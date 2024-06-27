package Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Action.*;
import Layout.CanvasArea;
import Layout.MainWindow;
import Object.ObjBase;

public abstract class ButtonBase extends JButton {
    private int iconWH = 100;

    public ButtonBase(String path) {
        setButtonImg(path);
        setBackground(Color.white);
        addMouseListener(new ButtonClicked());
    }

    private void setButtonImg(String imgPath) {
        ImageIcon icon = new ImageIcon(imgPath);
        Image img = icon.getImage().getScaledInstance(iconWH, iconWH, Image.SCALE_DEFAULT);
        icon = new ImageIcon(img);
        setIcon(icon);
    }

    public abstract void onClicked();

    public static void removeAllMouseListener() {
        CanvasArea canvasArea = MainWindow.getCanvasArea();
        for (MouseListener mouseListener : canvasArea.getMouseListeners()) {
            canvasArea.removeMouseListener(mouseListener);
        }
        for (ObjBase obj : canvasArea.getObjs()) {
            for (MouseListener mouseListener : obj.getMouseListeners()) {
                obj.removeMouseListener(mouseListener);
            }
        }
        for (MouseMotionListener mouseMotionListener : canvasArea.getMouseMotionListeners()) {
            canvasArea.removeMouseMotionListener(mouseMotionListener);
        }
        // 取消所有select
        for (ObjBase obj : canvasArea.getObjs()) {
            obj.setSelect(false);
        }
        canvasArea.repaint();
    }

}
