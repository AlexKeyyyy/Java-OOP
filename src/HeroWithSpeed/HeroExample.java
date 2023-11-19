package HeroWithSpeed;

public class HeroExample
{
    public static void main(String[] args) {
        Hero hero = new Hero();
        Point startPoint = new Point(0,0);
        Point endPoint = new Point(10, 10);

        hero.setStrategy(new RunStrategy());
        hero.executeStrategy(startPoint, endPoint, 10);

        hero.setStrategy(new JumpStrategy());
        hero.executeStrategy(startPoint, endPoint, 5);

        hero.setStrategy(new HorseRidingStrategy());
        hero.executeStrategy(startPoint, endPoint, 20);
    }
}
