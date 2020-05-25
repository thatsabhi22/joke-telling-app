package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import androidx.core.util.Pair;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotEquals;

/**
 * Instrumented test, which will execute on an Android device.
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    final String LOG_TAG = "ExampleInstrumentedTest";
    Context appContext;

    // This test should be run on free flavor of app
    @Test
    public void useAppContext() {
        // Context of the app under test.
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.udacity.gradle.builditbigger.free", appContext.getPackageName());
    }

    @Test
    public void testEndpointTask() throws ExecutionException, InterruptedException {
        String result =
                new EndpointsAsyncTask(null)
                        .execute(new Pair<Context, String>(appContext, "Manfred")).get();
        assertNotNull(result);
        assertNotEquals(result, "error");
        assertTrue(result.length() > 0);
    }
}
