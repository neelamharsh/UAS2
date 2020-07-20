package harshpvtltd.example.uas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class user extends AppCompatActivity {

    ImageView edit_image;
    TextView show_name,show_num,show_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        edit_image = (ImageView)findViewById(R.id.edit);
      show_name =(TextView)findViewById(R.id.showName);
show_num=(TextView)findViewById(R.id.showNum);
       show_email=(TextView)findViewById(R.id.showEmail);
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("User Information"+user.getEmail());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
show_name.setText(dataSnapshot.child("Name").toString());
                show_email.setText(dataSnapshot.child("Email").toString());
show_num.setText(dataSnapshot.child("Registration No.").toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//        String Name = getIntent().getStringExtra("Name");
//        String Reg = getIntent().getStringExtra("Num");
//        String Email = getIntent().getStringExtra("Email");
//        t1.setText(Name);
//        t2.setText(Reg);
//        t3.setText(Email);

        edit_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(user.this,editor.class));
                finish();
            }
        });
    }
}