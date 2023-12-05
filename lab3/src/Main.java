import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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

    public static void segregate(
            List<? extends Chordal> srcCollection,
            List<? super CommonHedgehog> collection1,
            List<? super Manul> collection2,
            List<? super Lynx> collection3) {

        System.out.println("До применения метода segregate:");
        System.out.print("srcCollection: ");
        System.out.println(srcCollection);
        System.out.print("collection1: ");
        System.out.println(collection1);
        System.out.print("collection2: ");
        System.out.println(collection2);
        System.out.print("collection3: ");
        System.out.println(collection3);

        for (Chordal animal : srcCollection) {
            if (animal.getClass() == CommonHedgehog.class) {
                collection1.add((CommonHedgehog) animal);
            }
            if (animal.getClass() == Manul.class) {
                collection2.add((Manul) animal);
            }
            if (animal.getClass() == Lynx.class) {
                collection3.add((Lynx) animal);
            }
        }

        //var v  = collection1.get(0); //будет Object, т.к. super приведет к наивысшему классу

        System.out.println("После применения метода segregate:");
        System.out.print("srcCollection: ");
        System.out.println(srcCollection);
        System.out.print("collection1: ");
        System.out.println(collection1);
        System.out.print("collection2: ");
        System.out.println(collection2);
        System.out.print("collection3: ");
        System.out.println(collection3);

    }
}