package chen.gong.youtubetogo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

/**
 * Created by gongchen on 1/5/17.
 */

public class StandaloneActivity  extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);

        Button btnPlayVideo = (Button)findViewById(R.id.btnPlayVideo);
        Button btnPlayList = (Button)findViewById(R.id.btnPlayList);

        btnPlayVideo.setOnClickListener(this);
        btnPlayList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this
                        , YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_VIDEO_ID, 0, true,
                        false);
                break;
            case R.id.btnPlayList:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this
                        , YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTBE_PLAYLIST, 0, 0,
                        true, true);//The 1st  0 is index. The 2nd true switches on the light box
                break;
            default:
        }
        if (intent != null){
            startActivity(intent);
        }

    }
}
