public class Sqr {
    private int x;
    private int y;

    public Sqr(int size) {
        x = (int) (Math.random() * 10000) % 420 ;
        y = (int) (Math.random() * 10000) % 420 ;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean inRange(int x, int y, int size) {
        if (x >= this.x && y >= this.y )
            if (x <= this.x + size && y <= this.y + size)
                  return true;
        return false;
    }
}
