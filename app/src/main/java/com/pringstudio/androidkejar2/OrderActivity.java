package com.pringstudio.androidkejar2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        String dataku = getIntent().getStringExtra("KUNCI");

        TextView textData = (TextView) findViewById(R.id.textData);
        textData.setText(dataku);
    }
}
