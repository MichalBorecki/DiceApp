package com.example.android.diceapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result_view;
    int spinnerDice;
    int spinnerSides;
    public String result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result_view = findViewById(R.id.result_view);

        //get the spinner (quantity of sides) from the xml.
        Spinner dropdown1 = findViewById(R.id.spinner_sides);
        //create a list of items for the spinner-dices.
        Integer[] items1 = new Integer[]{6, 8, 10};
        //create an adapter to describe how the items are displayed.
        ArrayAdapter<Integer> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items1);
        //set the spinners adapter to the previously created one.
        dropdown1.setAdapter(adapter1);

        //get the spinner (quantity of dice)from the xml.
        Spinner dropdown2 = findViewById(R.id.spinner_dice);
        //create a list of items for the spinner-dices.
        Integer[] items2 = new Integer[]{1, 2};
        //create an adapter to describe how the items are displayed.
        ArrayAdapter<Integer> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        //set the spinners adapter to the previously created one.
        dropdown2.setAdapter(adapter2);
    }

    /**
     * method for button rollButton
     *
     * @return the results of roll.
     */
    public void diceRollResult(View view) {
        // set result on empty value.
        result = "";
        // get value from each spinner.
        String spinnerDiceS = ((Spinner) findViewById(R.id.spinner_dice)).getSelectedItem().toString();
        spinnerDice = Integer.parseInt(spinnerDiceS);
        String spinnerSidesS = ((Spinner) findViewById(R.id.spinner_sides)).getSelectedItem().toString();
        spinnerSides = Integer.parseInt(spinnerSidesS);
        String and = "";
        // check how many dices should be throw and return a result into xml.
        for (int i = 0; i < spinnerDice; i++) {
            int diceRoll = diceRoll();
            if (i == 1) {
                and = "   i   ";
            }
            result += and + diceRoll;
        }
        result_view.setText(result);
    }

    /**
     * method returns a random integer simulating a dice roll with stated quantity of sides.
     *
     * @return random number in the range of 1 to sides.
     */
    public int diceRoll() {
        int rollDice = (int) (Math.random() * spinnerSides + 1);
        return rollDice;
    }
}
