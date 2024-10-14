import Interfaces.HealthPoint;

import java.awt.*;

public class Ship extends Unit implements HealthPoint {
    public Weapon weapon;
    public int hp = 1;

    public Ship(int x, int y, int speed, double angle, Image image, Weapon weapon, int hp) {
        super(x, y, speed, angle, image);
        this.weapon = weapon;
        this.hp = hp;
    }

    @Override
    public void move() {
        int dx = -(int) (Math.sin(angle) * speed);
        int dy = (int) (Math.cos(angle) * speed);
        if (direction.up) {
            x -= dx;
            y -= dy;
        }
        if (direction.down) {
            x += dx;
            y += dy;
        }
        if (direction.left) {
            angle -= 0.1;  // ToDo 0.1 is variable
        }
        if (direction.right) {
            angle += 0.1;
        }
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.rotate(angle, x + image.getWidth(null) / 2, y + image.getHeight(null) / 2);
        g.drawImage(image, x, y, null);
        graphics2D.rotate(-angle, x + image.getWidth(null) / 2, y + image.getHeight(null) / 2);
    }

    @Override
    public int getHP() {
        return hp;
    }

    @Override
    public void setHP(int healthPoint) {
        if (healthPoint < 0) {
            hp = 0;
        } else {
            hp = healthPoint;
        }
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }
}
