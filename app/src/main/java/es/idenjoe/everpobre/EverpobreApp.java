package es.idenjoe.everpobre;

import android.app.Application;
import android.util.Log;

import es.idenjoe.everpobre.model.Notebook;
import es.idenjoe.everpobre.model.db.DBConstants;
import es.idenjoe.everpobre.model.db.DBHelper;
import es.idenjoe.everpobre.model.db.dao.NotebookDAO;

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

        /*NotebookDAO notebookDAO = new NotebookDAO();
        for (int i = 0;i<20;i++){
            Notebook notebook = new Notebook(1,"Notebook" + i);
            notebookDAO.insert(notebook);
        }*/
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
