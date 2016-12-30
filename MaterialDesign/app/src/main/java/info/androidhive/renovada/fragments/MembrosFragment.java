package info.androidhive.renovada.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import info.androidhive.materialdesign.R;
import info.androidhive.renovada.DAO.MembroDAO;
import info.androidhive.renovada.activity.MembroActivity;
import info.androidhive.renovada.model.Membro;

import java.util.List;


public class MembrosFragment extends Fragment {

    ListView lstMembros;
    Button btnIncluir;

    MembroDAO membroDAO;

    ArrayAdapter<Membro> arrayAdapter;

    public MembrosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.fragment_membros, container, false );

        lstMembros = (ListView) rootView.findViewById( R.id.lst_membros );
        btnIncluir = (Button) rootView.findViewById( R.id.btnIncluir );

        btnIncluir.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent( getContext(), MembroActivity.class );

                startActivity( i );
            }
        } );

        membroDAO = new MembroDAO( getContext() );

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        setupListView();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach( activity );
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void setupListView() {

        List<Membro> membros = membroDAO.getAllMembros();

        arrayAdapter = new ArrayAdapter<>( getContext(), android.R.layout.simple_list_item_1, membros );

        lstMembros.setAdapter( arrayAdapter );

        lstMembros.setOnItemLongClickListener( new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                // Colocar um alert dialog

                Membro membro = arrayAdapter.getItem( position );

                membroDAO.deleteMembro( membro );

                arrayAdapter.remove( membro );

//                arrayAdapter.notifyDataSetChanged();

                return false;
            }
        } );

    }
}