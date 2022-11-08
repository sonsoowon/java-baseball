package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void computerSelectNumbers_컴퓨터가_1에서_9까지_서로_다른_임의의_수_3개_선택(){
        assertThat(Game.computerSelectNumbers())
                .isInstanceOf(List.class)
                .hasSize(Game.ANSWER_SIZE)
                .doesNotHaveDuplicates()
                .map(num -> assertThat(num).isBetween(Game.MIN_NUMBER_OF_ANSWER, Game.MAX_NUMBER_OF_ANSWER));
    }

    @Test
    void countNumbersContainedInAnswer_게임정답에_포함된_입력의_개수_반환(){
        Game game = new Game(List.of(1, 2, 3));
        List<List<Integer>> playerInput = List.of(
                List.of(7, 2, 1),
                List.of(1, 5, 3),
                List.of(3, 1 ,2),
                List.of(5, 2, 4),
                List.of(9, 8, 7)
        );
        List<Integer> expectedOutput = List.of(2, 2, 3, 1, 0);

        List<Integer> realOutput = playerInput.stream()
                .map(input -> game.countNumbersContainedInAnswer(input))
                .collect(Collectors.toList());

        assertThat(expectedOutput).isEqualTo(realOutput);
    }

    @Test
    void countStrike_스트라이크_개수_반환(){
        Game game = new Game(List.of(1, 2, 3));
        List<List<Integer>> playerInput = List.of(
                List.of(1, 2, 3),
                List.of(1, 5, 3),
                List.of(3, 1 ,2),
                List.of(3, 2, 1),
                List.of(9, 8, 7)
        );
        List<Integer> expectedOutput = List.of(3, 2, 0, 1, 0);

        List<Integer> realOutput = playerInput.stream()
                .map(input -> game.countStrike(input))
                .collect(Collectors.toList());

        assertThat(expectedOutput).isEqualTo(realOutput);
    }

    @Test
    void getBallStrikeCnt_볼_스트라이크_개수를_리스트로_반환(){
        Game game = new Game(List.of(1, 2, 3));
        List<List<Integer>> playerInput = List.of(
                List.of(1, 2, 3),
                List.of(1, 5, 3),
                List.of(3, 1 ,2),
                List.of(3, 2, 1),
                List.of(9, 8, 7)
        );
        List<List<Integer>> expectedOutput = List.of(
                List.of(0, 3),
                List.of(0, 2),
                List.of(3, 0),
                List.of(2, 1),
                List.of(0, 0)
        );

        List<List<Integer>> realOutput = playerInput.stream()
                .map(input -> game.getBallStrikeCnt(input))
                .collect(Collectors.toList());

        assertThat(expectedOutput).isEqualTo(realOutput);

    }

    @Test
    void getResultOfPlayerGuess_볼_스트라이크_개수에_따른_결과문구_반환(){
        List<List<Integer>> ballStrikeInput = List.of(
                List.of(0, 3),
                List.of(0, 2),
                List.of(3, 0),
                List.of(2, 1),
                List.of(0, 0)
        );
        List<String> expectedOutput = List.of(
                "3스트라이크",
                "2스트라이크",
                "3볼",
                "2볼 1스트라이크",
                "낫싱"
        );

        List<String> realOutput = ballStrikeInput.stream()
                .map(ballStrike -> Game.getResultOfPlayerGuess(ballStrike.get(0), ballStrike.get(1)))
                .collect(Collectors.toList());

        assertThat(expectedOutput).isEqualTo(realOutput);
    }

    @Test
    void isAllStrike_올스트라이크인_경우_참(){
        List<Integer> strikeCnts = List.of(3, 2);
        List<Boolean> expectedOutput = List.of(true, false);

        List<Boolean> realOutput = strikeCnts.stream()
                .map(cnt -> Game.isAllStrike(cnt))
                .collect(Collectors.toList());

        assertThat(expectedOutput).isEqualTo(realOutput);
    }
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
