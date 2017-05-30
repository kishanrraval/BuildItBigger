package android.ahduni.seas.builditbigger;

import android.os.AsyncTask;
import android.util.Log;

import com.example.kisha.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by kishan on 27/05/2017.
 */

public class GetJokeAsyncTask extends AsyncTask<Void, Void, String>
{
    public final String LOG_TAG = GetJokeAsyncTask.class.getSimpleName();


    public GetJokeAsyncTask()
    {
        super();
    }

    @Override
    protected String doInBackground(Void... params) {

        if(myApiService == null)
        {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("http://192.168.137.1:8080/_ah/api")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
            /*MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://myendpoint.azurewebsites.net/_ah/api/");
            myApiService = builder.build();*/
        }



        try
        {
            return myApiService.getJoke().execute().getData();
        }
        catch (IOException ex)
        {
            return ex.getMessage();
        }

    }

    private static MyApi myApiService = null;
    private OnGetJokeAsyncTaskCompleted theListener;

    public GetJokeAsyncTask(OnGetJokeAsyncTaskCompleted listener)
    {
        theListener = listener;
    }

    public GetJokeAsyncTask setListener(OnGetJokeAsyncTaskCompleted listener) {
        this.theListener = listener;
        return this;
    }

    @Override
    protected void onPostExecute(String s) {
        Log.i(LOG_TAG, "onPostExecute result: " + s);
        theListener.onGetJokeTaskCompleted(s);

    }

    public interface OnGetJokeAsyncTaskCompleted {
        void onGetJokeTaskCompleted(String result);
    }
}
