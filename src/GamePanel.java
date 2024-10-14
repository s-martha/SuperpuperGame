import Constants.Constants;
import Constants.FilesPaths;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener {
    public Ship ship1;  // arrows
    public Ship ship2;  // wasd
    Timer timer;
    public Image BackgroundImage;

    public GamePanel() throws IOException {
        setFocusable(true);
        timer = new Timer(50, this);
        timer.start();
        try {
            Image imageShip1 = ImageIO.read(new File(FilesPaths.Ship1));
            Image imageShip2 = ImageIO.read(new File(FilesPaths.Ship2));
            this.ship1 = new Ship(Constants.Ship1SpawnX, Constants.Ship1SpawnY, Constants.Ship1Speed, Constants.StartAngleShip1, imageShip1, null, 1);
            this.ship2 = new Ship(Constants.Ship2SpawnX, Constants.Ship2SpawnY, Constants.Ship2Speed, Constants.StartAngleShip2, imageShip2, null, 1);

            this.BackgroundImage = ImageIO.read(new File(FilesPaths.BackgroundImage));}
        catch (IOException e) {
            System.out.println("Картинка не загрузилась(( облом");
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(BackgroundImage, 0, 0, null);
        ship1.draw(g);
        ship2.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ship1.move();
        ship2.move();
        repaint();
    }
}
