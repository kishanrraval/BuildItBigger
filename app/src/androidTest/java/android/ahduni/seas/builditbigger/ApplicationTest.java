package android.ahduni.seas.builditbigger;

/**
 * Created by kisha on 27/05/2017.
 */
import android.app.Application;
import android.test.ApplicationTestCase;
import android.text.TextUtils;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;

import java.util.concurrent.CountDownLatch;


public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testSample() {
        assertEquals(1 + 1, 2);
    }

    String joke;

    public void testJoke() throws InterruptedException {
        final CountDownLatch signal = new CountDownLatch(1);
        GetJokeAsyncTask task = new GetJokeAsyncTask();
        task.setListener(new GetJokeAsyncTask.OnGetJokeAsyncTaskCompleted() {
            @Override
            public void onGetJokeTaskCompleted(String jsonString) {
                joke = jsonString;

                signal.countDown();
            }
        }).execute();
        signal.await();

        Assert.assertThat(joke, CoreMatchers.containsString("bla bla bla"));

        assertFalse("Joke is empty", TextUtils.isEmpty(joke));

    }



}
