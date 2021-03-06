package com.experiment.anotherproject;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

public class Training extends AppCompatActivity {
    protected static final int RESULT_SPEECH = 1;
    ImageButton imagea, imageb, imagec, imaged, imagee, imagef, imageg, imageh, imagei, imagej,
            imagek, imagel, imagem, imagen, imageo, imagep, imageq, imager, images, imaget, imageu,
            imagev, imagew, imagex, imagey, imagez, imageone, imagetwo, imagethree, imagefour, imagefive, imagesix,
            imageseven, imageeight, imagenine, imagezero;

    TextView tv_converter;
    public String letterConfirm;


    private TextToSpeech tts;
    boolean mBluetoothConnected =false;
    BluetoothConnectionService mBluetoothConnection;
    final static String inStream_a = "01";//a
    final static String inStream_b = "02";//b
    final static String inStream_c = "03";//c
    final static String inStream_d = "04";//d
    final static String inStream_e = "05";//e
    final static String inStream_f = "06";//f
    final static String inStream_g = "07";//g
    final static String inStream_h = "8";//off
    final static String inStream_i = "9";//blink
    final static String inStream_j = "10";//on
    final static String inStream_k = "11";//off
    final static String inStream_l = "12";//blink
    final static String inStream_m = "13";//on
    final static String inStream_n = "14";//off
    final static String inStream_o = "15";//blink
    final static String inStream_p = "16";//on
    final static String inStream_q = "17";//off
    final static String inStream_r = "18";//blink
    final static String inStream_s = "19";//on
    final static String inStream_t = "20";//off
    final static String inStream_u = "21";//blink
    final static String inStream_v = "22";//on
    final static String inStream_w = "23";//off
    final static String inStream_x = "24";//blink
    final static String inStream_y = "25";//on
    final static String inStream_z = "26";//off

    final static String inStream_one = "31";//blink
    final static String inStream_two = "32";//on
    final static String inStream_three = "33";//off
    final static String inStream_four = "34";//blink
    final static String inStream_five = "35";//on
    final static String inStream_six = "36";//off
    final static String inStream_seven = "37";//blink
    final static String inStream_eight = "38";//on
    final static String inStream_nine = "39";//off
    final static String inStream_zero = "30";//blink
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT ="text";
    private String name;
    private static final String TAG = "BlueTest5-Controlling";
    private final ArrayList<String> letterArray = new ArrayList<>();
    private final ArrayList<String> countArray = new ArrayList<>();
    private final ArrayList<ImageButton> imageButtonsAbcArray = new ArrayList<>();
    private final ArrayList<ImageButton> imageButtonsCountArray = new ArrayList<>();
    private final ArrayList<String> confirmStringLetter = new ArrayList<>();
    private final ArrayList<String> confirmStringNumber = new ArrayList<>();
    private final String[] letterA = {"a", "hey", "aye","A", "Hey", "Aye"};
    private final String[] letterB = {"B", "Bee", "Me", "b", "bee", "me"};
    private final String[] letterC = {"C", "Sea", "See", "c", "sea", "see" };
    private final String[] letterD = {"Did", "dee", "Dee", "d", "D", "did"};
    private final String[] letterE = {"E", "Ee","He", "e", "he", "ee"};
    private final String[] letterF = {"F", "Ef", "Ff", "f", "eff", "fff"};
    private final String[] letterG = {"G", "Gee", "Gg", "g", "gee", "gii"};
    private final String[] letterH = {"H", "Itch", "Etch", "h", "itch", "etch"};
    private final String[] letterI = {"Eye", "Aye", "I", "i", "aye", "eye"};
    private final String[] letterJ = {"J", "jay", "jj",  "j", "Jay", "Jj"};
    private final String[] letterK = {"K", "Kay", "kk",  "k", "kay", "kei"};
    private final String[] letterL = {"L", "Ll", "l", "el", "ll"};
    private final String[] letterM = {"M", "Am", "mm", "m", "em", "am"};
    private final String[] letterN= {"N", "In", "nn", "n", "en", "in"};
    private final String[] letterO = {"O", "Oh", "oo", "o", "oh", "ou"};
    private final String[] letterP = {"p", "Pee", "Pp", "p", "Pee", "pp"};
    private final String[] letterQ = {"Q", "Cue", "qq", "q", "cue", "queue"};
    private final String[] letterR = {"R", "Are", "Our", "r", "are", "our"};
    private final String[] letterS = {"s", "Is", "ss", "s", "es", "is"};
    private final String[] letterT = {"T", "Tea", "tt", "t", "tee", "tea"};
    private final String[] letterU = {"U", "You", "Uu", "u", "you", "uu"};
    private final String[] letterV = {"V", "Vv", "Vee", "v", "vee", "vv"};
    private final String[] letterW = {"W", "Ww", "Www", "w", "ww", "w w"};
    private final String[] letterX = {"X", "Text", "Sex", "x", "text", "sex"};
    private final String[] letterY = {"Y", "Yy", "Why", "y", "yy", "why"};
    private final String[] letterZ = {"Z", "Zee", "Say", "z", "zee", "say"};


