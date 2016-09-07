package com.xin.xinprojectsdemo.rxjava;

import android.os.Bundle;
import android.view.View;

import com.xin.xinprojectsdemo.R;
import com.xin.xinprojectsdemo.base.BaseActivity;

import java.io.File;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

public class RxJavaDemoActivity extends BaseActivity {
    File[] folders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_rx_java_demo);

        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hello");
                subscriber.onNext("world");
                subscriber.onCompleted();
            }

        });

        Observable observable1 = Observable.just("hello", "xin");


        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        };
        //订阅
        observable.subscribe(observer);

    }


    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void processClick(View v) {

    }
}
