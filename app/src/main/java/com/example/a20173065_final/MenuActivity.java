package com.example.a20173065_final;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MenuActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MAIN = 201;
    public static final int REQUEST_CODE_PHOTO = 202;
    public static final int REQUEST_CODE_WRITE = 203;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // process received intent
        Intent receivedIntent = getIntent();
        String username = receivedIntent.getStringExtra("username");
        String password = receivedIntent.getStringExtra("password");

        Toast.makeText(this, "username : " + username + ", password : " + password, Toast.LENGTH_LONG).show();

        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("message", "result message is OK!");

                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

        Button menu01Button = (Button) findViewById(R.id.menu01Button);
        menu01Button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("titleMsg", "영화 화면");

                startActivityForResult(intent, REQUEST_CODE_MAIN);
            }
        });

        Button menu02Button = (Button) findViewById(R.id.menu02Button);
        menu02Button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PhotoActivity.class);
                intent.putExtra("titleMsg", "사진 화면");

                startActivityForResult(intent, REQUEST_CODE_PHOTO);
            }
        });

        Button menu03Button = (Button) findViewById(R.id.menu03Button);
        menu03Button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WriteActivity.class);
                intent.putExtra("titleMsg", "글쓰기 화면");

                startActivityForResult(intent, REQUEST_CODE_WRITE);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (intent != null) {
            if (requestCode == REQUEST_CODE_MAIN) {
                String message = intent.getStringExtra("message");

                if (message != null) {
                    Toast toast = Toast.makeText(getBaseContext(), "영화, result code : " + resultCode + ", message : " + message, Toast.LENGTH_LONG);
                    toast.show();
                }
            } else if (requestCode == REQUEST_CODE_PHOTO) {
                String message = intent.getStringExtra("message");

                if (message != null) {
                    Toast toast = Toast.makeText(getBaseContext(), "사진, result code : " + resultCode + ", message : " + message, Toast.LENGTH_LONG);
                    toast.show();
                }
            } else if (requestCode == REQUEST_CODE_WRITE) {
                String message = intent.getStringExtra("message");

                if (message != null) {
                    Toast toast = Toast.makeText(getBaseContext(), "글쓰기, result code : " + resultCode + ", message : " + message, Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        }

    }

}