package sv.edu.udb.dsm.parcialpractico1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.EditText;

import java.text.DecimalFormat;

public class FichaDeVendedor extends AppCompatActivity {
   String elementos[]={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    Spinner mes12;
    EditText nom,cod,ven;
    Button camara;
    ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_de_vendedor);
        mes12=(Spinner) findViewById(R.id.mes);
     //configuracion de spinner
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,R.layout.spinner_item_colores,elementos);
    mes12.setAdapter(adapter);

    camara=(Button)findViewById(R.id.btncamara);
    foto=(ImageView)findViewById(R.id.foto1);
    nom=(EditText) findViewById(R.id.nombre);
    cod=(EditText) findViewById(R.id.codigo);
    ven=(EditText) findViewById(R.id.venta11);


    camara.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
abrirCamara();
        }
    });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap fototomada = (Bitmap) extras.get("data");
            foto.setImageBitmap(fototomada);
        }
    }

    public void CALCULARCOMISION (View view) {
        String vendedor = nom.getText().toString();
        String codvende = cod.getText().toString();
        //capturamos el mes en el spinner
        String mesven = mes12.getSelectedItem().toString();
        double ventashechas = Double.parseDouble(ven.getText().toString());
        Bitmap tomada = ((BitmapDrawable) foto.getDrawable()).getBitmap();
        if (ventashechas < 500) {
            String porcentajecomis = "0%";
            String comis = "0";
            Intent datos = new Intent(this, COMISIONES.class);
            datos.putExtra("vennom", vendedor);
            datos.putExtra("vencod", codvende);
            datos.putExtra("venmes", mesven);
            datos.putExtra("venvent", String.valueOf(ventashechas));
            datos.putExtra("venporce", porcentajecomis);
            datos.putExtra("vencomi", comis);
            datos.putExtra("bit", tomada);
            startActivity(datos);
        } else if (ventashechas >= 500 && ventashechas < 1000) {
            String porcentajecomis = "5%";
            double comis = ventashechas * (0.05);
            DecimalFormat deci = new DecimalFormat("#.##");
            Intent datos = new Intent(this, COMISIONES.class);
            datos.putExtra("vennom", vendedor);
            datos.putExtra("vencod", codvende);
            datos.putExtra("venmes", mesven);
            datos.putExtra("venvent", String.valueOf(ventashechas));
            datos.putExtra("venporce", porcentajecomis);
            datos.putExtra("vencomi", deci.format(comis));
            datos.putExtra("bit", tomada);
            startActivity(datos);
        } else if (ventashechas >= 1000 && ventashechas < 2000) {
            String porcentajecomis = "10%";
            double comis = ventashechas * (0.1);
            DecimalFormat deci = new DecimalFormat("#.##");
            Intent datos = new Intent(this, COMISIONES.class);
            datos.putExtra("vennom", vendedor);
            datos.putExtra("vencod", codvende);
            datos.putExtra("venmes", mesven);
            datos.putExtra("venvent", String.valueOf(ventashechas));
            datos.putExtra("venporce", porcentajecomis);
            datos.putExtra("vencomi", deci.format(comis));
            datos.putExtra("bit", tomada);
            startActivity(datos);
        } else if (ventashechas >= 2000 && ventashechas < 3000) {
            String porcentajecomis = "15%";
            double comis = ventashechas * (0.15);
            DecimalFormat deci = new DecimalFormat("#.##");
            Intent datos = new Intent(this, COMISIONES.class);
            datos.putExtra("vennom", vendedor);
            datos.putExtra("vencod", codvende);
            datos.putExtra("venmes", mesven);
            datos.putExtra("venvent", String.valueOf(ventashechas));
            datos.putExtra("venporce", porcentajecomis);
            datos.putExtra("vencomi", deci.format(comis));
            datos.putExtra("bit", tomada);
            startActivity(datos);
        } else if (ventashechas >= 3000 && ventashechas < 4000) {
            String porcentajecomis = "20%";
            double comis = ventashechas * (0.2);
            DecimalFormat deci = new DecimalFormat("#.##");
            Intent datos = new Intent(this, COMISIONES.class);
            datos.putExtra("vennom", vendedor);
            datos.putExtra("vencod", codvende);
            datos.putExtra("venmes", mesven);
            datos.putExtra("venvent", String.valueOf(ventashechas));
            datos.putExtra("venporce", porcentajecomis);
            datos.putExtra("vencomi", deci.format(comis));
            datos.putExtra("bit", tomada);
            startActivity(datos);
        } else if (ventashechas >= 4000) {
            String porcentajecomis = "30%";
            double comis = ventashechas * (0.3);
            DecimalFormat deci = new DecimalFormat("#.##");
            Intent datos = new Intent(this, COMISIONES.class);
            datos.putExtra("vennom", vendedor);
            datos.putExtra("vencod", codvende);
            datos.putExtra("venmes", mesven);
            datos.putExtra("venvent", String.valueOf(ventashechas));
            datos.putExtra("venporce", porcentajecomis);
            datos.putExtra("vencomi", deci.format(comis));
            datos.putExtra("bit", tomada);
            startActivity(datos);
        }
    }
    private void abrirCamara() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,1);
    }

    public void volver (View view){
        Intent men=new Intent(this,MainActivity.class);
        startActivity(men);
    }
}