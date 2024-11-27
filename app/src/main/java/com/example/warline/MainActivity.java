package com.example.warline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnDaging, btnSayur, btnBuah, btnSembako, btnKeranjang;
    TextView saldoText, userText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences share = getSharedPreferences("Data", MODE_PRIVATE);
        String email = share.getString("email", "");
        String pass = share.getString("pass", "");
        String user = share.getString("username", "");
        double saldo = (double)share.getLong("saldo", 0);

        btnDaging = findViewById(R.id.dagingbtn);
        btnSayur = findViewById(R.id.sayuranbtn);
        btnBuah = findViewById(R.id.buahbtn);
        btnSembako = findViewById(R.id.sembakobtn);
        btnKeranjang = findViewById(R.id.keranjangBtn);

        saldoText = findViewById(R.id.saldo);
        userText = findViewById(R.id.userView);

        User usernow = new Customer(email, pass, saldo, user);

        saldoText.setText(usernow.getSaldotext());
        userText.setText(usernow.getNama());

        Intent intent = getIntent();
        ArrayList<Keranjang> cartProducts = (ArrayList<Keranjang>) intent.getSerializableExtra("cartList");


        btnDaging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DagingActivity.class);
                startActivity(intent);
            }
        });

        btnSayur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SayurActivity.class);
                startActivity(intent);
            }
        });

        btnBuah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BuahActivity.class);
                startActivity(intent);
            }
        });

        btnSembako.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SembakoActivity.class);
                startActivity(intent);
            }
        });

        btnKeranjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, KeranjangActivity.class);
                startActivity(intent);
            }
        });
    }

    public class Customer extends User {
        public Customer(String email, String pass, double saldo, String nama) {
            super(email, pass, saldo, nama);
        }
    }

}