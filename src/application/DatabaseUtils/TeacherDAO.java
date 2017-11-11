package application.DatabaseUtils;

import application.TimetableClasses.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {
    private Connection myCon;

    public TeacherDAO(){
        myCon = DatabaseConnection.getConnection();
    }

    public void insertTeacher(String id,String teacherName,String department){
        PreparedStatement pstmt = null;

        try{
            pstmt = myCon.prepareStatement("insert into teacher values (?,?,?)");
            pstmt.setString(1,id);
            pstmt.setString(2,teacherName);
            pstmt.setString(3,department);
            pstmt.executeUpdate();
        }catch(Exception exc){
            exc.printStackTrace();
        }finally{
            if(pstmt!=null){
                try {
                    pstmt.close();
                }catch(Exception exc){
                    exc.printStackTrace();
                }
            }
        }
    }

    public List<Teacher> getAllTeachers(){
        PreparedStatement pstmt = null;
        ArrayList<Teacher> teacherList = null;
        try{
            teacherList = new ArrayList<Teacher>();
            pstmt = myCon.prepareStatement("select * from teacher");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String tid = rs.getString(1);
                String tname = rs.getString(2);
                String dname = rs.getString(3);
                Teacher teacherObj = new Teacher(tid,tname,dname);
                teacherList.add(teacherObj);
            }
            //System.out.println("Fetched :: "+teacherList.size());
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
        return teacherList;
    }

    public Teacher getTeacherById(String tid){
        PreparedStatement pstmt = null;
        Teacher teacherObj = null;
        try{
            pstmt = myCon.prepareStatement("select * from teacher where id = ?");
            pstmt.setString(1,tid);
            ResultSet rstmt = pstmt.executeQuery();
            if(rstmt.next()) {
                String teacherId = rstmt.getString(1);
                String tname = rstmt.getString(2);
                String dname = rstmt.getString(3);
                teacherObj = new Teacher(teacherId, tname, dname);
            }
        }catch(Exception exc){
            exc.printStackTrace();
        }finally{
            if(pstmt != null ){
                try{
                    pstmt.close();
                }catch(Exception exc){
                    exc.printStackTrace();
                }
            }
        }
        return teacherObj;
    }

    public void deleteTeacher(String id){
        PreparedStatement pstmt = null;
        try{
            pstmt = myCon.prepareStatement("delete from teacher where id = ?");
            pstmt.setString(1,id);
            pstmt.executeUpdate();
        }catch(Exception exc){
            exc.printStackTrace();
        }finally{
            if(pstmt!=null){
                try{
                    pstmt.close();
                }catch (Exception exc){
                    exc.printStackTrace();
                }
            }
        }
    }
}
