package info.androidhive.renovada.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import info.androidhive.materialdesign.R;


public class LoginActivity extends AppCompatActivity {

ImageButton botaoFacebook;
ImageButton botaoInstagram;

    //Função do botão Entrar na tela inicial

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {


            // Função do botão login
            @Override
            public void onClick(View view) {
                botaoFacebook = (ImageButton) findViewById(R.id.botao_facebook);
                botaoInstagram = (ImageButton) findViewById(R.id.botao_instagram);
                TextView tlogin = (TextView) findViewById(R.id.edtlogin);
                TextView tsenha = (TextView) findViewById(R.id.edtSenha);
                TextView txt1 = (TextView)findViewById(R.id.textView) ;

                String login = tlogin.getText().toString();
                String senha = tsenha.getText().toString();

                // Senha salva direto no código. Usar o banco de dados.

                if (login.equals("admin") && senha.equals("renovada")) {

                    alert("Login realizado com sucesso");

                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);

                    // close this activity
                    finish();

                } else {

                    alert("Senha ou Login incorreto!");


                }
            }
        });

    }

    private void alert(String s) {

        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

}
