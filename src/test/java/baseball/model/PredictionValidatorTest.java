package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PredictionValidatorTest {

    @DisplayName("플레이어가 입력한 1에서 9까지 서로 다른 수 3개를 반환한다")
    @Test
    void getValidInputTest() {
        List<Integer> actual = PredictionValidator.getValidInput("123");
        List<Integer> expected = List.of(1, 2, 3);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("플레이어가 1에서 9까지 범위가 아닌 수를 입력하면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"012", "34d"})
    void invalidRangeTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PredictionValidator.getValidInput(input));
    }

    @DisplayName("플레이어가 입력한 숫자의 개수가 3이 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"", "12", "999999999999999999999999999999999999"})
    void invalidSizeTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PredictionValidator.getValidInput(input));
    }

    @DisplayName("플레이어가 중복된 숫자를 입력하면 예외가 발생한다")
    @Test
    void duplicateTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PredictionValidator.getValidInput("122"));
    }
}
