package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallListTest {
    private static final BallList computer = new BallList(List.of(
            new Ball(0, 1),
            new Ball(1, 2),
            new Ball(2, 3)
    ));

    private static final BallList player = new BallList(List.of(
            new Ball(0, 3),
            new Ball(1, 2),
            new Ball(2, 1)
    ));

    @DisplayName("컴퓨터의 수와 플레이어의 수를 비교해 볼 개수를 반환한다")
    @Test
    void countBallsTest() {
        assertThat(computer.countBalls(player))
                .isEqualTo(2);
    }

    @DisplayName("스트라이크 개수를 반환한다")
    @Test
    void countStrikesTest() {
        assertThat(computer.countStrikes(player))
                .isEqualTo(1);
    }

}
