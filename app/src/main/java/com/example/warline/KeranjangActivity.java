package com.example.warline;

import androidx.appcompat.app.AppCompatActivity;

import com.example.warline.KeranjangI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class KeranjangActivity extends AppCompatActivity {

    List<KeranjangI> selectedProducts = CartManager.getSelectedProducts();
    TextView totalText;
    Button btnCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keranjang);

        ListView cartView = findViewById(R.id.listKeranjang);
        List<KeranjangI> selectedProducts = CartManager.getSelectedProducts();

        totalText = findViewById(R.id.totalText);
        btnCheckout = findViewById(R.id.checkoutBtn);

        SharedPreferences share = getSharedPreferences("Data", MODE_PRIVATE);
        String email = share.getString("email", "");
        String pass = share.getString("pass", "");
        String user = share.getString("username", "");
        final double[] saldo = {(double) share.getLong("saldo", 0)};

        CustomKeranjangAdapter adapter = new CustomKeranjangAdapter(this, selectedProducts);

        // Set the adapter for the listview
        cartView.setAdapter(adapter);

        totalHarga();

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saldo[0] = saldo[0] - total;
                SharedPreferences share = getSharedPreferences("Data", MODE_PRIVATE);
                SharedPreferences.Editor editor = share.edit();
                editor.putLong("saldo", (long) saldo[0]);
                editor.apply();
                checkout(view);
                Intent intent = new Intent(KeranjangActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void checkout (View view){
        if (selectedProducts.isEmpty()){
            Toast.makeText(KeranjangActivity.this, "Daftar pesanan kosong!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(KeranjangActivity.this, "Pesanan berhasil dibuat", Toast.LENGTH_SHORT).show();
            selectedProducts.clear();
        }
    }
    double total;

    private double calctotal() {
        for (KeranjangI cartProduct : selectedProducts) {
            Double totalT = cartProduct.totalHarga(cartProduct.getPrice(), cartProduct.getJumlah());
            total += totalT;
        }
        return total;
    }
    public void totalHarga(){
        if (selectedProducts.isEmpty()){
            totalText.setText("0");
        }

        total = calctotal();

        NumberFormat f = new DecimalFormat("#,###");
        String textTotal = f.format(total);
        totalText.setText(textTotal);

    }
}