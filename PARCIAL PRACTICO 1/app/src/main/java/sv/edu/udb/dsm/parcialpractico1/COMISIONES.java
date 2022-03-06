package sv.edu.udb.dsm.parcialpractico1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class COMISIONES extends AppCompatActivity {
TextView no,co,ve,me,po,com1;
ImageView fot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comisiones);
        no=(TextView) findViewById(R.id.nombre1);
        co=(TextView) findViewById(R.id.codi1);
        ve=(TextView) findViewById(R.id.vent22);
        me=(TextView) findViewById(R.id.mes2);
        po=(TextView) findViewById(R.id.porcentaje);
        com1=(TextView) findViewById(R.id.comision);
        fot=(ImageView)findViewById(R.id.foto2);

        Bundle bundle = getIntent().getExtras();
        String nom3=bundle.getString("vennom");
        String cod3=bundle.getString("vencod");
        String ven3=bundle.getString("venvent");
        String mes3=bundle.getString("venmes");
        String por3=bundle.getString("venporce");
        String comi3=bundle.getString("vencomi");
        Bitmap bitextraido=bundle.getParcelable("bit");

        no.setText(nom3);
        co.setText(cod3);
        ve.setText(ven3);
        me.setText(mes3);
        po.setText(por3);
        com1.setText(comi3);
        fot.setImageBitmap(bitextraido);

    }
    public void volvercalculo (View view){
        Intent volcal=new Intent(this,FichaDeVendedor.class);
        startActivity(volcal);
    }
}