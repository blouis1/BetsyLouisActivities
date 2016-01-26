package com.example.betsy.betsylouisactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    public final static String FIRST_MESSAGE = "com.example.betsy.betsylouisactivities.FIRST_MESSAGE";
    public final static String NEW_MESSAGE = "com.example.betsy.betsylouisactivities.NEW_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.textView_message);
        textView.setText(message);

    }

    /** Called when the user clicks the Next button */
    public void nextMessage(View view) {
        Intent intent = new Intent(this, DisplayBothActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message2);
        String message = editText.getText().toString();
        intent.putExtra(NEW_MESSAGE, message);
        TextView textView = (TextView) findViewById(R.id.textView_message);
        message = textView.getText().toString();
        intent.putExtra(FIRST_MESSAGE, message);
        startActivity(intent);
    }
}
