package baseball.view;

public enum OutputView {
    INSTANCE;

    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public static void printStartGame() {
        System.out.println(START_GAME_MESSAGE);
    }
}
