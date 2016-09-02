package org.kirinsan.hydrogenbooster;

import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Receiver;
import org.androidannotations.annotations.sharedpreferences.Pref;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @Pref
    MyPrefs_ prefs;

    @AfterViews
    void init() {
        toSplash();
    }

    /**
     * Called when splash screen is timed out.
     */
    @Receiver(actions = SplashFragment.ACTION_SPLASH_END, local = true)
    void onSplashEnd() {

        // Already downloaded
        if (prefs.downloaded().get()) {
            toHydrogen();
        } else {
            // Not downloaded
            toDownload();
        }
    }

    /**
     * Called when skip was tapped.
     */
    @Receiver(actions = DownloadFragment.ACTION_SKIP, local = true)
    void onSkipDownload() {
        toHydrogen();
    }

    /**
     * Called when download was completed.
     */
    @Receiver(actions = DownloadFragment.ACTION_DOWNLOAD_COMPLETE, local = true)
    void onDownloadCompleted() {

        // Save downloaded
        prefs.downloaded().put(true);

        toHydrogen();
    }

    /**
     * Go to splash screen.
     */
    private void toSplash() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, SplashFragment_.builder().build())
                .commit();
    }

    /**
     * Go to hydrogen screen.
     */
    private void toHydrogen() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, HydrogenFragment_.builder().build())
                .commit();
    }

    /**
     * Go to download screen.
     */
    private void toDownload() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, DownloadFragment_.builder().build())
                .commit();
    }
}
