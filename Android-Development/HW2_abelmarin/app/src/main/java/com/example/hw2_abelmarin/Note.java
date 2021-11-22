package com.example.hw2_abelmarin;

import android.util.JsonReader;
import android.util.JsonWriter;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;

public class Note implements Serializable {

    private String title;
    private String noteText;
    private String lastSaveDate;

    Note(String title, String noteText) {
        this.title = title;
        this.noteText = noteText;


    }

    public String getTitle() { return title; }

    public String getNoteText() { return noteText; }

    @NonNull
    public String toString() {
        try {
            StringWriter sw = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(sw);
            jsonWriter.setIndent("  ");
            jsonWriter.beginObject();
            jsonWriter.name("title").value(getTitle());
            jsonWriter.name("body").value(getNoteText());
            jsonWriter.endObject();
            jsonWriter.close();
            return sw.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
