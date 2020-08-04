package in.blogspot.tecnopandit.recycleviewwithaddremove;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbarmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.add){
            Intent intent=new Intent(this,AddNote.class);
            startActivity(intent);
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
        myAdapter=new MyAdapter(this,ds.getNotes());
        activityMainBinding.rcv.setAdapter(myAdapter);
        getSupportActionBar().setTitle("Notes");



    }

    @Override
    protected void onResume() {
        super.onResume();
        String data;
        data=getIntent().getStringExtra("textofnote");
        if(data!=null){
            //result.add(new NoteDataModel(getIntent().getStringExtra("textofnote")));
            ds.addNote(new NoteDataModel(getIntent().getStringExtra("textofnote")));
            myAdapter.notifyDataSetChanged();
            getIntent().removeExtra("textofnote");
            for(NoteDataModel d: ds.getNotes()){
                Log.i("Data set item:::::::::", d.getNotetext()+" is the item");
            }
        }


    }
}