package mx.itson.cheems;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public int ubicacion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar();

        Button btnReiniciar = (Button)findViewById(R.id.btnReiniciar);
        btnReiniciar.setOnClickListener(this);

        for(int i =1; i<=6;i++){
            ImageButton btnSeleccion = (ImageButton) findViewById((
                    getResources().getIdentifier("opcion"+ i, "id", this.getPackageName())));
            btnSeleccion.setOnClickListener(this);
        }
    }

    public void iniciar(){
        (findViewById(R.id.opcion1)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion2)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion3)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion4)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion5)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion6)).setBackgroundResource(R.drawable.icon_pregunta);

        Random random = new Random();
        ubicacion = random.nextInt(5)+1;


    }

    public void destapar(int opcion){
        if(opcion ==ubicacion){
            Vibrator vibrador = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            long[] patronVibracion = new long[]{0, 200, 150, 200, 150, 200};
            vibrador.vibrate(VibrationEffect.createWaveform(patronVibracion, -1));
            Toast.makeText(this, "¡PERMDISTE!", Toast.LENGTH_LONG).show();;

            for(int i = 1; i<=6; i++){
                ImageButton btnSeleccion = (ImageButton) findViewById((
                        getResources().getIdentifier("opcion"+ i, "id", this.getPackageName())));
                if(i == opcion){
                    btnSeleccion.setBackgroundResource(R.drawable.icon_cheems_llora);
                }else {
                    btnSeleccion.setBackgroundResource(R.drawable.icon_cheems);
                }
            }
        }else{
            Vibrator vibrador = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrador.vibrate(VibrationEffect.createOneShot(150, VibrationEffect.DEFAULT_AMPLITUDE));


            ImageButton btnSeleccion = (ImageButton) findViewById((
                    getResources().getIdentifier("opcion"+ opcion, "id", this.getPackageName())));
            btnSeleccion.setBackgroundResource(R.drawable.icon_cheems);
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.opcion1){
            destapar(1);
        } else if(view.getId() == R.id.opcion2){
            destapar(2);
        }else if(view.getId() == R.id.opcion3){
            destapar(3);
        }else if(view.getId() == R.id.opcion4){
            destapar(4);
        }else if(view.getId() == R.id.opcion5){
            destapar(5);
        }else if(view.getId() == R.id.opcion6){
            destapar(6);
        } else if(view.getId() == R.id.btnReiniciar){
            iniciar();
        }
    }
}