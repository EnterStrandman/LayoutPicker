package layoutpicker.layoutpicker.layoutpicker;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.layoutpicker.layoutpicker.R;


public class ScoreCardDialog extends AppCompatDialogFragment {
    private EditText input1;
    private EditText input2;
    private EditText input3;
    private EditText input4;
    private EditText input5;

    private ScoreCardDialogListener listener;
    String[] playerNames = new String[5];

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.scorecard_dialog, null);

        builder.setView(view)
                .setTitle("Enter Players")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //add the text from the edits to the array
                        playerNames[0] = input1.getText().toString();
                        playerNames[1] = input2.getText().toString();
                        playerNames[2] = input3.getText().toString();
                        playerNames[3] = input4.getText().toString();
                        playerNames[4] = input5.getText().toString();
                        listener.createNames(playerNames);
                    }
                });

        input1 = view.findViewById(R.id.input1);
        input2 = view.findViewById(R.id.input2);
        input3 = view.findViewById(R.id.input3);
        input4 = view.findViewById(R.id.input4);
        input5 = view.findViewById(R.id.input5);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (ScoreCardDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ScoreCardDialogListener");
        }
    }

    public interface ScoreCardDialogListener {
        void createNames(String[] players);
    }
}
