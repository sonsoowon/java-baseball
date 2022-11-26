package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private static final int NUMBER_SIZE = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static List<Integer> generates() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
