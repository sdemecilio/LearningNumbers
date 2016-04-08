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
    private int retrySecond;

    public LearningGameModel()
    {
        generate();
        gamesPlayed = 0;
        score = 0;
    }

    public void generate()
    {
        Random random = new Random();

        firstNumber = random.nextInt(10) + 1;
        secondNumber = random.nextInt(10) + 1;

        if (secondNumber == firstNumber)
        {
            retrySecond = random.nextInt(10) + 1;
            retrySecond = secondNumber;
        }
    }

    public int getFirstNumber()
    {
        return firstNumber;
    }

    public int getSecondNumber()
    {
        return secondNumber;
    }
}
