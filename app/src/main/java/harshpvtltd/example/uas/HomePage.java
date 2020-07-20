package harshpvtltd.example.uas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class HomePage extends AppCompatActivity implements  View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        ImageView i0,i1,i2,i3,i4,i5,i6,i7,i8,i9,i10;
        TextView t0;
        i0=(ImageView)findViewById(R.id.culture);
        i1=(ImageView)findViewById(R.id.dance);
        i2=(ImageView)findViewById(R.id.sing);
        i3=(ImageView)findViewById(R.id.sport);
        i4=(ImageView)findViewById(R.id.art);
        i5=(ImageView)findViewById(R.id.coad);
        i6=(ImageView)findViewById(R.id.cook);
        i7=(ImageView)findViewById(R.id.tech);
        i8=(ImageView)findViewById(R.id.lit);
        i9=(ImageView)findViewById(R.id.poet);
        t0=(TextView)findViewById(R.id.developer);
        i0.setOnClickListener(this);
        i1.setOnClickListener(this);
        i2.setOnClickListener(this);
        i3.setOnClickListener(this);
        i4.setOnClickListener(this);
        i5.setOnClickListener(this);
        i6.setOnClickListener(this);
        i7.setOnClickListener(this);
        i8.setOnClickListener(this);
        i9.setOnClickListener(this);
        t0.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.culture:
                Intent intent0 = new Intent(HomePage.this,culture0.class);
                startActivity(intent0);
                break;
            case R.id.dance:
                Intent intent1 = new Intent(HomePage.this,dance.class);
                startActivity(intent1);
                break;
            case R.id.sing:
                Intent intent2 = new Intent(HomePage.this,sing0.class);
                startActivity(intent2);
                break;
            case R.id.sport:
                Intent intent3 = new Intent(HomePage.this,sports0.class);
                startActivity(intent3);
                break;
            case R.id.art:
                Intent intent4 = new Intent(HomePage.this,art0.class);
                startActivity(intent4);
                break;
            case R.id.lit:
                Intent intent5 = new Intent(HomePage.this,lit0.class);
                startActivity(intent5);
                break;
            case R.id.poet:
                Intent intent6 = new Intent(HomePage.this,poet0.class);
                startActivity(intent6);
                break;
            case R.id.coad:
                Intent intent7 = new Intent(HomePage.this,code0.class);
                startActivity(intent7);
                break;
            case R.id.tech:
                Intent intent8 = new Intent(HomePage.this,tech0.class);
                startActivity(intent8);
                break;
            case R.id.cook:
                Intent intent9 = new Intent(HomePage.this,cook0.class);
                startActivity(intent9);
                break;
            case R.id.developer:
                Intent intent = new Intent(HomePage.this,Devloper.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Toast.makeText(this,""+item,Toast.LENGTH_SHORT).show();
        if(item.getItemId() == R.id.item0)
        {
            startActivity(new Intent(this,user.class));
        }
        if(item.getItemId() == R.id.item1)
            startActivity(new Intent(this,reset.class));
        if(item.getItemId() == R.id.item2){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Logout");
            builder.setMessage("Are you Sure you want to logout");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(HomePage.this,Login.class));
                    finish();
                }
            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.show();
        }
        return super.onOptionsItemSelected(item);
    }

}