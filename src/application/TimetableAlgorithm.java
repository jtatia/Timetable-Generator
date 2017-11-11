package application;

import application.TimetableClasses.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TimetableAlgorithm {
    final int row = 5, column=6;
    public boolean isCourseTeacherPresent(ArrayList<ArrayList<TimetableSlots>> timetable,Doublet d,Batch b){
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(timetable.get(i).get(j).isDoubletPresent(d)){
                    timetable.get(i).get(j).insertBatch(b);
                    return true;
                }
            }
        }
        return false;
    }

    public List<ArrayList<TimetableSlots>> createTimetable(ArrayList<Triplet> tripletList) {
        int i,j;
        ArrayList<ArrayList<TimetableSlots>> timetable = new ArrayList<ArrayList<TimetableSlots>>();
        ArrayList<ArrayList<Doublet>> dayList = new ArrayList<ArrayList<Doublet>>(row);
        for(i=0;i<row;i++){
            timetable.add(new ArrayList<TimetableSlots>());
            dayList.add(new ArrayList<Doublet>());
        }
        for(i=0;i<row;i++){
            for(j=0;j<column;j++){
                timetable.get(i).add(new TimetableSlots());
            }
        }
        for(Triplet t:tripletList){
            int f = t.getCourse().getFrequencyOfCourse();
            Doublet doublet = new Doublet(t.getTeacher(),t.getCourse());
            while(f!=0){
                boolean found = false;
                if(isCourseTeacherPresent(timetable,doublet,t.getBatch())){
                    f--;
                    continue;
                }
                for(i=0;i<row;i++){
                    if(dayList.get(i).contains(doublet)){
                        continue;
                    }
                    Random rand = new Random();
                    //See random number generation maybe buggy
                    int randomPeriod = rand.nextInt(((row-1)-0)+1);
                    for(j=0;j<column;j++){
                        TimetableSlots ts =timetable.get(i).get(randomPeriod);
                        if(!ts.isTeacherPresent(doublet.getDTeacher()) && !ts.isBatchPresent(t.getBatch())){
                            found = true;
                            ts.insertDoublet(doublet);
                            ts.insertBatch(t.getBatch());
                            timetable.get(i).set(randomPeriod,ts);
                            dayList.get(i).add(doublet);
                            break;
                        }
                        randomPeriod = (randomPeriod+j)%column;
                    }
                }
                if(!found){
                    for(i=0;i<row;i++){
                        for(j=0;j<column;j++){
                            TimetableSlots ts =timetable.get(i).get(j);
                            if(!ts.isTeacherPresent(doublet.getDTeacher()) && !ts.isBatchPresent(t.getBatch())){
                                found = true;
                                ts.insertDoublet(doublet);
                                ts.insertBatch(t.getBatch());
                                timetable.get(i).set(j,ts);
                                dayList.get(i).add(doublet);
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
