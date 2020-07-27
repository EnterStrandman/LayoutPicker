package layoutpicker.layoutpicker.layoutpicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.layoutpicker.layoutpicker.R;

/* METHODS NEEDED:
 * [] Enter Players Names (Up to 5, min 1)
 * [] total strokes
 * [] par compare
 * [] final scores
 * [] enter scores
 *      maybe use scroll area and swipe right to go to back 9,
 *
 *
 *
 */

public class ScoreCard extends AppCompatActivity {
    //init UI components
    private TableRow topRow;

    private TextView column;
    private TextView column1;
    private TextView column2;

    private String[] playerNames;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scorecard);

        openDialog();//get the players names
//        createCard();

    }

    public void openDialog() {
        ScoreCardDialog scoreCardDialog = new ScoreCardDialog();
        scoreCardDialog.show(getSupportFragmentManager(), "scorecard dialog");
    }

    public void createNames(String[] players) {
        //TODO: WRITE CODE HERE TO ADD THE NAMES TO THE PROPER LABELS
        playerNames = stripNull(players, countPlayers(players));
    }

    public void createCard()
    {
        column1 = new TextView(this);
        column2 = new TextView(this);
        topRow = new TableRow(this);

        column1.setText("Hole");
        column2.setText("Par");
        topRow.addView(column1);
        topRow.addView(column2);

        for(int i=0; i < playerNames.length; ++i) {
            column = new TextView(this);
            column.setText(playerNames[i]);
            topRow.addView(column);
        }

        //create the scorecard layout
        TableLayout tl = (TableLayout) findViewById(R.id.tableLayout);
        tl.addView(topRow, new TableLayout.LayoutParams());
    }


    public interface ScoreCardDialogListener
    {
        void createNames(String[] playerNames);
    }

    //remove the null characters from the array of players and return an array with the correct number of players entered
    private String[] stripNull(String[] players, int numPlayers)
    {
        int count = 0;
        String[] noNullPlayers = new String[numPlayers];
        for (int i=0; i < players.length;i++) {
            if(players[i] != null) {
                noNullPlayers[count] = players[i];
                ++count;
            }
        }
        return noNullPlayers;
    }

    //count how many player names were entered
    private int countPlayers(String[] players)
    {
        int counter = 0;
        for(int i=0; i < players.length; ++i){
            if(players[i] != null) {
                ++counter;
            }
        }
        return counter;
    }
}
