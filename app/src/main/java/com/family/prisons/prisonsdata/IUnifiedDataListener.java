package com.family.prisons.prisonsdata;

/**
 * Created by ThinkPad on 2018/6/12.
 */

public interface IUnifiedDataListener<T> {
    void success(T response); // 获取数据成功

    void fail(int errCode, String msg); // 获取数据失败
}
