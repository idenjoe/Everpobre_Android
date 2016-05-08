package es.idenjoe.everpobre.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by idenjoe on 7/5/16.
 */
public class Notebooks {
    List<Notebook> notebooks;

    public static Notebooks createNotebooks(List<Notebook> notebooks){
        Notebooks myNotebooks = new Notebooks();

        for (Notebook n: notebooks){
            myNotebooks.add(n);
        }

        return myNotebooks;
    }

    private void add(Notebook notebook) {
        getNotebooks().add(notebook);
    }

    private Notebooks(){
    }

    public List<Notebook> getNotebooks(){
        if (this.notebooks == null){
            this.notebooks = new LinkedList<>();
        }
        return this.notebooks;
    }
}
