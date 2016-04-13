package stacey.greenrivertech.net.learningnumbers;
import java.util.Random;

/**
 * Created by Stacey on 4/8/2016.
 */
public class LearningGameModel
{
    private int firstNumber;
    private int secondNumber;
    private int score;
    private int gamesPlayed;
    public static final int LEFT_SIDE = 0; // different to show left
    public static final int RIGHT_SIDE = 1; // different to show right

    Random random = new Random();

    public LearningGameModel() {
        gamesPlayed = 0;
        score = 0;
        generate();
    }

    public void generate() {
        firstNumber = random.nextInt(10) + 1;
        secondNumber = random.nextInt(10) + 1;
    }

    public boolean play (int choice) {
        gamesPlayed++;

        if (choice == 0 && firstNumber > secondNumber) {
            score++;
            return true;
        }

        else if (choice == 1 && secondNumber > firstNumber) {
            score++;
            return true;
        }
        else {
            return false;
        }
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public int getScore() {
        return score;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

}