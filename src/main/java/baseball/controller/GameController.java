package baseball.controller;

import baseball.model.*;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {
    private static final String RETRY = "1";
    public static void gameStart() {
        BallList computer = generateComputerBalls();
        predict(computer);
    }

    private static void predict(BallList computer) throws IllegalArgumentException {
        BallList player = getPlayerBalls();
        Result result = computer.getResultOf(player);
        OutputView.printResult(result);

        if (result.allStrike()) {
            OutputView.printAllStrike();
            restart();
            return;
        }
        predict(computer);
    }


    private static void restart() throws IllegalArgumentException {
        String gameCommand = InputView.readGameCommand();
        if(gameCommand.equals(RETRY)) {
            gameStart();
        }
    }
    private static BallList generateComputerBalls() {
        List<Integer> computerNumbers =  NumberGenerator.generates();
        List<Ball> computerBalls = BallListGenerator.generateBallsOf(computerNumbers);
        return new BallList(computerBalls);
    }

    private static BallList getPlayerBalls() throws IllegalArgumentException {
        List<Integer> playerNumbers = InputView.readPrediction();
        List<Ball> playerBalls = BallListGenerator.generateBallsOf(playerNumbers);
        return new BallList(playerBalls);
    }


}
