package com.akitektuo.notifier;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by AoD Akitektuo on 23-Apr-17 at 10:12.
 */

public class Preference {

    static final String KEY_INITIALIZE = "initialize";
    static final String KEY_ON_OFF = "on_off";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public Preference(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(KEY_INITIALIZE, Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
        }
    }

    private void savePreferences() {
        editor.commit();
    }

    public void setPreference(String key, boolean bool) {
        editor.putBoolean(key, bool);
        savePreferences();
    }

    public boolean getPreferenceBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

}
