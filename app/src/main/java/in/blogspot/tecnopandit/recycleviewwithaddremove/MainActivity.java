package in.blogspot.tecnopandit.recycleviewwithaddremove;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.prefs.NodeChangeEvent;
import java.util.zip.Inflater;

import in.blogspot.tecnopandit.recycleviewwithaddremove.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    MyAdapter myAdapter;
    DataStructure ds=new DataStructure();
    ArrayList<NoteDataModel> result=new ArrayList<>();



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2) {
            if(resultCode == Activity.RESULT_OK){
                String res=data.getStringExtra("textofnote");
                Log.i("Data recieved:::::::",res);
                result.add(new NoteDataModel(res,0));
                myAdapter.notifyDataSetChanged();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbarmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.add){
            Intent intent=new Intent(this,AddNote.class);
            startActivityForResult(intent,2);
        }
        else if(item.getItemId()==R.id.count){
            int countdata=0;
            for(NoteDataModel temp: result){
                countdata+=temp.getCount();
            }
            Toast.makeText(this,"Total items is: "+countdata,Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.rcv.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.rcv.setHasFixedSize(true);
        myAdapter=new MyAdapter(this,result);
        activityMainBinding.rcv.setAdapter(myAdapter);
        getSupportActionBar().setTitle("Notes");


    }
}