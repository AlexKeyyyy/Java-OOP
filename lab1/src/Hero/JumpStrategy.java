package Hero;

public class JumpStrategy implements MovementStrategy {
    @Override
    public void move() {
        System.out.println("Hero is jumping !");
    }
}
