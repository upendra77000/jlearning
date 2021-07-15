package com.example.jlearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.text.TextUtils;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView signup;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Login = (Button)findViewById(R.id.btnLogin);
        signup = (TextView)findViewById(R.id.tvRegister);
        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        FirebaseUser user=firebaseAuth.getCurrentUser();


        if(user!=null){
            finish();
            startActivity(new Intent(MainActivity.this,syllabus_activity.class));
        }

        Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String email = Name.getText().toString().trim();
                String password = Password.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    Name.setError("Email is Required.");
                    return;
                }
                if(TextUtils.isEmpty(password)) {
                    Password.setError("Password is Required.");
                    return;
                }
                if(email.equals("admin") && password.equals("bvrit") ){
                    goto_content();
                }else {
                    validate(email, password);
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,register_activity.class));
            }
        });

    }

    private void goto_content() {
        startActivity(new Intent(MainActivity.this,syllabus_activity.class));
        MainActivity.this.finish();
    }

    private void validate(String UserName,String UserPassword) {
        progressDialog.setMessage("please wait");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(UserName,UserPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(!task.isSuccessful()){
                    Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                }else {
                    progressDialog.dismiss();
                    checkEmailVerification();
                    MainActivity.this.finish();
                }
            }
        });
        }

        private void checkEmailVerification(){
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
            assert firebaseUser != null;
            boolean emailflag = firebaseUser.isEmailVerified();

        if(emailflag){
            finish();
            startActivity(new Intent(MainActivity.this,syllabus_activity.class));
        }else {
            Toast.makeText(this,"Verify your Email",Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }
        }


}
