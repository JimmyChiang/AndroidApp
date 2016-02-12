package megachips.msensor;

/**
 * Created by honda.kazuhisa on 2015/10/07.
 */
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import megachips.msensor.R;

/**
 * Created by honda.kazuhisa on 2015/10/05.
 */
public class SensorList extends AppCompatActivity implements SensorEventListener  {
	final private String mVersion = "Ver.1.0";
	final private String mTag = "HalSensorList";
	private TextView tv;
	private SensorManager mSensorManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sensor_list_main);

		// SensorManagerのインスタンスを取得する
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

		// センサーのオブジェクトリストを取得する
		List<Sensor> sensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);

		// センサ数更新
		tv = (TextView)findViewById(R.id.id_sensor_num);
		tv.setText(String.valueOf(sensors.size()));

		// 全センサのリストを表示
		LinearLayout tableLayout = (LinearLayout)findViewById(R.id.sensor_list_linear_layer);
		for(int i=0; i < sensors.size(); i++) {
			Sensor s = sensors.get(i);

			LinearLayout linlay = (LinearLayout)getLayoutInflater().inflate(R.layout.sensor_list_param, null);
			// Number
			TextView senidx = (TextView)linlay.findViewById(R.id.sen_idx);
			senidx.setText(String.valueOf(i));
			// Name
			TextView name = (TextView)linlay.findViewById(R.id.id_sen_name);
			name.setText(s.getName());
			// Vendor
			TextView vendor = (TextView)linlay.findViewById(R.id.sen_param_vendor);
			vendor.setText(s.getVendor());
			// Version
			TextView version = (TextView)linlay.findViewById(R.id.sen_param_version);
			version.setText(String.valueOf(s.getVersion()));
			// Type
			TextView type = (TextView)linlay.findViewById(R.id.sen_param_type);
			type.setText(String.valueOf(s.getType()));
			// MaxRange
			TextView maxrange = (TextView)linlay.findViewById(R.id.sen_param_maxrange);
			maxrange.setText(String.valueOf(s.getMaximumRange()));
			// Resolution
			TextView resolution = (TextView)linlay.findViewById(R.id.sen_param_resolution);
			resolution.setText(String.valueOf(s.getResolution()));
			// Power
			TextView power = (TextView)linlay.findViewById(R.id.sen_param_power);
			power.setText(String.valueOf(s.getPower()));
			// MinDelay
			TextView mindelay = (TextView)linlay.findViewById(R.id.sen_param_mindelay);
			mindelay.setText(String.valueOf(s.getMinDelay()));
			// fifoReservedEventCount
			TextView frevc = (TextView)linlay.findViewById(R.id.sen_param_fifoReservedEventCount);
			frevc.setText(String.valueOf(s.getFifoReservedEventCount()));
			// fifoMaxEventCount
			TextView fmec = (TextView)linlay.findViewById(R.id.sen_param_fifoMaxEventCount);
			fmec.setText(String.valueOf(s.getFifoMaxEventCount()));
			// stringtype
			TextView strtype = (TextView)linlay.findViewById(R.id.sen_param_stringType);
//			strtype.setText(getResources().getString(R.string.str_not_supp));
			strtype.setText(s.getStringType());
			// MaxDelay
			TextView maxdelay = (TextView)linlay.findViewById(R.id.sen_param_maxDelay);
			maxdelay.setText(String.valueOf(s.getMaxDelay()));
//			maxdelay.setText(getResources().getString(R.string.str_not_supp));
			// ReportingMode
			TextView repmode = (TextView)linlay.findViewById(R.id.sen_param_reportingMode);
			repmode.setText(String.valueOf(s.getReportingMode()));
//			repmode.setText(getResources().getString(R.string.str_not_supp));
			// Add View
			tableLayout.addView(linlay, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_sensor_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_sensorMonitor) {
			//次の画面に遷移させる
			Intent intent = new Intent();
			intent.setClassName(
					getPackageName(),
					getPackageName() + getResources().getString(R.string.class_SensorMonitor));
			startActivity(intent);
			return true;
		}else if (id == R.id.action_sensorList) {
			//次の画面に遷移させる
			Intent intent = new Intent();
			intent.setClassName(
					getPackageName(),
					getPackageName() + getResources().getString(R.string.class_SensorList));
			startActivity(intent);
			return true;
		}
		else {
			// Non
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onSensorChanged(SensorEvent event) {

	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {

	}
}
