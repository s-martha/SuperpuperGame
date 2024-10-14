import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameFrame extends JFrame {
    private GamePanel gamePanel;

    public GameFrame(int sizeW, int sizeH) throws HeadlessException, IOException {
        setBounds(50, 50, sizeW, sizeH);
        setVisible(true);
        gamePanel = new GamePanel();
        add(gamePanel);
    }
}
