package application;

import application.TimetableClasses.*;

import java.lang.reflect.Array;
import java.util.*;

public class TimetableAlgorithm {
    final int row = 5, column=6;
    public List<ArrayList<TimetableSlots>> createTimetable(ArrayList<Triplet> tripletList) {

        int i,j;
        ArrayList<ArrayList<TimetableSlots>> timetable = new ArrayList<ArrayList<TimetableSlots>>();
        ArrayList<Integer> shuffle = new ArrayList<>(Arrays.asList(0,1,2,3,4));
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
            if (p!=tripletList.size())
            if(p!=tripletList.size() && tripletList.get(p).getCourse().getCourseId().equals(tripletList.get(p-1).getCourse().getCourseId())){
                batches.add(tripletList.get(p).getBatch());
                insert = false;
            }
            if(insert){
                Triplet t = tripletList.get(p-1);
                int f = t.getCourse().getFrequencyOfCourse();
                Course cr = t.getCourse();
                ArrayList<Integer> arr = new ArrayList<>(shuffle);
                Collections.shuffle(arr);
                for(i=0;i<row;i++) {
                    Random rand = new Random();
                 int randDay = arr.get(i);
                 //See random number generation maybe buggy
                    int randomPeriod = rand.nextInt(((column - 1) - 0) + 1);
                    randomPeriod=randomPeriod%6;
                        TimetableSlots ts = timetable.get(randDay).get(randomPeriod);
                        if (!ts.isTeacherPresent(t.getTeacher()) && !ts.isBatchPresent(t.getBatch())) {
                            Doublet newEntry = new Doublet(t.getTeacher(), t.getCourse(), batches);
                            ts.insertDoublet(newEntry);
                            ts.insertBatch(t.getBatch());
                            ts.insertTeacher(t.getTeacher());
                            timetable.get(randDay).set(randomPeriod,ts);
                            dayList.get(randDay).add(t.getCourse());
                            f--;
                        }
                        if(f<=0)
                            break;
                        randomPeriod = (randomPeriod + 1) % column;
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
