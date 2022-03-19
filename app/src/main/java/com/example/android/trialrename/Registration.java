package com.example.android.trialrename;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class Registration extends AppCompatActivity {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://booklist-577f5-default-rtdb.firebaseio.com/");
//    Registration object = new Registration();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        final EditText fullNameReg = findViewById(R.id.NameReg);
        final EditText userNameReg = findViewById(R.id.userReg);
        final EditText emailReg = findViewById(R.id.emailReg);
        final EditText passwordReg = findViewById(R.id.passReg);
        final EditText passwordConReg = findViewById(R.id.passConReg);
        final EditText phoneReg = findViewById(R.id.phoneReg);

        String [] nameCheck = {"0","1","2","3","4","5","6","7","8","9"};
        String beingChecked ;


        final Button Register = findViewById(R.id.RegisterButton);
        final Button LogInReg = findViewById(R.id.LoginReg);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // fetching the data from the edit text so that we can do the string methods on it and see that the data enter by the user is accurate or not .
                String fullNameS = fullNameReg.getText().toString();
                String userNameS = userNameReg.getText().toString();
                String emailS = emailReg.getText().toString();
                String passwordS = passwordReg.getText().toString();
                String passwordConS = passwordConReg.getText().toString();
                String phoneS = phoneReg.getText().toString();


                int i =0 ;

                if (fullNameS.isEmpty() || userNameS.isEmpty() || emailS.isEmpty() || passwordS.isEmpty() || passwordConS.isEmpty()){
                    Toast.makeText(Registration.this, "Please enter your credentials", Toast.LENGTH_SHORT).show();
                }
                else if (phoneS.length() < 10){
                    Toast.makeText(Registration.this, "Give accurate phone number", Toast.LENGTH_SHORT).show();
                }
                // this will be used to determine that the phone number is not greater then 10
                else if (phoneS.length()>10){
                    Toast.makeText(Registration.this, "Please Give accurate phone number", Toast.LENGTH_SHORT).show();
                }
                else if (!passwordS.equals(passwordConS)){
                    Toast.makeText(Registration.this, "Passwords are not matching", Toast.LENGTH_SHORT).show();
                }
                else if (!emailS.contains("@")){
                    Toast.makeText(Registration.this, "Add proper email id", Toast.LENGTH_SHORT).show();
                }
                // the following emails are only allowed
                // the below one is giving the problem
//                else if (!emailS.contains("gmail.com") || !emailS.contains("email.com") || !emailS.contains("rediffmail.com") || !emailS.contains("yahoo.com") || !emailS.contains("outlook.com")
//                        || !emailS.contains("zohomail.com") ){
//                    Toast.makeText(Registration.this, "Add genuine email id", Toast.LENGTH_SHORT).show();
//                }
                else if (!emailS.endsWith("com")){
                    Toast.makeText(Registration.this, ".com kon dalega mei !!", Toast.LENGTH_SHORT).show();
                }
                else if (fullNameS.startsWith("1") || fullNameS.startsWith("2") || fullNameS.startsWith("3") || fullNameS.startsWith("4") || fullNameS.startsWith("5")
                    || fullNameS.startsWith("6") || fullNameS.startsWith("7")|| fullNameS.startsWith("8") || fullNameS.startsWith("9") ||fullNameS.startsWith("0")) {
                    Toast.makeText(Registration.this, "dont add number in your name", Toast.LENGTH_SHORT).show();
                }
                else if (fullNameS.endsWith("1") || fullNameS.endsWith("2") || fullNameS.endsWith("3") || fullNameS.endsWith("4") || fullNameS.endsWith("5")
                        || fullNameS.endsWith("6") || fullNameS.endsWith("7")|| fullNameS.endsWith("8") || fullNameS.endsWith("9") ||fullNameS.endsWith("0")) {
                    Toast.makeText(Registration.this, "dont add number in your name", Toast.LENGTH_SHORT).show();
                }
                else if (fullNameS.contains("1") || fullNameS.contains("2") || fullNameS.contains("3") || fullNameS.contains("4") || fullNameS.contains("5") || fullNameS.contains("6")
                        || fullNameS.contains("7") || fullNameS.contains("8") || fullNameS.contains("9") || fullNameS.contains("0")){
                    Toast.makeText(Registration.this, "Please only add your name and not number", Toast.LENGTH_SHORT).show();
                }
//                else if (fullNameS.endsWith("1") ||fullNameS.endsWith("2") )



//                else if (fullNameS.startsWith(nameCheck[i++])){
//                    Toast.makeText(Registration.this, "Please give accurate name", Toast.LENGTH_SHORT).show();
//                    for(int j = 0 ; j<nameCheck.length;j++){
//                        fullNameS.startsWith(nameCheck[i]);
//                    }
//                }

//                else if (true ==true){
//                    for (int k = 0 ; k<nameCheck.length ; k++){
//                        if (fullNameS.startsWith(nameCheck[k])){
//                            Toast.makeText(Registration.this, "does your name starts with a number", Toast.LENGTH_SHORT).show();
//                        }
//                        else {
////                            Toast.makeText(Registration.this, "Name is accurate", Toast.LENGTH_SHORT).show();
//                            return;
//                        }
//
//                    }
//                }


//                else if (fullNameS.st)

                else {

                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            // to check if the db has the already registered email id.
                            if (snapshot.hasChild(phoneS)){
                                Toast.makeText(Registration.this, "Account is already registered", Toast.LENGTH_SHORT).show();
                            }
                            else {

                                // sending the current information of the user provided details to the firebase
                                databaseReference.child("users").child(phoneS).child("fullname").setValue(fullNameS);
                                databaseReference.child("users").child(phoneS).child("userName").setValue(userNameS);
                                databaseReference.child("users").child(phoneS).child("email").setValue(emailS);
                                databaseReference.child("users").child(phoneS).child("password").setValue(passwordS);

                                Toast.makeText(Registration.this, "User registered Successfully", Toast.LENGTH_SHORT).show();
                                finish();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }



            }
        });

        LogInReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this, LoginPage.class));
            }
        });

        // this is the method for the verification of the starts with method :
//        private static void name (beingChecked){
//            for (int i=0 ; i<10 ; i++){
//                beingChecked.startsWith(nameCheck[i]);
//            }
//        }

    }

}