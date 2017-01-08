package com.price.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "rxJava_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Observable observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                observableEmitter.onNext(1);
                observableEmitter.onNext(2);
                observableEmitter.onComplete();
                observableEmitter.onNext(3);
            }
        });
        Observer observer = new Observer<Integer>() {

            private Disposable mDisposable;
            int i;

            @Override
            public void onSubscribe(Disposable disposable) {
                Log.e(TAG,"onSubscribe");
                mDisposable = disposable;
            }

            @Override
            public void onNext(Integer o) {
                Log.e(TAG,o+"");
                if(1==i){
                    mDisposable.dispose();
                }
                i++;
            }

            @Override
            public void onError(Throwable throwable) {
                Log.e(TAG,"onError");
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"onComplete");
            }
        };
        observable.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer o) throws Exception {
                Log.e(TAG,"accept: "+o);
            }
        });
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
//
//            }
//        }).subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable disposable) {
//
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });

    }
}
