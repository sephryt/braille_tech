package com.experiment.anotherproject;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    Button search,btn_fam,btn_exe,confirmN;
    EditText nameUser;
    CardView cardView;
    String Uname;
    ConstraintLayout expandableView, settingsView;
    private ListView listView;
    ImageView pic1, pic2;
    private TextToSpeech txts;
    private BluetoothAdapter mBTAdapter;private static final int BT_ENABLE_REQUEST = 10; // This is the code we use for BT Enable
    private static final int SETTINGS = 20;
    private UUID mDeviceUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private int mBufferSize = 50000; //Default
    public static final String DEVICE_EXTRA = "com.example.anotherproject.SOCKET";
    public static final String DEVICE_UUID = "com.example.anotherproject.uuid";
    private static final String DEVICE_LIST = "com.example.anotherproject.devicelist";
    private static final String DEVICE_LIST_SELECTED = "com.example.anotherproject.devicelistselected";
    public static final String BUFFER_SIZE = "com.example.anotherproject.buffersize";
    private static final String TAG = "BlueTest5-MainActivity";
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT ="text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        nameUser = findViewById(R.id.userName);
        confirmN = findViewById(R.id.confirmName);
        btn_fam = findViewById(R.id.btn_familiarization);
        btn_exe = findViewById(R.id.btn_exercise);
        search = findViewById(R.id.btn_search);
        settingsView = findViewById(R.id.SettingsContainer);
        pic1 = findViewById(R.id.image2);
        pic2 = findViewById(R.id.image3);

        expandableView = findViewById(R.id.expandableView);
        cardView = findViewById(R.id.cardview);
        listView = findViewById(R.id.listview);
        mBTAdapter = BluetoothAdapter.getDefaultAdapter();

        txts = new TextToSpeech(getApplicationContext(), status -> {
            if (status ==TextToSpeech.SUCCESS)
            {
                String spike = "Welcome to Braille Learning App";
                Log.d(TAG, "Opened App" + " Opened the App Successfully");
                txts.setLanguage(Locale.getDefault());
                txts.setSpeechRate(0.7f);
                txts.speak(spike, TextToSpeech.QUEUE_FLUSH, null); } });

        settingsView.setOnClickListener(v -> {
            if (expandableView.getVisibility()==View.GONE){
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                expandableView.setVisibility(View.VISIBLE);
                pic1.setImageResource(R.drawable.ic_launcher_arrowup_foreground);
                pic2.setImageResource(R.drawable.ic_launcher_arrowup_foreground);
            } else {
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                expandableView.setVisibility(View.GONE);
                pic1.setImageResource(R.drawable.ic_dropdown_arrow);
                pic2.setImageResource(R.drawable.ic_dropdown_arrow); } });

        Uname = nameUser.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String conf = sharedPreferences.getString(TEXT, "");
        if(conf.isEmpty()){
            msg("No User Name Yet");
        }else {
            nameUser.setText(conf);
        }

        confirmN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uname = nameUser.getText().toString();
                if(Uname.isEmpty()){
                    txts = new TextToSpeech(getApplicationContext(), status -> {
                        if (status ==TextToSpeech.SUCCESS)
                        {
                            String spike = "Kindly put the user's name on the field, thank you";
                            txts.setLanguage(Locale.getDefault());
                            txts.setSpeechRate(0.8f);
                            txts.speak(spike, TextToSpeech.QUEUE_FLUSH, null); } });


                }else{
                    txts = new TextToSpeech(getApplicationContext(), status -> {
                        if (status ==TextToSpeech.SUCCESS)
                        {
                            String spike = "Welcome "+Uname+", Lets learn braille";
                            txts.setLanguage(Locale.getDefault());
                            txts.setSpeechRate(0.8f);
                            txts.speak(spike, TextToSpeech.QUEUE_FLUSH, null); } });
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    if (!sharedPreferences.getString(TEXT,"").isEmpty())
                    {
                        editor.clear().apply();
                    }
                    editor.putString(TEXT, Uname);
                    editor.apply();
                }
            }
        });

        btn_exe.setOnClickListener(v -> {
            Uname = nameUser.getText().toString();
            if (!mBTAdapter.isEnabled()){
                try{msg("Bluetooth is not available");
                }catch (Exception e){
                    msg(e.getMessage());
                }
            }else
            {
                BluetoothDevice device = ((MyAdapter) (listView.getAdapter())).getSelectedItem();
                if(device == null)
                {
                    msg("Search for the bluetooth device");
                }
                Intent intent = new Intent(getApplicationContext(), Training.class);
                intent.putExtra(DEVICE_EXTRA, device);
                intent.putExtra(DEVICE_UUID, mDeviceUUID.toString());
                intent.putExtra(BUFFER_SIZE, mBufferSize);
                intent.putExtra("nameUSER", Uname);
                startActivity(intent); } });
        btn_fam.setOnClickListener(v -> {
            Uname = nameUser.getText().toString();
            BluetoothDevice device = ((MyAdapter) (listView.getAdapter())).getSelectedItem();
            if (!mBTAdapter.isEnabled()&&device==null){
                try{msg("Bluetooth is not available");
                }catch (Exception e){
                   msg(e.getMessage());
                }

            }else
            {
                if(device == null)
                {
                    msg("Search for the bluetooth device");
                }
                Intent intent = new Intent(getApplicationContext(), GetToKnow.class);
                intent.putExtra(DEVICE_EXTRA, device);
                intent.putExtra(DEVICE_UUID, mDeviceUUID.toString());
                intent.putExtra(BUFFER_SIZE, mBufferSize);
                intent.putExtra("nameUSER", Uname);
                startActivity(intent);
            }
        });

        if (savedInstanceState != null) {
            ArrayList<BluetoothDevice> list = savedInstanceState.getParcelableArrayList(DEVICE_LIST);
            if (list != null) {
                initList(list);
                MyAdapter adapter = (MyAdapter) listView.getAdapter();
                int selectedIndex = savedInstanceState.getInt(DEVICE_LIST_SELECTED);
                if (selectedIndex != -1) {
                    adapter.setSelectedIndex(selectedIndex);
                    btn_exe.setEnabled(true);
                    btn_fam.setEnabled(true);
                }
            } else {
                initList(new ArrayList<>());
            }

        } else {
            initList(new ArrayList<>());
        }

        search.setOnClickListener(v -> {

            if (mBTAdapter == null) {
                Toast.makeText(getApplicationContext(), "Bluetooth not found", Toast.LENGTH_SHORT).show();
            } else if (!mBTAdapter.isEnabled()) {
                Intent enableBT = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBT, BT_ENABLE_REQUEST);
            } else {
                new SearchDevices().execute();
            }
        });
    }

    private static class MyAdapter extends ArrayAdapter<BluetoothDevice> {
        private int selectedIndex;
        private final Context context;
        private final int selectedColor = Color.parseColor("#abcdef");
        private List<BluetoothDevice> myList;

        public MyAdapter(Context ctx, int resource, int textViewResourceId, List<BluetoothDevice> objects) {
            super(ctx, resource, textViewResourceId, objects);
            context = ctx;
            myList = objects;
            selectedIndex = -1;
        }
        public void setSelectedIndex(int position) {
            selectedIndex = position;
            notifyDataSetChanged();
        }
        public BluetoothDevice getSelectedItem() {
            try{
                return myList.get(selectedIndex);
            }catch (Exception e) {
                Log.d(TAG,e.getMessage());
            }
            return null;
        }
        @Override
        public int getCount() {
            return myList.size();
        }
        @Override
        public BluetoothDevice getItem(int position) {
            return myList.get(position);
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        private static class ViewHolder {
            TextView tv;
        }
        public void replaceItems(List<BluetoothDevice> list) {
            myList = list;
            notifyDataSetChanged();
        }
        public List<BluetoothDevice> getEntireList() {
            return myList;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View vi = convertView;
            ViewHolder holder;
            if (convertView == null) {
                vi = LayoutInflater.from(context).inflate(R.layout.list_item, null);
                holder = new ViewHolder();

                holder.tv = vi.findViewById(R.id.lstContent);

                vi.setTag(holder);
            } else {
                holder = (ViewHolder) vi.getTag();
            }

            if (selectedIndex != -1 && position == selectedIndex) {
                holder.tv.setBackgroundColor(selectedColor);
            } else {
                holder.tv.setBackgroundColor(Color.WHITE);
            }
            BluetoothDevice device = myList.get(position);
            holder.tv.setText(device.getName() + "\n " + device.getAddress());
            return vi; }}
    protected void onPause() {
        super.onPause(); }
    @Override
    protected void onStop() {
        super.onStop(); }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case BT_ENABLE_REQUEST:
                if (resultCode == RESULT_OK) {
                    msg("Bluetooth Enabled successfully");
                    new SearchDevices().execute();
                } else {
                    msg("Bluetooth couldn't be enabled");
                }
                break;
            case SETTINGS: //If the settings have been updated
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
                String uuid = prefs.getString("prefUuid", "Null");
                mDeviceUUID = UUID.fromString(uuid);
                Log.d(TAG, "UUID: " + uuid);
                String bufSize = prefs.getString("prefTextBuffer", "Null");
                mBufferSize = Integer.parseInt(bufSize);

                String orientation = prefs.getString("prefOrientation", "Null");
                Log.d(TAG, "Orientation: " + orientation);
                if (orientation.equals("Portrait")) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
                }
                break;
            default:
                break;
        }
        super.onActivityResult(requestCode, resultCode, data); }

    private class SearchDevices extends AsyncTask<Void, Void, List<BluetoothDevice>> {

        @Override
        protected List<BluetoothDevice> doInBackground(Void... params) {
            Set<BluetoothDevice> pairedDevices = mBTAdapter.getBondedDevices();
            return new ArrayList<>(pairedDevices); }
        @Override
        protected void onPostExecute(List<BluetoothDevice> listDevices) {
            super.onPostExecute(listDevices);
            if (listDevices.size() > 0) {
                MyAdapter adapter = (MyAdapter) listView.getAdapter();
                adapter.replaceItems(listDevices);
            } else {
                msg("No paired devices found, please pair your serial BT device and try again"); } }}
    private void msg(String str) {
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show(); }
    private void initList(List<BluetoothDevice> objects) {
        MyAdapter adaptr = new MyAdapter(getApplicationContext(), R.layout.list_item, R.id.lstContent, objects);
        listView.setAdapter(adaptr);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            adaptr.setSelectedIndex(position);
            btn_fam.setEnabled(true);
            btn_exe.setEnabled(true);
        }); }
    @Override
    protected void onDestroy() {
        if(txts != null){
            txts.stop();
            txts.shutdown();
        }
        super.onDestroy(); }}
