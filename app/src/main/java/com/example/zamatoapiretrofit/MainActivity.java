package com.example.zamatoapiretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.zamatoapiretrofit.Json.BaseClient;
import com.example.zamatoapiretrofit.Json.CollectionData;
import com.example.zamatoapiretrofit.Json.CollectionResponse;
import com.example.zamatoapiretrofit.Json.NetworkApi;
import com.example.zamatoapiretrofit.RecyclerView.CollectionAdapter;
import com.squareup.picasso.Picasso;
//import com.nostra13.universalimageloader.core.ImageLoader;
//import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.net.HttpURLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    RecyclerView recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycle = (RecyclerView)findViewById(R.id.recycle);
        recycle.setLayoutManager(new LinearLayoutManager(this));


        getLatestCollection(4);


    }
    public void  getLatestCollection(int CityId){

        NetworkApi apiService = BaseClient.getBaseClient().create(NetworkApi.class);

        //To exectue our Network Request We have to use the Call Object
        Call<CollectionResponse> call =  apiService.getCollectionList(CityId,null,null,null);

        // now we Simply have to execute Call and get our Response back
        call.enqueue(new Callback<CollectionResponse>() {
            @Override
            public void onResponse(Call<CollectionResponse> call, Response<CollectionResponse> response) {
                // This method will be Trigger when we get back response from server but it doesnot mean our request is Sucessful
                //  bcz Server can response whith 404 code which mean the data we are looking for is not heir

                //it will run when it get resonse and response code is OK
                if (response.isSuccessful() && HttpURLConnection.HTTP_OK == response.code()){

                    Toast.makeText(MainActivity.this, "Response Recived", Toast.LENGTH_SHORT).show();
                    CollectionResponse abc = response.body();
                    CollectionAdapter adapter = new CollectionAdapter(abc.getCollection());
                    recycle.setAdapter(adapter);

                }else {
                    // this is when server give 404 code in response
                    Toast.makeText(MainActivity.this, "Unsucessfull", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CollectionResponse> call, Throwable t) {
                // this method onFaliure means when something went wrong with comminucation between Server
                Toast.makeText(MainActivity.this, "Please Try Again Later", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
