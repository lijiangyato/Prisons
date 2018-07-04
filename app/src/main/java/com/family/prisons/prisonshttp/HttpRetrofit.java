package com.family.prisons.prisonshttp;

import android.content.Context;

import com.alibaba.android.arouter.exception.InitException;
import com.family.prisons.prisonsfather.Application;
import com.family.prisons.prisonshttp.constant.Constant;
import com.family.prisons.prisonshttp.interceptor.IngInterceptorLog;
import com.family.prisons.prisonshttp.interceptor.InterceptorCookiesInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ThinkPad on 2018/6/11.
 */

public class HttpRetrofit {

    private static Application mApplication;
    private static HttpRetrofit mhttpRetrofit;
    private volatile static boolean hasInit = false;
    private static Retrofit receivedCookiesRetrofit, sendCookiesRetrofit, noCookiesRetrofit, sendReceivedCookiesRetrofit;

    public HttpRetrofit(Application application) {
        this.mApplication = application;
    }

    // 提供一个全局的静态方法
    public static void init(Application mapplication) {
        if (mhttpRetrofit == null) {
            synchronized (HttpRetrofit.class) {
                if (mhttpRetrofit == null) {
                    mhttpRetrofit = new HttpRetrofit(mapplication);
                    hasInit = true;
                    new InterceptorCookiesInterceptor(mApplication);
                }
            }
        }
    }

    /**
     * 请求Retrofit（保存Cookies）
     */
    public static Retrofit getReceivedCookiesRetrofit() {
        if (!hasInit)
            throw new InitException("HttpRetrofit::Init::Invoke init(context) first!");
        else {
            if (receivedCookiesRetrofit == null) {
                synchronized (Retrofit.class) {
                    if (receivedCookiesRetrofit == null) {
                        receivedCookiesRetrofit = new Retrofit.Builder()
                                .addConverterFactory(GsonConverterFactory.create())
                                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                .baseUrl(Constant.URL)
                                .client(new OkHttpClient.Builder()
                                        .retryOnConnectionFailure(true)
                                        .addInterceptor(new IngInterceptorLog())
                                        .addInterceptor(new InterceptorCookiesInterceptor(mApplication))
                                        .connectTimeout(15, TimeUnit.SECONDS)
                                        .build())
                                .build();
                    }
                }
            }
            return receivedCookiesRetrofit;
        }
    }

    /**
     * 请求Retrofit（携带Cookies）
     */
    public static Retrofit getRequestCookiesRetrofit() {
        if (!hasInit)
            throw new InitException("HttpRetrofit::Init::Invoke init(context) first!");
        else {
            if (sendCookiesRetrofit == null) {
                synchronized (Retrofit.class) {
                    if (sendCookiesRetrofit == null) {
                        sendCookiesRetrofit = new Retrofit.Builder()
                                .addConverterFactory(GsonConverterFactory.create())
                                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                .baseUrl(Constant.URL)
                                .client(new OkHttpClient.Builder()
                                        .retryOnConnectionFailure(true)
                                        .addInterceptor(new IngInterceptorLog())
                                        .addInterceptor(new InterceptorCookiesInterceptor(mApplication))
                                        .connectTimeout(15, TimeUnit.SECONDS)
                                        .build())
                                .build();
                    }
                }
            }
            return sendCookiesRetrofit;
        }
    }


    /**
     * 获取默认Retrofit（无Cookies）
     */
    public static Retrofit getDefaultRetrofit() {
        if (!hasInit)
            throw new InitException("HttpRetrofit::Init::Invoke init(context) first!");
        else {
            if (noCookiesRetrofit == null) {
                synchronized (Retrofit.class) {
                    if (noCookiesRetrofit == null) {
                        noCookiesRetrofit = new Retrofit.Builder()
                                .addConverterFactory(GsonConverterFactory.create())
                                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                .baseUrl(Constant.URL)
                                .client(new OkHttpClient.Builder()
                                        .retryOnConnectionFailure(true)
                                        .addInterceptor(new IngInterceptorLog())
                                        .connectTimeout(15, TimeUnit.SECONDS)
                                        .build())
                                .build();
                    }
                }
            }
            return noCookiesRetrofit;
        }
    }


    /**
     * 获取Retrofit（带Cookies并保持新Cookies）
     */
    public static Retrofit getRequestReceivedCookiesRetrofit() {
        if (!hasInit)
            throw new InitException("HttpRetrofit::Init::Invoke init(context) first!");
        else {
            if (sendReceivedCookiesRetrofit == null) {
                synchronized (Retrofit.class) {
                    if (sendReceivedCookiesRetrofit == null) {
                        sendReceivedCookiesRetrofit = new Retrofit.Builder()
                                .addConverterFactory(GsonConverterFactory.create())
                                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                .baseUrl(Constant.URL)
                                .client(new OkHttpClient.Builder()
                                        .retryOnConnectionFailure(true)
                                        .addInterceptor(new IngInterceptorLog())
                                        .addInterceptor(new InterceptorCookiesInterceptor(mApplication))
                                        .addInterceptor(new InterceptorCookiesInterceptor(mApplication))
                                        .connectTimeout(15, TimeUnit.SECONDS)
                                        .build())
                                .build();
                    }
                }
            }
            return sendReceivedCookiesRetrofit;
        }
    }
}

