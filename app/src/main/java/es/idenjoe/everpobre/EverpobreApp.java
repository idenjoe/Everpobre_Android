package es.idenjoe.everpobre;

import android.app.Application;
import android.util.Log;

import es.idenjoe.everpobre.model.db.DBConstants;
import es.idenjoe.everpobre.model.db.DBHelper;

/**
 * Created by idenjoe on 7/5/16.
 */
public class EverpobreApp extends Application {

    public static final String TAG = EverpobreApp.class.getName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"Hello World");
        DBHelper.configure(DBConstants.DBNAME,getApplicationContext());
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
