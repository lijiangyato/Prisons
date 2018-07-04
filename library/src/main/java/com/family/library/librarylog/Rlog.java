package com.family.library.librarylog;
import com.socks.library.KLog;

/**
 * Created by ThinkPad on 2018/6/12.
 */

public class Rlog {
    public static  void  Log(String name,String isSucess,String errCode){
        KLog.a(name+"——网络请求——"+isSucess+"——错误码——"+errCode);
    }
}
