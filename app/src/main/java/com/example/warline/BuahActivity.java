package com.example.warline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class BuahActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buah);

        // Get a reference to your ListView or GridView
        ListView listView = findViewById(R.id.listBuah); // Replace with your actual ID

        // Create a list of Product objects (replace this with your data)
        List<Buah> productList = getBuahProductList();

        // Create the CustomListAdapter and set it as the adapter for the ListView
        CustomListAdapter adapter = new CustomListAdapter(this, productList);
        listView.setAdapter(adapter);
    }

    class Buah extends Product{
        public Buah (String name, double price, int stok, int ImageResource){
            super(name, price, stok, ImageResource);
        }

    }
    // Replace this with your actual data retrieval method
    private List<Buah> getBuahProductList() {
        List<Buah> productList = new ArrayList<>();
        productList.add(new Buah("Apel (1 kg)", 40000, 5, R.mipmap.apel_foreground));
        productList.add(new Buah("Mangga (1 kg)", 40000, 5, R.mipmap.mangga_foreground));
        productList.add(new Buah("Melon (1 kg)", 30000, 5, R.mipmap.melon_foreground));
        productList.add(new Buah("Semangka (1 Kg)", 20000, 5, R.mipmap.semangka_foreground));
        productList.add(new Buah("Naga (1 Kg)", 20000, 5, R.mipmap.naga_foreground));
        productList.add(new Buah("Jeruk (1 Kg)", 25000, 5, R.mipmap.jeruk_foreground));
        return productList;
    }
}