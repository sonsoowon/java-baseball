package baseball.view;

import baseball.model.GameCommandValidator;
import baseball.model.PredictionValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public enum InputView {

    INSTANCE;

    private static final String PREDICTS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_COMMAND_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static List<Integer> readPrediction() throws IllegalArgumentException {
        System.out.println(PREDICTS_MESSAGE);
        String input = Console.readLine();
        return PredictionValidator.getValidInput(input);
    }

    public static String readGameCommand() throws IllegalArgumentException {
        System.out.println(GAME_COMMAND_MESSAGE);
        String input = Console.readLine();
        GameCommandValidator.validate(input);
        return input;
    }

}
