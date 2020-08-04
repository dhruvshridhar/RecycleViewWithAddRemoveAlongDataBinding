package in.blogspot.tecnopandit.recycleviewwithaddremove;

import java.util.ArrayList;

public class DataStructure {
    static private ArrayList<NoteDataModel> notes=new ArrayList<>();

    public  ArrayList<NoteDataModel> getNotes() {
        return notes;
    }

    public void addNote(NoteDataModel no){
        notes.add(no);
    }
}
