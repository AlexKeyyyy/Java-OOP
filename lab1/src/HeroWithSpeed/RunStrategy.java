package HeroWithSpeed;

public class RunStrategy implements MovementStrategy
{
    public void move(Point startPoint, Point endPoint, int speed, double distance, String time)
    {
        System.out.println("Hero is running from point " + startPoint + " to point " + endPoint +
                " with speed " + speed + " km/h " + time + " hours.");
    }
}
