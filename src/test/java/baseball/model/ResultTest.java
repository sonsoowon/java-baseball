package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.xml.transform.Source;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResultTest {

    @DisplayName("볼/스트라이크 개수를 출력 형식에 맞는 문자열로 변환한다")
    @ParameterizedTest
    @MethodSource("convertToStringTestSource")
    void convertToStringTest(Result result, String expected) {
        assertThat(result.convertToString())
                .isEqualTo(expected);
    }


    private static Stream<Arguments> convertToStringTestSource() {
        return Stream.of(
                Arguments.of(new Result(1, 1), "1볼 1스트라이크"),
                Arguments.of(new Result(1, 0), "1볼"),
                Arguments.of(new Result(0, 1), "1스트라이크"),
                Arguments.of(new Result(0, 0), "낫싱")
        );
    }
}