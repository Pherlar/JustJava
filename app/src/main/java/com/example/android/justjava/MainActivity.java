package com.example.android.justjava;

/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
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

        //get name from input box
        EditText nameEditText = findViewById(R.id.nameEditTextView);
        String customerName = nameEditText.getText().toString();

        // check to see if whipped cream checkbox is clicked
        CheckBox whippedCreamCheckbox = findViewById(R.id.checkBox1);
        boolean hasWhippedCreamBoolean = whippedCreamCheckbox.isChecked();
        Log.i("MainActivity", "has whipped cream "+ hasWhippedCreamBoolean);

        // check to see if chocolate checkbox is clicked
        CheckBox chocolateCheckbox = findViewById(R.id.checkBox2);
        boolean hasChocolateBoolean = chocolateCheckbox.isChecked();
        Log.i("MainActivity", "has chocolate "+ hasChocolateBoolean);

        int price = calculatePrice(hasWhippedCreamBoolean, hasChocolateBoolean);
        displayMessage(createOrderSummary(customerName,quantity,price,hasWhippedCreamBoolean,hasChocolateBoolean));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method is called when the increment button is clicked.
     */
    public void incrementQuantity(View view) {
        if (quantity <10)
        {
            quantity = quantity + 1;
        }
        else
        {
            Toast.makeText(this, "Max Coffees Reached!", Toast.LENGTH_SHORT).show();
        }

        displayQuantity (quantity);

    }

    /**
     * This method is called when the decrement button is clicked.
     */

    public void decrementQuantity(View view) {

        if (quantity >0)
        {
            quantity = quantity - 1;
        }
        else{
            Toast.makeText(this, "Min Coffees Reached!", Toast.LENGTH_SHORT).show();

        }

        displayQuantity (quantity);

    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    /**
     * This method calculates the total price
     */
    private int calculatePrice (boolean hasWhippedCreamBoolean, boolean hasChocolateBoolean ){
        int price = quantity*5;
        if (hasWhippedCreamBoolean)
        {
            price += (1 * quantity);
        }
        if (hasChocolateBoolean)
        {
            price += (2 * quantity);
        }
    return price;
    }

    private String createOrderSummary
            (String customerName, int quantity, int price, boolean hasWhippedCreamBoolean, boolean hasChocolateBoolean){
        String priceMessage = "Name:  " + customerName;
        priceMessage += "\nAdd whipped Cream? " + hasWhippedCreamBoolean;
        priceMessage += "\nAdd Chocolate? " + hasChocolateBoolean;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank You!";
        return priceMessage;

    }




}