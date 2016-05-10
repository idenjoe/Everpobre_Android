package es.idenjoe.everpobre.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.idenjoe.everpobre.R;
import es.idenjoe.everpobre.model.Notebook;
import es.idenjoe.everpobre.model.Notebooks;
import es.idenjoe.everpobre.views.NotebookRowViewHolder;

/**
 * Created by idenjoe on 10/5/16.
 */
public class NotebookAdapter extends RecyclerView.Adapter<NotebookRowViewHolder> {

    public interface OnElementClick<Notebook> {
        public void clickedOn(Notebook notebook, int position);
    }

    private OnElementClick<Notebook> listener;

    private LayoutInflater layoutInflater;
    private Notebooks notebooks;

    public NotebookAdapter(Notebooks notebooks, Context context){
        layoutInflater = LayoutInflater.from(context);
        this.notebooks = notebooks;
    }

    @Override
    public NotebookRowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.row_notebook,parent,false);

        return new NotebookRowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NotebookRowViewHolder holder, final int position) {
        final Notebook notebook = notebooks.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null){
                    listener.clickedOn(notebook, position);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });

        holder.setNotebookName(notebook.getName());
    }

    @Override
    public int getItemCount() {
        return notebooks.size();
    }

    public void setOnElementClickListener(@NonNull final OnElementClick<Notebook> listener){
        this.listener = listener;
    }
}
