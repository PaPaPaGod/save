package com.price.rxjava.test;


import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by price on 1/10/2017.
 */

public interface NewsService {
    /**
     * 根据newsid获取对应的资讯数据
     * 如果不需要转换成Json数据,可以用了ResponseBody;
     * @return call
     */
    @FormUrlEncoded
    @POST("login")
    Observable<Example> getUser(@Field("phone_num") String username,
                                @Field("password") String password);
}
