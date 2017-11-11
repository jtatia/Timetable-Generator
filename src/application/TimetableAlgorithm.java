package application;

import application.TimetableClasses.Course;
import application.TimetableClasses.TimetableSlots;
import application.TimetableClasses.Triplet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TimetableAlgorithm {
    public List<ArrayList<TimetableSlots>> createTimetable(ArrayList<Triplet> tripletList) {
        int i,j;
        final int row = 5, column=6;
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
            while(f!=0){
                boolean found = false;
                for(i=0;i<row;i++){
                    if(dayList.get(i).contains(t.getCourse())){
                        continue;
                    }
                    Random rand = new Random();
                    //See random number generation maybe buggy
                    int randomPeriod = rand.nextInt(((row-1)-0)+1);
                    for(j=0;j<column;j++){
                        TimetableSlots ts =timetable.get(i).get(randomPeriod);
                        if(!ts.isTeacherPresent(t.getTeacher()) && !ts.isBatchPresent(t.getBatch())){
                            found = true;
                            ts.insertTeacher(t.getTeacher());
                            ts.insertBatch(t.getBatch());
                            timetable.get(i).set(randomPeriod,ts);
                            dayList.get(i).add(t.getCourse());
                            break;
                        }
                        randomPeriod = (randomPeriod+j)%column;
                    }
                }
                if(!found){
                    for(i=0;i<row;i++){
                        for(j=0;j<column;j++){
                            TimetableSlots ts =timetable.get(i).get(j);
                            if(!ts.isTeacherPresent(t.getTeacher()) && !ts.isBatchPresent(t.getBatch())){
                                found = true;
                                ts.insertTeacher(t.getTeacher());
                                ts.insertBatch(t.getBatch());
                                timetable.get(i).set(j,ts);
                                dayList.get(i).add(t.getCourse());
                                break;
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
