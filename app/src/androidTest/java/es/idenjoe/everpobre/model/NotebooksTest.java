package es.idenjoe.everpobre.model;

import android.test.AndroidTestCase;

import java.util.Arrays;
import java.util.List;

import es.idenjoe.everpobre.model.db.DBHelper;

import static org.junit.Assert.*;

/**
 * Created by idenjoe on 8/5/16.
 */
public class NotebooksTest extends AndroidTestCase {

    private Notebooks notebooks;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        Notebook n1 = new Notebook(1,"n1");
        Notebook n2 = new Notebook(2,"n2");

        Notebook[] arrayNotebooks = {
                n1, n2
        };

        List<Notebook> notebooksList = Arrays.asList(arrayNotebooks);
        notebooks = Notebooks.createNotebooks(notebooksList);
    }

    @org.junit.Test
    public void testCreateNotebooks() throws Exception {
        assertNotNull(notebooks);
    }

    @org.junit.Test
    public void testSize() throws Exception {
        assertEquals(notebooks.size(),2);
    }

    @org.junit.Test
    public void testGet() throws Exception {
        assertEquals(notebooks.get(0).getName(), "n1");
    }

    @org.junit.Test
    public void testRemove() throws Exception {

    }

    @org.junit.Test
    public  void testAdd(Notebook notebook) throws Exception{
        
    }

    @org.junit.Test
    public void testGetNotebooks() throws Exception {

    }
}