package mvestro.android.quizinparis.fragment;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import java.util.ArrayList;
import java.util.List;

import me.dm7.barcodescanner.zbar.BarcodeFormat;
import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;
import mvestro.android.quizinparis.R;
import mvestro.android.quizinparis.Activity.MainActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class PresenceFragment extends Fragment implements ZBarScannerView.ResultHandler {

    public static String TAG = "QRCODE";
    View view;

    ZBarScannerView scannerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_presence, container, false);

        scannerView = new ZBarScannerView(getActivity());

        List<BarcodeFormat> formats = new ArrayList<>();
        formats.add(BarcodeFormat.QRCODE);
        scannerView.setFormats(formats);

        FrameLayout contentFL = view.findViewById(R.id.contentFL);
        contentFL.addView(scannerView);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && getActivity().checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{
                    Manifest.permission.CAMERA}, 99);
            } else {

        }
        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 99 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

        }
    }

    private boolean checkCameraHardware(Context ctx) {

        if(ctx.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            // Cet appareil possède une caméra
            return true;
        } else {
            // Cet appareil ne possède pas une caméra
            return false;
        }
    }

    @Override
    public void handleResult(Result rawResult) {
        String qrcode = rawResult.getContents();
        Log.d(TAG, "QRcode" + qrcode);
        String token = "47009fb3c5609b31ce86c27b3a38f380";
        Toast.makeText(view.getContext(),qrcode,Toast.LENGTH_LONG).show();
        remoteSign(token, qrcode);
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();

        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }

    public void remoteSign(String token, String qrcode) {

        String urlString = "http://172.30.46.136/iot-server/api/qrcode-sign.php?key=iot1235&token="+ token +"&qrcode=" + qrcode;
        Ion.with(this).load(urlString).asString().withResponse().setCallback(new FutureCallback<Response<String>>() {
            @Override
            public void onCompleted(Exception e, Response<String> result) {
                if (result.getHeaders().code() == 200){

                }
            }
        });

    }

    @Override
    public void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
