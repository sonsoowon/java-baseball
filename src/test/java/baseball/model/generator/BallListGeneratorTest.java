package baseball.model.generator;

import baseball.model.Ball;
import baseball.model.generator.BallListGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallListGeneratorTest {
    @DisplayName("플레이어의 숫자 리스트를 볼 객체 리스트로 변환한다")
    @Test
    void generateBallListTest() {
        List<Ball> actual = BallListGenerator.generateBallsOf(List.of(1, 2, 3));
        List<Ball> expected = List.of(
                new Ball(0, 1),
                new Ball(1, 2),
                new Ball(2, 3)
        );

        assertThat(actual).isEqualTo(expected);

    }
}
