package HeroWithSpeed;

public interface MovementStrategy
{
    void move(Point startPoint, Point endPoint, int speed, double distance, String time);
}
