import Constants.Constants;
import Constants.FilesPaths;

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
    public Ship ship1;  // arrows
    public Ship ship2;  // wasd
    Timer timer;

    public GamePanel() throws IOException {
        setFocusable(true);
        addKeyListener(this);
        timer = new Timer(50, this);
        timer.start();
        try {
            Image imageShip1 = ImageIO.read(new File(FilesPaths.Ship1));
            Image imageShip2 = ImageIO.read(new File(FilesPaths.Ship2));
            this.ship1 = new Ship(Constants.Ship1SpawnX, Constants.Ship1SpawnY, Constants.Ship1Speed, Constants.StartAngleShip1, imageShip1, null, 1);
            this.ship2 = new Ship(Constants.Ship2SpawnX, Constants.Ship2SpawnY, Constants.Ship2Speed, Constants.StartAngleShip2, imageShip2, null, 1);
        }
        catch (IOException e) {
            System.out.println("Картинка не загрузилась(( облом");
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ship1.draw(g);
        ship2.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ship1.move();
        ship2.move();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // ship1
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            ship1.direction.right = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            ship1.direction.left = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            ship1.direction.up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            ship1.direction.down = true;
        }

        // ship2
        if (e.getKeyCode() == KeyEvent.VK_A) {
            ship2.direction.right = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            ship2.direction.left = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            ship2.direction.up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            ship2.direction.down = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //ship1
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            ship1.direction.right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            ship1.direction.left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            ship1.direction.up = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            ship1.direction.down = false;
        }

        //ship2
        if (e.getKeyCode() == KeyEvent.VK_A) {
            ship2.direction.right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            ship2.direction.left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            ship2.direction.up = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            ship2.direction.down = false;
        }
    }
}
