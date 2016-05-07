package es.idenjoe.everpobre.model;

/**
 * Created by idenjoe on 7/5/16.
 */
public class Notebook {
    private int id;
    private String name;


    public Notebook(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private Notebook(){
        //disable default constructor, customer requirement
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
