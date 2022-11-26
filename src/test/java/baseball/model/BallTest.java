package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    // TODO: 중복제거
    private static final Ball ball1 = new Ball(0, 1);
    private static final Ball ball2 = new Ball(0, 1);
    private static final Ball ball3 = new Ball(1, 2);

    private static final Ball ball4 = new Ball(1, 1);

    @DisplayName("두 객체의 위치가 같고 숫자값이 같다면 볼이 아니다")
    @Test
    void isNotBallTest1() {
        boolean actual = ball1.isBallWith(ball2);
        assertThat(actual).isFalse();
    }

    @DisplayName("두 객체의 숫자값이 다르다면 볼이 아니다")
    @Test
    void isNotBallTest2() {
        boolean actual = ball1.isBallWith(ball3);
        assertThat(actual).isFalse();
    }

    @DisplayName("두 객체의 위치가 다르고 숫자값이 같다면 볼이다")
    @Test
    void isBallTest(){
        boolean actual = ball1.isBallWith(ball4);
        assertThat(actual).isTrue();
    }

    @DisplayName("두 객체의 위치와 숫자값이 모두 같다면 스트라이크이다")
    @Test
    void isStrikeTest() {
        boolean actual = ball1.isStrikeWith(ball2);
        assertThat(actual).isTrue();
    }

    @DisplayName("두 객체의 위치나 숫자값이 같지 않다면 스트라이크가 아니다")
    @Test
    void isNotStrikeTest() {
        boolean actual = ball1.isStrikeWith(ball4);
        assertThat(actual).isFalse();
    }


    @DisplayName("두 객체의 위치와 숫자값이 모두 같다면 같은 객체이다")
    @Test
    void equalsTest() {
        assertThat(ball1).isEqualTo(ball2);
    }

    @DisplayName("두 객체의 위치나 숫자값이 같지 않다면 다른 객체이다")
    @Test
    void notEqualsTest() {
        assertThat(ball1).isNotEqualTo(ball3);
    }
}
