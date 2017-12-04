package com.nanosoft.sreda.Utility;

import com.nanosoft.sreda.Model.UserLoginResponse_Info;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Sadi on 11/18/2017.
 */

public interface Api {

    //String BASE_URL = "http://offerian.com/";
    String BASE_URL = "http://192.168.0.119/renewableenergy/api/";


    @FormUrlEncoded
    @POST("login")
    Call<UserLoginResponse_Info> getLoginUser(
            @Field("email") String email,
            @Field("password") String password

    );

  /*  @FormUrlEncoded
    @POST("/api/apps/allbusiness")
    Call<List<BusinessInfo>> getAllBusiness(
            @Field("session_id") String session_id,
            @Field("latitude") String latitude,
            @Field("longitude") String longitude
    );*/

}
