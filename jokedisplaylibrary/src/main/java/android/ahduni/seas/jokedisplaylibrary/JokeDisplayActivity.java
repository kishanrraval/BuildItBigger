package android.ahduni.seas.jokedisplaylibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    public final String LOG_TAG = JokeDisplayActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_activity);
        Log.i(LOG_TAG, "onCreate:JokeDisplayActivity");

        String joke;
        if(savedInstanceState == null)
        {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                joke = null;
            } else {
                joke = extras.getString(Intent.EXTRA_TEXT);
            }
        }
        else
        {
            joke = (String) savedInstanceState.getSerializable(Intent.EXTRA_TEXT);

        }

        Log.i(LOG_TAG, "joke: " + joke);
        TextView textView = (TextView) this.findViewById(R.id.joke_text_view);
        textView.setText(joke);
    }
}
