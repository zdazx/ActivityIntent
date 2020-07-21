package com.thoughtworks.activityintent;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SelectContactActivity extends AppCompatActivity {
    private TextView contactTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_contact);
        contactTextView = findViewById(R.id.contact_info);
        Button select = findViewById(R.id.select_contact);
        Button lifeCircle = findViewById(R.id.viewLifeCircle);
        lifeCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLifeCircleActivity();
            }
        });
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                SelectContactActivity.this.startActivityForResult(intent, 1);
            }
        });
    }

    private void openLifeCircleActivity() {
        Intent intent = new Intent(this, LifeCircleActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Uri contractData = data.getData();
            String info = getContractInfo(contractData);
            contactTextView.setText(info);
        }
    }

    private String getContractInfo(Uri data) {
        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(data, null, null, null, null);
        if (cursor == null) {
            return "";
        }
        if (!cursor.moveToFirst()) {
            cursor.close();
            return "";
        }
        int nameIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
        String name = cursor.getString(nameIndex);
        int phoneIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
        String phoneNum = cursor.getString(phoneIndex);
        cursor.close();
        return name + phoneNum;
    }
}
