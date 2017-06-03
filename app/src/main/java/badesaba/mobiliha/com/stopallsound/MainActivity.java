package badesaba.mobiliha.com.stopallsound;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{
private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Onclick();
    }

    private void Onclick() {
        btn.setOnClickListener(this);
    }

    private void init(){
        btn=(Button)findViewById(R.id.button);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button :
                stop();
                break;
            default :
                break;

        }
    }
    private void stop(){
        AudioManager am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        int result = am.requestAudioFocus(focusChangeListener,
                 // Use the music stream.
                AudioManager.STREAM_MUSIC,
                // Request permanent focus.
                AudioManager.AUDIOFOCUS_GAIN);


        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            // other app had stopped playing song now , so u can do u stuff now .
        }
    }

   private AudioManager.OnAudioFocusChangeListener focusChangeListener =
           new AudioManager.OnAudioFocusChangeListener() {
               public void onAudioFocusChange(int focusChange) {
                   switch (focusChange) {

                       case (AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) :
                           break;
                       case (AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) :
                           break;

                       case (AudioManager.AUDIOFOCUS_LOSS) :
                           break;
                       case (AudioManager.AUDIOFOCUS_GAIN) :
                           break;
                       default: break;
                   }
               }
           };

}
