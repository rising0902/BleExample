package jp.co.ctc_g.bleexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import de.greenrobot.event.EventBus;
import jp.co.ctc_g.bleexample.R;

public class MainActivity extends AppCompatActivity {

    private ScannerController scannerController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scannerController = new ScannerController(getApplicationContext());

        Button scanStartButton = (Button)findViewById(R.id.scanStartButton);
        scanStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scannerController.startScanning();
            }
        });
        Button scanStopButton = (Button)findViewById(R.id.scanStopButton);
        scanStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scannerController.stopScanning();
            }
        });
        ListView deviceList = (ListView)findViewById(R.id.deviceList);
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onEvent(ScanSuccessed event) {
        Toast.makeText(getApplicationContext(), "scan successed!", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
