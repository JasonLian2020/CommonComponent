package me.jessyan.armscomponent.commonsdk.utils.sp;

import java.util.Set;

import static me.jessyan.armscomponent.commonsdk.utils.sp.PreUtil.TYPE_BOOLEAN;
import static me.jessyan.armscomponent.commonsdk.utils.sp.PreUtil.TYPE_FLOAT;
import static me.jessyan.armscomponent.commonsdk.utils.sp.PreUtil.TYPE_INT;
import static me.jessyan.armscomponent.commonsdk.utils.sp.PreUtil.TYPE_LONG;
import static me.jessyan.armscomponent.commonsdk.utils.sp.PreUtil.TYPE_SET;
import static me.jessyan.armscomponent.commonsdk.utils.sp.PreUtil.TYPE_STRING;

public class UserPreUtil {
    private UserPreUtil() {
        throw new IllegalStateException("you can't instantiate me!");
    }

    public static boolean save(String key, String value) {
        return PreUtil.save(key, value, TYPE_STRING, true);
    }

    public static boolean save(String key, int value) {
        return PreUtil.save(key, value, TYPE_INT, true);
    }

    public static boolean save(String key, boolean value) {
        return PreUtil.save(key, value, TYPE_BOOLEAN, true);
    }

    public static boolean save(String key, float value) {
        return PreUtil.save(key, value, TYPE_FLOAT, true);
    }

    public static boolean save(String key, long value) {
        return PreUtil.save(key, value, TYPE_LONG, true);
    }

    public static boolean save(String key, Set<String> values) {
        return PreUtil.save(key, values, TYPE_SET, true);
    }

    public static String get(String key, String defValue) {
        return (String) PreUtil.get(key, defValue, TYPE_STRING, true);
    }

    public static int get(String key, int defValue) {
        return (int) PreUtil.get(key, defValue, TYPE_INT, true);
    }

    public static boolean get(String key, boolean defValue) {
        return (boolean) PreUtil.get(key, defValue, TYPE_BOOLEAN, true);
    }

    public static float get(String key, float defValue) {
        return (float) PreUtil.get(key, defValue, TYPE_FLOAT, true);
    }

    public static long get(String key, long defValue) {
        return (long) PreUtil.get(key, defValue, TYPE_LONG, true);
    }

    public static Set<String> get(String key, Set<String> defValues) {
        return (Set<String>) PreUtil.get(key, defValues, TYPE_SET, true);
    }

    public static boolean clear() {
        return PreUtil.clear(true);
    }

    public static boolean remove(String key) {
        return PreUtil.remove(key, true);
    }
}
