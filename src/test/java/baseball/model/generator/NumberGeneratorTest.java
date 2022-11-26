package baseball.model.generator;

import baseball.model.generator.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {

    @DisplayName("컴퓨터가 1에서 9까지 서로 다른 임의의 수 3개를 선택한다")
    @Test
    void generateTest() {
        List<Integer> numbers = NumberGenerator.generates();
        IntStream numberRange = IntStream.rangeClosed(1, 9);

        assertThat(numbers)
                .hasSize(3)
                .doesNotHaveDuplicates();
    }
}
