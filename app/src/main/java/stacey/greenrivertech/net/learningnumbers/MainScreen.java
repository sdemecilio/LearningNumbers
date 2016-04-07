package stacey.greenrivertech.net.learningnumbers;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainScreen extends AppCompatActivity {

    Random random = new Random();
    private int score = 0;
    private int playTracker = 0;
    private int firstNumber = random.nextInt(10) + 1; // +1 allows for number between 0 and 1
    private int secondNumber = random.nextInt(10) + 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /** created method for random number */
    public void generate(View view)
    {
        firstNumber = random.nextInt(10) + 1;
        secondNumber = random.nextInt(10) + 1;

        // prints random number to button 1
        TextView firstNum = (TextView)findViewById(R.id.firstNumber);
        String firstNumString = String.valueOf(firstNumber);
        firstNum.setText(firstNumString);

        // prevent first and second number from being the same
        if (secondNumber == firstNumber)
        {
            int retrySecond = random.nextInt(10) + 1;
            secondNumber = retrySecond;
        }
        else
        {
            // print second number to button 2
            TextView secondNum = (TextView)findViewById(R.id.secondNumber);
            String secondNumString = String.valueOf(secondNumber);
            secondNum.setText(secondNumString);
        }

        playTracker++; // keeps track of number of plays

        // prints the number of plays to the correct section
        TextView trackPlay = (TextView)findViewById(R.id.numberPlayed);
        String play = String.valueOf(playTracker);
        trackPlay.setText(play);

        // after clicking the "generate" button for first round,
        // button becomes disabled and numbers are automatically regenerated
        Button generateNumbers = (Button)findViewById(R.id.generateNumbers);
        generateNumbers.setEnabled(false);
    }

    /** check to see if firstNumber is bigger than secondNumber */
    public void checkFirstNumber (View view) {

        if (firstNumber > secondNumber) {
            score++;

            // toast which sends a message that answer is correct
            CharSequence text = "That is correct!";
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            CharSequence text = "That is not right. :(";

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            --score;

        }

        TextView scoreNum = (TextView) findViewById(R.id.numberScore);
        String stringScore = String.valueOf(score);
        scoreNum.setText(stringScore);

        generate(view); // automatically regenerates numbers

    }

    /** check to see if secondNumber is bigger than firstNumber */
    public void checkSecoundNumber (View view)
    {
        if (secondNumber > firstNumber)
        {

            score++;

            // toast which sends a message that answer is correct
            CharSequence text = "That is correct!";
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        else
        {
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            CharSequence text = "That is not right. :(";

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            --score;
        }

        TextView scoreNum = (TextView)findViewById(R.id.numberScore);
        String stringScore = String.valueOf(score);
        scoreNum.setText(stringScore);

        generate(view); // automatically regenerates numbers
    }
}
