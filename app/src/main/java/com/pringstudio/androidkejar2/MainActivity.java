package com.pringstudio.androidkejar2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

import static com.pringstudio.androidkejar2.R.id.btnOrder;

public class MainActivity extends AppCompatActivity {

    // Global variabel
    int quantity = 2;
    CheckBox checkHasTopping;
    // Snippet bisa dicopy di sini: https://git.io/vXKTW

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Aplikasi Pesan Kopi");

        checkHasTopping = (CheckBox) findViewById(R.id.checkHasTopping);
        checkHasTopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btnOrder = (Button) findViewById(R.id.btnOrder);

                if(checkHasTopping.isChecked()){
                    btnOrder.setVisibility(View.VISIBLE);
                }else {
                    btnOrder.setVisibility(View.GONE);
                }
            }
        });
    }

    // Membuat handler click tombol order
    public void submitOrder(View view){
        int price = calculatePrice(quantity);
        String priceMessage = createOrderSummary(price);

        displayMessage(priceMessage);

        Intent orderIntent = new Intent(this,OrderActivity.class);
        orderIntent.putExtra("KUNCI",priceMessage);
        startActivity(orderIntent);

    }

    // Aksi untuk menampilkan order
    private void displayOrder(int number){
        // Cari TextView berdasarkan ID di layout
        TextView quantityOrderText = (TextView) findViewById(R.id.text_quantity);
        // Ubah Text
        quantityOrderText.setText(""+number);
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

    // Membuat method calculate price
    // Untuk menghitung harga
    private int calculatePrice(int quantity){
        return quantity * 5;
    }

    private String createOrderSummary(int price){
        CheckBox checkHasTopping = (CheckBox) findViewById(R.id.checkHasTopping);
        boolean hasTopping = checkHasTopping.isChecked();
        String pakaiMocca = "Tidak";

        EditText textNama = (EditText) findViewById(R.id.text_nama);
        String namaPemesan = textNama.getText().toString();

        if(hasTopping){
            pakaiMocca = "Ya";
        }else{
            pakaiMocca = "Tidak";
        }

        String priceMessage = "Name : "+namaPemesan;
        priceMessage += "\nPakai Mocca? "+pakaiMocca;
        priceMessage += "\nQuantity: "+quantity;
        priceMessage += "\nTotal $"+price;
        priceMessage += "\nThank You!";

        return priceMessage;
    }
}
