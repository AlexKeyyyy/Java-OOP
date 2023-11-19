import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nТест метода segregate(Млекопитающие, Ежовые, Кошачьи, Хищные)");
        ArrayList<Mammals> srcCollection = new ArrayList<>();
        srcCollection.add(new Lynx());
        srcCollection.add(new Lynx());
        srcCollection.add(new Manul());
        srcCollection.add(new CommonHedgehog());


        ArrayList<HedgehogFamily> a = new ArrayList<>();
        ArrayList<CatFamily> b = new ArrayList<>();
        ArrayList<Predators> c = new ArrayList<>();

        segregate(srcCollection, a, b, c);


        System.out.println("\nТест метода segregate(Хищные, Хордовые, Манулы, Кошачьи)");
        ArrayList<Predators> srcCollection1 = new ArrayList<>();
        srcCollection1.add(new Lynx());
        srcCollection1.add(new Lynx());
        srcCollection1.add(new Manul());
        srcCollection1.add(new Manul());


        ArrayList<Chordal> a1 = new ArrayList<>();
        ArrayList<Manul> b1 = new ArrayList<>();
        ArrayList<CatFamily> c1 = new ArrayList<>();

        segregate(srcCollection1, a1, b1, c1);


        System.out.println("\nТест метода segregate(Ежовые, Насекомоядные, Хищные, Хищные)");
        ArrayList<HedgehogFamily> srcCollection2 = new ArrayList<>();
        srcCollection2.add(new CommonHedgehog());
        srcCollection2.add(new CommonHedgehog());


        ArrayList<Insectivores> a2 = new ArrayList<>();
        ArrayList<Predators> b2 = new ArrayList<>();
        ArrayList<Predators> c2 = new ArrayList<>();

        segregate(srcCollection2, a2, b2, c2);

    }

    public static <T extends Chordal, T1 extends Chordal, T2 extends Chordal, T3 extends Chordal> void segregate(
            Collection<T> srcCollection,
            Collection<T1> collection1,
            Collection<T2> collection2,
            Collection<T3> collection3) {

        System.out.println("До применения метода segregate:");
        System.out.print("srcCollection: ");
        printCollection(srcCollection);
        System.out.print("collection1: ");
        printCollection(collection1);
        System.out.print("collection2: ");
        printCollection(collection2);
        System.out.print("collection3: ");
        printCollection(collection3);

        for (T animal : srcCollection) {
            if (animal.getClass() == CommonHedgehog.class) {
                collection1.add((T1) animal);
            }
            if (animal.getClass() == Manul.class) {
                collection2.add((T2) animal);
            }
            if (animal.getClass() == Lynx.class) {
                collection3.add((T3) animal);
            }
        }

        System.out.println("После применения метода segregate:");
        System.out.print("srcCollection: ");
        printCollection(srcCollection);
        System.out.print("collection1: ");
        printCollection(collection1);
        System.out.print("collection2: ");
        printCollection(collection2);
        System.out.print("collection3: ");
        printCollection(collection3);

    }

    public static <T extends Chordal> void printCollection(Collection<T> collection) {
        System.out.print("[ ");
        for (T element : collection) {
            System.out.print(element.getClass().getName() + " ");
        }
        System.out.println("]");
    }
}