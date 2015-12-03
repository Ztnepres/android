package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {
    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
//Could not find a method onCheckboxClicked(View) in the activity class com.example.android.justjava.MainActivity for onClick handler
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        Log.v("MainActivity","Has whipped Cream: "+ hasWhippedCream);
        int price= quantity*5;
        String priceMessage ="Total: $"+price + "\nThank you!";
        displayMessage(priceMessage);
    }
    /**
     * This method is called when the plus button(+) is clicked.
     */
    public void increment(View view){
        quantity+=1;
        display(quantity);
    }
    /**
     * This method is called when the minus(-) button is clicked.
     */
    public void decrement(View view){
        quantity-=1;
        display(quantity);
    }
    public void displayPrice(int view) {

        display(1);
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}