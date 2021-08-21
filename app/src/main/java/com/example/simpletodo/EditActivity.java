package com.example.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {

    EditText etItem;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etItem = findViewById(R.id.etItem);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit item");
        etItem.setText(getIntent().getStringExtra(MainActivity.Key_Item_Text));
        //when user is done editing, they click the save button
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create an intent which will contain the results of the user modification
                Intent intent = new Intent();
                //pass the data (results of editing)
                intent.putExtra(MainActivity.Key_Item_Text, etItem.getText().toString());
                intent.putExtra(MainActivity.Key_Item_Position, getIntent().getExtras().getInt(MainActivity.Key_Item_Position));
                //set the result of the intent
                setResult(RESULT_OK, intent);
                //finish the activity, close the screen and go back
                finish();
            }
        });
    }
}