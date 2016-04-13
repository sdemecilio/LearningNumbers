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

    private LearningGameModel model = new LearningGameModel();

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

        model.generate();
        Button firstButton = (Button)findViewById(R.id.firstNumber);
        firstButton.setText("" + model.getFirstNumber());

        Button secondButton = (Button)findViewById(R.id.secondNumber);
        secondButton.setText("" + model.getSecondNumber());

        TextView score = (TextView)findViewById(R.id.numberScore);
        score.setText("" + model.getScore());

        TextView gamesPlayed = (TextView)findViewById(R.id.numberPlayed);
        gamesPlayed.setText("" + model.getGamesPlayed());
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

    public void checkFirstNumber (View view)
    {
        boolean result = model.play(LearningGameModel.LEFT_SIDE);
        model.generate();

        model.getFirstNumber();
        model.getSecondNumber();

        model.getScore();
        TextView score = (TextView)findViewById(R.id.numberScore);
        score.setText("" + model.getScore());

        Button leftButton = (Button)findViewById(R.id.firstNumber);
        leftButton.setText("" + model.getFirstNumber());

        Button rightButton = (Button)findViewById(R.id.secondNumber);
        rightButton.setText("" + model.getSecondNumber());

        TextView gamesPlayed = (TextView)findViewById(R.id.numberPlayed);
        score.setText("" + model.getGamesPlayed());

        if (result == true)
        {
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            CharSequence text = "That's correct!";

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else
        {
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            CharSequence text = "That is not correct :(";

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void checkSecondNumber(View view)
    {
        boolean result = model.play(LearningGameModel.RIGHT_SIDE);

        model.generate();
        model.getFirstNumber();
        model.getSecondNumber();

        model.getScore();
        TextView score = (TextView)findViewById(R.id.numberScore);
        score.setText("" + model.getScore());

        Button leftButton = (Button)findViewById(R.id.firstNumber);
        leftButton.setText("" + model.getFirstNumber());

        Button rightButton = (Button)findViewById(R.id.secondNumber);
        rightButton.setText("" + model.getSecondNumber());

        TextView gamesPlayed = (TextView)findViewById(R.id.numberPlayed);
        score.setText("" + model.getGamesPlayed());

        if (result == true)
        {
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            CharSequence text = "That's correct!";

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else
        {
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            CharSequence text = "That is not correct :(";

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}
