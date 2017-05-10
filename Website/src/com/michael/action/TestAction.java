package com.michael.action;

import com.michael.bean.Vehicle;
import com.michael.dao.VehicleDao;
import com.michael.dao.VehicleDaoImplementation;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * Created by Michael Lee on 2017-01-04.
 */
public class TestAction extends ActionSupport{
    private List<Vehicle> list;
    private String result = "";

    public List<Vehicle> getList(){
        return list;
    }
    public void setList(List<Vehicle> list){
        this.list = list;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String execute() throws Exception {
        try {
            VehicleDao vehicleDao = new VehicleDaoImplementation();
            list = vehicleDao.getAllVehicle(1);
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = new JSONObject();

            for (Vehicle v : list) {
                jsonObject.put("id", "220151459");
                jsonObject.put("date", v.getDate());
                jsonObject.put("time", v.getTime());
                jsonObject.put("VIN", v.getVIN());
                jsonObject.put("status", v.getStatus());
                jsonArray.add(jsonObject);
            }

            result = jsonArray.toString();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return SUCCESS;
    }
}
