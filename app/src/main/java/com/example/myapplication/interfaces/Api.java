package com.example.myapplication.interfaces;


import com.example.myapplication.bean.CurriculumBean;
import com.example.myapplication.bean.IndexBean;
import com.example.myapplication.bean.LoginBean;
import com.example.myapplication.bean.TypeIndexBean;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface Api {

    @POST("index/user/login")
    @FormUrlEncoded
    Flowable<LoginBean> login(@Field("mobile") String mobile,@Field("password") String password);

    @POST("index/train/index")
    @Headers({"Content-Type:application/x-www-form-urlencoded"})
    @FormUrlEncoded
    Flowable<IndexBean> getIndex(@Header("x-access-token") String token,@Field("curriculum") String curriculum,@Field("type") String type,@Field("page") String page);

    @POST("index/train/type_index")
    @Headers({"Content-Type:application/x-www-form-urlencoded"})
    @FormUrlEncoded
    Flowable<TypeIndexBean> getTypeIndex(@Header("x-access-token") String token, @Field("type") String type, @Field("page") String page);

    @POST("index/train/curriculum_show")
    @Headers({"Content-Type:application/x-www-form-urlencoded"})
    @FormUrlEncoded
    Flowable<CurriculumBean> getCurriculum(@Header("x-access-token") String token, @Field("curriculum_id") String curriculum_id);



}


