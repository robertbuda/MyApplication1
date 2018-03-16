package services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import timber.log.Timber;

/**
 * Created by Robert on 2018-03-09.
 */

public class BinderService extends Service {

    private myBinder myBinder = new myBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Timber.d("onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Timber.d("on Destroy");
    }

    class myBinder extends Binder {
        BinderService getService(){
            return BinderService.this;
        }
    }

    public String greet(){
        return "Hello";
    }
}