    private final String[] numberZero = {"Zero", "00", "000", "zero", "0", "cero"};
    private final String[] numberOne = {"One", "1", "Launch", "one", "wan", "launch"};
    private final String[] numberTwo = {"Two", "too", "2", "two", "22", "to"};
    private final String[] numberThree = {"3", "33", "Three", "three", "tree", "say"};
    private final String[] numberFour = {"4", "Four", "For", "four", "for", "44"};
    private final String[] numberFive = {"55", "555", "Five", "five", "5", "hi"};
    private final String[] numberSix = {"66", "Six", "sick", "six", "6", "pics"};
    private final String[] numberSeven = {"7 7", "Seven", "Heaven", "seven", "heaven", "7"};
    private final String[] numberEight = {"Eight", "8 8", "8", "eight", "ate", "hey"};
    private final String[] numberNine = {"9 9", "99", "Nine", "nine", "time", "9"};

    private UUID mDeviceUUID;
    private BluetoothDevice mDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        Bundle b = getIntent().getExtras();
        mDevice = b.getParcelable(MainActivity.DEVICE_EXTRA);
        mDeviceUUID = UUID.fromString(b.getString(MainActivity.DEVICE_UUID));
        mBluetoothConnection = new BluetoothConnectionService(Training.this);
        if(!mBluetoothConnected) {
            mBluetoothConnection.convertBoolean(true);
            startConnection();
        }
        Log.d(TAG, "Ready");
        tv_converter = findViewById(R.id.tv_converter);
        imageButtonsAbcArray.add(imagea=findViewById(R.id.lst_a));
        imageButtonsAbcArray.add(imageb= findViewById(R.id.lst_b));
        imageButtonsAbcArray.add(imagec= findViewById(R.id.lst_c));
        imageButtonsAbcArray.add(imaged= findViewById(R.id.lst_d));
        imageButtonsAbcArray.add(imagee= findViewById(R.id.lst_e));
        imageButtonsAbcArray.add(imagef= findViewById(R.id.lst_f));
        imageButtonsAbcArray.add(imageg= findViewById(R.id.lst_g));
        imageButtonsAbcArray.add(imageh= findViewById(R.id.lst_h));
        imageButtonsAbcArray.add(imagei= findViewById(R.id.lst_i));
        imageButtonsAbcArray.add(imagej= findViewById(R.id.lst_j));
        imageButtonsAbcArray.add(imagek= findViewById(R.id.lst_k));
        imageButtonsAbcArray.add(imagel= findViewById(R.id.lst_l));
        imageButtonsAbcArray.add(imagem= findViewById(R.id.lst_m));
        imageButtonsAbcArray.add(imagen= findViewById(R.id.lst_n));
        imageButtonsAbcArray.add(imageo= findViewById(R.id.lst_o));
        imageButtonsAbcArray.add(imagep= findViewById(R.id.lst_p));
        imageButtonsAbcArray.add(imageq= findViewById(R.id.lst_q));
        imageButtonsAbcArray.add(imager= findViewById(R.id.lst_r));
        imageButtonsAbcArray.add(images= findViewById(R.id.lst_s));
        imageButtonsAbcArray.add(imaget= findViewById(R.id.lst_t));
        imageButtonsAbcArray.add(imageu= findViewById(R.id.lst_u));
        imageButtonsAbcArray.add(imagev= findViewById(R.id.lst_v));
        imageButtonsAbcArray.add(imagew= findViewById(R.id.lst_w));
        imageButtonsAbcArray.add(imagex= findViewById(R.id.lst_x));
        imageButtonsAbcArray.add(imagey= findViewById(R.id.lst_y));
        imageButtonsAbcArray.add(imagez= findViewById(R.id.lst_z));

