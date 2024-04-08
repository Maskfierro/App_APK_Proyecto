package com.elxit.apk_app;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity { //Aqui se declaran las variables

    private ImageView elxitimg; //Se importa la imagen desde activity_main
    Button si;
    Button no;
    TextView correo2;
    TextView contra2;

    TextView usuario;
    TextView contra;
    TextView numero;
    TextView correo;

//--------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;});
//--------------------------------------------------------------------------------------------------

//////////////////////////////// ANIMACION DE ROTACION DE LA IMAGEN "E"

        elxitimg = findViewById(R.id.elxitimg); //Se importa el objeto por su "ID"
        Animation rotationAnimation = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        //Se carga la animacion desde el archivo "rotacion.xml"
        elxitimg.startAnimation(rotationAnimation); //Se inicializa la funcion

/////////////////////////////// ACCION AL PRESIONAR EL BOTON Y MOSTRAR UN MENSAJE

        correo2 = findViewById(R.id.correo2);
        contra2 = findViewById(R.id.contra2);
        final boolean[] invisible = {true};

        si = (Button) findViewById(R.id.si);
        no = (Button) findViewById(R.id.no);
        si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Registrarse",Toast.LENGTH_SHORT).show();
                //Mostrar un mensaje al presionar el boton

                if(invisible[0]){ //Condicion en donde la variable invisible esta en "true"
                                 // si "invisible" es verdadero entonces no se mostrara el formulario
                    correo2.setVisibility(View.INVISIBLE);
                    contra2.setVisibility(View.INVISIBLE);
                    invisible[0] = false; // Cambia a "false"

                } else{
                    //En caso de que la variable sea "false" se mostrara el formulario
                    correo2.setVisibility(View.VISIBLE);
                    contra2.setVisibility(View.VISIBLE);
                    invisible[0] = true; //Se cambia el valor a "true"
                }

            }
        });

    }

    final boolean[] mostrar = {true};
    public void boton_no(View view){

        Toast.makeText(this,"INICIAR SESION",Toast.LENGTH_SHORT).show();

        usuario = findViewById(R.id.usuario);
        contra = findViewById(R.id.contra);
        numero = findViewById(R.id.numero);
        correo = findViewById(R.id.correo);


        if(mostrar[0]){

        usuario.setVisibility(View.INVISIBLE);
        contra.setVisibility(View.INVISIBLE);
        numero.setVisibility(View.INVISIBLE);
        correo.setVisibility(View.INVISIBLE);

        mostrar[0] = false;

        }else {

            usuario.setVisibility(View.VISIBLE);
            contra.setVisibility(View.VISIBLE);
            numero.setVisibility(View.VISIBLE);
            correo.setVisibility(View.VISIBLE);

            mostrar[0] = true;

        }


    }
}