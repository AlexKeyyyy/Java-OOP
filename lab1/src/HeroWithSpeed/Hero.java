package HeroWithSpeed;

public class Hero
{
    private MovementStrategy strategy;

    public Hero()
    {}

    public void setStrategy(MovementStrategy strategy)
    {
        this.strategy = strategy;
    }

    public void executeStrategy(Point startPoint, Point endPoint, int speed)
    {
        double distance = calculateDistance(startPoint, endPoint);
        double time = distance / speed;
        String formattedDouble = String.format("%.2f", time);
        strategy.move(startPoint, endPoint, speed, distance, formattedDouble);
    }

    public double calculateDistance(Point startPoint, Point endPoint)
    {
        int deltaX = endPoint.getX() - startPoint.getX();
        int deltaY = endPoint.getY() - startPoint.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
