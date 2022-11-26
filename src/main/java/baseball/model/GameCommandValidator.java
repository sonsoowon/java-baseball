package baseball.model;

import java.util.List;

public class GameCommandValidator {
    private static final String RESTART = "1";
    private static final String QUIT = "2";

    public static void validate(String input) throws IllegalArgumentException {
        List<String> gameCommands = List.of(RESTART, QUIT);
        if (!gameCommands.contains(input)) {
            throw new IllegalArgumentException();
        }
    }
}
