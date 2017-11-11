package application.TimetableClasses;

import java.util.HashSet;

public class TimetableSlots {

    private HashSet<Doublet> doubletSet;

    private HashSet<Teacher> teacherSet;

    private HashSet<Batch> batchSet;

    public TimetableSlots() {
        this.doubletSet = new HashSet<Doublet>();
        this.batchSet = new HashSet<Batch>();
        this.teacherSet = new HashSet<Teacher>();
    }

    public void insertDoublet(Doublet d){
        doubletSet.add(d);
        teacherSet.add(d.getDTeacher());
    }

    public void insertBatch(Batch b){
        batchSet.add(b);
    }

    public boolean isDoubletPresent(Doublet d){
        return doubletSet.contains(d);
    }

    public boolean isTeacherPresent(Teacher t){
        return teacherSet.contains(t);
    }
    public boolean isBatchPresent(Batch b){
        return batchSet.contains(b);
    }
}
