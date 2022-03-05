package sv.edu.udb.dsm.parcialpractico1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LOGIN extends AppCompatActivity {
EditText usua,contr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    usua=(EditText) findViewById(R.id.logusuario);
    contr=(EditText) findViewById(R.id.logcontra);
    }

public void autenticar(View view) {

    SharedPreferences datos = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
    String nombre = usua.getText().toString();
    String contrase = contr.getText().toString();

    SharedPreferences.Editor editor = datos.edit();
    editor.putString("user", nombre);
    editor.putString("pass",contrase);

    editor.commit();

    Intent s=new Intent(this, MainActivity.class);
    startActivity(s);

}

    public void finalizar (View view){
        finish();
    }
}