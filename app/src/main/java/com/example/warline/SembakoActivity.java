package com.example.warline;

import androidx.appcompat.app.AppCompatActivity;

import com.example.warline.CartManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class SembakoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sembako);

        // Get a reference to your ListView or GridView
        ListView listView = findViewById(R.id.listSembako); // Replace with your actual ID

        // Create a list of Product objects (replace this with your data)
        List<Sembako> productList = getSembakoProductList();

        // Create the CustomListAdapter and set it as the adapter for the ListView
        CustomListAdapter adapter = new CustomListAdapter(this, productList);
        listView.setAdapter(adapter);
    }

    class Sembako extends Product{
        public Sembako (String name, double price, int stok, int ImageResource){
            super(name, price, stok, ImageResource);
        }

    }
    // Replace this with your actual data retrieval method
    private List<Sembako> getSembakoProductList() {
        List<Sembako> productList = new ArrayList<>();
        productList.add(new Sembako("Beras Putih (1 Kg)", 14000, 35, R.mipmap.beras_foreground));
        productList.add(new Sembako("Minyak (1 lt)", 15000, 35, R.mipmap.minyak_foreground));
        productList.add(new Sembako("Gula (1 Kg)", 12000, 25, R.mipmap.gula_foreground));
        productList.add(new Sembako("Tepung (1 Kg)", 10000, 55, R.mipmap.tepung_foreground));
        productList.add(new Sembako("Telur (1 Kg)", 25000, 15, R.mipmap.telur_foreground));
        productList.add(new Sembako("Gas LPG (3 Kg)", 20000, 25, R.mipmap.gas_foreground));
        return productList;
    }
}