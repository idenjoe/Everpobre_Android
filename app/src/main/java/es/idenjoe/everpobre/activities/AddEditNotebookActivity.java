package es.idenjoe.everpobre.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.idenjoe.everpobre.Constants;
import es.idenjoe.everpobre.R;
import es.idenjoe.everpobre.model.Notebook;
import es.idenjoe.everpobre.model.db.dao.NotebookDAO;

public class AddEditNotebookActivity extends AppCompatActivity {

    private  enum AddEditNotebookActivityMode {
        ADDING,
        EDITING
    }

    private AddEditNotebookActivityMode mode;

    @Bind(R.id.activity_add_edit_notebook_save_notebook)
    Button saveNotebook;

    @Bind(R.id.activity_add_edit_notebook_notebook_name)
    EditText notebookNameEditText;

    private Notebook notebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_notebook);
        ButterKnife.bind(this);

        processIntent(getIntent());
    }

    private void processIntent(Intent intent) {
        notebook = (Notebook) intent.getSerializableExtra(Constants.ES_IDENJOE_EVERPOBRE_NOTEBOOK_TO_EDIT);
        if (notebook == null){
            this.mode = AddEditNotebookActivityMode.ADDING;
        }else {
            this.mode = AddEditNotebookActivityMode.EDITING;
            notebookNameEditText.setText(notebook.getName());
        }
    }

    @OnClick(R.id.activity_add_edit_notebook_save_notebook) void OnClick(){
        saveAndFinish();
    }

    private void saveAndFinish() {
        NotebookDAO notebookDAO = new NotebookDAO();
        final String notebookName = notebookNameEditText.getText().toString();
        // validate notebookName

        //save
        if (this.mode == AddEditNotebookActivityMode.EDITING){
            notebook.setName(notebookName);
            notebookDAO.update(notebook);
        }else if(this.mode == AddEditNotebookActivityMode.ADDING) {
            notebook = new Notebook(0,notebookName);
            notebookDAO.insert(notebook);
        }

        Intent resultIntent = new Intent();
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
