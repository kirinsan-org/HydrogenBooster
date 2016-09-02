package org.kirinsan.hydrogenbooster;

import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Receiver;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @AfterViews
    void init() {
        toSplash();
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
     * Called when splash screen is timed out.
     */
    @Receiver(actions = SplashFragment.ACTION_SPLASH_END, local = true)
    void onSplashEnd() {
        toHydrogen();
    }
}
