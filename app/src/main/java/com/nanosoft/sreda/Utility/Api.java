package com.nanosoft.sreda.Utility;

import com.nanosoft.sreda.Model.CapacityReport_Info;
import com.nanosoft.sreda.Model.FuelGenerationRepoResponse;
import com.nanosoft.sreda.Model.GetTechnologyNames_Info;
import com.nanosoft.sreda.Model.Info_TechWiseGenReportResponse;
import com.nanosoft.sreda.Model.UserLoginResponse_Info;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

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


    @GET("capacity_report")
    Call<CapacityReport_Info> getCapacity(
            @Query("email") String email,
            @Query("password") String password

    );

    @GET("fuel_generation_report")
    Call<FuelGenerationRepoResponse> getFuel(
            @Query("email") String email,
            @Query("password") String password

    );


    @GET("get_technology_names")
    Call<GetTechnologyNames_Info> getTechnologyName(
            @Query("email") String email,
            @Query("password") String password

    );

    @GET("technology_wise_generation_report")
    Call<Info_TechWiseGenReportResponse> getTechnologyNameReport(
            @Query("email") String email,
            @Query("password") String password

    );



}
