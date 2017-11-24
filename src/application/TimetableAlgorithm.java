package application;

import application.TimetableClasses.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TimetableAlgorithm {
    final int row = 5, column=6;
    public List<ArrayList<TimetableSlots>> createTimetable(ArrayList<Triplet> tripletList) {
        int i,j;
        ArrayList<ArrayList<TimetableSlots>> timetable = new ArrayList<ArrayList<TimetableSlots>>();
        ArrayList<ArrayList<Course>> dayList = new ArrayList<ArrayList<Course>>(row);
        ArrayList<Batch> batches = new ArrayList<Batch>();
        for(i=0;i<row;i++){
            timetable.add(new ArrayList<TimetableSlots>());
            dayList.add(new ArrayList<Course>());
        }
        for(i=0;i<row;i++){
            for(j=0;j<column;j++){
                timetable.get(i).add(new TimetableSlots());
            }
        }
        batches.add(tripletList.get(0).getBatch());
        for(int p=1;p<=tripletList.size();p++){
            boolean insert = true;
            if(p!=tripletList.size() && tripletList.get(p).getCourse().getCourseId().equals(tripletList.get(p-1).getCourse().getCourseId())){
                batches.add(tripletList.get(p).getBatch());
                insert = false;
            }
            if(insert){
                Triplet t = tripletList.get(p-1);
                int f = t.getCourse().getFrequencyOfCourse();
                Course cr = t.getCourse();
                for(i=0;i<row;i++) {
                    if (dayList.get(i).contains(cr)) {
                        continue;
                    }
                    Random rand = new Random();
                    //See random number generation maybe buggy
                    int randomPeriod = rand.nextInt(((column - 1) - 0) + 1);
                    for (j = 0; j < column; j++) {
                        TimetableSlots ts = timetable.get(i).get(randomPeriod);
                        if (!ts.isTeacherPresent(t.getTeacher()) && !ts.isBatchPresent(t.getBatch())) {
                            Doublet newEntry = new Doublet(t.getTeacher(), t.getCourse(), batches);
                            ts.insertDoublet(newEntry);
                            ts.insertBatch(t.getBatch());
                            ts.insertTeacher(t.getTeacher());
                            timetable.get(i).set(randomPeriod,ts);
                            dayList.get(i).add(t.getCourse());
                            f--;
                        }
                        if(f==0)
                            break;
                        randomPeriod = (randomPeriod + j) % column;
                    }
                }
                if(f!=0){
                    for(i=0;i<row;i++){
                        for(j=0;j<column;j++){
                            TimetableSlots ts =timetable.get(i).get(j);
                            if(!ts.isTeacherPresent(t.getTeacher()) && !ts.isBatchPresent(t.getBatch())){
                                Doublet newEntry = new Doublet(t.getTeacher(), t.getCourse(), batches);
                                ts.insertDoublet(newEntry);
                                ts.insertBatch(t.getBatch());
                                ts.insertTeacher(t.getTeacher());
                                timetable.get(i).set(j,ts);
                                dayList.get(i).add(t.getCourse());
                                f--;
                            }
                        }
                        if(f==0){
                            break;
                        }
                    }
                }
                batches.clear();
                batches.add(t.getBatch());
            }
        }
        return timetable;
    }
}
