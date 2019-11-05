package com.example.capplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CreateContact extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etPhone, etAddress, etWebsite;

    ImageView ivSmile, ivSad, ivNeutral;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etAddress = findViewById(R.id.etAddress);
        etWebsite = findViewById(R.id.etWebsite);
        ivSmile = findViewById(R.id.ivSmile);
        ivSad = findViewById(R.id.ivSad);
        ivNeutral = findViewById(R.id.ivNeutral);

        ivSmile.setOnClickListener(this);
        ivSad.setOnClickListener(this);
        ivNeutral.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(etName.getText().toString().isEmpty() || etPhone.getText().toString().isEmpty()
            || etWebsite.getText().toString().isEmpty() || etAddress.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Insert All The Fields", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent inten = new Intent();
            inten.putExtra("name", etName.getText().toString().trim());
            inten.putExtra("phone", etPhone.getText().toString().trim());
            inten.putExtra("address", etAddress.getText().toString().trim());
            inten.putExtra("website", etWebsite.getText().toString().trim());
            if(v.getId() == R.id.ivSad)
            {
                inten.putExtra("face", "Sad");
            }
            else if(v.getId()==R.id.ivSmile)
            {
                inten.putExtra("face", "Smile");
            }
            else
            {
                inten.putExtra("face", "Neutral");
            }

            setResult(RESULT_OK, inten);
            CreateContact.this.finish();

        }
    }
}
