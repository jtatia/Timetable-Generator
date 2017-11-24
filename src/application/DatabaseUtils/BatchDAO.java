package application.DatabaseUtils;

import application.TimetableClasses.Batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
public class BatchDAO {

    public static void insertBatch(Batch batch){
        Connection connection = DatabaseConnection.getConnection();

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO batch VALUES (?,?)");
            preparedStatement.setString(1,batch.getId());
            preparedStatement.setString(2,batch.getDepartment());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<Batch> getAllBatches(){
        Connection connection = DatabaseConnection.getConnection();

        PreparedStatement preparedStatement = null;
        ArrayList<Batch> list = new ArrayList<Batch>();

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM batch");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
                Batch batch = new Batch();
                batch.setId(resultSet.getString(1));
                batch.setDepartment(resultSet.getString(2));
                list.add(batch);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return list;

    }

    public static Batch getBatchByID(String id){

        Connection connection = DatabaseConnection.getConnection();

        PreparedStatement preparedStatement = null;

        Batch batch = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM batch WHERE id = ?");
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
                batch = new Batch();
                batch.setId(resultSet.getString(1));
                batch.setDepartment(resultSet.getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return batch;

    }

    public static List<Batch> getBatchByDepartment(String department){
        Connection connection = DatabaseConnection.getConnection();

        PreparedStatement preparedStatement = null;
        ArrayList<Batch> list = new ArrayList<Batch>();

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM batch WHERE department = ?");
            preparedStatement.setString(1,department);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
                Batch batch = new Batch();
                batch.setId(resultSet.getString(1));
                batch.setDepartment(resultSet.getString(2));
                list.add(batch);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }

    public static void deleteBatch(String id){
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement pstmt = null;
        try{
            pstmt = connection.prepareStatement("DELETE FROM batch where id = ?");
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
