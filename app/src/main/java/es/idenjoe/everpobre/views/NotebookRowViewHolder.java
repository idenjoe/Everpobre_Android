package es.idenjoe.everpobre.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import es.idenjoe.everpobre.R;

/**
 * Created by idenjoe on 9/5/16.
 */
public class NotebookRowViewHolder extends RecyclerView.ViewHolder {

    private String notebookName;
    @Bind(R.id.row_notebook_notebook_name) TextView notebookNameTextView;

    public NotebookRowViewHolder(View rowNotebook) {
        super(rowNotebook);
        ButterKnife.bind(this, rowNotebook);
    }

    public void setNotebookName(String name){
        notebookNameTextView.setText(name);
    }
}
