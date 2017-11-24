package application.TimetableClasses;

import java.util.ArrayList;
import java.util.List;


//Teacher -> teaches -> course -> to ->batchList
public class Doublet {
    private Teacher teacher;
    private Course course;
    private ArrayList<Batch> listOfBatch;

    public Doublet(Teacher teacher, Course course) {
        this.listOfBatch = new ArrayList<Batch>();
        this.teacher = teacher;
        this.course = course;
    }

    public Doublet(Teacher teacher, Course course,Batch b) {
        this.listOfBatch = new ArrayList<Batch>();
        this.listOfBatch.add(b);
        this.teacher = teacher;
        this.course = course;
    }

    public Doublet(Teacher teacher, Course course,ArrayList<Batch> blist) {
        this.listOfBatch = new ArrayList<Batch>();
        for(Batch b:blist){
            this.listOfBatch.add(b);
        }
        this.teacher = teacher;
        this.course = course;
        
    }

    public void insertDoubletBatch(Batch b){
        this.listOfBatch.add(b);
    }

    public List<Batch> getDoubletBatchList(){
        return this.listOfBatch;
    }

    public Teacher getDTeacher() {
        return teacher;
    }

    public Course getDCourse() {
        return course;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
