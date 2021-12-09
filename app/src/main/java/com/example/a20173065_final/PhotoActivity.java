package com.example.a20173065_final;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PhotoActivity extends AppCompatActivity {

    ImageView imageView_java;
    ImageView imageView2_java;
    int imageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        imageView_java = findViewById(R.id.imageView);
        imageView2_java = findViewById(R.id.imageView2);

        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("message", "result message is OK!");

                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }

    public void imageChange(View v) {
        changeImage();
    }

    private void changeImage() {
        if (imageIndex == 0) {
            imageView_java.setVisibility(View.VISIBLE);
            imageView2_java.setVisibility(View.INVISIBLE);
            imageIndex = 1;
        } else if (imageIndex == 1) {
            imageView_java.setVisibility(View.INVISIBLE);
            imageView2_java.setVisibility(View.VISIBLE);
            imageIndex = 0;
        }
    }
}