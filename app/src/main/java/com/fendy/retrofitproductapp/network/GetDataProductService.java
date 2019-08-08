package com.fendy.retrofitproductapp.network;

import com.fendy.retrofitproductapp.model.ProductList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataProductService {

    @GET("products")
    Call<ProductList> getProductData();
}
