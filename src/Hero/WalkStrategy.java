package Hero;

public class WalkStrategy implements MovementStrategy {
    @Override
    public void move() {
        System.out.println("Hero is walking !");
    }
}
