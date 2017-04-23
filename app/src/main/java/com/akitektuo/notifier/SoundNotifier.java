package com.akitektuo.notifier;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by AoD Akitektuo on 23-Apr-17 at 07:14.
 */

public class SoundNotifier extends AccessibilityService {

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if (event.getEventType() == AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED) {
            //Play sound
            Toast.makeText(getApplicationContext(), "Here is a notification!", LENGTH_SHORT).show();
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
