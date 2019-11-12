package layoutpicker.layoutpicker.layoutpicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

import com.layoutpicker.layoutpicker.R;

import java.util.*;

public class CoursePicker extends AppCompatActivity {

    //forward declare UI elements
    private CheckBox cb1; private CheckBox cb2; private CheckBox cb3; private CheckBox cb4; private CheckBox cb5;
    private CheckBox cb6; private CheckBox cb7; private CheckBox cb8; private CheckBox cb9; private CheckBox cb10;
    private CheckBox cb11; private CheckBox cb12; private CheckBox cb13; private CheckBox cb14;
    private CheckBox cb15; private CheckBox cb16;

    private TextView courseDisplay;
    private Button button;

    List<String> selectedLayouts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_picker);

        //INITIALIZE UI COMPONENTS
        //SBM CheckBoxes
        cb1 = findViewById(R.id.checkBox);//SS
        cb2 = findViewById(R.id.checkBox2);//SL
        cb3 = findViewById(R.id.checkBox3);//LS
        cb4 = findViewById(R.id.checkBox4);//LL
        cb5 = findViewById(R.id.checkBox5);//Blended A
        cb6 = findViewById(R.id.checkBox6);//Blended B
        cb7 = findViewById(R.id.checkBox7);//Blended C
        cb8 = findViewById(R.id.checkBox8);//Blended D

        //OC Check Boxes
        cb9 = findViewById(R.id.checkBox9);//SS
        cb10 = findViewById(R.id.checkBox10);//SL
        cb11 = findViewById(R.id.checkBox11);//LS
        cb12 = findViewById(R.id.checkBox12);//LL
        cb13 = findViewById(R.id.checkBox13);//Blended A
        cb14 = findViewById(R.id.checkBox14);//Blended B
        cb15 = findViewById(R.id.checkBox15);//Blended C
        cb16 = findViewById(R.id.checkBox16);//Blended D
        courseDisplay = findViewById(R.id.textView);
        button = findViewById(R.id.button);//Pick Layout!
    }

    private void main()
    {
        selectedLayouts.clear();//clear any layouts so they arent doubled and unwanted layouts are removed
        getSelected(selectedLayouts);

        //change the text to match the layout that was generated
        if(selectedLayouts.size() != 0) {
            courseDisplay.setText(selectedLayouts.get(getRand()));
        }
    }

    public void selectButton(View view) { main();}

    private int getRand()
    {
        Random rand = new Random();
        System.out.println("SIZE OF LIST: " + selectedLayouts.size());
        return rand.nextInt(selectedLayouts.size());
    }

    private void getSelected(List<String> selectedLayouts)
    {
        if(cb1.isChecked()) {selectedLayouts.add("SBM Short->Short");}
        if(cb2.isChecked()) {selectedLayouts.add("SBM Short->Long");}
        if(cb3.isChecked()) {selectedLayouts.add("SBM Long->Short");}
        if(cb4.isChecked()) {selectedLayouts.add("SBM Long->Long");}
        if(cb5.isChecked()) {selectedLayouts.add("Blended A-SBM SS->OC SS");}
        if(cb6.isChecked()) {selectedLayouts.add("Blended B-SBM SL->OC SL");}
        if(cb7.isChecked()) {selectedLayouts.add("Blended C-SBM LS->OC LS");}
        if(cb8.isChecked()) {selectedLayouts.add("Blended D-SBM LL->OC LL");}
        if(cb9.isChecked()) {selectedLayouts.add("OC Short->Short");}
        if(cb10.isChecked()) {selectedLayouts.add("OC Short->Long");}
        if(cb11.isChecked()) {selectedLayouts.add("OC Long->Short");}
        if(cb12.isChecked()) {selectedLayouts.add("OC Long->Long");}
        if(cb13.isChecked()) {selectedLayouts.add("Blended A-OC SS->SBM SS");}
        if(cb14.isChecked()) {selectedLayouts.add("Blended B-OC SL->SBM SL");}
        if(cb15.isChecked()) {selectedLayouts.add("Blended C-OC LS->SBM LS");}
        if(cb16.isChecked()) {selectedLayouts.add("Blended D-OC LL->SBM LL");}
        if(selectedLayouts.size() == 0) {
            Toast.makeText(this, "No Layouts Selected", Toast.LENGTH_SHORT).show();
        }
    }
}
