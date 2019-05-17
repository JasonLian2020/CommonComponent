package me.jessyan.armscomponent.commonsdk.utils.sp;

import android.content.Context;
import android.content.SharedPreferences;


import com.blankj.utilcode.util.Utils;

import java.util.Set;

public class PreUtil {
    public static final String TYPE_STRING = "String";
    public static final String TYPE_INT = "int";
    public static final String TYPE_BOOLEAN = "boolean";
    public static final String TYPE_FLOAT = "float";
    public static final String TYPE_LONG = "long";
    public static final String TYPE_SET = "Set";

    private PreUtil() {
        throw new IllegalStateException("you can't instantiate me!");
    }

    private static SharedPreferences getSharedPreferences(boolean isUser) {
        return Utils.getApp().getSharedPreferences(isUser ? "USER" : "APP", Context.MODE_PRIVATE);
    }

    public static boolean save(String key, String value) {
        return save(key, value, TYPE_STRING, false);
    }

    public static boolean save(String key, int value) {
        return save(key, value, TYPE_INT, false);
    }

    public static boolean save(String key, boolean value) {
        return save(key, value, TYPE_BOOLEAN, false);
    }

    public static boolean save(String key, float value) {
        return save(key, value, TYPE_FLOAT, false);
    }

    public static boolean save(String key, long value) {
        return save(key, value, TYPE_LONG, false);
    }

    public static boolean save(String key, Set<String> values) {
        return save(key, values, TYPE_SET, false);
    }

    public static String get(String key, String defValue) {
        return (String) get(key, defValue, TYPE_STRING, false);
    }

    public static int get(String key, int defValue) {
        return (int) get(key, defValue, TYPE_INT, false);
    }

    public static boolean get(String key, boolean defValue) {
        return (boolean) get(key, defValue, TYPE_BOOLEAN, false);
    }

    public static float get(String key, float defValue) {
        return (float) get(key, defValue, TYPE_FLOAT, false);
    }

    public static long get(String key, long defValue) {
        return (long) get(key, defValue, TYPE_LONG, false);
    }

    public static Set<String> get(String key, Set<String> defValues) {
        return (Set<String>) get(key, defValues, TYPE_SET, false);
    }

    public static boolean save(String key, Object value, String type, boolean isUser) {
        SharedPreferences.Editor editor = getSharedPreferences(isUser).edit();
        switch (type) {
            case TYPE_STRING:
                editor.putString(key, (String) value);
                break;
            case TYPE_INT:
                editor.putInt(key, (Integer) value);
                break;
            case TYPE_BOOLEAN:
                editor.putBoolean(key, (Boolean) value);
                break;
            case TYPE_FLOAT:
                editor.putFloat(key, (Float) value);
                break;
            case TYPE_LONG:
                editor.putLong(key, (Long) value);
                break;
            case TYPE_SET:
                editor.putStringSet(key, (Set<String>) value);
                break;
            default:
                break;
        }
        return editor.commit();
    }

    public static Object get(String key, Object defValue, String type, boolean isUser) {
        SharedPreferences sp = getSharedPreferences(isUser);
        switch (type) {
            case TYPE_STRING:
                return sp.getString(key, (String) defValue);
            case TYPE_INT:
                return sp.getInt(key, (Integer) defValue);
            case TYPE_BOOLEAN:
                return sp.getBoolean(key, (Boolean) defValue);
            case TYPE_FLOAT:
                return sp.getFloat(key, (Float) defValue);
            case TYPE_LONG:
                return sp.getLong(key, (Long) defValue);
            case TYPE_SET:
                return sp.getStringSet(key, (Set<String>) defValue);
            default:
                return null;
        }
    }

    public static boolean clear(boolean isUser) {
        SharedPreferences sp = getSharedPreferences(isUser);
        return sp.edit().clear().commit();
    }

    public static boolean remove(String key, boolean isUser) {
        SharedPreferences sp = getSharedPreferences(isUser);
        return sp.edit().remove(key).commit();
    }

    public static boolean clear() {
        return clear(false);
    }

    public static boolean remove(String key) {
        return remove(key, false);
    }
}
