import java.util.ArrayList;
import java.util.List;

class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}

public class Main {
    public static void main(String[] args) {
        // Пример использования Producer Extends
        List<? extends Animal> animals = new ArrayList<Dog>(); // Мы можем получать элементы типа Animal или его подтипы
        //animals.add(new Dog()); // Нельзя добавить, так как коллекция может быть типа List<Cat>
        animals.get(0);
        // Пример использования Consumer Super
        List<? super Dog> dogList = new ArrayList<Animal>(); // Мы можем добавлять элементы типа Dog или его супертипы
        dogList.add(new Dog()); // Можно добавлять Dog и его подклассы
        // Dog d = dogList.get(0); // Нельзя получить элемент с уверенностью, что он типа Dog
    }
}