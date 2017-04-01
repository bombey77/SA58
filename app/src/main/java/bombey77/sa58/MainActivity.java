package bombey77.sa58;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    private static int myHour = 0;
    private static int myMinute = 0;
    private static final int DIALOGE = 1;

    TextView tvSetText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSetText = (TextView) findViewById(R.id.tvSetTime);
        tvSetTimeListener();
    }

    void tvSetTimeListener() {
        tvSetText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOGE);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOGE) {
            TimePickerDialog tpd = new TimePickerDialog(this, myCallBack, myHour, myMinute, false);
            return tpd;
        }
        return super.onCreateDialog(id);
    }

    TimePickerDialog.OnTimeSetListener myCallBack = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            myHour = hourOfDay;
            myMinute = minute;
            tvSetText.setText("Hour: " + myHour + " Minute: " + myMinute);
        }
    };
}
