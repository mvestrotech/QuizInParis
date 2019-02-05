package mvestro.android.quizinparis.fragment;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pedro.vlc.VlcListener;
import com.pedro.vlc.VlcVideoLibrary;

import mvestro.android.quizinparis.R;
import mvestro.android.quizinparis.RetrieveDataTask;

import static mvestro.android.quizinparis.controller.MainActivity.TAG;

public class VideoFragment extends Fragment implements VlcListener {
    VlcVideoLibrary vlcPlayer;
    SurfaceView previewSV ;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        return inflater.inflate(R.layout.fragment_video, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        previewSV = (SurfaceView) view.findViewById(R.id.previewSV);

        vlcPlayer = new VlcVideoLibrary(getContext(), this, previewSV);

        String mrl = "rtsp://wowzaec2demo.streamlock.net/vod/mp4:BigBuckBunny_115k.mov";
        vlcPlayer.play(mrl);
    }



    @Override
    public void onComplete() {
        Toast.makeText(getContext(), "Playing", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError() {
        Toast.makeText(getContext(), "Incorrect MRL", Toast.LENGTH_SHORT).show();
        vlcPlayer.stop();
    }

}
