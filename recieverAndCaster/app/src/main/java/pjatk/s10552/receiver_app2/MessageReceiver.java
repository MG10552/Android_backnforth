package pjatk.s10552.receiver_app2;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Toast;


public class MessageReceiver extends BroadcastReceiver {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i("ReceiverTest", "Intent received: "+intent.getAction());
        Toast.makeText(context, "Received new message", Toast.LENGTH_SHORT).show();
        Log.d("1", "onReceive: --------------------------------------------------------------------------------------------------");

        Intent serviceIntent = new Intent(context, MService.class);
        context.startService(serviceIntent);
        String data = intent.getStringExtra("data");
        SendNotification(context, data);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void SendNotification(Context context, String message){
        Log.i("NotificationTest", "I caught something ");
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, context.getPackageManager().getLaunchIntentForPackage("pjatk.s10552.caster_app1"), PendingIntent.FLAG_CANCEL_CURRENT);
        Notification notification = new Notification.Builder(context)
                .setContentTitle("New incoming message. ")
                .setContentText("Content: "+ message)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();

       NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
       notificationManager.notify(0, notification);
    }
}