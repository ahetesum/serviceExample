package ali.com.foregroundservice;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import static ali.com.foregroundservice.App.CHANNEL_ID;

public class ExampleService extends Service
{

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String message=intent.getStringExtra("ExtraInput");

        Intent notificationIntent=new Intent(this,MainActivity.class);

        PendingIntent pendingIntent= PendingIntent.getActivity(this,0,notificationIntent,0);


        Notification notification= new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("Example Service")
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_add_alert_black_24dp)
                .setContentIntent(pendingIntent).build();

        startForeground(1,notification);

        return  START_NOT_STICKY;

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
