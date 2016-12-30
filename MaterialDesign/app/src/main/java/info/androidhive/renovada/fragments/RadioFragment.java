package info.androidhive.renovada.fragments;



import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.IOException;

import info.androidhive.materialdesign.R;
import info.androidhive.renovada.utils.Constants;

public class RadioFragment extends Fragment {

    private Button btn_Play;
    private Button btn_Stop;
    private MediaPlayer mPlayer;

    public RadioFragment() {


        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_radio, container, false);


        btn_Play = (Button) rootView.findViewById(R.id.btn_Play);
        btn_Stop = (Button) rootView.findViewById(R.id.btn_Stop);

        mPlayer = new MediaPlayer();

        btn_Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    mPlayer.setDataSource ( Constants.STREAM_URL );
                    mPlayer.prepareAsync();
                    mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mp.start();
                        }
                    });


                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
        });
        btn_Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayer.stop();
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}