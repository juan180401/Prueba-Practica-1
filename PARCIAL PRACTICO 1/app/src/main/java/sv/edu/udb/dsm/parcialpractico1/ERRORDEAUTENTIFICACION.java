package sv.edu.udb.dsm.parcialpractico1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ERRORDEAUTENTIFICACION extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_errordeautentificacion);
    }
    public void regresar (View view){
        Intent a=new Intent(this, LOGIN.class);
        startActivity(a);
    }
}