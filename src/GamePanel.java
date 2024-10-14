import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    public Ship orc;
    Timer timer;

    public GamePanel() throws IOException {
        setFocusable(true);
        addKeyListener(this);
        timer = new Timer(50, this);
        timer.start();
        try {
            Image image = ImageIO.read(new File("src/orc.png"));
            this.orc = new Ship(50, 50, 10, Math.PI/2.0, image, null, 1);
        }
        catch (IOException e) {
            System.out.println("Картинка не загрузилась(( облом");
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        orc.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        orc.move();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            orc.direction.right = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            orc.direction.left = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            orc.direction.up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            orc.direction.down = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            orc.direction.right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            orc.direction.left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            orc.direction.up = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            orc.direction.down = false;
        }
    }
}
