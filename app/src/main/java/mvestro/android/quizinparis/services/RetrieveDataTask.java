package mvestro.android.quizinparis.services;

import android.app.Activity;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import mvestro.android.quizinparis.R;

import static android.widget.Toast.LENGTH_SHORT;

public class RetrieveDataTask extends AsyncTask<Void, Void, TemperatureSensorData> {

    Activity activity;
    ProgressDialog pDialog;
    public static String TAG = "SENSOR";

    public BluetoothAdapter btAdapter;

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
            Log.e(TAG, "erreur");
            Toast.makeText(activity, "imposible", LENGTH_SHORT);


        } else {
            TextView textViewTemp = (TextView) this.activity.findViewById(R.id.temperature);
            TextView textViewHum = (TextView) this.activity.findViewById(R.id.humidity);
            TextView textViewPow = (TextView) this.activity.findViewById(R.id.power);

            textViewTemp.setText(String.valueOf(temperatureSensorData.temperature) + "°C");
            textViewHum.setText(String.valueOf(temperatureSensorData.humidity) + "%");
            textViewPow.setText(String.valueOf(temperatureSensorData.power) + "%");
        }
        return;

    }
}
