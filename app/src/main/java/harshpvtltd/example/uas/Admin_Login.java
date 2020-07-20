package harshpvtltd.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Admin_Login extends AppCompatActivity {
EditText mail,password;
Button login;
TextView error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__login);
        error=findViewById(R.id.error);
        mail=findViewById(R.id.email);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String ravi_mail = "raviyadavrr37@gmail.com";
                final String ravi_psw = "11902465";
                String admin_mail = mail.getText().toString();
                String admin_psw = password.getText().toString();
                if (admin_mail.equals(ravi_mail) && admin_psw.equals(ravi_psw)) {

                    Intent admin_panel = new Intent(Admin_Login.this, Admin_pannel.class);
                    startActivity(admin_panel);
                } else {
                    String error_msg = "Sorry, You can not login in this section";
                    error.setText(error_msg);


                }
            }
});
        }
    }