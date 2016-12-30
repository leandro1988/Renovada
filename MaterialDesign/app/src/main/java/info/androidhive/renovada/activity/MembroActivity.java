package info.androidhive.renovada.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import info.androidhive.materialdesign.R;

import android.widget.Toast;
import info.androidhive.renovada.DAO.MembroDAO;
import info.androidhive.renovada.model.Membro;

/**
 * Created by leandro on 17/12/16.
 */
public class MembroActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private EditText edtnome;
    private EditText edttelefone;
    private EditText edtcelular;
    private EditText edtbairro;
    private EditText edtnascimento;
    private EditText edtpastor;
    private EditText edtcampo;
    private EditText edtdata;

    private MembroDAO membroDAO;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadcliente);

        edtnome = (EditText) findViewById(R.id.edtnome);
        edttelefone = (EditText) findViewById(R.id.edttelefone);
        edtcelular = (EditText) findViewById(R.id.edtcelular);
        edtbairro = (EditText) findViewById(R.id.edtbairro);
        edtnascimento = (EditText) findViewById(R.id.edtnascimento);
        edtpastor = (EditText) findViewById(R.id.edtpastor);
        edtcampo = (EditText) findViewById(R.id.edtcampo);
        edtdata = (EditText) findViewById(R.id.edtdata);


        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        membroDAO = new MembroDAO( this );

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cad_cliente, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_Salvar) {

            insereDadoNoBanco();

            return true;
        }

        if(id == R.id.action_Excluir){
            Toast.makeText(getApplicationContext(), "Search action is selected!", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void insereDadoNoBanco(){

        Membro membro = new Membro();

        membro.setNome( edtnome.getText().toString() );

        membroDAO.insereMembro( membro );

    }
}
