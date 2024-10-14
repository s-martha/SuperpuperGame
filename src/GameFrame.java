import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameFrame extends JFrame {
    private GamePanel gamePanel;

    public GameFrame(int size) throws HeadlessException, IOException {
        setBounds(100, 100, 100 + size, 100 + size);
        setVisible(true);
        gamePanel = new GamePanel();
        add(gamePanel);
    }
}
