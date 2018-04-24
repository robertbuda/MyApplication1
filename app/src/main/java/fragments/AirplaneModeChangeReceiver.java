package fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import timber.log.Timber;

public class AirplaneModeChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean status = intent.getBooleanExtra("state", false);
        if (status) {
            Timber.e("Status - on");
        }
    }

}
