package com.akitektuo.notifier;

import android.accessibilityservice.AccessibilityService;
import android.os.Handler;
import android.view.accessibility.AccessibilityEvent;

import static com.akitektuo.notifier.MainActivity.preference;
import static com.akitektuo.notifier.MainActivity.sound;
import static com.akitektuo.notifier.MainActivity.soundId;

/**
 * Created by AoD Akitektuo on 23-Apr-17 at 07:14.
 */

public class SoundNotifier extends AccessibilityService {

    private static final String KEY_NOTIFICATION = "android.app.Notification";

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if (preference.getPreferenceBoolean(Preference.KEY_ON_OFF) &&
                event.getEventType() == AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED &&
                event.getClassName().equals(KEY_NOTIFICATION)) {
            sound.play(soundId, 1, 1, 1, 0, 1);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    sound.autoPause();
                }
            }, 1000);
        }
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        System.out.println("initialized");
    }

    @Override
    public void onInterrupt() {
        System.out.println("connection lost");
    }

}
