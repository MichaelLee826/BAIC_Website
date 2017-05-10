package com.michael.dao;

import com.michael.bean.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael Lee on 2016-12-28.
 */
public class VehicleDaoImplementation extends BaseDao implements VehicleDao {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String[] tableNames = {"station_one", "station_two", "station_three", "station_four"};

    public int[] getTableNum(){
        int num[] = {0, 0, 0, 0};

        for (int i = 0; i < 4; i++){
            String sql = "SELECT * FROM " + tableNames[i];
            try {
                con = this.getConnection();
                pstmt = con.prepareStatement(sql);
                rs = pstmt.executeQuery();
                if (rs.last()) {
                    num[i] = rs.getRow();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }finally{
                this.closeAll(con, pstmt, rs);
            }
        }
        return num;
    }


    //查询所有的用户信息，并以id正序排序
    public List<Vehicle> getAllVehicle(int table_num){
        List<Vehicle> list=new ArrayList<Vehicle>();
        String sql = "SELECT * FROM " + tableNames[table_num - 1] + " order by id";

        try {
            con = this.getConnection();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            Vehicle v = null;

            while(rs.next()){
                v = new Vehicle();
                v.setId(rs.getInt("id"));
                v.setDate(rs.getString("date"));
                v.setTime(rs.getString("time"));
                v.setVIN(rs.getString("VIN"));
                v.setStatus(rs.getString("status"));
                list.add(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.closeAll(con, pstmt, rs);
        }
        return list;
    }

    //查询得到List的公有方法
    /*public List<Vehicle> getList(ResultSet rs) {
        List<Vehicle> list = new ArrayList<Vehicle>();
        try {
            Vehicle v = null;
            while(rs.next()){
                v = new Vehicle();
                v.setId(rs.getInt("id"));
                v.setDate(rs.getString("date"));
                v.setTime(rs.getString("time"));
                v.setVIN(rs.getString("VIN"));
                v.setStatus(rs.getString("status"));
                list.add(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }*/

    //根据姓名模糊查询相关姓的用户信息
    /*public List<Vehicle> getByNameVehicle(String likeName){
        List<Vehicle> list=null;
        String sql="select * from userinfo where name like '%"+likeName+"%'";
        try {
            con=this.getConnection();
            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            list=this.getList(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.closeAll(con, pstmt, rs);
        }
        return list;
    }*/

    //根据学校模糊查询相关学校的用户信息
    /*public List<Vehicle> getBySchoolVehicle(String likeSchool) {
        List<Vehicle> list=null;
        String sql="select * from userinfo where school like '%"+likeSchool+"%'";
        try {
            con=this.getConnection();
            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            list=this.getList(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.closeAll(con, pstmt, rs);
        }
        return list;
    }*/

    //根据id号查询用户信息
    /*public Vehicle getVehicleById(int id){
        Vehicle v = null;
        String sql = "select * from " + tableName + "  where id = "+ id;
        try {
            con=this.getConnection();
            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            v = new Vehicle();
            if(rs.next()){
                v = new Vehicle();
                v.setId(rs.getInt("id"));
                v.setDate(rs.getString("date"));
                v.setTime(rs.getString("time"));
                v.setVIN(rs.getString("VIN"));
                v.setStatus(rs.getString("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.closeAll(con, pstmt, rs);
        }
        return v;
    }*/

    //获得最大用户的id号
    /*public int getMaxId(){
        int maxId=0;
        String sql="select max(id) from userinfo";
        try {
            con=this.getConnection();
            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            if(rs.next()){
                maxId=rs.getInt(1)+1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.closeAll(con, pstmt, rs);
        }
        return maxId;

    }*/

    //根据id号删除用户信息
    /*public int deleteVehicle(int id){
        int result=0;
        String sql="delete from userinfo where id=?";
        try {
            con=this.getConnection();
            pstmt=con.prepareStatement(sql);
            pstmt.setInt(1, id);
            result=pstmt.executeUpdate();
            if (result!=0) {
                System.out.println("删除了id为"+id+"的记录！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.closeAll(con, pstmt, rs);
        }
        return result;
    }*/

    //增加一条用户信息
    /*public int addVehicle(Vehicle v){
        int result = 0;
        String sql = "INSERT INTO " + tableName + " values (?,?,?,?,?)";

        try {
            con = this.getConnection();
            pstmt  =con.prepareStatement(sql);

            //pstmt处理
            pstmt.setString(1, v.getDate());
            pstmt.setString(2, v.getTime());
            pstmt.setString(3, v.getVIN());
            pstmt.setString(4, v.getStatus());
            result=pstmt.executeUpdate();

            if (result != 0) {
                System.out.println("添加了一条用户信息！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.closeAll(con, pstmt, rs);
        }
        return result;
    }*/

    //修改一条用户信息
    /*public int updateVehicle(Vehicle v){
        int result  =0;
        String sql = "update " + tableName + " where id= "+ v.getId();
        try {
            con = this.getConnection();
            pstmt = con.prepareStatement(sql);

            //pstmt处理
            pstmt.setString(1, v.getDate());
            pstmt.setString(2, v.getTime());
            pstmt.setString(3, v.getVIN());
            pstmt.setString(4, v.getStatus());
            result=pstmt.executeUpdate();

            if (result != 0) {
                System.out.println("修改一条用户信息！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.closeAll(con, pstmt, rs);
        }
        return result;
    }*/
}
