package com.price.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.price.rxjava.test.NetConnection;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "rxJava_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NetConnection.connect();
//        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//                Log.d(TAG, "emit 1");
//                emitter.onNext(1);
//                Thread.sleep(1000);
//
//                Log.d(TAG, "emit 2");
//                emitter.onNext(2);
//                Thread.sleep(1000);
//
//                Log.d(TAG, "emit 3");
//                emitter.onNext(3);
//                Thread.sleep(1000);
//
//                Log.d(TAG, "emit 4");
//                emitter.onNext(4);
//                Thread.sleep(1000);
//
//                Log.d(TAG, "emit complete1");
//                emitter.onComplete();
//            }
//        }).subscribeOn(Schedulers.newThread());
//
//        Observable<String> observable2 = Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
//                Log.d(TAG, "emit A");
//                emitter.onNext("A");
//                Thread.sleep(1000);
//
//                Log.d(TAG, "emit B");
//                emitter.onNext("B");
//                Thread.sleep(1000);
//
//                Log.d(TAG, "emit C");
//                emitter.onNext("C");
//                Thread.sleep(1000);
//
////                Log.d(TAG, "emit complete2");
////                emitter.onComplete();
//            }
//        });
//
//        Observable.zip(observable1, observable2, new BiFunction<Integer, String, String>() {
//            @Override
//            public String apply(Integer integer, String s) throws Exception {
//                return integer + s;
//            }
//        }).subscribe(new Observer<String>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.d(TAG, "onSubscribe");
//            }
//
//            @Override
//            public void onNext(String value) {
//                Log.d(TAG, "onNext: " + value);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d(TAG, "onError");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "onComplete");
//            }
//        });
//
////        Observable observable = Observable.create(new ObservableOnSubscribe<Integer>() {
////            @Override
////            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
////                observableEmitter.onNext(1);
////                observableEmitter.onNext(2);
////                observableEmitter.onComplete();
////                observableEmitter.onNext(3);
////            }
////        });
////        Observer observer = new Observer<Integer>() {
////
////            private Disposable mDisposable;
////            int i;
////
////            @Override
////            public void onSubscribe(Disposable disposable) {
////                Log.e(TAG,"onSubscribe");
////                mDisposable = disposable;
////            }
////
////            @Override
////            public void onNext(Integer o) {
////                Log.e(TAG,o+"");
////                if(1==i){
////                    mDisposable.dispose();
////                }
////                i++;
////            }
////
////            @Override
////            public void onError(Throwable throwable) {
////                Log.e(TAG,"onError");
////            }
////
////            @Override
////            public void onComplete() {
////                Log.e(TAG,"onComplete");
////            }
////        };
////        observable.subscribe(new Consumer<Integer>() {
////            @Override
////            public void accept(Integer o) throws Exception {
////                Log.e(TAG,"accept: "+o);
////            }
////        });
//
////        Observable observable1 = Observable.create(new ObservableOnSubscribe() {
////            @Override
////            public void subscribe(ObservableEmitter e) throws Exception {
////                Log.e(TAG,"ob1:commit 1");
////                e.onNext(1);
////                Thread.sleep(1000);
////
////                Log.e(TAG,"ob1:commit 2");
////                e.onNext(2);
////                Thread.sleep(1000);
////
////                Log.e(TAG,"ob1:commit 3");
////                e.onNext(3);
////                Thread.sleep(1000);
////
////                Log.e(TAG,"ob1:commit 4");
////                e.onNext(4);
////                Thread.sleep(1000);
////
////                Log.e(TAG,"complete");
////                e.onComplete();
////            }
////        }).subscribeOn(Schedulers.io());
////
////        Observable observable2 = Observable.create(new ObservableOnSubscribe() {
////            @Override
////            public void subscribe(ObservableEmitter e) throws Exception {
////                Log.e(TAG,"ob2:commit A");
////                e.onNext("A");
////                Thread.sleep(1000);
////
////                Log.e(TAG,"ob2:commit B");
////                e.onNext("B");
////                Thread.sleep(1000);
////
////                Log.e(TAG,"ob2:commit C");
////                e.onNext("C");
////                Thread.sleep(1000);
////                e.onComplete();
////            }
////        }).subscribeOn(Schedulers.io());
////
////        Observable.zip(observable1, observable2, new BiFunction<Integer,String,String>() {
////            @Override
////            public String apply(Integer integer, String s) throws Exception {
////                return integer+"::"+s;
////            }
////        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
////            @Override
////            public void onSubscribe(Disposable d) {
////                Log.e(TAG,"onSubscribe");
////            }
////
////            @Override
////            public void onNext(String o) {
////                Log.e(TAG,o);
////            }
////
////            @Override
////            public void onError(Throwable e) {
////
////            }
////
////            @Override
////            public void onComplete() {
////                Log.e(TAG,"onComplete");
////            }
////        });
//
//
////        Observable.create(new ObservableOnSubscribe<Integer>() {
////            @Override
////            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
////                e.onNext(1);
////                e.onNext(2);
////                e.onNext(3);
////            }
////        }).flatMap(new Function<Integer, ObservableSource<String>>() {
////            @Override
////            public ObservableSource<String> apply(Integer integer) throws Exception {
////                List<String> list = new ArrayList<String>();
////                for(int i=0;i<3;i++){
////                    list.add("flatmap: "+integer);
////                }
////                return Observable.fromIterable(list).delay(10, TimeUnit.MILLISECONDS);
////            }
////        }).subscribe(new Consumer<String>() {
////            @Override
////            public void accept(String s) throws Exception {
////                Log.e(TAG,s);
////            }
////        });
//
////        Observable.create(new ObservableOnSubscribe<Integer>() {
////            @Override
////            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
////
////            }
////        }).subscribe(new Observer<Integer>() {
////            @Override
////            public void onSubscribe(Disposable disposable) {
////
////            }
////
////            @Override
////            public void onNext(Integer integer) {
////
////            }
////
////            @Override
////            public void onError(Throwable throwable) {
////
////            }
////
////            @Override
////            public void onComplete() {
////
////            }
////        });

    }
}
