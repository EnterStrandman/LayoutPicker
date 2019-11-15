package layoutpicker.layoutpicker.layoutpicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.layoutpicker.layoutpicker.R;


public class CourseInformation extends AppCompatActivity {
    //forward declare UI elements
    Button sethBurtonMemorialLogo;
    TextView locationText;
    TextView SBMdescription;
    TextView OCdescription;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_information);

        //init UI components
        sethBurtonMemorialLogo = findViewById(R.id.SBMlogo);
        locationText = findViewById(R.id.locationText);
        SBMdescription = findViewById(R.id.SBMdescription);
        OCdescription = findViewById(R.id.OCdescription);
    }
}
