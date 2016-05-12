package es.idenjoe.everpobre.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONArray;

import es.idenjoe.everpobre.R;
import es.idenjoe.everpobre.fragments.NotebooksFragment;
import es.idenjoe.everpobre.model.Notebooks;
import es.idenjoe.everpobre.model.db.dao.NotebookDAO;
import es.idenjoe.everpobre.model.jsonmapper.MapNotebooks;
import es.idenjoe.everpobre.network.JSONUtil;

public class NotebookListActivity extends AppCompatActivity {

    public static final String TAG = NotebookListActivity.class.getName();
    private NotebooksFragment notebooksFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notebook_list);

        Log.d(TAG,"Hello from Notebook List");

        getNotbooksFromServer();

        FragmentManager fm =  getSupportFragmentManager();


        if (fm != null){
            notebooksFragment = new NotebooksFragment();

            fm.beginTransaction()
                    .add(R.id.activity_notebook_fragment_container, notebooksFragment)
                    .commit();
        }
    }

    private void getNotbooksFromServer(){
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                JSONArray jsonArray = JSONUtil.getJSONFromHttpRequest("http://www.mocky.io/v2/5734b60b1300008901cddfa4");

                MapNotebooks mapper = new MapNotebooks();
                Notebooks notebooks = mapper.map(jsonArray);

                NotebookDAO notebookDAO = new NotebookDAO();
                for (int i=0;i<notebooks.size();i++) {
                    notebookDAO.insert(notebooks.get(i));
                }

                //refresh fragment
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        notebooksFragment.refreshUI();
                    }
                });

            }
        });
        backgroundThread.start();
    }
}
