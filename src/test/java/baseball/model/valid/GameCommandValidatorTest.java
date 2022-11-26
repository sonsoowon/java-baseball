package baseball.model.valid;

import baseball.model.valid.GameCommandValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class GameCommandValidatorTest {
    @DisplayName("1, 2 중 하나를 입력하지 않으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"12", "3"})
    void invalidInputTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> GameCommandValidator.validate(input));
    }

    @DisplayName("1, 2 중 하나를 입력하면 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void validInputTest(String input) {
        assertThatNoException()
                .isThrownBy(() -> GameCommandValidator.validate(input));
    }
}
