package pjatk.s10552.caster_app1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button1 = (Button) findViewById(R.id.button1);
        final EditText editText1 = (EditText) findViewById(R.id.editText1);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String data = editText1.getText().toString();
                intent.setAction("pjatk.s10552.caster_app1.CATCH_MESSAGE");
                intent.putExtra("data", data);
                intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                sendBroadcast(intent, "pjatk.s10552.caster_app1.CATCH_MESSAGE");
                Log.i("BroadcastTest", "broadcast OUT with value: "+editText1.getText());
            }
        });
    }
}
