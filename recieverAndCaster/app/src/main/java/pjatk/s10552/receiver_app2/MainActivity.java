package pjatk.s10552.receiver_app2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MessageReceiver myReceiver = new MessageReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.button);
        final Button button1 = (Button) findViewById(R.id.button2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(v);
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.listening), Toast.LENGTH_SHORT).show();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(v);
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.ceasing), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void startService(View view) {
        Intent i = new Intent(this, MService.class);
        startService(i);
        Log.d("aaaa", "startService: aaaaaaaaaaaaaaaaaa");
    }

    public void stopService(View view) {
        Intent i = new Intent(this, MService.class);
        stopService(i);
        Log.d("bbbb", "stopService: bbbbbbbbbbbbbbbbbbbb");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ReceiverTest_+", "Receiver Online ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ReceiverTest_-", "Receiver Offline ");
    }
}
