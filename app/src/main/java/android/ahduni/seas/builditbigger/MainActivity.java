package android.ahduni.seas.builditbigger;

import android.ahduni.seas.jokedisplaylibrary.JokeDisplayActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.JokeLibrary;

public class MainActivity extends AppCompatActivity implements GetJokeAsyncTask.OnGetJokeAsyncTaskCompleted
{

    public final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log.i(LOG_TAG, "onCreate: MainActivity");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

        new GetJokeAsyncTask(this).execute();
    }

    public void displayJokeActivity(String joke) {
        Intent jokeDisplayIntent = new Intent(this, JokeDisplayActivity.class);
        jokeDisplayIntent.putExtra(Intent.EXTRA_TEXT, joke);
        startActivity(jokeDisplayIntent);
    }

    @Override
    public void onGetJokeTaskCompleted(String result) {
        displayJokeActivity(result);
    }
}
