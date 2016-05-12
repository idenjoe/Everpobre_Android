package es.idenjoe.everpobre.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import es.idenjoe.everpobre.Constants;
import es.idenjoe.everpobre.R;
import es.idenjoe.everpobre.activities.AddEditNotebookActivity;
import es.idenjoe.everpobre.adapters.NotebookAdapter;
import es.idenjoe.everpobre.model.Notebook;
import es.idenjoe.everpobre.model.Notebooks;
import es.idenjoe.everpobre.model.db.dao.NotebookDAO;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotebooksFragment extends Fragment {

    @Bind(R.id.fragment_notebooks_recycler_view)
    RecyclerView notebooksRecyclerView;

    private NotebookAdapter notebookAdapter;
    public NotebooksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_notebooks, container, false);

        ButterKnife.bind(this, view);

        setupAdapter();

        return view;
    }

    public void refreshUI(){
        setupAdapter();
    }

    private void setupAdapter() {
        notebooksRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        NotebookDAO notebookDAO = new NotebookDAO();
        Notebooks notebooks = notebookDAO.query();
        notebookAdapter = new NotebookAdapter(notebooks, getActivity());
        notebookAdapter.setOnElementClickListener(new NotebookAdapter.OnElementClick<Notebook>() {
            @Override
            public void clickedOn(Notebook notebook, int position) {
                Log.d("Clicked","OnClick");
                Intent i = new Intent(getActivity(), AddEditNotebookActivity.class);
                i.putExtra(Constants.ES_IDENJOE_EVERPOBRE_NOTEBOOK_TO_EDIT,notebook);
                startActivityForResult(i, 1, null);
            }
        });
        notebooksRecyclerView.setAdapter(notebookAdapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == getActivity().RESULT_OK){
                setupAdapter();
            }
        }
    }
}
