package android.ahduni.seas.jokedisplaylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class JokeDisplayActivity extends AppCompatActivity {

    public final String LOG_TAG = JokeDisplayActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.i(LOG_TAG, "onCreate:JokeDisplayActivity");
    }
}
