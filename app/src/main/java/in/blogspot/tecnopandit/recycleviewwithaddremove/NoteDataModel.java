package in.blogspot.tecnopandit.recycleviewwithaddremove;

public class NoteDataModel {
    private  String notetext;
    private int count;

    public NoteDataModel(String notetext,int count) {
        this.notetext = notetext;
        this.count=count;
    }

    public String getNotetext() {
        return notetext;
    }

    public void increment(){
        count++;

    }

    public void decrement(){
        if(count>0){
            count--;
        }
    }

    public int getCount(){
        return count;
    }
}
