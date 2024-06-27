package Layout;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    MenuBar mainMenuBar;
    ButtonsPanel buttonsPanel;
    static CanvasArea canvasArea;
    JSplitPane splitPane;
    int x = 200, y = 200;
    int w = 1200, h = 800;

    public MainWindow() {
        setTitle("UML Editor");
        setBounds(x, y, w, h);
        borderLayout();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void borderLayout() {
        buttonsPanel = new ButtonsPanel();
        canvasArea = new CanvasArea();
        setLayout(new BorderLayout());
        mainMenuBar = new MenuBar(canvasArea);
        setJMenuBar(mainMenuBar.menuBar);
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buttonsPanel, canvasArea);
        add(splitPane);
    }

    public static CanvasArea getCanvasArea() {
        return canvasArea;
    }
}
