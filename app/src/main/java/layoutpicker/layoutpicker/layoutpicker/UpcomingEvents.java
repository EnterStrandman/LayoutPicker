package layoutpicker.layoutpicker.layoutpicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.layoutpicker.layoutpicker.R;


public class UpcomingEvents extends AppCompatActivity {
    //forward declare UI elements
    TextView upcomingEventsHeader;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upcoming_events);

        //init UI components
        upcomingEventsHeader = findViewById(R.id.upcomingEventsHeader);
    }
}
