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
            pstmt = myCon.prepareStatement("select teaches.courseId,teaches.teacherId," +
                    "studies.batchId from teaches,studies where teaches.courseId = studies.courseId");
            ResultSet rs = pstmt.executeQuery();
            TeacherDAO teacherDAO = new TeacherDAO();
            CourseDAO courseDAO = new CourseDAO();
            BatchDAO batchDAO = new BatchDAO();
            while(rs.next()){
                String teacherId = rs.getString(1);
                String courseId = rs.getString(2);
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
