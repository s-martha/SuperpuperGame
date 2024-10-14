public class Direction {
    boolean up, down, right, left;

    public Direction() {
        this.up = false;
        this.down = false;
        this.right = false;
        this.left = false;
    }

    public Direction(boolean up, boolean down, boolean right, boolean left) {
        this.up = up;
        this.down = down;
        this.right = right;
        this.left = left;
    }
}
