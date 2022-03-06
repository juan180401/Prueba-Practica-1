package sv.edu.udb.dsm.parcialpractico1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Ecuacion extends AppCompatActivity {
EditText va1,va2,va3;
TextView res,res2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecuacion);
        va1=(EditText)findViewById(R.id.val1);
        va2=(EditText)findViewById(R.id.val2);
        va3=(EditText)findViewById(R.id.val3);
        res=(TextView) findViewById(R.id.resul);
        res2=(TextView) findViewById(R.id.resul2);
    }

    public void calcularec (View view) {
        if (validar1()) {
            String valor1 = va1.getText().toString();
            String valor2 = va2.getText().toString();
            String valor3 = va3.getText().toString();
            double a1 = Integer.parseInt(valor1);
            double b2 = Integer.parseInt(valor2);
            double c3 = Integer.parseInt(valor3);
            //fuera de raíz
            double p1 = b2 * -1;
            //dentro de raíz
            double p2 = Math.pow(b2, 2);
            double p3 = (-4) * a1 * c3;
            double p4 = p2 + p3;
            //imaginarios
            if (p4 < 0) {
                double p5 = Math.abs(p4);
                double p6 = Math.sqrt(p5);
                double p7positivo = (p1) / (2 * a1);
                double p8positivo = (p6) / (2 * a1);
                double p7negativo = (p1) / (2 * a1);
                double p8negativo = (p6) / (2 * a1);
                DecimalFormat dec = new DecimalFormat("#.##");
                String resulta1 = String.valueOf(dec.format(p7positivo));
                String resulta2 = String.valueOf(dec.format(p8positivo));
                String resulta3 = String.valueOf(dec.format(p7negativo));
                String resulta4 = String.valueOf(dec.format(p8negativo));
                res.setText(resulta1 + "+" + resulta2 + "i");
                res2.setText(resulta3 + "-" + resulta4 + "i");
                va1.setText("");
                va2.setText("");
                va3.setText("");
                //normales
            } else if (p4 >= 0) {
                double p5 = Math.sqrt(p4);
                double p6 = (p1) / (2 * a1);
                double p7 = (p5) / (2 * a1);
                DecimalFormat dec = new DecimalFormat("#.##");
                double p9positivo = (p6 + p7);
                double p10negativo = (p6 - p7);
                String resulta1 = String.valueOf(dec.format(p9positivo));
                String resulta2 = String.valueOf(dec.format(p10negativo));
                res.setText(resulta1);
                res2.setText(resulta2);
                va1.setText("");
                va2.setText("");
                va3.setText("");
            }
        }
    }
        public boolean validar1(){
            boolean retorno1=true;
            String valor1=va1.getText().toString();
            String valor2=va2.getText().toString();
            String valor3=va3.getText().toString();
            if(valor1.isEmpty())
            {
                va1.setError("Este campo no puede quedar vacío");
                retorno1=false;
            }
            if(valor2.isEmpty()){
                va2.setError("Este campo no puede quedar vacío");
                retorno1=false;
            }
            if(valor3.isEmpty()){
                va3.setError("Este campo no puede quedar vacío");
                retorno1=false;
            }
            return retorno1;
        }

    public void volver (View view){
        finish();
    }
}