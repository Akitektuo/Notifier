package com.akitektuo.notifier;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import static com.akitektuo.notifier.SoundNotifier.sound;
import static com.akitektuo.notifier.SoundNotifier.soundId;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sound = new SoundPool(8, AudioManager.STREAM_MUSIC, 0);
        soundId = sound.load(this, R.raw.sound, 1);
        startService(new Intent(this, SoundNotifier.class));
    }

}
