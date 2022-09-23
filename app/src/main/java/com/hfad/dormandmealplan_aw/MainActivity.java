package com.hfad.dormandmealplan_aw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * MainActivity Class which calls all the parts that run code
 * in the layout and create the action they compute
 * Author: Austin Weaver
 */
public class MainActivity extends AppCompatActivity {
    /**
     * onCreate function that creates all the action that run when selected
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Calls each object in the layout view and creates a editable
        object which can be called within the function
         */
        Spinner spinnerDorm = (Spinner) findViewById(R.id.spnDorm);
        Spinner spinnerMeal = (Spinner) findViewById(R.id.spnMeal);
        Button btnFindCost = (Button) findViewById(R.id.btn_generate);
        TextView tvCost = (TextView) findViewById(R.id.Cost);
        TextView errorCheck = (TextView) findViewById(R.id.Error);

        /**
         * BtnFindCost.setOnClickListener runs when the button with the id findcost get selected
         * and this function runs the required lines to complete the requested action
         */
        btnFindCost.setOnClickListener(new View.OnClickListener() {
            //Onclick listener runs when the button is clicked on the app
            @Override
            public void onClick(View view) {
                //Total of the dorm and meal plan
                double total = 0;

                //If the choice that is selected equals the text, then it adds the required amount to the total variable
                if (spinnerDorm.getSelectedItem().equals("Allen Hall: $1800")) {
                    total += 1800;
                    errorCheck.setText("");
                } else if (spinnerDorm.getSelectedItem().equals("Pike Hall: $2200")) {
                    total += 2200;
                    errorCheck.setText("");
                } else if (spinnerDorm.getSelectedItem().equals("Farthing Hall: $2800")) {
                    total += 2800;
                    errorCheck.setText("");
                } else if (spinnerDorm.getSelectedItem().equals("University Suites: $3000")) {
                    total += 3000;
                    errorCheck.setText("");
                }

                //Same as above, if the choice selected is equals to the string below then it adds the price to the total
                if (spinnerMeal.getSelectedItem().equals("7 meals per Week: $600")) {
                    total += 600;
                    errorCheck.setText("");
                } else if (spinnerMeal.getSelectedItem().equals("14 meals per Week: $1100")) {
                    total += 1100;
                    errorCheck.setText("");
                } else if (spinnerMeal.getSelectedItem().equals("Unlimited meals per week: $1800")) {
                    total += 1800;
                    errorCheck.setText("");
                }

                //Error check, if any of the choices equals None then generate
                //error and display to user, else continue as normal
                if (spinnerDorm.getSelectedItem().equals("None") || spinnerMeal.getSelectedItem().equals("None")) {
                    tvCost.setText("");
                    errorCheck.setText("Error: Invalid Choices. Please make sure you have chosen from both drop down boxes.");
                } else {
                    tvCost.setText(String.format("$%.2f", total));

                }
            }
        });
    }
}