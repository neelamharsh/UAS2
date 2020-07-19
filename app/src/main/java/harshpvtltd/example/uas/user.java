package harshpvtltd.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class user extends AppCompatActivity {

    ImageView i;
    TextView t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        i = (ImageView)findViewById(R.id.edit);
//        t1=(TextView)findViewById(R.id.showName);
//        t2=(TextView)findViewById(R.id.showNum);
//        t3=(TextView)findViewById(R.id.showEmail);
//        String Name = getIntent().getStringExtra("Name");
//        String Reg = getIntent().getStringExtra("Num");
//        String Email = getIntent().getStringExtra("Email");
//        t1.setText(Name);
//        t2.setText(Reg);
//        t3.setText(Email);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(user.this,editor.class));
                finish();
            }
        });
    }
}