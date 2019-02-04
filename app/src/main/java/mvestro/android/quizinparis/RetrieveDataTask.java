package mvestro.android.quizinparis;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import mvestro.android.quizinparis.controller.MainActivity;
import mvestro.android.quizinparis.fragment.GridFragment;
import mvestro.android.quizinparis.fragment.TemperatureFragment;
import mvestro.android.quizinparis.model.TemperatureSensorData;
import mvestro.android.quizinparis.services.GattSensorReader;
import mvestro.android.quizinparis.services.ISensorReader;

import static mvestro.android.quizinparis.controller.MainActivity.TAG;

public class RetrieveDataTask extends AsyncTask<Void, Void, TemperatureSensorData> {

    Activity activity;
    ProgressDialog pDialog;
    Dialog mDialog:

    public BluetoothAdapter btAdapter;

    Fragment fragment;

    public  RetrieveDataTask(Activity activity, BluetoothAdapter btAdapter) {this.activity = activity; this.btAdapter = btAdapter;}

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(activity);
        pDialog.setMessage("Getting data from sensor...");
        pDialog.setIndeterminate(false);
        pDialog.show();
    }

    @Override
    protected TemperatureSensorData doInBackground(Void... voids) {
        try {
            String sensorMacAddresse = "F0:C7:7F:85:35:0C";
            ISensorReader reader = new GattSensorReader(activity, btAdapter);
            String[] rawData = reader.readRawData(sensorMacAddresse);
            TemperatureSensorData data = TemperatureSensorData.parseData(rawData);
            return data;
        } catch (RuntimeException e) {
            Log.e(TAG, e.getMessage());
            return null;
        }

    }

    @Override
    protected void onPostExecute(TemperatureSensorData temperatureSensorData) {
        super.onPostExecute(temperatureSensorData);

        pDialog.dismiss();

        if (temperatureSensorData == null){
//            Toast.makeText(activity, Double.toString(temperatureSensorData.temperature), Toast.LENGTH_LONG);
//            Toast.makeText(,"Impossible de joindre", Toast.LENGTH_LONG);


        } else {
            TextView textViewTemp = (TextView) this.activity.findViewById(R.id.temperature);
            TextView textViewHum = (TextView) this.activity.findViewById(R.id.humidity);
            TextView textViewPow = (TextView) this.activity.findViewById(R.id.power);

            textViewTemp.setText(String.valueOf(temperatureSensorData.temperature) + "°C");
            textViewHum.setText(String.valueOf(temperatureSensorData.humidity) + "%");
            textViewPow.setText(String.valueOf(temperatureSensorData.power) + "%");
            return;
        }

    }
}
