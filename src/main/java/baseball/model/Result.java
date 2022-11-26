package baseball.model;

public class Result {

    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String BLANK = " ";

    private static final int NUMBER_SIZE = 3;

    private final int ballCnt;
    private final int strikeCnt;

    public Result(int ballCnt, int strikeCnt) {
        this.ballCnt = ballCnt;
        this.strikeCnt = strikeCnt;
    }

    public String convertToString() {
        if (ballCnt * strikeCnt != 0) {
            return ballCnt + BALL + BLANK + strikeCnt + STRIKE;
        }
        if (ballCnt > 0) {
            return ballCnt + BALL;
        }
        if (strikeCnt > 0) {
            return strikeCnt + STRIKE;
        }
        return NOTHING;
    }

    public boolean allStrike() {
        return strikeCnt == NUMBER_SIZE;
    }
}
