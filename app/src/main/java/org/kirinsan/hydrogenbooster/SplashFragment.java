package org.kirinsan.hydrogenbooster;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;

@EFragment(R.layout.fragment_splash)
public class SplashFragment extends Fragment {

    public static final String ACTION_SPLASH_END = "splash_end";
    private boolean resumed;

    @Override
    public void onResume() {
        super.onResume();
        resumed = true;

        notifySplashTimeout();
    }

    @UiThread(delay = 1000)
    void notifySplashTimeout() {
        if (resumed) {
            LocalBroadcastManager.getInstance(getContext())
                    .sendBroadcast(new Intent(ACTION_SPLASH_END));
        }
    }

    @Override
    public void onPause() {
        resumed = false;
        super.onPause();
    }
}
