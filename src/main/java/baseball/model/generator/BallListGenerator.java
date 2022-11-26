package baseball.model.generator;

import baseball.model.Ball;

import java.util.ArrayList;
import java.util.List;

public class BallListGenerator {

    public static List<Ball> generateBallsOf(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();
        for (int index = 0; index < numbers.size(); index++) {
            Ball ball = new Ball(index, numbers.get(index));
            balls.add(ball);
        }
        return balls;
    }
}
