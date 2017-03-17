package com.example.android.justjava;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    int quantity=0,price=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submitOrder(View view) {
        boolean hasWhippedCream = false;
        CheckBox toppings = (CheckBox) findViewById(R.id.has_whipped_cream);
        hasWhippedCream = toppings.isChecked();
        toppings = (CheckBox) findViewById(R.id.has_choclates);
        price = quantity*5;
        boolean hasChoclates = toppings.isChecked();
        if (hasChoclates) {
            price += quantity*2;
        }
        if (hasWhippedCream)
        {
            price+=quantity*1;
        }
        EditText nameText = (EditText)findViewById(R.id.name_text);
        String customerName = nameText.getText().toString().toUpperCase();
        display(quantity);
        displayPrice(price,hasWhippedCream,hasChoclates,customerName);
    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number,boolean hasWhippedCream,boolean hasChoclate,String name)
    {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        String order = "Name:"+name+"\nExtra whipped Cream: "+hasWhippedCream+"\nChoclate topping:"+hasChoclate+"\nQuantity:"+number/5+"\nTotal:"+number+"rs"+"\nThank You!";
        orderSummaryTextView.setText(order);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just java app");
        intent.putExtra(Intent.EXTRA_TEXT,order);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
    public void increment(View view )
    {
        if(quantity<100) {
            quantity += 1;
            display(quantity);
        }
    }
    public void decrement(View view)
    {
        if(quantity>1)
        {
            quantity -= 1;
            display(quantity);
        }
    }
}
