package layoutpicker.layoutpicker.layoutpicker;

import java.util.Locale;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.content.ActivityNotFoundException;
import android.widget.Toast;

import com.layoutpicker.layoutpicker.R;


public class MainActivity extends AppCompatActivity {
    //forward declare UI elements
    private Button course_information;
    private Button course_picker;
    private Button scorecard;
    private Button upcoming_events;
    private Button course_map;
    private Button contact_dev;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init UI components
        course_information = findViewById(R.id.btn_course_info);
        course_picker = findViewById(R.id.btn_course_picker);
        scorecard = findViewById(R.id.btn_scorecard);
        upcoming_events = findViewById(R.id.btn_upcoming_events);
        course_map = findViewById(R.id.btn_get_directions);
        contact_dev = findViewById(R.id.btn_contact_devs);

    }

    public void courseInformation(View view)
    {
        Intent intent = new Intent(this, CourseInformation.class);
        startActivity(intent);
    }

    public void coursePicker(View view)
    {
        Intent intent = new Intent(this, CoursePicker.class);
        startActivity(intent);
    }

    public void openScorecard(View view)
    {

    }

    public void upcomingEvents(View view)
    {

    }

    public void linkButton(View view)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(view.getTag().toString()));
        startActivity(intent);
    }

    //Open Google Maps and set it to go to Morris Park if the user has google maps
    public void directionsMap(View view)
    {
        String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?daddr=%f,%f (%s)", 39.458783, -80.140759, "Where the party is at");
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        intent.setPackage("com.google.android.apps.maps");
        try
        {
            startActivity(intent);
        }
        catch(ActivityNotFoundException ex)
        {
            try
            {
                Intent unrestrictedIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(unrestrictedIntent);
            }
            catch(ActivityNotFoundException innerEx)
            {
                Toast.makeText(this, "Please install a maps application", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void contactDevs(View view)
    {

    }
}
