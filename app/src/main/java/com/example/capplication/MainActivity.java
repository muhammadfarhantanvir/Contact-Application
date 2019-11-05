package com.example.capplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    ImageView ivFace, ivCall, ivLocation, ivWebsite;
    Button btnSubmit;

    final int createContact = 3;

    String name="", phone="", address="", website="", face="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ivFace = findViewById(R.id.ivFace);
        ivCall = findViewById(R.id.ivCall);
        ivLocation = findViewById(R.id.ivLocation);
        ivWebsite = findViewById(R.id.ivWebsite);
        btnSubmit = findViewById(R.id.btnSubmit);

        ivFace.setVisibility(View.GONE);
        ivCall.setVisibility(View.GONE);
        ivWebsite.setVisibility(View.GONE);
        ivLocation.setVisibility(View.GONE);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        com.example.capplication.CreateContact.class);
                startActivityForResult(intent, createContact);
            }
        });

        ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == createContact)
        {
            if(resultCode == RESULT_OK)
            {
                ivFace.setVisibility(View.VISIBLE);
                ivCall.setVisibility(View.VISIBLE);
                ivLocation.setVisibility(View.VISIBLE);
                ivWebsite.setVisibility(View.VISIBLE);

                name = data.getStringExtra("name");
                phone = data.getStringExtra("phone");
                address = data.getStringExtra("address");
                website = data.getStringExtra("website");
                face = data.getStringExtra("face");


                if(face.equals("Smile"))
                {
                    ivFace.setImageResource(R.drawable.smile);
                }
                else if(face.equals("Sad"))
                {
                    ivFace.setImageResource(R.drawable.sad);
                }
                else if(face.equals("Neutral"))
                {
                    ivFace.setImageResource(R.drawable.neutral);
                }

            }
            else
            {
                Toast.makeText(this,"No Data Received", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
