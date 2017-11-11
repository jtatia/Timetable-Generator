package application.TimetableClasses;

import java.util.HashSet;

public class TimetableSlots {

    private HashSet<Teacher> teacherSet;

    private HashSet<Batch> batchSet;

    public TimetableSlots() {
        this.teacherSet = new HashSet<Teacher>();
        this.batchSet = new HashSet<Batch>();
    }

    public void insertTeacher(Teacher t){
        teacherSet.add(t);
    }

    public void insertBatch(Batch b){
        batchSet.add(b);
    }

    public boolean isTeacherPresent(Teacher t){
        return teacherSet.contains(t);
    }

    public boolean isBatchPresent(Batch b){
        return batchSet.contains(b);
    }
}
