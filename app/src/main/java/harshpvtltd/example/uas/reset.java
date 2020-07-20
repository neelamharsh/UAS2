package harshpvtltd.example.uas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class reset extends AppCompatActivity {

    Button reset;
    EditText new_password,confirm_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        reset=(Button)findViewById(R.id.done);
        new_password=findViewById(R.id.RNPass);
        confirm_password=findViewById(R.id.RRPass);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String New_psw = new_password.getText().toString();
                String cnf_psw = confirm_password.getText().toString();
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    if (New_psw.equals(cnf_psw)) {
                        user.updatePassword(New_psw).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {

                                    Toast.makeText(reset.this, "Your password has been changed", Toast.LENGTH_LONG).show();
                                    Intent info_page = new Intent(reset.this, HomePage.class);
                                    startActivity(info_page);
                                } else {
                                    Toast.makeText(reset.this, "Procees failed", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                } else {
                    Toast.makeText(reset.this, "Empty Credential", Toast.LENGTH_SHORT).show();
                }
            }
        });
        }
    }

