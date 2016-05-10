package es.idenjoe.everpobre.model;


import java.io.Serializable;

/**
 * Created by idenjoe on 7/5/16.
 */
public class Notebook implements Serializable {
    public static final String DEFAULT_NAME = "John Doe";
    private long id;
    private String name;


    public Notebook(long id, String name) {
        if (name == null || name.isEmpty()) {
            this.name = DEFAULT_NAME;
        }else{
            this.name = name;
        }

        this.id = id;
    }

    private Notebook(){
        //disable default constructor, customer requirement
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
