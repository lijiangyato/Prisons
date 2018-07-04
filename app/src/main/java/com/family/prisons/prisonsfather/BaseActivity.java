package com.family.prisons.prisonsfather;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.family.prisons.R;
import com.family.library.libraryutils.UtilsStack;

import butterknife.ButterKnife;
import cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper;


/**
 * Created by ThinkPad on 2018/6/11.
 */

public abstract class BaseActivity extends AppCompatActivity implements BGASwipeBackHelper.Delegate {
    //
    protected AppCompatActivity mContext;
    //
    protected BGASwipeBackHelper mSwipeBackHelper;
    //页面布局的 根view
    protected View mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       initSwipeBackFinish();
        super.onCreate(savedInstanceState);
        // 设置不能横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        mContext = this;
        //Activity 入栈
        UtilsStack.getInstance().addActivity(this);
        //初始化ARouter
        ARouter.getInstance().inject(this);

    }



    @Override
    public void setContentView(int layoutResID) {
        View view = LayoutInflater.from(this).inflate(layoutResID, null);
        setContentView(view);
    }

    @Override
    public void setContentView(View view) {
        setStatusBar();

        super.setContentView(view);
        ButterKnife.bind(this);
        mContentView = view;
//        baseHandler = new Handler(Looper.getMainLooper());
        initView();

        initData();

    }

    /**
     * 初始化view
     */
    public abstract void initView();

    /**
     * 初始化数据
     */
    public abstract void initData();


    /**
     * 初始化状态栏
     */
    protected void setStatusBar() {
        /*StatusBarUtil.setTranslucent(this);
       // StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorPrimary), StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA);
        StatusBarUtil.setTranslucent(this);*/
    }
    @Override
    public boolean isSupportSwipeBack() {
        return true;
    }

    @Override
    public void onSwipeBackLayoutSlide(float slideOffset) {

    }

    @Override
    public void onSwipeBackLayoutCancel() {

    }

    @Override
    public void onSwipeBackLayoutExecuted() {
        mSwipeBackHelper.swipeBackward();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void initSwipeBackFinish() {
        mSwipeBackHelper = new BGASwipeBackHelper(this, this);
        // 「必须在 Application 的 onCreate 方法中执行 BGASwipeBackManager.getInstance().init(this) 来初始化滑动返回」
        // 下面几项可以不配置，这里只是为了讲述接口用法。

        // 设置滑动返回是否可用。默认值为 true
        mSwipeBackHelper.setSwipeBackEnable(true);
        // 设置是否仅仅跟踪左侧边缘的滑动返回。默认值为 true
        mSwipeBackHelper.setIsOnlyTrackingLeftEdge(true);
        // 设置是否是微信滑动返回样式。默认值为 true
        mSwipeBackHelper.setIsWeChatStyle(false);
        // 设置阴影资源 id。默认值为 R.drawable.bga_sbl_shadow
        mSwipeBackHelper.setShadowResId(R.drawable.bga_sbl_shadow);
        // 设置是否显示滑动返回的阴影效果。默认值为 true
        mSwipeBackHelper.setIsNeedShowShadow(true);
        // 设置阴影区域的透明度是否根据滑动的距离渐变。默认值为 true
        mSwipeBackHelper.setIsShadowAlphaGradient(true);
        // 设置触发释放后自动滑动返回的阈值，默认值为 0.3f
        mSwipeBackHelper.setSwipeBackThreshold(0.8f);


        mSwipeBackHelper.setIsNeedShowShadow(true);
    }

    @Override
    public void onBackPressed() {
        // 正在滑动返回的时候取消返回按钮事件
        if (mSwipeBackHelper.isSliding()) {
            return;
        }
        mSwipeBackHelper.backward();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UtilsStack.getInstance().finishActivity(this);//Activity 出栈
        mContentView = null;
    }
}
