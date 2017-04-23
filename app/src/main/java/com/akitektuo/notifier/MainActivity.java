package com.akitektuo.notifier;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    public static SoundPool sound;
    public static int soundId;
    public static Preference preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sound = new SoundPool(8, AudioManager.STREAM_MUSIC, 0);
        soundId = sound.load(this, R.raw.sound, 1);
        CheckBox checkOnOff = (CheckBox) findViewById(R.id.check_on_off);
        preference = new Preference(this);
        checkOnOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                preference.setPreference(Preference.KEY_ON_OFF, b);
            }
        });
        startService(new Intent(this, SoundNotifier.class));
    }

}
