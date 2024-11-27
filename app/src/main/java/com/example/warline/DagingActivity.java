package com.example.warline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class DagingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daging);

        // Get a reference to your ListView or GridView
        ListView listView = findViewById(R.id.listDaging); // Replace with your actual ID

        // Create a list of Product objects (replace this with your data)
        List<Daging> productList = getDagingProductList();

        // Create the CustomListAdapter and set it as the adapter for the ListView
        CustomListAdapter adapter = new CustomListAdapter(this, productList);
        listView.setAdapter(adapter);

    }

    class Daging extends Product{
        public Daging (String name, double price, int stok, int ImageResource){
            super(name, price, stok, ImageResource);
        }

    }
    // Replace this with your actual data retrieval method
    private List<Daging> getDagingProductList() {
        List<Daging> productList = new ArrayList<>();
        productList.add(new Daging("Daging Ayam (1/4 Kg)", 15000, 20, R.mipmap.daging_ayam_foreground));
        productList.add(new Daging("Daging Ayam (1/2 Kg)", 25000, 20, R.mipmap.daging_ayam_foreground));
        productList.add(new Daging("Daging Ayam (1 Kg)", 40000, 20, R.mipmap.daging_ayam_foreground));
        productList.add(new Daging("Daging Sapi (1/4 Kg)", 30000, 10, R.mipmap.daging_sapi_foreground));
        productList.add(new Daging("Daging Sapi (1/2 Kg)", 55000, 10, R.mipmap.daging_sapi_foreground));
        productList.add(new Daging("Daging Sapi (1 Kg)", 100000, 10, R.mipmap.daging_sapi_foreground));
        return productList;
    }
}