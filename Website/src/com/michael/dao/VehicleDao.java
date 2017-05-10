package com.michael.dao;

import com.michael.bean.Vehicle;

import java.util.List;

/**
 * Created by Michael Lee on 2016-12-28.
 */
public interface VehicleDao {
    public int[] getTableNum();                                     //查出每张表的记录数
    public List<Vehicle> getAllVehicle(int table_num);              //查出所有已有记录
    //public Vehicle getVehicleById(int id);                          //按照主键查询出一条记录
    //public int addVehicle(Vehicle vehicle);                         //添加一条新的记录
    //public int updateVehicle(Vehicle vehicle);                      //按照主键修改一条已有记录
    //public int deleteVehicle(int id);                               //按照主键删除一条已有记录
}
