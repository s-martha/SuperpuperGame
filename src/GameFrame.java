import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.*;

public class GameFrame extends JFrame implements KeyListener {
    private GamePanel gamePanel;

    public GameFrame(int sizeW, int sizeH) throws HeadlessException, IOException {
        setBounds(50, 50, sizeW, sizeH);
        setVisible(true);
        addKeyListener(this);
        gamePanel = new GamePanel();
        add(gamePanel);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // ship1
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            gamePanel.ship1.direction.right = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            gamePanel.ship1.direction.left = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            gamePanel.ship1.direction.up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            gamePanel.ship1.direction.down = true;
        }

        // ship2
        if (e.getKeyCode() == KeyEvent.VK_A) {
            gamePanel.ship2.direction.right = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            gamePanel.ship2.direction.left = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            gamePanel.ship2.direction.up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            gamePanel.ship2.direction.down = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //ship1
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            gamePanel.ship1.direction.right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            gamePanel.ship1.direction.left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            gamePanel.ship1.direction.up = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            gamePanel.ship1.direction.down = false;
        }

        //ship2
        if (e.getKeyCode() == KeyEvent.VK_A) {
            gamePanel.ship2.direction.right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            gamePanel.ship2.direction.left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            gamePanel.ship2.direction.up = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            gamePanel.ship2.direction.down = false;
        }
    }
}
