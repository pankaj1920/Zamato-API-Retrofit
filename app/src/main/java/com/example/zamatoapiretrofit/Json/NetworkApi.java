package com.example.zamatoapiretrofit.Json;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface NetworkApi {
    //Create a Method
    //Here we want to getBack List Of PostJson
    // In java interface we didnot provide method body We just declare getPost Method
    // for Later implement of this Interface we requried body for this method and this
    // is what Retrofit will take care it will automatically generate all necesasary code
    // URL = (https://jsonplaceholder.typicode.com/posts)
    //to tell Retrofit what to do we have to annotate this method and put realative url i.e 'posts'
    // the reason to put realitive url in Interface is that we will put 'Base'
    @Headers("user-key: 1bc5f0f40c40c612d336de49e9189526")
    @GET ("collections")
    Call<CollectionResponse> getCollectionList(@Query("city_id") int CityId,
                                               @Query("lat") Double lat,
                                               @Query("lon") Double lon,
                                               @Query("count") Double count);
}
