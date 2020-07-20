package harshpvtltd.example.uas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {

    EditText regname,registration_no,email,password;
    Button register;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        regname = (EditText)findViewById(R.id.RegName);
        registration_no = (EditText)findViewById(R.id.RegNum);
        email = (EditText)findViewById(R.id.RegEmail);
        password = (EditText)findViewById(R.id.RegPass);
        register = (Button) findViewById(R.id.RegBtn);
        mAuth=FirebaseAuth.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email=email.getText().toString();
                String name=regname.getText().toString();
                String reg_no=registration_no.getText().toString();
                String txt_pass = password.getText().toString();
                if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_pass))
                    Toast.makeText(register.this, "Empty credential", Toast.LENGTH_SHORT).show();
                else {
                    registerUser(txt_email, txt_pass,name,reg_no);

                }
            }
        });
    }
    public void registerUser(final String email, String pass,final String name,final String reg_no) {

        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseDatabase.getInstance().getReference().child("User Information"+email).child("Name").setValue(name);
                    FirebaseDatabase.getInstance().getReference().child("User Inforfamion"+email).child("Email").setValue(email);
                    FirebaseDatabase.getInstance().getReference().child("User Inforfamion"+email).child("Registration No.").setValue(reg_no);
                        Intent Home_page = new Intent(register.this, HomePage.class);
                        startActivity(Home_page);
                    }

            }
        }).addOnFailureListener(new OnFailureListener() {

            @Override
            public void onFailure(@NonNull Exception e) {
                if (e instanceof FirebaseAuthUserCollisionException) {
                    // this is for showing error if email is already exist
                    Toast.makeText(register.this, "Email already in use", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}