        imageButtonsCountArray.add( imagezero=findViewById(R.id.lst_zero));
        imageButtonsCountArray.add( imageone= findViewById(R.id.lst_one));
        imageButtonsCountArray.add( imagetwo= findViewById(R.id.lst_two));
        imageButtonsCountArray.add( imagethree=findViewById(R.id.lst_three));
        imageButtonsCountArray.add( imagefour=findViewById(R.id.lst_four));
        imageButtonsCountArray.add( imagefive=findViewById(R.id.lst_five));
        imageButtonsCountArray.add( imagesix= findViewById(R.id.lst_six));
        imageButtonsCountArray.add( imageseven=findViewById(R.id.lst_seven));
        imageButtonsCountArray.add( imageeight=findViewById(R.id.lst_eight));
        imageButtonsCountArray.add( imagenine =findViewById(R.id.lst_nine));

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

        confirmStringLetter.add("A");
        confirmStringLetter.add("B");
        confirmStringLetter.add("C");
        confirmStringLetter.add("D");
        confirmStringLetter.add("E");
        confirmStringLetter.add("F");
        confirmStringLetter.add("G");
        confirmStringLetter.add("H");
        confirmStringLetter.add("I");
        confirmStringLetter.add("J");
        confirmStringLetter.add("K");
        confirmStringLetter.add("L");
        confirmStringLetter.add("M");
        confirmStringLetter.add("N");
        confirmStringLetter.add("O");
        confirmStringLetter.add("P");
        confirmStringLetter.add("Q");
        confirmStringLetter.add("R");
        confirmStringLetter.add("S");
        confirmStringLetter.add("T");
        confirmStringLetter.add("U");
        confirmStringLetter.add("V");
        confirmStringLetter.add("W");
        confirmStringLetter.add("X");
        confirmStringLetter.add("Y");
        confirmStringLetter.add("Z");

        confirmStringNumber.add("0");
        confirmStringNumber.add("1");
        confirmStringNumber.add("2");
        confirmStringNumber.add("3");
        confirmStringNumber.add("4");
        confirmStringNumber.add("5");
        confirmStringNumber.add("6");
        confirmStringNumber.add("7");
        confirmStringNumber.add("8");
        confirmStringNumber.add("9");

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        name = sharedPreferences.getString(TEXT,"");

