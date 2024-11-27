package com.example.warline;

import com.example.warline.CartManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Context context;
    private List<? extends Product> productList;

    public CustomListAdapter(Context context, List<? extends Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_list_item, parent, false);
        }

        ImageView productImage = convertView.findViewById(R.id.listItemImage);
        TextView productName = convertView.findViewById(R.id.listItemNama);
        TextView productStok = convertView.findViewById(R.id.listItemStok);
        TextView productHarga = convertView.findViewById(R.id.listItemHarga);
        Button addToCartButton = convertView.findViewById(R.id.listItemButton);

        Product product = productList.get(position);

        productImage.setImageResource(product.getImageResource()); // Set the product's image
        productName.setText(product.getName());
        productStok.setText(product.getStok2());
        productHarga.setText(product.getHarga());
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart(productList.get(position));
            }
        });

        return convertView;
    }

    public void addToCart(Product product) {
        List<KeranjangI> selectedProducts = CartManager.getSelectedProducts();

        boolean productExists = false;
        for (KeranjangI cartProduct : selectedProducts) {
            if (cartProduct.getName().equals(product.getName())) {
                productExists = true;
                cartProduct.setJumlah(cartProduct.getJumlah() + 1);
                break;
            }
        }

        if (!productExists){
            selectedProducts.add(new KeranjangI(product.getName(), product.getPrice(), 1, product.getImageResource()));
        }
        CartManager.setSelectedProducts(selectedProducts);
    }
}


