package pjatk.s10552.receiver_app2;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

public class MService extends Service {

    MessageReceiver myReceiver = new MessageReceiver();
    public MService() {
    }
    private boolean isRunning  = false;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("ServiceTest", "Service Started");

        new Thread(new Runnable() {
            @Override
            public void run() {
                registerReceiver(myReceiver, new IntentFilter("pjatk.s10552.caster_app1.CATCH_MESSAGE"));

                for (int i = 0; i < 15; i++) {
                    try {
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                    if(isRunning){
                        Log.i("ServiceTest", "My name is "+i+" and I'm a proof of running receiver.");
                    }
                }
            }
        }).start();

        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("ServiceTest", "Service Bound.");
        return null;
    }
    @Override
    public void onCreate(){
        Log.i("ServiceTest", "Service Created.");
        isRunning = true;
    }
    @Override
    public void onDestroy(){
        unregisterReceiver(myReceiver);
        isRunning = false;
        Log.i("ServiceTest", "Service Destroyed.");
    }
}
