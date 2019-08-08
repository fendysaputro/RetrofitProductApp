package com.fendy.retrofitproductapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.fendy.retrofitproductapp.R;
import com.fendy.retrofitproductapp.adapter.ProductAdapter;
import com.fendy.retrofitproductapp.model.Product;
import com.fendy.retrofitproductapp.model.ProductList;
import com.fendy.retrofitproductapp.network.GetDataProductService;
import com.fendy.retrofitproductapp.network.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ProductAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetDataProductService service = RetrofitInstance.getRetrofitInstance().create(GetDataProductService.class);
        Call<ProductList> call = service.getProductData();

        Log.wtf("URL called", call.request().url() + "");

        call.enqueue(new Callback<ProductList>() {
            @Override
            public void onResponse(Call<ProductList> call, Response<ProductList> response) {
                generateProductList(response.body().getProductArrayList());
            }

            @Override
            public void onFailure(Call<ProductList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "this error, please check later", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void generateProductList(ArrayList<Product> proDataList){
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_product_list);
        adapter = new ProductAdapter(proDataList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
