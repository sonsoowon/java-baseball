package baseball.model.valid;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public enum PredictionValidator {
    INSTANCE;

    private static final int NUMBER_SIZE = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;


    public static List<Integer> getValidInput(String input) throws IllegalArgumentException {
        List<Integer> numbers = convertToInteger(input);
        if (hasSize(numbers) && isInRange(numbers) && isDistinct(numbers)) {
            return numbers;
        }
        throw new IllegalArgumentException();
    }

    private static List<Integer> convertToInteger(String input) {
        try {
            return Arrays.stream(input.split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean hasSize(List<Integer> numbers) {
        return numbers.size() == NUMBER_SIZE;
    }

    private static boolean isInRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(num -> num >= MIN_NUMBER && num <= MAX_NUMBER);
    }

    private static boolean isDistinct(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        return numbers.size() == numberSet.size();
    }
}
