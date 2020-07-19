package harshpvtltd.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {

    EditText e1,e2,e3,e4;
    Button b0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        e1 = (EditText)findViewById(R.id.RegName);
        e2 = (EditText)findViewById(R.id.RegNum);
        e3 = (EditText)findViewById(R.id.RegEmail);
        e4 = (EditText)findViewById(R.id.RegPass);
        b0 = (Button) findViewById(R.id.RegBtn);
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(register.this,"Saved",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(register.this,HomePage.class));
                finish();
            }
        });
    }
}