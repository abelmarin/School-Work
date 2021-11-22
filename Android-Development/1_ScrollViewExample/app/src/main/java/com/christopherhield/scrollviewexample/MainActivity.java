package com.christopherhield.scrollviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView story = findViewById(R.id.textView2);
        story.setMovementMethod(new ScrollingMovementMethod());
        story.setText(R.string.story_text);

    }
}