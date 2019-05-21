package me.jessyan.armscomponent.commonsdk.utils.rxjava;


import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class RxUtil {

    private RxUtil() {
        throw new IllegalStateException("you can't instantiate me!");
    }

    public static Observable<Integer> countDown(int maxTime) {
        return Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(maxTime + 1)//只发射开始的N项数据或者一定时间内的数据
                .subscribeOn(AndroidSchedulers.mainThread())
                .map(aLong -> {
                    // 做数据的变化，因为interval执行along会从0开始递增，我们需要的是剩余值
                    return maxTime - aLong.intValue();
                })
                .observeOn(AndroidSchedulers.mainThread());
    }
}