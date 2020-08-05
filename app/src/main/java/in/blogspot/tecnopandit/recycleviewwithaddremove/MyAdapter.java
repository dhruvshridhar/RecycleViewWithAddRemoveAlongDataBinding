package in.blogspot.tecnopandit.recycleviewwithaddremove;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import in.blogspot.tecnopandit.recycleviewwithaddremove.databinding.RecycleviewrowBinding;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<NoteDataModel> text;

    public MyAdapter(Context context, ArrayList<NoteDataModel> text) {
        this.context = context;
        this.text = text;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecycleviewrowBinding recycleviewrowBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.recycleviewrow,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(recycleviewrowBinding);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        NoteDataModel note=text.get(position);

        holder.recycleviewrowBinding.setNotes(note);
        //holder.recycleviewrowBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return text.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        RecycleviewrowBinding recycleviewrowBinding;

        public MyViewHolder(@NonNull RecycleviewrowBinding itemView) {
            super(itemView.getRoot());
            recycleviewrowBinding =itemView;
            recycleviewrowBinding.executePendingBindings();
            recycleviewrowBinding.remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    remove(getAdapterPosition());
                    Toast.makeText(recycleviewrowBinding.getRoot().getContext(),"Removed Successfully!",Toast.LENGTH_SHORT).show();
                }
            });

            recycleviewrowBinding.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    text.get(getAdapterPosition()).increment();
                    notifyDataSetChanged();

                }
            });

            recycleviewrowBinding.remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    text.get(getAdapterPosition()).decrement();
                    notifyDataSetChanged();
                }
            });

        }
    }
    public void remove(int pos){
        text.remove(pos);
        notifyItemRemoved(pos);
        notifyItemRangeChanged(pos,text.size());
    }
}
