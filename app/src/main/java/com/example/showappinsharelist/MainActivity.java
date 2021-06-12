package com.example.showappinsharelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);


        getImage();


    }

    private void getImage() {
        Intent getIntent = getIntent();
        String getIntentAction = getIntent.getAction();
        String getIntentType = getIntent.getType();

        if (getIntentAction.equals(Intent.ACTION_SEND)){
            if (getIntentType.startsWith("image/")){
                Uri imageUri = getIntent.getParcelableExtra(Intent.EXTRA_STREAM);
                if (imageUri!=null){
                    imageView.setImageURI(imageUri);
                    Toast.makeText(this, "This image is send.", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}