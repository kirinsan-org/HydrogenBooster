package org.kirinsan.hydrogenbooster;

import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @AfterViews
    void init() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, HydrogenFragment_.builder().build())
                .commit();
    }
}
