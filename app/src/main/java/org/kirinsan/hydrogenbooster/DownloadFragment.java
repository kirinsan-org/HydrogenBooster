package org.kirinsan.hydrogenbooster;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;

import com.afollestad.materialdialogs.MaterialDialog;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;

@EFragment(R.layout.fragment_download)
public class DownloadFragment extends Fragment {

    public static final String ACTION_SKIP = "goto_next";
    public static final String ACTION_DOWNLOAD_COMPLETE = "download_complete";
    private MaterialDialog dialog;

    @Click
    void download() {
        dialog = new MaterialDialog.Builder(getContext())
                .title(R.string.downloading)
                .content(R.string.downloading_hydrogen)
                .progress(false, 602214085, true)
                .canceledOnTouchOutside(false)
                .build();
        dialog.show();

        downloadHydrogen();
    }

    @Click
    void skip() {
        LocalBroadcastManager.getInstance(getContext())
                .sendBroadcast(new Intent(ACTION_SKIP));
    }

    @Background
    void downloadHydrogen() {

        boolean completed = monitorDownload();
        hideDialog();

        if (completed) {
            done();
        }
    }

    private boolean monitorDownload() {

        while (dialog.getCurrentProgress() != dialog.getMaxProgress()) {

            if (dialog.isCancelled()) return false;
            try {
                Thread.sleep((long) (10 + Math.random() * 100));
            } catch (InterruptedException e) {
                return false;
            }

            dialog.incrementProgress((int) (Math.random() * 1000000) + 1000000);
        }

        return true;
    }

    @UiThread
    void done() {

        // Notify to Activity
        LocalBroadcastManager.getInstance(getContext())
                .sendBroadcast(new Intent(ACTION_DOWNLOAD_COMPLETE));
    }

    @UiThread
    void hideDialog() {
        dialog.dismiss();
        dialog = null;
    }
}
