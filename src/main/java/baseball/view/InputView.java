package baseball.view;

import baseball.model.PredictionValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public enum InputView {

    INSTANCE;

    private static final String PREDICTS_MESSAGE = "숫자를 입력해주세요 : ";

    public static List<Integer> readPrediction() throws IllegalArgumentException {
        System.out.println(PREDICTS_MESSAGE);
        String input = Console.readLine();
        return PredictionValidator.getValidInput(input);
    }

}
