package HeroWithSpeed;

public class Point
{
    private int x_;
    private int y_;

    public Point(int x, int y)
    {
        this.x_ = x;
        this.y_ = y;
    }

    public int getX()
    {
        return x_;
    }

    public int getY()
    {
        return y_;
    }

    public String toString() {
        return "(" + x_ + ", " + y_ + ")";
    }
}
