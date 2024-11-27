package com.example.warline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomKeranjangAdapter extends BaseAdapter {
    private Context context;
    private List<KeranjangI> selectedProducts;

    public CustomKeranjangAdapter(Context context, List<KeranjangI> selectedProducts) {
        this.context = context;
        this.selectedProducts = selectedProducts;
    }

    @Override
    public int getCount() {
        return selectedProducts.size();
    }

    @Override
    public Object getItem(int position) {
        return selectedProducts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.keranjang_list_item, parent, false);
        }

        ImageView cartImage = convertView.findViewById(R.id.listCartImage);
        TextView cartName = convertView.findViewById(R.id.listCartNama);
        TextView cartJumlah = convertView.findViewById(R.id.listCartJumlah);
        TextView cartHarga = convertView.findViewById(R.id.listCartHarga);
        Button btnMin = convertView.findViewById(R.id.listItemMin);
        Button btnPlus = convertView.findViewById(R.id.listCartPlus);

        btnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        KeranjangI cart = selectedProducts.get(position);

        cartImage.setImageResource(cart.getImageResource());
        cartName.setText(cart.getName());
        cartJumlah.setText(cart.getStok2());
        cartHarga.setText(cart.getHarga());

        return convertView;
    }
}
