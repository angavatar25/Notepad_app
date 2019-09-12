package com.example.notepadviewonly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public EditText et_Title, et_Body;
    public SharedPreferences savedNotes;
    public Button btnClear, btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        components();
        savedNotes = getSharedPreferences("notes",MODE_PRIVATE);
        et_Body.setText(savedNotes.getString("tag", ""));
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearNotes();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_Body.getText().length()>0){
                    makeTag(et_Title.getText().toString());
                    ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(et_Body.getWindowToken(),0);
                }
            }
        });
    }

    public void components() {
        et_Title = (EditText)findViewById(R.id.et_Title);
        et_Body = (EditText)findViewById(R.id.et_Body);
        btnClear = (Button)findViewById(R.id.clearButton);
        btnSave = (Button)findViewById(R.id.saveButton);
    }

    private void makeTag(String tag)
    {
        String or = savedNotes.getString(tag, null);
        SharedPreferences.Editor preferencesEditor = savedNotes.edit();
        preferencesEditor.putString(tag,null);
        preferencesEditor.commit();
    }

    public void clearNotes() {
        et_Title.setText("");
        et_Body.setText("");
    }
}




