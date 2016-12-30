package info.androidhive.renovada.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.*;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.renovada.fragments.MembrosFragment;
import info.androidhive.renovada.database.DataBaseHelper;
import info.androidhive.renovada.model.Membro;

/**
 * Created by leandro on 29/12/16.
 */

public class MembroDAO {

    private Context context;
    private SQLiteDatabase conn;

    public MembroDAO(Context context) {

        this.context = context;

        DataBaseHelper dataBaseHelper = new DataBaseHelper( context );

        this.conn = dataBaseHelper.getWritableDatabase();
    }

    public void insereMembro(Membro membro){

        ContentValues valores = new ContentValues();

        valores.put("NOME", membro.getNome());
//        valores.put(CriaBanco.AUTOR, autor);
//        valores.put(CriaBanco.EDITORA, editora);
//
        long resultado = conn.insert("MEMBROS", null, valores);

        if (resultado == -1)

            Toast.makeText( context,  "Erro ao inserir registro", Toast.LENGTH_SHORT ).show();
        else
            Toast.makeText( context,  "Registro Inserido com sucesso" , Toast.LENGTH_SHORT ).show();

    }

    public void testeInserirMembros() {

        for (int i = 0; 1 < 10; i++) {

            ContentValues values = new ContentValues();

            values.put( "NOME", "Leandro Henrique" );

            conn.insertOrThrow( "MEMBROS", null, values );


        }


    }

    public List<Membro> getAllMembros() {

        List<Membro> contactList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + "MEMBROS";

        Cursor cursor = conn.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Membro membro = new Membro();

                membro.setId( Integer.parseInt( cursor.getString( 0 ) ) );
                membro.setNome(cursor.getString(1));

                // Adding contact to list
                contactList.add(membro);

            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }


    public List<String> buscaMembros(MembrosFragment context) {

        List<String> adpMembros = new ArrayList<String>();

        Cursor cursor = conn.query( "MEMBROS", null, null, null, null, null, null );

        if (cursor.getCount() > 0) {

            cursor.moveToFirst();


            do {

                String NOME = cursor.getString( 1 );
                adpMembros.add( NOME );
            }

            while (cursor.moveToNext());

        }

        return adpMembros;
    }
// Deletando o membro cadastrado //

    public void deleteMembro(Membro membro) {

        conn.delete("MEMBROS", "id" + " = ?",
                new String[] { String.valueOf(membro.getId()) });
    }


}