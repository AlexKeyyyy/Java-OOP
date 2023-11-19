package Hero;

public class Hero {
    private MovementStrategy strategy = new WalkStrategy();

    public void setStrategy(MovementStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        strategy.move();
    }


}
