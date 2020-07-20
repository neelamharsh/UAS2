package harshpvtltd.example.uas;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.FirebaseDatabase;

public class Admin_pannel extends AppCompatActivity {
EditText msg;
    EditText child;
    Button add;
    Spinner _spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_pannel);
        msg=findViewById(R.id.annoucement);
        add=findViewById(R.id.add);
        _spinner=findViewById(R.id.spinner);
        child=findViewById(R.id.child);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.usertype,R.layout.support_simple_spinner_dropdown_item);
        _spinner.setAdapter(adapter);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_msg=msg.getText().toString();
                String child_name=child.getText().toString();
                final String type_txt=_spinner.getSelectedItem().toString();
                if(txt_msg.isEmpty()||child_name.isEmpty()||type_txt.isEmpty())
                {
                    Toast.makeText(Admin_pannel.this,"add msg in msg box",Toast.LENGTH_SHORT).show();
                }

                else {
                    switch (type_txt) {
                        case "tech":
                            FirebaseDatabase.getInstance().getReference().child("tech_Annocement").child(child_name).setValue(txt_msg);
                            Toast.makeText(Admin_pannel.this, "Annocement added successfully", Toast.LENGTH_SHORT).show();
                            break;
                        case "art":
                            FirebaseDatabase.getInstance().getReference().child("Art_Annocement").child(child_name).setValue(txt_msg);
                            Toast.makeText(Admin_pannel.this, "Annocement added successfully", Toast.LENGTH_SHORT).show();
                            break;
                        case "culture":
                            FirebaseDatabase.getInstance().getReference().child("culture_Annocement").child(child_name).setValue(txt_msg);
                            Toast.makeText(Admin_pannel.this, "Annocement added successfully", Toast.LENGTH_SHORT).show();
                            break;
                        case "dance":
                            FirebaseDatabase.getInstance().getReference().child("dance_Annocement").child(child_name).setValue(txt_msg);
                            Toast.makeText(Admin_pannel.this, "Annocement added successfully", Toast.LENGTH_SHORT).show();
                            break;
                        case "cook":
                            FirebaseDatabase.getInstance().getReference().child("cook_Annocement").child(child_name).setValue(txt_msg);
                            Toast.makeText(Admin_pannel.this, "Annocement added successfully", Toast.LENGTH_SHORT).show();
                            break;
                        case "poet":
                            FirebaseDatabase.getInstance().getReference().child("poet_Annocement").child(child_name).setValue(txt_msg);
                            Toast.makeText(Admin_pannel.this, "Annocement added successfully", Toast.LENGTH_SHORT).show();
                            break;
                        case "singing":
                            FirebaseDatabase.getInstance().getReference().child("singing_Annocement").child(child_name).setValue(txt_msg);
                            Toast.makeText(Admin_pannel.this, "Annocement added successfully", Toast.LENGTH_SHORT).show();
                            break;
                        case "code":
                            FirebaseDatabase.getInstance().getReference().child("code_Annocement").child(child_name).setValue(txt_msg);
                            Toast.makeText(Admin_pannel.this, "Annocement added successfully", Toast.LENGTH_SHORT).show();
                            break;
                        case "sport":
                            FirebaseDatabase.getInstance().getReference().child("sport_Annocement").child(child_name).setValue(txt_msg);
                            Toast.makeText(Admin_pannel.this, "Annocement added successfully", Toast.LENGTH_SHORT).show();
                            break;
                        case "literature":
                            FirebaseDatabase.getInstance().getReference().child("literature_Annocement").child(child_name).setValue(txt_msg);
                            Toast.makeText(Admin_pannel.this, "Annocement added successfully", Toast.LENGTH_SHORT).show();
                            break;




                    }
                }

            }
        });
    }
}