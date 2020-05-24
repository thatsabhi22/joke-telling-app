package com.udacity.telljokeslib;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowJokeActivity extends AppCompatActivity {

    TextView joke_text_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_joke);

        joke_text_tv = findViewById(R.id.joke_text);

        Intent intent = getIntent();
        if (intent != null) {
            String jokeText = intent.getStringExtra("theJoke");
            joke_text_tv.setText(jokeText);
        }
    }
}
