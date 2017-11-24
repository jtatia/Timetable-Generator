package application;

import application.TimetableClasses.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TimetableAlgorithm {
    final int row = 5, column=6;
    public boolean checkTimetable(ArrayList<ArrayList<TimetableSlots>> timetable,Triplet t){
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                int position = timetable.get(i).get(j).isTeacherCoursePresent(t.getTeacher(),t.getCourse());
                if(position != -1){
                    //timetable.get(i).get(j).insertBatch(t.getBatch());
                    timetable.get(i).get(j).insertBatch(t.getBatch(),position);
                    return true;
                }
            }
        }
        return false;
    }

    public List<ArrayList<TimetableSlots>> createTimetable(ArrayList<Triplet> tripletList) {
        int i,j;
        ArrayList<ArrayList<TimetableSlots>> timetable = new ArrayList<ArrayList<TimetableSlots>>();
        ArrayList<ArrayList<Course>> dayList = new ArrayList<ArrayList<Course>>(row);
        for(i=0;i<row;i++){
            timetable.add(new ArrayList<TimetableSlots>());
            dayList.add(new ArrayList<Course>());
        }
        for(i=0;i<row;i++){
            for(j=0;j<column;j++){
                timetable.get(i).add(new TimetableSlots());
            }
        }
        for(Triplet t:tripletList){
            int f = t.getCourse().getFrequencyOfCourse();
            Course cr = t.getCourse();
            //Doublet doublet = new Doublet(t.getTeacher(),t.getCourse());
            while(f!=0){
                boolean found = false;
                //Buggy Same batch may already be present on that day
                if(checkTimetable(timetable,t)){
                    f--;
                    continue;
                }
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
                            Doublet newEntry = new Doublet(t.getTeacher(), t.getCourse(), t.getBatch());
                            ts.insertDoublet(newEntry);
                            ts.insertBatch(t.getBatch());
                            ts.insertTeacher(t.getTeacher());
                            timetable.get(i).set(randomPeriod,ts);
                            dayList.get(i).add(t.getCourse());
                        }
                        randomPeriod = (randomPeriod + j) % column;
                    }
                }
                if(!found){
                    for(i=0;i<row;i++){
                        for(j=0;j<column;j++){
                            TimetableSlots ts =timetable.get(i).get(j);
                            if(!ts.isTeacherPresent(t.getTeacher()) && !ts.isBatchPresent(t.getBatch())){
                                Doublet newEntry = new Doublet(t.getTeacher(), t.getCourse(), t.getBatch());
                                ts.insertDoublet(newEntry);
                                ts.insertBatch(t.getBatch());
                                ts.insertTeacher(t.getTeacher());
                                timetable.get(i).set(j,ts);
                                dayList.get(i).add(t.getCourse());
                            }
                        }
                    }
                }
                f--;
            }
        }
        return timetable;
    }
}
