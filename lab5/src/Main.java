import java.util.*;


public class Main {
    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 3, 6, 7, 8, 9);
        List<String> strings = Arrays.asList("azily", "apple", "banana", "cherry", "date", "apple", "banana");
        List<String> strings1 = Arrays.asList("azily", "apple", "banana", "cherry", "date", "apple", "banana");
        int[] numbersArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println("1) Среднее чисел: " + StreamMethods.averageOfList(numbers));
        System.out.println("2) Измененные строки: " + StreamMethods.changeStrings(strings));
        System.out.println("3) Квадраты только уникальных элементов: " + StreamMethods.squaresOfUniqueElements(numbers));
        System.out.println("4) Слова с заданной буквы: " + StreamMethods.startsWithLetterAndSort(strings, 'a'));
        try
        {
            System.out.println("5) Последний элемент: " + StreamMethods.getLastElement(strings1));
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("6) Сумма четных чисел: " + StreamMethods.sumOfEvenNumbers(numbersArr));
        System.out.println("7) Строки отсортированные по первой букве: " + StreamMethods.listToMap(strings));
    }
}