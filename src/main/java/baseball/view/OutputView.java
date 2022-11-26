package baseball.view;

import baseball.model.Result;

public enum OutputView {
    INSTANCE;

    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";

    private static final String ALL_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printStartGame() {
        System.out.println(START_GAME_MESSAGE);
    }
    public static void printAllStrike() {
        System.out.println(ALL_STRIKE_MESSAGE);
    }

    public static void printResult(Result result) {
        System.out.println(result.convertToString());
    }
}
