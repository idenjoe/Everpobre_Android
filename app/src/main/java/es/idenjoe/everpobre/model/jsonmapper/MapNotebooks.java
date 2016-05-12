package es.idenjoe.everpobre.model.jsonmapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import es.idenjoe.everpobre.model.Notebook;
import es.idenjoe.everpobre.model.Notebooks;

/**
 * Created by idenjoe on 12/5/16.
 */
public class MapNotebooks {

    public Notebooks map(JSONArray arrayOfNotebooks){
        if (arrayOfNotebooks == null){
            return null;
        }

        Notebooks notebooks = Notebooks.createNotebooks();

        for (int i=0 ; i < arrayOfNotebooks.length(); i++) {
            try {
                JSONObject notebookJson = arrayOfNotebooks.getJSONObject(i);
                Notebook notebook = new Notebook(i,notebookJson.getString("name"));
                notebooks.add(notebook);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return notebooks;
    }
}
