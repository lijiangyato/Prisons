package com.family.prisons.prisonshttp.interceptor;

import android.content.Context;
import android.content.SharedPreferences;


import com.socks.library.KLog;

import java.io.IOException;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import okhttp3.Interceptor;
import okhttp3.Response;

import static android.content.Context.MODE_PRIVATE;
/**
 * Created by ThinkPad on 2018/6/11.
 */

public class IesInterceptorReceivedCook implements Interceptor {

    private Context context;

    public IesInterceptorReceivedCook(Context context) {
        super();
        this.context = context;


    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Response originalResponse = chain.proceed(chain.request());
        //这里获取请求返回的cookie
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            final StringBuffer cookieBuffer = new StringBuffer();


            Flowable.fromIterable(originalResponse.headers("Set-Cookie"))
                    .map(new Function<String, String>() {
                        @Override
                        public String apply(@NonNull String s) throws Exception {

                            KLog.e("GGGGGGGGGGGGG", s);
                            String[] cookieArray = s.split(";");
                            return cookieArray[0];

                        }
                    })
                    .subscribe(new Consumer<String>() {
                        @Override
                        public void accept(@NonNull String cookie) throws Exception {

                            KLog.e("SSTCOOKIE", cookie);
                            cookieBuffer.append(cookie).append(";");

                        }
                    });


            SharedPreferences sharedPreferences = context.getSharedPreferences("cookie", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            String sting = cookieBuffer.toString();
            String[] idArr = sting.split(";");

            String idArre = idArr[0];
            editor.putString("idarre", idArre);
            String idArrg;
            if (idArr.length == 2) {
                idArrg = idArr[1];
                editor.putString("idarreg", idArrg);


            }
            editor.commit();


        }
        return originalResponse;
    }
}