package application.TimetableClasses;

import java.util.ArrayList;
import java.util.HashSet;

public class TimetableSlots {

    private ArrayList<Doublet> doubletList;

    private HashSet<Teacher> teacherSet;

    private HashSet<Batch> batchSet;

    public TimetableSlots() {
        this.doubletList = new ArrayList<Doublet>();
        this.batchSet = new HashSet<Batch>();
        this.teacherSet = new HashSet<Teacher>();
    }

    /*public void insertDoublet(Doublet d){
        doubletSet.add(d);
        teacherSet.add(d.getDTeacher());
    }*/


    public void insertDoublet(Doublet d) {
        doubletList.add(d);
    }

    public void insertBatch(Batch b){
        batchSet.add(b);
    }
    //Overloading
    public void insertBatch(Batch b,int pos){
        batchSet.add(b);
        doubletList.get(pos).insertDoubletBatch(b);
    }

    public void insertTeacher(Teacher t){
        teacherSet.add(t);
    }

    public boolean isDoubletPresent(Doublet d){
        return doubletList.contains(d);
    }

    public boolean isTeacherPresent(Teacher t){
        return teacherSet.contains(t);
    }

    public boolean isBatchPresent(Batch b){
        return batchSet.contains(b);
    }

    public int isTeacherCoursePresent(Teacher t,Course c){
        int itr = 0;
        for(Doublet d:doubletList){
            if(d.getDTeacher().getId().equals(t.getId()) && d.getDCourse().getCourseId().equals(c.getCourseId())){
                return itr;
            }
            itr++;
        }
        return -1;
    }
}
