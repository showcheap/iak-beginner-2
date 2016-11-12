package com.pringstudio.androidkejar2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    // Global variabel
    int quantity = 2;

    // Snippet bisa dicopy di sini: https://git.io/vXKTW

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Membuat handler click tombol order
    public void submitOrder(View view){
        int price = quantity * 5;
        String priceMessage = "Total: $"+price+"\nThank You!";

        displayMessage(priceMessage);
    }

    // Aksi untuk menampilkan order
    private void displayOrder(int number){
        // Cari TextView berdasarkan ID di layout
        TextView quantityOrderText = (TextView) findViewById(R.id.text_quantity);
        // Ubah Text
        quantityOrderText.setText(""+number);
    }

    private void displayPrice(int number){
        TextView priceText = (TextView) findViewById(R.id.text_price);
        priceText.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void tambahOrder(View view){
        quantity = quantity + 1;
        displayOrder(quantity);
    }

    public void kurangiOrder(View view){
        quantity = quantity - 1;
        displayOrder(quantity);
    }

    private void displayMessage(String message){
        TextView priceText = (TextView) findViewById(R.id.text_price);
        priceText.setText(message);
    }
}
