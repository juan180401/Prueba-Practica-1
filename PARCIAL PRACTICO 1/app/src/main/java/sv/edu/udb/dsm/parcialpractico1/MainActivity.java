package sv.edu.udb.dsm.parcialpractico1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView us1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        us1=(TextView) findViewById(R.id.idusuario);
        cargar();
    }
    public void cargar() {
        SharedPreferences datos = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String usuario1 = datos.getString("user", "ERROR");
        String contra1 = datos.getString("pass", "ERROR");
        if (usuario1.equals("juan chicas")&&contra1.equals("12345")) {
            us1.setText(usuario1);
        }else {
            Intent x=new Intent(this, ERRORDEAUTENTIFICACION.class);
            startActivity(x);
        }
    }
    public void resolverecuacion (View view)
    {
        Intent e=new Intent(this, Ecuacion.class);
        startActivity(e);
    }
    public void fin (View view){
        Intent ini=new Intent(this, LOGIN.class);
        startActivity(ini);
        finish();
    }
}