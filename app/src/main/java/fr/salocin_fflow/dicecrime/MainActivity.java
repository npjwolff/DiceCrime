package fr.salocin_fflow.dicecrime;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DiceCrime";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollButton = (Button) findViewById(R.id.rollButton);
        final ImageView leftDice = (ImageView) findViewById(R.id.image_leftDice);
        final ImageView centertDice = (ImageView) findViewById(R.id.image_centerDice);
        final ImageView rightDice = (ImageView) findViewById(R.id.image_rightDice);
        final TextView result = (TextView) findViewById(R.id.textView_result);


        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int[] dices = {
                    rollDice(leftDice),
                    rollDice(centertDice),
                    rollDice(rightDice)
                };


                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(dices[0]*100+dices[1]*10 + dices[2]);
            };



            private int rollDice (ImageView dice){



                final int[] diceArray = {
                        R.drawable.dice1,
                        R.drawable.dice2,
                        R.drawable.dice3,
                        R.drawable.dice4,
                        R.drawable.dice5,
                        R.drawable.dice6
                };

                Random randomNoGen = new Random();
                int roll = 0;
                roll = randomNoGen.nextInt(6);
                dice.setImageResource(diceArray[roll]);

                Log.d(TAG, "rollDice: a dice has been rolled: " + roll);
                

                return roll;

            };

        });

    }
}
