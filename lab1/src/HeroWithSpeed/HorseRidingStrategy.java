package HeroWithSpeed;

public class HorseRidingStrategy implements MovementStrategy
{
    public void move(Point startPoint, Point endPoint, int speed, double distance, String time)
    {
        System.out.println("Hero is riding a horse from point " + startPoint + " to point " + endPoint +
                " with speed " + speed + " km/h " + time + " hours.");
    }
}
