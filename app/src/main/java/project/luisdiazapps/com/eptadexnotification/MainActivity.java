package project.luisdiazapps.com.eptadexnotification;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnNoti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnNoti = (Button)findViewById(R.id.btnNoti);
        
        btnNoti.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        int color = getResources().getColor(R.color.colorPrimary);


        builder.setContentTitle("Super notificacion")
                .setContentText("Notificando al usuairo al instante")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setVibrate(new long[]{100,100,100,400})
                .setAutoCancel(false)
                .setColor(color);

        builder.setContentIntent(pendingIntent);
        builder.setDefaults(Notification.DEFAULT_SOUND);

        NotificationManager manager = (NotificationManager)getSystemService(this.NOTIFICATION_SERVICE);
        manager.notify(0,builder.build());
        Toast.makeText(this, "sdfjsd",Toast.LENGTH_LONG).show();
    }
}




















/*
/**Intent intent = new Intent(this, MainActivity.class);
 PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
 int color = this.getResources().getColor(R.color.colorPrimary);
 NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
 .setSmallIcon(R.mipmap.ic_launcher)
 .setColor(color)
 .setVibrate(new long[]{100, 250})
 .setAutoCancel(false)
 .setContentTitle("Notificacion")
 .setContentText("Contenido de la misma");

 mBuilder.setContentIntent(pi);
 mBuilder.setDefaults(Notification.DEFAULT_ALL);


 NotificationManager mNotificationManager = (NotificationManager) this.getSystemService(this.NOTIFICATION_SERVICE);
 mNotificationManager.notify(0, mBuilder.build());**/

