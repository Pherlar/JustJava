package com.example.android.justjava;

/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
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
        int price = calculatePrice();
        // check to see if order button is clicked
        CheckBox whippedCreamCheckbox = findViewById(R.id.checkBox1);
        boolean hasWhippedCreamBoolean = whippedCreamCheckbox.isChecked();
        Log.i("MainActivity", "has whipped cream "+ hasWhippedCreamBoolean);

        displayMessage(createOrderSummary(quantity,price,hasWhippedCreamBoolean));
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
        quantity =  quantity + 1;
        displayQuantity (quantity);

    }

    /**
     * This method is called when the decrement button is clicked.
     */

    public void decrementQuantity(View view) {
        quantity = quantity - 1;
        displayQuantity (quantity );
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
    private int calculatePrice (){
        return quantity * 5;

    }

    private String createOrderSummary (int quantity, int price, boolean hasWhippedCreamBoolean){
        String priceMessage = "Name:  Chris";
        priceMessage += "\nAdd whipped Cream? " + hasWhippedCreamBoolean;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank You!";
        return priceMessage;

    }




}