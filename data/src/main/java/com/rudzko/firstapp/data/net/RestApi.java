package com.rudzko.firstapp.data.net;

import com.rudzko.firstapp.data.entity.SourceProfile;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * @author Olga Rudzko
 */

public interface RestApi {

    @GET("data/sourceProfile")
    Observable<List<SourceProfile>> getSourceProfiles();

    @POST("data/sourceProfile")
    Observable<Void> saveProfile(@Body SourceProfile profile);

    @PUT("data/sourceProfile")
    Observable<Void> updateProfile(@Body SourceProfile profile);

//
//    @GET("data/sourceProfile?id={id}\"")
//    Observable<List<SourceProfile>> getSourceProfiles(@Path("id") String id);
}
