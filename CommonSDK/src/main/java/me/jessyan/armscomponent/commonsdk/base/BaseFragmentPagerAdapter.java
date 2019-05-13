package me.jessyan.armscomponent.commonsdk.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class BaseFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private String[] titleList;

    public BaseFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragmentList, String[] titleList) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titleList = titleList;
    }

    public void setNewList(List<Fragment> fragmentList, String[] titleList) {
        this.fragmentList = fragmentList;
        this.titleList = titleList;
        notifyDataSetChanged();
    }

    /**
     * 是否自定义ItemId，由于源码ItemId使用position，无法重置数据。
     */
    private boolean isCanCustomItemId = false;
    private List<Long> customIdList;

    public void setCanCustomItemId(boolean canCustomItemId) {
        isCanCustomItemId = canCustomItemId;
    }

    public void setCustomIdList(List<Long> customIdList) {
        this.customIdList = customIdList;
    }

    private long getCustomItemId(int position) {
        if (customIdList != null && customIdList.size() > position) {
            return customIdList.get(position);
        }
        return position;
    }

    @Override
    public long getItemId(int position) {
        if (isCanCustomItemId) return getCustomItemId(position);
        else return super.getItemId(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList == null ? null : fragmentList.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList == null ? null : titleList[position];
    }

    @Override
    public int getCount() {
        return fragmentList == null ? 0 : fragmentList.size();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}