package me.jessyan.armscomponent.commonres.utils;

import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.jess.arms.utils.ArmsUtils;

public class FragmentUtil {
    public static void setTitle(Fragment fragment, String title) {
        if (ArmsUtils.findViewByName(fragment.getContext(), fragment.getView(), "public_titlebar_title") != null) {
            ((TextView) ArmsUtils.findViewByName(fragment.getContext(), fragment.getView(), "public_titlebar_title")).setText(title);
        }
    }

    public static void setTitle(Fragment fragment, @StringRes int resId) {
        if (ArmsUtils.findViewByName(fragment.getContext(), fragment.getView(), "public_titlebar_title") != null) {
            ((TextView) ArmsUtils.findViewByName(fragment.getContext(), fragment.getView(), "public_titlebar_title")).setText(resId);
        }
    }
}
