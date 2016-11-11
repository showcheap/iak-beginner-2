package com.pringstudio.androidkejar2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Snippet bisa dicopy di sini: https://git.io/vXKTW

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Membuat handler click tombol order
    public void submitOrder(View view){
        // Panggil Fungsi saat tombol di klik
        displayOrder(2);

        displayOrder(7 * 2);
    }

    // Aksi untuk menampilkan order
    private void displayOrder(int number){
        // Cari TextView berdasarkan ID di layout
        TextView quantityOrderText = (TextView) findViewById(R.id.text_quantity);
        // Ubah Text
        quantityOrderText.setText(""+number);
    }
}
