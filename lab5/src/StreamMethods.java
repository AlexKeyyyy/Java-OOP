import java.util.*;
import java.util.stream.Collectors;

public class StreamMethods
{
    private static final String NO_SUCH_ELEMENT_EXCEPTION = "Collection is empty!";
    public static double averageOfList(List<Integer> num)
    {
        return num.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static List<String> changeStrings(List<String> strings)
    {
        return strings.stream()
                .map(s -> "_new_" + s.toUpperCase())
                .collect(Collectors.toList());
    }

    public static List<Integer> squaresOfUniqueElements(List<Integer> numbers)
    {
        return numbers.stream()
                .filter(num -> Collections.frequency(numbers, num) == 1)
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    public static List<String> startsWithLetterAndSort(List<String> strings, char letter)
    {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .sorted()
                .collect(Collectors.toList());

    }

    public static <T> T getLastElement(Collection<T> collection) throws NoSuchElementException
    {
        return collection.stream()
                .reduce((first, second) -> second)
                .orElseThrow(() -> new NoSuchElementException(NO_SUCH_ELEMENT_EXCEPTION));

    }

    public static int sumOfEvenNumbers(int[] numbers)
    {
        return Arrays.stream(numbers)
                .filter(n -> n % 2 ==0)
                .sum();
    }

    public static Map<Character, List<String>> listToMap(List<String> strings)
    {

        return strings.stream()
                .collect(Collectors.groupingBy(k -> k.charAt(0),
                        Collectors.mapping(v -> v.substring(1), Collectors.toList())));

    }
}
