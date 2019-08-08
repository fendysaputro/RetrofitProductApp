package com.fendy.retrofitproductapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fendy.retrofitproductapp.R;
import com.fendy.retrofitproductapp.model.Product;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private ArrayList<Product> dataList;

    public ProductAdapter(ArrayList<Product> dataList){
        this.dataList = dataList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        holder.txtProName.setText(dataList.get(position).getName());
        holder.txtProPrice.setText(dataList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        TextView txtProName, txtProPrice;

        ProductViewHolder(View viewItem){
            super(viewItem);

            txtProName = viewItem.findViewById(R.id.txt_product_name);
            txtProPrice = viewItem.findViewById(R.id.txt_product_price);
        }
    }
}
