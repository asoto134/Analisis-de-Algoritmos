package soto.selectionsortapp;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class BackgroundIntent extends IntentService {

    public static final int STATUS_RUNNING = 0;
    public static final int STATUS_FINISHED = 1;
    public static final int STATUS_ERROR = 2;

    private static final String TAG = "BackgroundIntent";

    public BackgroundIntent() {
        super(BackgroundIntent.class.getName());
    }



    static final int MAX_VALUE = 100000;
    static int[] data = new int[MAX_VALUE];


    public void generarNuevoArreglo() {
        Random random = new Random();

        for (int i = 0; i < data.length; i++){
            data[i] = random.nextInt(MAX_VALUE);
        }
    }

    public static void Selection()
    {
        SelectionSort(data);
    }

    public static void SelectionSort(int[] num)
    {
        int i;
        int j;
        int posMin;
        int tem;
        int n = data.length;
        for ( i = 0; i < n; i++)
        {
            posMin = i;
            for ( j = i + 1; j < n ; j++)
            {
                if (data[j] < data[posMin])
                {
                    posMin = j;
                }
            }
            tem = data[posMin];
            data[posMin] = data[i];
            data[i] = tem;
        }
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.d(TAG, "Service Started!");

        final ResultReceiver receiver = intent.getParcelableExtra("receiver");

        Bundle bundle = new Bundle();

 /* Service Started */
        receiver.send(STATUS_RUNNING, Bundle.EMPTY);
        try {

            long start = System.nanoTime();
            generarNuevoArreglo();
            Selection();
            long end = System.nanoTime();

            long elapsedTime = end - start;
            String res = "trascurrieron: " + elapsedTime + "nano seconds\n" +
                    "lo cual es " + TimeUnit.NANOSECONDS.toSeconds(elapsedTime) + " segundos";

            bundle.putString("exectime",res);
        }
        catch (Error err)
        {
            bundle.putString(Intent.EXTRA_TEXT, err.getMessage());
            receiver.send(STATUS_ERROR, bundle);
        }

        /* Status Finished */
        receiver.send(STATUS_FINISHED, bundle);
        Log.d(TAG, "Service Stopping!");
        this.stopSelf();
    }
}