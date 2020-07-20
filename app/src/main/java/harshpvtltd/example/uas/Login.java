package harshpvtltd.example.uas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    EditText email, password;
    TextView error;
    Button admin;
    Button login;
    TextView register;
    private FirebaseAuth mAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        admin = findViewById(R.id.admin);
        error = findViewById(R.id.error);
        email = findViewById(R.id.usrn);
        password = findViewById(R.id.pswd);
        register = (TextView) findViewById(R.id.reg);
        login = (Button) findViewById(R.id.btnln);
        mAuth = FirebaseAuth.getInstance();

                                                        //code  for go to admin page
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(Login.this, Admin_Login.class);
                startActivity(j);
                finish();
            }
        });
                                                          //code for login button
login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String txt_email=email.getText().toString();
        String txt_psw=password.getText().toString();
        if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_psw))
            Toast.makeText(Login.this, "Empty credential", Toast.LENGTH_SHORT).show();
        else {
            loginUser(txt_email, txt_psw);

        }

    }
});
                                                           // code for to go register page
register.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent register_page=new Intent(Login.this, harshpvtltd.example.uas.register.class);
        startActivity(register_page);
    }
});
    }                                      //code for function loginuser


    public void loginUser(String email, String pass) {

        mAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                                Intent Home_page = new Intent(Login.this, HomePage.class);
                                startActivity(Home_page);
                            }

                        else {
                            if(task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                error.setText("Invalid Password");
                                Toast.makeText(Login.this,"Invalid password",Toast.LENGTH_SHORT).show();
                            }
                            else if(task.getException() instanceof FirebaseAuthInvalidUserException) {
                                error.setText("Invalid Email");
                                Toast.makeText(Login.this,"Invalid mail",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });

    }
}



