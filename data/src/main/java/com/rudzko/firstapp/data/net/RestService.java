package com.rudzko.firstapp.data.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rudzko.firstapp.data.entity.SourceProfile;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Olga Rudzko
 */

public class RestService {

    private static final RestService instance = new RestService();
    private RestApi api;
    private RestService(){
        init();
    }
    public static RestService getInstance(){
        return instance;
    }
        private void init(){

            HttpLoggingInterceptor logging=new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            //provides connection to Internet
            OkHttpClient client= new OkHttpClient.Builder().readTimeout(10, TimeUnit.SECONDS)
                    .connectTimeout(10, TimeUnit.SECONDS).addInterceptor(logging).build();

            Gson gson = new GsonBuilder().create();

            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl("https://api.backendless.com/70E26EEB-3ACD-601D-FF12-541F239F8800/FDBEBFDC-2C3B-E045-FF00-D718E4134700/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson)).client(client).build();
            api=retrofit.create(RestApi.class);
        }

    public Observable<List<SourceProfile>> getSourceProfiles(){
      return api.getSourceProfiles();
    }

    public Observable<Void> saveProfile (SourceProfile profile){
        return api.saveProfile(profile);
    }

    public Observable<Void> updateProfile(SourceProfile profile){
        return api.updateProfile(profile);
    }
}
