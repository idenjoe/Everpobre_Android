package es.idenjoe.everpobre;

import android.app.Application;
import android.util.Log;

/**
 * Created by idenjoe on 7/5/16.
 */
public class EverpobreApp extends Application {

    public static final String TAG = EverpobreApp.class.getName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"Hello World");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
