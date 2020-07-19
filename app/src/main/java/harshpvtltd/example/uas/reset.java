package harshpvtltd.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class reset extends AppCompatActivity {

    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        b=(Button)findViewById(R.id.RBtn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(reset.this,HomePage.class);
                Toast.makeText(reset.this,"Done",Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        });
    }
}