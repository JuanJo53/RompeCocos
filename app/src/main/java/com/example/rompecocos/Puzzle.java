package com.example.rompecocos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

public class Puzzle extends AppCompatActivity {

    TextView tvbienv;
    String nombre;
    TextView num1,num2,num3,num4,num5,num6,num7,num8,num9;
    TextView tvgan,tvper;
    Chronometer crono;
    int winCount=0,looseCount=0,pasos=0;
    int puntajeTiempo=0;
    boolean firstRound=true;
    boolean win=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);

        tvbienv=(TextView)findViewById(R.id.tvBienv);

        num1=(TextView)findViewById(R.id.topLeftCenter);
        num2=(TextView)findViewById(R.id.topCenter);
        num3=(TextView)findViewById(R.id.topRightCenter);
        num4=(TextView)findViewById(R.id.leftCenter);
        num5=(TextView)findViewById(R.id.center);
        num6=(TextView)findViewById(R.id.rightCenter);
        num7=(TextView)findViewById(R.id.botLeftCenter);
        num8=(TextView)findViewById(R.id.botCenter);
        num9=(TextView)findViewById(R.id.botRightCenter);

        tvgan=(TextView)findViewById(R.id.tvGanados);
        tvper=(TextView)findViewById(R.id.tvPerdidos);

        crono=(Chronometer)findViewById(R.id.cronometro);

        darBienvenida();
    }
    public boolean verfRepite(int n, int v[]){
        boolean verf=false;
        for (int i=0;i<9;i++){
            if(n!=v[i]){
                verf=true;
            }else{
                verf=false;
                break;
            }
        }
        return verf;
    }
    public void darBienvenida() {
        Bundle bolsa=getIntent().getExtras();
        nombre=bolsa.getString("nombre");
        tvbienv.setText("Bienvenido "+nombre+"!\nPuedes comenzar a jugar!");


    }
    public void ocTopLeft(View view){
        if(num2.getText().toString().equals("  ")){
            num2.setText(num1.getText().toString());
            num1.setText("  ");
        }
        if(num4.getText().toString().equals("  ")){
            num4.setText(num1.getText().toString());
            num1.setText("  ");
        }
        winnerControl("Movimiento");
    }
    public void ocTopRight(View view){
        if(num2.getText().toString().equals("  ")){
            num2.setText(num3.getText().toString());
            num3.setText("  ");
        }
        if(num6.getText().toString().equals("  ")){
            num6.setText(num3.getText().toString());
            num3.setText("  ");
        }
        winnerControl("Movimiento");
    }
    public void ocBotRight(View view){
        if(num8.getText().toString().equals("  ")){
            num8.setText(num9.getText().toString());
            num9.setText("  ");
        }
        if(num6.getText().toString().equals("  ")){
            num6.setText(num9.getText().toString());
            num9.setText("  ");
        }
        winnerControl("Movimiento");
    }
    public void ocBotLeft(View view){
        if(num8.getText().toString().equals("  ")){
            num8.setText(num7.getText().toString());
            num7.setText("  ");
        }
        if(num4.getText().toString().equals("  ")){
            num4.setText(num7.getText().toString());
            num7.setText("  ");
        }
        winnerControl("Movimiento");
    }
    public void ocRight(View view){
        if(num3.getText().toString().equals("  ")){
            num3.setText(num6.getText().toString());
            num6.setText("  ");
        }
        if(num9.getText().toString().equals("  ")){
            num9.setText(num6.getText().toString());
            num6.setText("  ");
        }
        if(num5.getText().toString().equals("  ")){
            num5.setText(num6.getText().toString());
            num6.setText("  ");
        }
        winnerControl("Movimiento");
    }
    public void ocLeft(View view){
        if(num1.getText().toString().equals("  ")){
            num1.setText(num4.getText().toString());
            num4.setText("  ");
        }
        if(num5.getText().toString().equals("  ")){
            num5.setText(num4.getText().toString());
            num4.setText("  ");
        }
        if(num7.getText().toString().equals("  ")){
            num7.setText(num4.getText().toString());
            num4.setText("  ");
        }
        winnerControl("Movimiento");
    }
    public void ocTopCenter(View view){
        if(num1.getText().toString().equals("  ")){
            num1.setText(num2.getText().toString());
            num2.setText("  ");
        }
        if(num3.getText().toString().equals("  ")){
            num3.setText(num2.getText().toString());
            num2.setText("  ");
        }
        if(num5.getText().toString().equals("  ")){
            num5.setText(num2.getText().toString());
            num2.setText("  ");
        }
        winnerControl("Movimiento");
    }
    public void ocBotCenter(View view){
        if(num9.getText().toString().equals("  ")){
            num9.setText(num8.getText().toString());
            num8.setText("  ");
        }
        if(num5.getText().toString().equals("  ")){
            num5.setText(num8.getText().toString());
            num8.setText("  ");
        }
        if(num7.getText().toString().equals("  ")){
            num7.setText(num8.getText().toString());
            num8.setText("  ");
        }
        winnerControl("Movimiento");
    }
    public void ocCenter(View view){
        if(num2.getText().toString().equals("  ")){
            num2.setText(num5.getText().toString());
            num5.setText("  ");
        }
        if(num4.getText().toString().equals("  ")){
            num4.setText(num5.getText().toString());
            num5.setText("  ");
        }
        if(num6.getText().toString().equals("  ")){
            num6.setText(num5.getText().toString());
            num5.setText("  ");
        }
        if(num8.getText().toString().equals("  ")){
            num8.setText(num5.getText().toString());
            num5.setText("  ");
        }
        winnerControl("Movimiento");
    }


    public void ocNuevo(View view){
        pasos=0;
        int c=0;
        int nums[]={0,0,0,0,0,0,0,0,0};
        String numsSt[]={"","","","","","","","",""};
        for(;c<9;){
            int aux=(int) (Math.random()*10);
            if(verfRepite(aux,nums)==true){
                nums[c]=aux;
                c++;
            }
        }
        for(int i=0;i<9;i++){
            if(nums[i]==9){
                nums[i]=0;
                numsSt[i]="  ";
            }else{
                numsSt[i]=String.valueOf(nums[i]);
            }
        }
        num1.setText(numsSt[0]);
        num2.setText(numsSt[1]);
        num3.setText(numsSt[2]);
        num4.setText(numsSt[3]);
        num5.setText(numsSt[4]);
        num6.setText(numsSt[5]);
        num7.setText(numsSt[6]);
        num8.setText(numsSt[7]);
        num9.setText(numsSt[8]);
        winnerControl("Nuevo");
        win=false;
        crono.setBase(SystemClock.elapsedRealtime());
        crono.start();
        tvgan.setText(String.valueOf(winCount));
        tvper.setText(String.valueOf(looseCount));
    }
    public void winnerControl(String type){
        if((num1.getText().toString()).equals("1")){
            if ((num2.getText().toString()).equals("2")){
                if((num3.getText().toString()).equals("3")){
                    if((num4.getText().toString()).equals("4")){
                        if((num5.getText().toString()).equals("5")){
                            if((num6.getText().toString()).equals("6")){
                                if((num7.getText().toString()).equals("7")){
                                    if((num8.getText().toString()).equals("8")){
                                        winCount++;
                                        crono.stop();
                                        long elapsedMillis = (SystemClock.elapsedRealtime() - crono.getBase())/1000;
                                        puntajeTiempo(elapsedMillis);
                                        Toast.makeText(getApplicationContext(),"Rompecabezas Solucionado!\nDuraste: "+elapsedMillis+" segs",Toast.LENGTH_SHORT).show();
                                        win=true;
                                        crono.setBase(SystemClock.elapsedRealtime());
                                        //tvgan.setText(winCount);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }else{
            if(firstRound){
                Toast.makeText(getApplicationContext(),"Generado!",Toast.LENGTH_SHORT).show();
                firstRound=false;
            }else{
                if(type.equals("Nuevo")&&!firstRound&&win==false){
                    long elapsedMillis = (SystemClock.elapsedRealtime() - crono.getBase())/1000;
                    puntajeTiempo(elapsedMillis);
                    looseCount++;
                    Toast.makeText(getApplicationContext(),"Nuevo Generado!\nDuraste: "+elapsedMillis+" segs",Toast.LENGTH_SHORT).show();
                }else{
                    pasos++;
                }
            }
        }
    }
    public void ocVerPuntajeFinal(View view){
        Intent retorno=new Intent();
        String mensaje="Puntaje Total: "+calcPuntaje()+"\n"+nombre+" eres";
        if(calcPuntaje()<100){
            mensaje+=" nada!";
        }else{
            if(calcPuntaje()<200){
                mensaje+=" un poco mas que nada!";
            }else{
                if(calcPuntaje()<500){
                    mensaje+=" bueno!";
                }else{
                    mensaje+=" muy bueno!";
                }
            }
        }
        retorno.putExtra("nombre",mensaje);
        setResult(1,retorno);
        finish();
    }
    public int calcPuntaje(){
        int pts=0;
        if(winCount>looseCount){
            pts+=300;
        }
        return pts+puntajeTiempo;
    }
    public int puntajeTiempo(long tiempo){
        int pt=0;
        if(tiempo<60){
            pt+=10;
        }else{
            if(tiempo<120){
                pt+=20;
            }else{
                if(tiempo<300){
                    pt+=40;
                }else{
                    pt+=100;
                }
            }
        }
        puntajeTiempo+=pt;
        return pt;
    }
}