        tts = new TextToSpeech(getApplicationContext(), status -> {
            if (status == TextToSpeech.SUCCESS) {
                String spike = "Welcome "+name+" to Train your Braille skills";
                tts.setLanguage(Locale.getDefault());
                tts.setSpeechRate(0.6f);
                tts.speak(spike, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

            tv_converter.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override

                public void afterTextChanged(Editable s) {
                    String strInput = tvCatcher(tv_converter);
                    if (possibleWords(strInput,letterA) && letterConfirm.equals("A")) {
                        reply("Good Job "+name+", that is letter A, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(0).getBytes());
                    }
                    else if (possibleWords(strInput, letterB) && letterConfirm.equals("B")) {
                        reply("Good Job "+name+", that is letter B, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(1).getBytes());
                    }
                    else if (possibleWords(strInput, letterC)&& letterConfirm.equals("C")) {
                        reply("Good Job "+name+", that is letter C, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(2).getBytes());
                    }
                    else if (possibleWords(strInput, letterD)&& letterConfirm.equals("D")) {
                        reply("Good Job "+name+", that is letter D, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(3).getBytes());
                    }
                    else if (possibleWords(strInput, letterE)&& letterConfirm.equals("E")) {
                        reply("Good Job "+name+", that is letter E, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(4).getBytes());
                    }
                    else if (possibleWords(strInput, letterF)&& letterConfirm.equals("F")) {
                        reply("Good Job "+name+", that is letter F, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(5).getBytes());
                    }
                    else if (possibleWords(strInput, letterG)&& letterConfirm.equals("G")) {
                        reply("Good Job "+name+", that is letter G, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(6).getBytes());
                    }
                    else if (possibleWords(strInput, letterH)&& letterConfirm.equals("H")) {
                        reply("Good Job "+name+", that is letter H , Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(7).getBytes());
                    }
                    else if (possibleWords(strInput, letterI)&& letterConfirm.equals("I")) {
                        reply("Good Job "+name+", that is letter I, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(8).getBytes());
                    }
                    else if (possibleWords(strInput, letterJ)&& letterConfirm.equals("J")) {
                        reply("Good Job "+name+", that is letter J, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(9).getBytes());
                    }
                    else if (possibleWords(strInput, letterK)&& letterConfirm.equals("K")) {
                        reply("Good Job "+name+", that is letter K, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(10).getBytes());
                    }
                    else if (possibleWords(strInput, letterL)&& letterConfirm.equals("L")) {
                        reply("Good Job "+name+", that is letter L, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(11).getBytes());
                    }
                    else if (possibleWords(strInput, letterM)&& letterConfirm.equals("M")) {
                        reply("Good Job "+name+", that is letter M, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(12).getBytes());
                    }
                    else if (possibleWords(strInput, letterN)&& letterConfirm.equals("N")) {
                        reply("Good Job "+name+", that is letter N, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(13).getBytes());
                    }
                    else if (possibleWords(strInput, letterO)&& letterConfirm.equals("O")) {
                        reply("Good Job "+name+", that is letter O, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(14).getBytes());
                    }
                    else if (possibleWords(strInput, letterP)&& letterConfirm.equals("P")) {
                        reply("Good Job "+name+", that is letter P , Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(15).getBytes());
                    }
                    else if (possibleWords(strInput, letterQ)&& letterConfirm.equals("Q")) {
                        reply("Good Job "+name+", that is letter Q, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(16).getBytes());
                    }
                    else if (possibleWords(strInput, letterR)&& letterConfirm.equals("R")) {
                        reply("Good Job "+name+", that is letter R, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(17).getBytes());
                    }
                    else if (possibleWords(strInput, letterS)&& letterConfirm.equals("S")) {
                        reply("Good Job "+name+", that is letter S, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(18).getBytes());
                    }
                    else if (possibleWords(strInput, letterT)&& letterConfirm.equals("T")) {
                        reply("Good Job "+name+", that is letter T, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(19).getBytes());
                    }
                    else if (possibleWords(strInput, letterU)&& letterConfirm.equals("U")) {
                        reply("Good Job "+name+", that is letter U, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(20).getBytes());
                    }
                    else if (possibleWords(strInput, letterV)&& letterConfirm.equals("V")) {
                        reply("Good Job "+name+", that is letter V, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(21).getBytes());
                    }
                    else if (possibleWords(strInput, letterW)&& letterConfirm.equals("W")) {
                        reply("Good Job "+name+", that is letter W, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(22).getBytes());
                    }
                    else if (possibleWords(strInput, letterX)&& letterConfirm.equals("X")) {
                        reply("Good Job "+name+", that is letter X, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(23).getBytes());
                    }
                    else if (possibleWords(strInput, letterY)&& letterConfirm.equals("Y")) {
                        reply("Good Job "+name+", that is letter Y, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(24).getBytes());
                    }
                    else if (possibleWords(strInput, letterZ)&& letterConfirm.equals("Z")) {
                        reply("Good Job "+name+", that is letter Z, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(25).getBytes());
                    }

                    else if (possibleWords(strInput, numberZero)&& letterConfirm.equals("0")) {
                        reply("Good Job "+name+", that is number zero, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(9).getBytes());
                    }
                    else if (possibleWords(strInput, numberOne)&& letterConfirm.equals("1")) {
                        reply("Good Job "+name+", that is number one, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(0).getBytes());
                    }
                    else if (possibleWords(strInput, numberTwo)&& letterConfirm.equals("2")) {
                        reply("Good Job "+name+", that is number two, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(1).getBytes());
                    }
                    else if (possibleWords(strInput, numberThree)&& letterConfirm.equals("3")) {
                        reply("Good Job "+name+", that is number three, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(2).getBytes());
                    }
                    else if (possibleWords(strInput, numberFour)&& letterConfirm.equals("4")) {
                        reply("Good Job "+name+", that is number four, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(3).getBytes());
                    }
                    else if (possibleWords(strInput, numberFive)&& letterConfirm.equals("5")) {
                        reply("Good Job "+name+", that is number five Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(4).getBytes());
                    }
                    else if (possibleWords(strInput, numberSix)&& letterConfirm.equals("6")) {
                        reply("Good Job "+name+", that is number six, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(5).getBytes());
                    }
                    else if (possibleWords(strInput, numberSeven)&& letterConfirm.equals("7")) {
                        reply("Good Job "+name+", that is number seven, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(6).getBytes());
                    }
                    else if (possibleWords(strInput, numberEight)&& letterConfirm.equals("8")) {
                        reply("Good Job "+name+", that is number eight, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(7).getBytes());
                    }
                    else if (possibleWords(strInput, numberNine)&& letterConfirm.equals("9")) {
                        reply("Good Job "+name+", that is number nine, Do you wanna continue learning braille?");
                        mBluetoothConnection.write(letterArray.get(8).getBytes());
                    }
                    else{
                        tryagain();
                    }
                }
            });

        for(int i=0; i!=26; i++){
            buttonClick(imageButtonsAbcArray.get(i),letterArray.get(i), confirmStringLetter.get(i));
        }

        for(int i=0; i!=10; i++){
            buttonClick(imageButtonsCountArray.get(i), countArray.get(i), confirmStringNumber.get(i));
        }
    }

    public void buttonClick(ImageButton button, String s, String confirmLetter) {
        button.setOnClickListener(v -> {
            mBluetoothConnection.write(s.getBytes());
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US");
            try {
                startActivityForResult(intent, RESULT_SPEECH);
            } catch (Exception e){
                Toast.makeText(getApplicationContext(), "Your device doesn't support Speech to Text", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
            msg(confirmLetter);
            letterConfirm = confirmLetter;
        });
    }

    public void startBTConnection(BluetoothDevice device, UUID uuid) {
        Log.d(TAG, "startBTConnection: Initializing RFCOM Bluetooth Connection.");
        mBluetoothConnection.startClient(device, uuid);
    }


    private void msg(String s) {
        Toast.makeText(Training.this, s, Toast.LENGTH_SHORT).show();
    }

    public void startConnection() {
        try {
            startBTConnection(mDevice, mDeviceUUID);
        } catch (Exception e) {
            Log.e(TAG, "Connection Failed");
            msg("Connection Failed.");
        }
    }

    public String tvCatcher(TextView tv) {
        return tv.getText().toString();
    }

    private void tryagain() {
        tts = new TextToSpeech(getApplicationContext(), status -> {
            if (status == TextToSpeech.SUCCESS) {
                String spike = "You almost got it, wanna try again?";
                tts.setLanguage(Locale.getDefault());
                tts.speak(spike, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }
    public void reply(String s) {
        tts = new TextToSpeech(getApplicationContext(), status -> {
            if (status == TextToSpeech.SUCCESS) {
                tts.setSpeechRate(0.8f);
                tts.setLanguage(Locale.getDefault());
                tts.speak(s, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_SPEECH) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                tv_converter.setText(text.get(0));
            }
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        msg("Main Menu");
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static boolean possibleWords(String inputStr, String[] items) {
        return Arrays.stream(items).anyMatch(inputStr::contains);
    }
    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
    }

}

