package mvestro.android.quizinparis.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.pedro.vlc.VlcListener;
import com.pedro.vlc.VlcVideoLibrary;
import org.videolan.libvlc.MediaPlayer;

import java.util.Arrays;

import mvestro.android.quizinparis.R;


public class CamFragment extends Fragment implements VlcListener {

    SurfaceView previewSV;
    VlcVideoLibrary vlcPlayer;
//    String mrl = "rtsp://admin:Azerty12345*@192.168.0.11:554/12";
    String mrl = "rtsp://wowzaec2demo.streamlock.net/vod/mp4:BigBuckBunny_115k.mov";
//    String mrl = "https://www.youtube.com/watch?v=ubloKkB835A";
private String[] options = new String[]{":fullscreen"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_cam, container, false);

//        previewSV = (SurfaceView) view.findViewById(R.id.previewSV);
//        vlcPlayer = new VlcVideoLibrary(getContext(), this, previewSV);
//        vlcPlayer.play(mrl);

        VideoView videoView = (VideoView) view.findViewById(R.id.videoView);
        MediaController mc = new MediaController(getActivity());

        videoView.setVideoURI(Uri.parse(mrl));

        videoView.requestFocus();
        videoView.start();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onComplete() {
        Toast.makeText(getContext(), "Play", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError() {
        Toast.makeText(getContext(), "Incorrect MRL", Toast.LENGTH_SHORT).show();
        vlcPlayer.stop();
    }
}
