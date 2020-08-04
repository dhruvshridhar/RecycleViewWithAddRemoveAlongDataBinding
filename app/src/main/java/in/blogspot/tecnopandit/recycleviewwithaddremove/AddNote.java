package in.blogspot.tecnopandit.recycleviewwithaddremove;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AddNote extends AppCompatActivity {
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        getSupportActionBar().setTitle("Add Note");
        textView=findViewById(R.id.noteedittext);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!textView.getText().toString().isEmpty()){
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    intent.putExtra("textofnote",textView.getText().toString());
                    startActivity(intent);

                }
                else{
                    Toast.makeText(getApplicationContext(),"Cannot be empty",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}