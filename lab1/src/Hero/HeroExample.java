package Hero;
import java.util.Scanner;

public class HeroExample {
    public static void main(String[] args) {
        Hero hero = new Hero();
        System.out.println("Choose movement strategy: \n" +
                "1. Start Walk\n" + "2. Start Jump\n" + "3. Start Run\n" + "4. Exit\n");

        int strategy = 0;
        Scanner in = new Scanner(System.in);
        while (strategy != 4) {
            if (in.hasNextInt()) {
                strategy = in.nextInt();
            }
            else
                break;
            if (strategy == 1) {
                hero.setStrategy(new WalkStrategy());
                hero.executeStrategy();
            } else if (strategy == 2) {
                hero.setStrategy(new JumpStrategy());
                hero.executeStrategy();
            } else if (strategy == 3) {
                hero.setStrategy(new RunStrategy());
                hero.executeStrategy();
            }
        }
    }
}
