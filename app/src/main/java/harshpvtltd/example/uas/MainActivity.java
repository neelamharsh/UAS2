package harshpvtltd.example.uas;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
   // private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
     //   mAuth = FirebaseAuth.getInstance();
        final Thread thread = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(4000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent( MainActivity.this, Login.class);
                    startActivity(intent);
                    finish();
                }
            }
        };thread.start();
    }


}