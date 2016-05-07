package es.idenjoe.everpobre;

import android.test.AndroidTestCase;

import es.idenjoe.everpobre.model.Notebook;

/**
 * Created by idenjoe on 7/5/16.
 */
public class NotebookTests extends AndroidTestCase{

    public static final String NOTEBOOK_TITLE = "Notebook title";

    public void testCanCreateNotebook(){
        final Notebook sut = new Notebook(1, NOTEBOOK_TITLE);
        assertNotNull(sut);
        assertEquals(1,sut.getId());
        assertEquals(NOTEBOOK_TITLE,sut.getName());
    }

    public void test_Creating_A_Notebook_With_Empty_OrNull_Name_SetsDefaultName(){
        final Notebook sut = new Notebook(1, null);
        assertEquals(Notebook.DEFAULT_NAME,sut.getName());

        final Notebook sut2 = new Notebook(1, "");
        assertEquals(Notebook.DEFAULT_NAME,sut2.getName());
    }
}
