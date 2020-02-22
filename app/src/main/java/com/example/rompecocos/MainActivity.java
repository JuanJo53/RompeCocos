package com.example.rompecocos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etnomb;
    TextView tvpuntaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnomb=(EditText)findViewById(R.id.etNombre);
        tvpuntaje=(TextView)findViewById(R.id.tvPuntaje);
    }
    boolean datosOk(){
        String nombre=etnomb.getText().toString();
        if(!nombre.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public void ocIniciar(View view){
        String nombre=etnomb.getText().toString();
        if(datosOk()){
            Intent invoca=new Intent(this,Puzzle.class);
            invoca.putExtra("nombre",nombre);
            startActivityForResult(invoca,1);
        }else{
            Toast.makeText(getApplicationContext(),"Ingrese su nombre!",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==1){
            String mensaje=data.getStringExtra("nombre");
            tvpuntaje.setText(mensaje);
        }
    }
}
