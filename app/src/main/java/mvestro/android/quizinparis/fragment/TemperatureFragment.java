package mvestro.android.quizinparis.fragment;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mvestro.android.quizinparis.R;
import mvestro.android.quizinparis.RetrieveDataTask;

import static mvestro.android.quizinparis.controller.MainActivity.TAG;

public class TemperatureFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_temperature, container, false);

        BluetoothManager bm = (BluetoothManager) getContext().getSystemService(Context.BLUETOOTH_SERVICE);
        BluetoothAdapter btAdapter =bm.getAdapter();



        if (btAdapter == null) {
            Log.e(TAG, "Bluetooth Adapter not available");
        }

        if (!btAdapter.isEnabled()) {
            Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(i, 99);
        } else {
            Log.e(TAG, "Bluetooth activé");
            new RetrieveDataTask(getActivity(),btAdapter).execute();



        }

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
