package application.DatabaseUtils;

import application.TimetableClasses.Batch;
import application.TimetableClasses.Teacher;
import application.TimetableClasses.Triplet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TripletDAO {

    private Connection myCon;

    public TripletDAO(){
        myCon = DatabaseConnection.getConnection();
    }

    public ArrayList<Triplet> getAllTriplets(){
        PreparedStatement pstmt = null;
        ArrayList<Triplet> tripletArrayList = null;
        try{
            tripletArrayList = new ArrayList<Triplet>();
            pstmt = myCon.prepareStatement("select course_teacher.courseId,course_teacher.teacherId, course_batch.batchId from\n" +
                    " course_teacher,course_batch where course_teacher.courseId = course_batch.courseId\n" +
                    "group by course_teacher.courseId,course_teacher.teacherId,course_batch.batchId order by count(course_teacher.courseId),course_teacher.courseId");
            ResultSet rs = pstmt.executeQuery();
            TeacherDAO teacherDAO = new TeacherDAO();
            CourseDAO courseDAO = new CourseDAO();
            BatchDAO batchDAO = new BatchDAO();
            while(rs.next()){
                String teacherId = rs.getString(2);
                String courseId = rs.getString(1);
                String batchId = rs.getString(3);
                Triplet triplet = new Triplet(teacherDAO.getTeacherById(teacherId),
                        CourseDAO.getCourseByCourseId(courseId),BatchDAO.getBatchByID(batchId));
                tripletArrayList.add(triplet);
            }
        }catch(Exception exc){
            exc.printStackTrace();
        }finally {
            if(pstmt!=null){
                try {
                    pstmt.close();
                }catch(Exception exc){
                    exc.printStackTrace();
                }
            }
        }
        return tripletArrayList;
    }
}
