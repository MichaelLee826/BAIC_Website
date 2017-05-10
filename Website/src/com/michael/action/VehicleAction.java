package com.michael.action;

import com.michael.bean.Vehicle;
import com.michael.dao.VehicleDao;
import com.michael.dao.VehicleDaoImplementation;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * Created by Michael Lee on 2016-12-28.
 */
public class VehicleAction extends ActionSupport {
    private List<Vehicle> list;
    private int tableOneNum;
    private int tableTwoNum;
    private int tableThreeNum;
    private int tableFourNum;
    private String tableTitle;

    public List<Vehicle> getList(){
        return list;
    }
    public void setList(List<Vehicle> list){
        this.list = list;
    }
    public int getTableOneNum() {
        return tableOneNum;
    }
    public void setTableOneNum(int tableOneNum) {
        this.tableOneNum = tableOneNum;
    }
    public int getTableTwoNum() {
        return tableTwoNum;
    }
    public void setTableTwoNum(int tableTwoNum) {
        this.tableTwoNum = tableTwoNum;
    }
    public int getTableThreeNum() {
        return tableThreeNum;
    }
    public void setTableThreeNum(int tableThreeNum) {
        this.tableThreeNum = tableThreeNum;
    }
    public int getTableFourNum() {
        return tableFourNum;
    }
    public void setTableFourNum(int tableFourNum) {
        this.tableFourNum = tableFourNum;
    }
    public String getTableTitle() {
        return tableTitle;
    }
    public void setTableTitle(String tableTitle) {
        this.tableTitle = tableTitle;
    }

    public String table_one() throws Exception {
        VehicleDao vehicleDao = new VehicleDaoImplementation();
        list = vehicleDao.getAllVehicle(1);
        int[] num = vehicleDao.getTableNum();
        tableOneNum = num[0];
        tableTwoNum = num[1];
        tableThreeNum = num[2];
        tableFourNum = num[3];
        tableTitle = "站点一：PDI质检";
        return "toList";
    }

    public String table_two() throws Exception {
        VehicleDao vehicleDao = new VehicleDaoImplementation();
        list = vehicleDao.getAllVehicle(2);
        int[] num = vehicleDao.getTableNum();
        tableOneNum = num[0];
        tableTwoNum = num[1];
        tableThreeNum = num[2];
        tableFourNum = num[3];
        tableTitle = "站点二：质检通道";
        return "toList";
    }
    public String table_three() throws Exception {
        VehicleDao vehicleDao = new VehicleDaoImplementation();
        list = vehicleDao.getAllVehicle(3);
        int[] num = vehicleDao.getTableNum();
        tableOneNum = num[0];
        tableTwoNum = num[1];
        tableThreeNum = num[2];
        tableFourNum = num[3];
        tableTitle = "站点三：总装车间";
        return "toList";
    }
    public String table_four() throws Exception {
        VehicleDao vehicleDao = new VehicleDaoImplementation();
        list = vehicleDao.getAllVehicle(4);
        int[] num = vehicleDao.getTableNum();
        tableOneNum = num[0];
        tableTwoNum = num[1];
        tableThreeNum = num[2];
        tableFourNum = num[3];
        tableTitle = "站点四：试车跑道";
        return "toList";
    }
}
