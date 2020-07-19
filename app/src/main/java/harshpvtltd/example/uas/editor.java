package harshpvtltd.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class editor extends AppCompatActivity {

    EditText e1,e2,e3;
    Button b0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
//        e1 = (EditText)findViewById(R.id.saveName);
//        e2 = (EditText)findViewById(R.id.saveReg);
//        e3 = (EditText)findViewById(R.id.saveEmail);
        b0 = (Button) findViewById(R.id.saveBtn);
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String Name = e1.getText().toString();
//                String Reg = e2.getText().toString();
//                String Email = e3.getText().toString();
                Intent intent = new Intent(editor.this,user.class);
//                intent.putExtra("Name",Name);
//                intent.putExtra("Num",Reg);
//                intent.putExtra("Email",Email);
                Toast.makeText(editor.this,"Saved",Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        });
    }
}