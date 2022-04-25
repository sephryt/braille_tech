package com.experiment.anotherproject;

import android.app.ActivityManager;
import android.bluetooth.BluetoothDevice;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Parcelable;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class GetToKnow extends AppCompatActivity {
    TextView tv_inv;

    ImageButton imagea, imageb, imagec, imaged, imagee, imagef , imageg , imageh , imagei , imagej,
            imagek , imagel, imagem, imagen , imageo , imagep , imageq , imager , images , imaget , imageu ,
            imagev , imagew , imagex , imagey , imagez, imageone, imagetwo, imagethree, imagefour, imagefive, imagesix,
            imageseven, imageeight, imagenine, imagezero;
    BluetoothConnectionService mBluetoothConnection;
    TextToSpeech txts;
    final float activatedButton = 1f;
    final float deactivatedButton =0.5f;
    MediaPlayer playMP3;
    boolean timerStarted=false;
    Timer timer;
    TimerTask timerTask;
    int arrayNum=0, arrayNumCount=0;
    boolean abclimit= false,  countlimit= false, mBluetoothConnected =false;
    private String buttonIndicator="";
    String inStreamResetCounter = "77";
    boolean letterFinished = false;
    final static String inStream_a="01";//a
    final static String inStream_b="02";//b
    final static String inStream_c="03";//c
    final static String inStream_d="04";//d
    final static String inStream_e="05";//e
    final static String inStream_f="06";//f
    final static String inStream_g="07";//g
    final static String inStream_h="8";//h
    final static String inStream_i="9";//i
    final static String inStream_j="10";//j
    final static String inStream_k="11";//k
    final static String inStream_l="12";//l
    final static String inStream_m="13";//m
    final static String inStream_n="14";//n
    final static String inStream_o="15";//o
    final static String inStream_p="16";//p
    final static String inStream_q="17";//q
    final static String inStream_r="18";//r
    final static String inStream_s="19";//s
    final static String inStream_t="20";//t
    final static String inStream_u="21";//u
    final static String inStream_v="22";//v
    final static String inStream_w="23";//w
    final static String inStream_x="24";//x
    final static String inStream_y="25";//y
    final static String inStream_z="26";//z

    final static String inStream_zero="30";//0
    final static String inStream_one="31";//1
    final static String inStream_two="32";//2
    final static String inStream_three="33";//3
    final static String inStream_four="34";//4
    final static String inStream_five="35";//5
    final static String inStream_six="36";//6
    final static String inStream_seven="37";//7
    final static String inStream_eight="38";//8
    final static String inStream_nine="39";//9
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT ="text";
    private static final String TAG = "BlueTest5-Controlling";
    private UUID mDeviceUUID;
    private BluetoothDevice mDevice;
    private String name;
    private final ArrayList<String> letterArray = new ArrayList<>();
    private final ArrayList<String> countArray = new ArrayList<>();
    private final ArrayList<Integer> abcMp3 = new ArrayList<>();
    private final ArrayList<Integer> countMp3 = new ArrayList<>();
    private final ArrayList<ImageButton> imageButtonsAbcArray = new ArrayList<>();
    private final ArrayList<ImageButton> imageButtonsCountArray = new ArrayList<>();
    Button btn_count,btn_abcde;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_to_know);
        btn_abcde = findViewById(R.id.btn_abc);
        btn_count = findViewById(R.id.btn_count);
        tv_inv = findViewById(R.id.tv_invi);
        Bundle b = getIntent().getExtras();
        mDevice = b.getParcelable(MainActivity.DEVICE_EXTRA);
        mDeviceUUID = UUID.fromString(b.getString(MainActivity.DEVICE_UUID));
        int mMaxChars = b.getInt(MainActivity.BUFFER_SIZE);
        mBluetoothConnection = new BluetoothConnectionService(GetToKnow.this);

        imageButtonsAbcArray.add(imagea=findViewById(R.id.gtk_a));
        imageButtonsAbcArray.add(imageb= findViewById(R.id.gtk_b));
        imageButtonsAbcArray.add(imagec= findViewById(R.id.gtk_c));
        imageButtonsAbcArray.add(imaged= findViewById(R.id.gtk_d));
        imageButtonsAbcArray.add(imagee= findViewById(R.id.gtk_e));
        imageButtonsAbcArray.add(imagef= findViewById(R.id.gtk_f));
        imageButtonsAbcArray.add(imageg= findViewById(R.id.gtk_g));
        imageButtonsAbcArray.add(imageh= findViewById(R.id.gtk_h));
        imageButtonsAbcArray.add(imagei= findViewById(R.id.gtk_i));
        imageButtonsAbcArray.add(imagej= findViewById(R.id.gtk_j));
        imageButtonsAbcArray.add(imagek= findViewById(R.id.gtk_k));
        imageButtonsAbcArray.add(imagel= findViewById(R.id.gtk_l));
        imageButtonsAbcArray.add(imagem= findViewById(R.id.gtk_m));
        imageButtonsAbcArray.add(imagen= findViewById(R.id.gtk_n));
        imageButtonsAbcArray.add(imageo= findViewById(R.id.gtk_o));
        imageButtonsAbcArray.add(imagep= findViewById(R.id.gtk_p));
        imageButtonsAbcArray.add(imageq= findViewById(R.id.gtk_q));
        imageButtonsAbcArray.add(imager= findViewById(R.id.gtk_r));
        imageButtonsAbcArray.add(images= findViewById(R.id.gtk_s));
        imageButtonsAbcArray.add(imaget= findViewById(R.id.gtk_t));
        imageButtonsAbcArray.add(imageu= findViewById(R.id.gtk_u));
        imageButtonsAbcArray.add(imagev= findViewById(R.id.gtk_v));
        imageButtonsAbcArray.add(imagew= findViewById(R.id.gtk_w));
        imageButtonsAbcArray.add(imagex= findViewById(R.id.gtk_x));
        imageButtonsAbcArray.add(imagey= findViewById(R.id.gtk_y));
        imageButtonsAbcArray.add(imagez= findViewById(R.id.gtk_z));

        imageButtonsCountArray.add( imagezero=findViewById(R.id.gtk_zero));
        imageButtonsCountArray.add( imageone= findViewById(R.id.gtk_one));
        imageButtonsCountArray.add( imagetwo= findViewById(R.id.gtk_two));
        imageButtonsCountArray.add( imagethree=findViewById(R.id.gtk_three));
        imageButtonsCountArray.add( imagefour=findViewById(R.id.gtk_four));
        imageButtonsCountArray.add( imagefive=findViewById(R.id.gtk_five));
        imageButtonsCountArray.add( imagesix= findViewById(R.id.gtk_six));
        imageButtonsCountArray.add( imageseven=findViewById(R.id.gtk_seven));
        imageButtonsCountArray.add( imageeight=findViewById(R.id.gtk_eight));
        imageButtonsCountArray.add( imagenine =findViewById(R.id.gtk_nine));
        

        letterArray.add(inStream_a);
        letterArray.add(inStream_b);
        letterArray.add(inStream_c);
        letterArray.add(inStream_d);
        letterArray.add(inStream_e);
        letterArray.add(inStream_f);
        letterArray.add(inStream_g);
        letterArray.add(inStream_h);
        letterArray.add(inStream_i);
        letterArray.add(inStream_j);
        letterArray.add(inStream_k);
        letterArray.add(inStream_l);
        letterArray.add(inStream_m);
        letterArray.add(inStream_n);
        letterArray.add(inStream_o);
        letterArray.add(inStream_p);
        letterArray.add(inStream_q);
        letterArray.add(inStream_r);
        letterArray.add(inStream_s);
        letterArray.add(inStream_t);
        letterArray.add(inStream_u);
        letterArray.add(inStream_v);
        letterArray.add(inStream_w);
        letterArray.add(inStream_x);
        letterArray.add(inStream_y);
        letterArray.add(inStream_z);

        countArray.add(inStream_zero);
        countArray.add(inStream_one);
        countArray.add(inStream_two);
        countArray.add(inStream_three);
        countArray.add(inStream_four);
        countArray.add(inStream_five);
        countArray.add(inStream_six);
        countArray.add(inStream_seven);
        countArray.add(inStream_eight);
        countArray.add(inStream_nine);

        abcMp3.add( R.raw.a);
        abcMp3.add( R.raw.b);
        abcMp3.add( R.raw.c);
        abcMp3.add( R.raw.d);
        abcMp3.add( R.raw.e);
        abcMp3.add( R.raw.f);
        abcMp3.add( R.raw.g);
        abcMp3.add( R.raw.h);
        abcMp3.add( R.raw.i);
        abcMp3.add( R.raw.j);
        abcMp3.add( R.raw.k);
        abcMp3.add( R.raw.l);
        abcMp3.add( R.raw.m);
        abcMp3.add( R.raw.n);
        abcMp3.add( R.raw.o);
        abcMp3.add( R.raw.p);
        abcMp3.add( R.raw.q);
        abcMp3.add( R.raw.r);
        abcMp3.add( R.raw.s);
        abcMp3.add( R.raw.t);
        abcMp3.add( R.raw.u);
        abcMp3.add( R.raw.v);
        abcMp3.add( R.raw.w);
        abcMp3.add( R.raw.x);
        abcMp3.add( R.raw.y);
        abcMp3.add( R.raw.z);

        countMp3.add(R.raw.numzero);
        countMp3.add(R.raw.numone);
        countMp3.add(R.raw.numtwo);
        countMp3.add(R.raw.numthree);
        countMp3.add(R.raw.numfour);
        countMp3.add(R.raw.numfive);
        countMp3.add(R.raw.numsix);
        countMp3.add(R.raw.numseven);
        countMp3.add(R.raw.numeight);
        countMp3.add(R.raw.numnine);
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        name = sharedPreferences.getString(TEXT,"");
        Log.d(TAG, "Parcels " + mDevice + "" + mDeviceUUID + "" + mMaxChars);
            if(!mBluetoothConnected) {
                mBluetoothConnection.convertBoolean(true);
                startConnection();
            }
        txts = new TextToSpeech(getApplicationContext(), status -> {
            if (status ==TextToSpeech.SUCCESS)
            {
                Log.d(TAG,"TTS " + "TTS SUCCESS");
                String spike = "Welcome "+name+", to Get to Know the Braille Alphabet";
                txts.setLanguage(Locale.getDefault());
                txts.setSpeechRate(0.6f);
                txts.speak(spike, TextToSpeech.QUEUE_FLUSH, null); } });
        btn_abcde.setOnClickListener(v -> {
            abclimit=false;
            buttonIndicator = "ABC";
            startStoppedTapped();
            if(timerStarted) {

                Log.d(TAG,"Write Successful ");
                btn_count.setAlpha(deactivatedButton);
                btn_count.setClickable(false);
            }
            else {
                byte[] tmp = inStreamResetCounter.getBytes();
                mBluetoothConnection.write(tmp);
                btn_count.setAlpha(activatedButton);
                btn_count.setClickable(true);
            }
        });
        btn_count.setOnClickListener(v -> {
            countlimit=false;
            buttonIndicator = "COUNT";
            startStoppedTapped();

            btn_abcde.setClickable(!timerStarted);
            if(timerStarted) {
                btn_abcde.setAlpha(deactivatedButton);
                btn_abcde.setClickable(false);
                Log.d(TAG,"Write Successful ");
            }
            else{
                byte[] tmp = inStreamResetCounter.getBytes();
                mBluetoothConnection.write(tmp);
                Log.d(TAG,"Write Successful ");
                btn_abcde.setAlpha(activatedButton);
                btn_abcde.setClickable(true);
            }
        });
        for(int i=0; i!=26; i++){
            buttonClick(imageButtonsAbcArray.get(i), abcMp3.get(i), letterArray.get(i));
        }

       for(int i=0; i!=10; i++){
           buttonClick(imageButtonsCountArray.get(i), countMp3.get(i), countArray.get(i));
       }
    }
    public void startBTConnection(BluetoothDevice device, UUID uuid){
        Log.d(TAG, "startBTConnection: Initializing RFCOM Bluetooth Connection.");
            mBluetoothConnection.startClient(device, uuid);
    }
    public void startConnection(){
        try {
            startBTConnection(mDevice,mDeviceUUID);
        } catch (Exception e) {
            Log.e(TAG,"Connection Failed");
        }
    }
    public void setPlayMP3(int letterSound){
        if(playMP3 == null) {
            playMP3 = MediaPlayer.create(getApplicationContext(), letterSound);
            playMP3.start();
            playMP3.setOnCompletionListener(mp -> {
                playMP3.stop();
                stopplay();
            });
        }else {
            playMP3.stop();
            stopplay();
        }
    }
    public void startStoppedTapped(){
        if(!timerStarted){
            timer = new Timer();
          timerStarted = true;
          arrayNum =0;
          arrayNumCount=0;
          Log.d(TAG, "Timer started.");
          startTimer();
        }
        else {
            timerStarted = false;
            Log.d(TAG, "Timer Stopped");
            letterFinished = false;
            arrayNum =0;
            arrayNumCount=0;
           timerStop();
        }
    }
    private void startTimer(){
        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                       if(!abclimit&&buttonIndicator.equals("ABC")) {
                           try {
                                   byte[] tmp = letterArray.get(arrayNum).getBytes();
                                   mBluetoothConnection.write(tmp);
                                   setPlayMP3(abcMp3.get(arrayNum));
                                   mBluetoothConnection.translateText(tv_inv);
                                   arrayNum++;
                           } catch (Exception e) {
                               e.printStackTrace();
                           }
                       }
                    if(!countlimit&&buttonIndicator.equals("COUNT")) {
                        try {
                            byte[] tmp = countArray.get(arrayNumCount).getBytes();
                            mBluetoothConnection.write(tmp);
                            setPlayMP3(countMp3.get(arrayNumCount));
                            mBluetoothConnection.translateText(tv_inv);
                            arrayNumCount++;

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                       if(arrayNum==26){
                           arrayNum=0;
                           abclimit =true;
                           btn_count.setAlpha(activatedButton);
                           btn_count.setClickable(true);
                           timerStarted = false;
                           timerStop();
                       }
                    if(arrayNumCount==10){
                        arrayNumCount=0;
                        countlimit =true;
                        btn_abcde.setAlpha(activatedButton);
                        btn_abcde.setClickable(true);
                        timerStarted = false;
                        timerStop();
                    }
                });
            }
        };
        if(buttonIndicator.equals("ABC")) {
            timer.scheduleAtFixedRate(timerTask, 0, 5000);
        }
        if(buttonIndicator.equals("COUNT")){
            timer.scheduleAtFixedRate(timerTask, 0, 5000 );
        }
    }
    private void timerStop(){
        timerTask.cancel();
    }
    public void buttonClick(ImageButton button, int mp3, String letter){
        button.setOnClickListener(v -> {
            try{
                byte[] tmp = letter.getBytes();
                mBluetoothConnection.write(tmp);
                Log.d(TAG,"Write Successful ");
                mBluetoothConnection.translateText(tv_inv);
                String tvText = tv_inv.getText().toString();
                setPlayMP3(mp3);
                /*if (tvText.equals("7")) {
                    setPlayMP3(mp3);
                    msg("Sensor is touched.");
                }else{
                    msg("Braille Tech isn't touched");
                }*/
                tv_inv.setText("");
            }catch (Exception e)
            {
                msg("Process Failed");
                tv_inv.setText("");
            } });
    }
    public void stopplay() {
        if(playMP3 != null){
            playMP3.release();
            playMP3 = null;
        }
    }
    private void msg(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        if (this.isFinishing()){ //basically BACK was pressed from this activity
            timerStop();
        }
        Context context = getApplicationContext();
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
        if (!taskInfo.isEmpty()) {
            ComponentName topActivity = taskInfo.get(0).topActivity;
            if (!topActivity.getPackageName().equals(context.getPackageName())) {
                if(timerStarted)
                timerStop();
            }
        }
        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
        if (this.isFinishing()){
            timerStop();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(timerStarted) timerStop();
        Intent i = new Intent(GetToKnow.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
    }
    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        if(timerStarted) timerStop();
    }
    @Override
    protected void onResume() {
        super.onResume();
        btn_abcde.setAlpha(activatedButton);
        btn_abcde.setClickable(true);
        btn_count.setAlpha(activatedButton);
        btn_count.setClickable(true);
    }
}
