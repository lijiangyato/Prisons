package com.family.prisons.prisonshttp.interceptor;

/**
 * Created by ThinkPad on 2018/6/11.
 */
import android.content.Context;
import android.content.SharedPreferences;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
public class InterceptorCookiesInterceptor implements Interceptor {

    private Context context;

    public InterceptorCookiesInterceptor(Context context) {
        super();
        this.context = context;

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        final Request.Builder builder = chain.request().newBuilder();
        SharedPreferences sharedPreferences = context.getSharedPreferences("cookie", Context.MODE_PRIVATE);
        String arre = sharedPreferences.getString("idarre", "hh");
        String arrg = sharedPreferences.getString("idarreg", "hh");
        /*String[] ASN = arre.split("=");
        String ASNG = ASN[1];
        String ASNGF = "hh";
        if (!arrg.equals("hh")) {
            String[] ASG = arrg.split("=");
            ASNGF = ASG[1];
        }*/

        // builder.addHeader("Cookie", ASNGF + ";" + ASNG);
        // builder.addHeader("aspnetauth", "","60BF0FAD00DB0BC97FE80B87AFFF627F904BE35CC850FAE0B4BFA3C7C01C2411569A1E658ECA890FA404600965C2CEB303C4CCB87D8E416D05CE49CA84CA3FC1971378771ED7BB2643241EF4B09D787A822AB57A30D1FE4919C6722CAD20B692B4D41D7FDD3D7C20A4B4D22B6943C48E8FC980D755BAA9EA25CC81D911CE11E8CBA13828DA3EE3BA5B842962952F00FF" + ";" + "h44pd442v5cux5eqwvvfhbfd");

        builder.addHeader("Cookie",arrg+";"+arre);

        // KLog.e("ASNGF!"+ASNGF+":"+"ASNG!"+ASNG);
        return chain.proceed(builder.build());
    }

}