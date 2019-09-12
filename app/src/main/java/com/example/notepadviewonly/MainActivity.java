package com.example.notepadviewonly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public EditText et_Title, et_Body;
    public Button btnClear, btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_Title = (EditText)findViewById(R.id.et_Title);
        et_Body = (EditText)findViewById(R.id.et_Body);
        btnClear = (Button)findViewById(R.id.clearButton);
        btnSave = (Button)findViewById(R.id.saveButton);
    }

    public void clearNotes(View v) {
        et_Title.setText("");
        et_Body.setText("");
    }

    @Override
    protected void saveNotes(View v) {

    }
}
