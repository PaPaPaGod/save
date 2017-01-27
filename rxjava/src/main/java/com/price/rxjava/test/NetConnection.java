package com.price.rxjava.test;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by price on 1/10/2017.
 */

public class NetConnection {
    private static final String TAG = "retrofit test";

    public static void connect(){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())//解析方法
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                //这里建议：- Base URL: 总是以/结尾；- @Url: 不要以/开头
                .baseUrl("http://takeapp.com.cn/Home/register/")
                .build();
        NewsService api = retrofit.create(NewsService .class);
        api.getUser("13222222222",MD5Tool.md5("123")).subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).doOnNext(new Consumer<Example>() {
            @Override
            public void accept(Example example) throws Exception {
                if(example.getData().getToken().isEmpty()){
                    Log.e(TAG,"token is null");
                }else{
                    Log.e(TAG,example.getData().getToken());
                }
            }
        }).subscribe(new Observer<Example>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Example example) {
                if(example.getData().getToken().isEmpty()){
                    Log.e(TAG,"onNext: token is null");
                }else{
                    Log.e(TAG,"onNext: "+example.getData().getToken());
                }
            }

            @Override
            public void onError(Throwable e) {
//                Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
                Log.e(TAG,"onError");
            }

            @Override
            public void onComplete() {

            }
        });
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                try {
//                    Log.e(TAG,response.body().string());
//                    Log.e(TAG,"exm");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//            }
//        });
    }
}
