import java.awt.*;

public abstract class Unit implements Moving, Drawing {
    public int x;
    public int y;
    public int speed;
    public double angle;
    public Image image;
    public Direction direction;

    public Unit(int x, int y, int speed, double angle, Image image) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.angle = angle;
        this.image = image;
        this.direction = new Direction();
    }
}
