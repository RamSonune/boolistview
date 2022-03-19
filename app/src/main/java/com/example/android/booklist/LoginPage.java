package com.example.android.booklist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.LocusId;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginPage extends AppCompatActivity {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://booklist-577f5-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        final EditText phoneLog = findViewById(R.id.phoneLog);
        final EditText userLog = findViewById(R.id.UsernameLog);
        final EditText passwordLog = findViewById(R.id.PassLogin);

        final Button LogButton = findViewById(R.id.LoginButton);
        final Button regnowBtn = findViewById(R.id.regNowLog);

        LogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneS = phoneLog.getText().toString();
                String userLogS = userLog.getText().toString();
                String passwordS = passwordLog.getText().toString();

                if (phoneS.isEmpty() || userLogS.isEmpty()|| passwordS.isEmpty()){
                    Toast.makeText(LoginPage.this, "Plz enter your credentials ", Toast.LENGTH_SHORT).show();
                }
                else{
                    //
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            // to check that the mobile number is already present in the database or not
                            if (snapshot.hasChild(phoneS)){

                                // we will get in this condition if the phone number exists in the db
                                // now fetch the password from the db to check that the password given by the user is correct or not
                                String fetchPassword = snapshot.child(phoneS).child("password").getValue(String.class);
                                // fetching the data of the UserName from the db to confim that the username entered by the user is correct .
                                String fetchUserid = snapshot.child(phoneS).child("userName").getValue(String.class);
                                if (fetchPassword.equals(passwordS) && fetchUserid.equals(userLogS)){
                                    Toast.makeText(LoginPage.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                                    Intent nextIntent = new Intent(LoginPage.this,MainActivity.class);
                                    nextIntent.putExtra("userName" , fetchUserid);
                                    startActivity(nextIntent);
                                }
                                else {
                                    Toast.makeText(LoginPage.this, "Wrong Password or UserName", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {
                                Toast.makeText(LoginPage.this, "Wrong Phone Number", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });

        regnowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginPage.this , MainActivity.class));
            }
        });



    }
}

//    // we will get in this condition if the phone number exists in the db
//    // now fetch the password from the db to check that the password given by the user is correct or not
//    String fetchPassword = snapshot.child(phoneS).child("password").getValue(String.class);
//                                if (fetchPassword.equals(passwordS)){
//                                        Toast.makeText(LoginPage.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
//                                        startActivity(new Intent(LoginPage.this,MainActivity.class));
//        }
//        else {
//        Toast.makeText(LoginPage.this, "Wrong Password", Toast.LENGTH_SHORT).show();
//        }
//        // fetching the data of the UserName from the db to confim that the username entered by the user is correct .
//        String fetchUserid = snapshot.child(phoneS).child("userName").getValue(String.class);
//        if (fetchUserid.equals(userLogS)){
//        //
//        }