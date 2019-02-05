package mvestro.android.quizinparis.fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mvestro.android.quizinparis.R;
import mvestro.android.quizinparis.controller.GameActivity;

import static android.support.v4.content.ContextCompat.checkSelfPermission;

public class CameraFragment extends Fragment {
    ZBarScannerView scannerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_camera, container, false);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && checkSelfPermission(Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{

                    Manifest.permission.CAMERA}, 99);

        }
        ZBarScannerView scannerView = new ZBarScannerView(this);
        scannerView = new ZBarScannerView(this);
        List<BarcodeFormat> formats = new ArrayList<>();
        formats.add(BarcodeFormat.QRCODE);
        scannerView.setFormats(formats);
        FrameLayout contentFL = findViewById(R.id.contentFL);
        contentFL.addView(scannerView);
        return view;
    }

    private int checkSelfPermission(String camera) {
        return 0;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[]

            permissions, int[] grantResults) {

        if(requestCode == 99 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            // permission autorisée ...
        }
    }

    private boolean checkCameraHardware(Context ctx) {
        if(ctx.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    @Override
    public void onResume() {
        super.onResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }
    @Override
    public void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }
}
