package com.example.myapplication;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // the 2 buttons:
    // defined in the activity_main.xml file
    Button buttonBlue;
    // defined in this file
    Button buttonPink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // display the GUI defined in the activity_main.xml file
        setContentView(R.layout.activity_main);

        // retrieve reference to the View defined in the activity_main.xml
        buttonBlue = (Button) findViewById(R.id.button_blueInvisible);

        // create the second button and add it to the GUI:
        // ----------------------------------------------
        // create the button
        buttonPink = new Button(getApplicationContext());
        // "configure" the button: text, color...
        buttonPink.setText("The Pink Panther's To Do List");
        buttonPink.setTextColor(Color.BLACK);
        buttonPink.setBackgroundColor(Color.parseColor("#FD9BF3")); // light pink
        // set the size and position of the button:
        // width: as large as the screen
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        // position: below the blue button
        layoutParams.addRule(RelativeLayout.BELOW, buttonBlue.getId());
        // add the button to the relative layout defined in activity_main.xml
        RelativeLayout relativeLayout_mainScreen = (RelativeLayout) findViewById(R.id.relativeLayout_mainScreen);
        relativeLayout_mainScreen.addView(buttonPink, layoutParams);

        // attach the current activity as a click listener for both buttons
        buttonBlue.setOnClickListener(this);
        buttonPink.setOnClickListener(this);
    }

    /**
     * called by the onClick method
     * @param v the button which was clicked
     */
    public void toDo(View v) {
        if (v.equals(buttonBlue))
            // buttonBlue was clicked
            // turn the button invisible
            v.setVisibility(View.INVISIBLE);
        if (v.equals(buttonPink))
            // buttonPink was clicked
            // display a pop-up message for a short duration
            Toast.makeText(getApplicationContext(),
                    "to do to do to do...",
                    Toast.LENGTH_SHORT).show();
    }

    /**
     * called when one of the buttons is clicked
     * @param v the View which triggered the notification of the listener:
     *          should refer to buttonBlue or buttonPink
     */
    @Override
    public void onClick(View v) {
        toDo(v);
    }
}
