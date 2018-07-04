package com.family.prisons.prisonsdata;

/**
 * Created by ThinkPad on 2018/6/12.
 */

public interface IUnifiedDataListenerUsb<T,B> {
    void success(T response, B jxm); // 获取数据成功

    void fail(int errCode, String msg); // 获取数据失败

    void byt(T response,B jxm,byte[] jxc);
}
