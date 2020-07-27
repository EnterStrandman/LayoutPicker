package layoutpicker.layoutpicker.layoutpicker;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.layoutpicker.layoutpicker.R;

public class UpcomingEvents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upcoming_events);
    }

    //pass a url in from the button on the xml layout
    public void linkButton(View view)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(view.getTag().toString()));
        startActivity(intent);
    }

    //there may be a better way to do this, seems to work for now
    public void setCalendarReminder(View view)
    {
        //String comes in like "title~begin time(ms)~duration(ms)~repeat rule"
        String parameters = Uri.parse(view.getTag().toString()).toString();
        String[] components;
        String delimiter = "~";

        components = parameters.split(delimiter);

        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra("title",  components[0]);
        intent.putExtra("allDay", false); //this won't change
        intent.putExtra("beginTime", Long.parseLong(components[1]));
        intent.putExtra("endTime", Long.parseLong(components[1]) + Long.parseLong(components[2]));
        intent.putExtra("rrule", components[3]); //repeat rule will change
        startActivity(intent);
    }

}
