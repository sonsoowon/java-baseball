package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class BallList {
    private final List<Ball> balls;

    public BallList(List<Ball> balls) {
        this.balls = balls;
    }

    public int countBalls(BallList other) {
        return (int) balls.stream()
                .filter(other::hasBallOf)
                .count();
    }
    private boolean hasBallOf(Ball ball) {
        return balls.stream()
                .anyMatch(b -> b.isBallWith(ball));
    }

}
