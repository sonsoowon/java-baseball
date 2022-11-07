package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {
    public static int ANSWER_SIZE = 3;
    public static int MIN_NUMBER_OF_ANSWER = 1;
    public static int MAX_NUMBER_OF_ANSWER = 9;

    static List<Integer> computerSelectNumbers(){
        List<Integer> selectedNums = new ArrayList<>();
        while (selectedNums.size() < ANSWER_SIZE) {
            int randomNumber = pickNumberInRange(MIN_NUMBER_OF_ANSWER, MAX_NUMBER_OF_ANSWER);
            if (!selectedNums.contains(randomNumber)) {
                selectedNums.add(randomNumber);
            }
        }
        return selectedNums;
    }
}