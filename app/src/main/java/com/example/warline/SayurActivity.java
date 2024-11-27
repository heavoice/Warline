package com.example.warline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class SayurActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayur);

        // Get a reference to your ListView or GridView
        ListView listView = findViewById(R.id.listSayur); // Replace with your actual ID

        // Create a list of Product objects (replace this with your data)
        List<Sayur> productList = getSayurProductList();

        // Create the CustomListAdapter and set it as the adapter for the ListView
        CustomListAdapter adapter = new CustomListAdapter(this, productList);
        listView.setAdapter(adapter);
    }

    class Sayur extends Product{
        public Sayur (String name, double price, int stok, int ImageResource){
            super(name, price, stok, ImageResource);
        }

    }
    // Replace this with your actual data retrieval method
    private List<Sayur> getSayurProductList() {
        List<Sayur> productList = new ArrayList<>();
        productList.add(new Sayur("Kentang (1 kg)", 12000, 15, R.mipmap.kentang_foreground));
        productList.add(new Sayur("Wortel (1 kg)", 15000, 15, R.mipmap.wortel_foreground));
        productList.add(new Sayur("Kacang Panjang (1 kg)", 10000, 20, R.mipmap.kacang_panjang_foreground));
        productList.add(new Sayur("Kembang Kol (1 Kg)", 9000, 20, R.mipmap.kembang_kol_foreground));
        productList.add(new Sayur("Sawi Putih (1 Kg)", 10000, 20, R.mipmap.sawi_putih_foreground));
        productList.add(new Sayur("Kacang Buncis (1 Kg)", 8000, 20, R.mipmap.buncis_foreground));
        return productList;
    }
}