package com.example.jlearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class register_activity extends AppCompatActivity {

    private EditText userName, userPassword, userEmail;
    private Button regButton;
    private TextView userLogin;
    private TextView userBranch;
    private TextView userRollNo;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore fstore;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setUIview();
        firebaseAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    final  String user_email = userEmail.getText().toString().trim();
                    final  String user_password = userPassword.getText().toString().trim();
                    final  String name = userName.getText().toString();
                    final  String branch=userBranch.getText().toString();
                    final  String rollno=userRollNo.getText().toString();
                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                sendEmailVerification();
                                FirebaseUser firebaseUser1 = firebaseAuth.getCurrentUser();
                                if(firebaseUser1!=null) {
                                    userID = firebaseUser1.getUid();
                                }
                                DocumentReference documentReference = fstore.collection("users").document(userID);
                                Map<String,Object> user = new HashMap<>();
                                user.put("Name",name);
                                user.put("Email",user_email);
                                user.put("Branch",branch);
                                user.put("Roll No",rollno);
                                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d("TAG", "onSuccess: User Profile Is Created For "+userID);
                                    }
                                });
                            } else {
                                Toast.makeText(register_activity.this, "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(register_activity.this, MainActivity.class));
            }
        });
    }

    private boolean validate() {
        Boolean result = false;

        String name = userName.getText().toString();
        String password = userPassword.getText().toString();
        String email = userEmail.getText().toString();
        String branch=userBranch.getText().toString();
        String rollno=userRollNo.getText().toString();

        if (name.isEmpty() || password.isEmpty() || email.isEmpty() || branch.isEmpty() || rollno.isEmpty()) {
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        }
        return result;
    }

    private void setUIview() {
        userName = (EditText) findViewById(R.id.etUserName);
        userPassword = (EditText) findViewById(R.id.etUserPassword);
        userEmail = (EditText) findViewById(R.id.etUserMail);
        regButton = (Button) findViewById(R.id.btnRegister);
        userLogin = (TextView) findViewById(R.id.tvUserLogin);
        userBranch=(TextView) findViewById(R.id.etBranch);
        userRollNo=(TextView)findViewById(R.id.etUserRollNo);
    }

    private void sendEmailVerification(){
        final FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser!=null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(register_activity.this,"Successfully Registered,Verification mail has sent",Toast.LENGTH_SHORT).show();
                        firebaseAuth.signOut();
                        finish();
                        startActivity(new Intent(register_activity.this,MainActivity.class));
                    }else {
                        Toast.makeText(register_activity.this,"Verification mail hasn't sent",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
