package es.idenjoe.everpobre.model.db.dao;

import android.test.AndroidTestCase;

import es.idenjoe.everpobre.model.Notebook;
import es.idenjoe.everpobre.model.db.DBHelper;

/**
 * Created by idenjoe on 9/5/16.
 */
public class NotebookDAOTests extends AndroidTestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        DBHelper.configure("TestDB.sqlite",getContext());
    }

    public void testCanInsertNotebook(){
        Notebook notebook = new Notebook(1,"TestNotebook");


        NotebookDAO notebookDAO = new NotebookDAO();
        long id = notebookDAO.insert(notebook);
        assertTrue(id > 0);
    }

    public void testCanUpdateNotebook(){
        Notebook notebook = new Notebook(2,"TestUpdateNotebook");

        NotebookDAO notebookDAO = new NotebookDAO();
        long id = notebookDAO.insert(notebook);

        notebook.setName("TestUpdateNewName");
        notebookDAO.update(id,notebook);
        Notebook notebook1 = notebookDAO.query(id);
        assertEquals(notebook1.getName(),"TestUpdateNewName");
    }

    public void testCanDelete(){
        Notebook notebook = new Notebook(1,"TestDeleteNotebook");
        NotebookDAO notebookDAO = new NotebookDAO();
        long id = notebookDAO.insert(notebook);

        notebookDAO.delete(notebook.getId());
        Notebook deletedNotebook = notebookDAO.query(notebook.getId());
        assertNull(deletedNotebook);
    }
}
