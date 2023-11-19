package HeroWithSpeed;

public class JumpStrategy implements MovementStrategy
{
    public void move(Point startPoint, Point endPoint, int speed, double distance, String time)
    {
        System.out.println("Hero is jumping from point " + startPoint + " to point " + endPoint +
                " with speed " + speed + " km/h " + time + " hours.");
    }
}
