package android.ahduni.seas.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.TimeUnit;

/**
 * Created by kisha on 30/05/2017.
 */

public class GCMEndpointJokeTest extends AndroidTestCase
{
    GetJokeAsyncTask test;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        test = new GetJokeAsyncTask(){
            @Override
            protected void onPostExecute(String result){
            }
        };
    }


    public void testString() {
        try
        {
            test.execute();
            assertNotNull(test.get());
        }catch(Exception ex)
        {
            fail("The wrong data was returned.");
        }

    }
    }
