package layoutpicker.layoutpicker.layoutpicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.layoutpicker.layoutpicker.R;


public class CourseInformation extends AppCompatActivity {
    //forward declare UI elements
    TextView pageHeader;
    Button SBMmap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_information);

        //init UI components
        pageHeader = findViewById(R.id.pageHeader);
        SBMmap = findViewById(R.id.SBMmap);
    }
}
