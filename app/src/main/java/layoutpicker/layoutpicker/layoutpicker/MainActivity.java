package layoutpicker.layoutpicker.layoutpicker;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

import com.layoutpicker.layoutpicker.R;


public class MainActivity extends AppCompatActivity {
    //forward declare UI elements
    private Button course_information;
    private Button course_picker;
    private Button scorecard;
    private Button upcoming_events;

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
}
