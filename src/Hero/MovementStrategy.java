package Hero;

public interface MovementStrategy {
    void move();

    default void go()
    {

    }
}
