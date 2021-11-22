package com.example.hw2_abelmarin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {

    private EditText title;
    private EditText noteBody;
    private final ArrayList<Note> noteList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        title = findViewById(R.id.TextNoteTitle);
        noteBody = findViewById(R.id.TextNoteBody);
        noteBody.setMovementMethod(new ScrollingMovementMethod());



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_action_menu, menu);
        return true;
    }


//    @Override
//    protected void onResume() {
//        noteList.clear();
//        noteList.addAll(loadFile());
//
//        if (noteList.size() != 3) {
//            super.onResume();
//            return;
//        }
//
//        Note n = noteList.get(0);
//        title.setText(n.getTitle() );
//        noteBody.setText(n.getNoteText());
//
//
//        super.onResume();
//    }

    private ArrayList<Note> loadFile() {

        ArrayList<Note> noteArrayList = new ArrayList<>();
        try {
            InputStream is = getApplicationContext().openFileInput(getString(R.string.file_name));
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            JSONArray jsonArray = new JSONArray(sb.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String title = jsonObject.getString("title");
                String body = jsonObject.getString("body");
                Note note = new Note(title, body);
                noteArrayList.add(note);
            }

        } catch (FileNotFoundException e) {
            Toast.makeText(this, getString(R.string.no_file), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return noteArrayList;
    }

    @Override
    protected void onPause() {
        if (!title.getText().toString().isEmpty() && !noteBody.toString().isEmpty()) {
            Note p = new Note(title.getText().toString(), noteBody.getText().toString());
            noteList.add(p);
        }
        saveNote();
        super.onPause();
    }

    private void saveNote() {


        try {
            FileOutputStream fos = getApplicationContext().
                    openFileOutput(getString(R.string.file_name), Context.MODE_PRIVATE);

            PrintWriter printWriter = new PrintWriter(fos);
            printWriter.print(noteList);
            printWriter.close();
            fos.close();


        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        saveNote();
        Intent intent1 = new Intent(EditActivity.this, MainActivity.class);
        startActivity(intent1);
        return true;
    }
}
