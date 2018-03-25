package com.sebasku.networks.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fadil on 3/25/18.
 */

public class ApiClient {
  public static final String BASE_URL = "http://149.129.212.12:3000/api/";
  private static Retrofit retrofit = null;
  public static Retrofit getClient() {
    if (retrofit==null) {
      retrofit = new Retrofit.Builder()
              .baseUrl(BASE_URL)
              .addConverterFactory(GsonConverterFactory.create())
              .build();
    }
    return retrofit;
  }
}