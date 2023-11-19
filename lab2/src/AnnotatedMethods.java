@MyAnnotation
public class AnnotatedMethods {

    public AnnotatedMethods() {

    }

    @MyAnnotation(numberOfCalls = 1)
    public int publicMethod1() {
        System.out.println("Public method 1 called");
        return 0;
    }

    @MyAnnotation(numberOfCalls = 1)
    public int publicMethod2(String x, int y, boolean b) {
        System.out.println("Public method 2 called");
        return 0;
    }

    @MyAnnotation(numberOfCalls = 2)
    protected int protectedMethod3() {
        System.out.println("Protected method 3 called");
        return 0;
    }

    @MyAnnotation(numberOfCalls = 2)
    protected int protectedMethod4(@MyAnnotation() int a) {
        System.out.println("Protected method 4 called");
        return 0;
    }

    @MyAnnotation(numberOfCalls = 3)
    private int privateMethod5(double a, int b) {
        System.out.println("Private method 5 called");
        return 0;
    }

    @MyAnnotation()
    private int privateMethod6(float x) {
        System.out.println("Private method 6 called");
        return 0;
    }

}
