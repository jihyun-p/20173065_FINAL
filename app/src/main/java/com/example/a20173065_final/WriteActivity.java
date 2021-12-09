package com.example.a20173065_final;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

public class WriteActivity extends AppCompatActivity {
    EditText jinputMessage;
    TextView jinputCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        jinputMessage = findViewById(R.id.xinputMessage);
        jinputCount = findViewById(R.id.xinputCount);

        Button jsendButton = findViewById(R.id.xsendButton);
        jsendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = jinputMessage.getText().toString();
                Toast.makeText(getApplicationContext(),"전송할 메시지\n\n"+message,Toast.LENGTH_LONG).show();
            }
        });

        Button jcloseButton = findViewById(R.id.xcloseButton);
        jcloseButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });
        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence str, int i, int i1, int i2) {
                byte[] bytes = null;
                try {
                    bytes = str.toString().getBytes("KSC5601");
                    int strCount = bytes.length;
                    jinputCount.setText(strCount +" / 80바이트");

                }catch (UnsupportedEncodingException ex){
                    ex.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable strEditable) {
                String str = strEditable.toString();
                try{
                    byte[] strBytes = str.getBytes("KSC5601");
                    if(strBytes.length > 80){
                        strEditable.delete(strEditable.length()-2, strEditable.length()-1);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        };
        jinputMessage.addTextChangedListener(watcher);

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
}
