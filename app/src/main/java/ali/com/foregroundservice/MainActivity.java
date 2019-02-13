package ali.com.foregroundservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText inputEditText=null;
    private Button startButton=null;
    private Button stopButton=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText= findViewById(R.id.inputEditText);
        startButton= findViewById(R.id.startButton);
        stopButton= findViewById(R.id.stopButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String notificationMessage= inputEditText.getText().toString();
                Intent startServiceIntent=new Intent(MainActivity.this,ExampleService.class);
                startServiceIntent.putExtra("ExtraInput",notificationMessage);
                startService(startServiceIntent);
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startServiceIntent=new Intent(MainActivity.this,ExampleService.class);
                stopService(startServiceIntent);
            }
        });

    }
}
