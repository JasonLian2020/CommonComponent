package me.jessyan.armscomponent.commonsdk.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jess.arms.base.BaseFragment;
import com.jess.arms.base.delegate.FragmentDelegateImpl;
import com.jess.arms.mvp.IPresenter;

import butterknife.Unbinder;

public abstract class BaseLazyFragment<P extends IPresenter> extends BaseFragment<P> {
    /**
     * 缓存View，不需要每次都初始化
     */
    private View rootView;
    /**
     * Fragment当前状态是否可见
     */
    protected boolean isVisible;
    /**
     * Fragment是否初始化视图完毕
     */
    protected boolean isPrepared = false;
    /**
     * Fragment是否第一次加载数据
     */
    protected boolean isFirst = true;
    /**
     * Fragment是否初始化view配置
     */
    private boolean isInitView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            isInitView = true;
            rootView = initView(inflater, container, savedInstanceState);
        } else {
            isInitView = false;
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }
        }
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        /**
         * 由于框架{@link FragmentDelegateImpl#onDestroyView()}会调用{@link Unbinder#unbind()}解除绑定，
         * 此时view会为null，此时再调用{@link #initData()}就会报错，所以{@link isPrepared}需要在此时改为false
         */
        isPrepared = false;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (isInitView) initViewConfig();// 避免多次调用
        isPrepared = true;
        onVisible();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        //do nothing
    }

    /**
     * 由于框架{@link BaseFragment#initData(Bundle)}方法默认不是懒加载，但是view初始化配置又放在该方法，
     * 所以提供了该{@link #initViewConfig()}来实现该需求，{@link #initData()}来实现懒加载。
     */
    protected abstract void initViewConfig();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 视图不可见时候的回调
     */
    private void onInvisible() {
        //do nothing
    }

    /**
     * 视图可见时候的回调
     */
    private void onVisible() {
        if (!isPrepared || !isVisible || !isFirst) {
            return;
        }
        isFirst = false;
        initData();
    }
}