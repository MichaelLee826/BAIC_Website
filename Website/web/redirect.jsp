<%--
  Created by IntelliJ IDEA.
  User: Michael Lee
  Date: 2016-12-30
  Time: 09:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String action = "table_oneVehicleToList";
    response.sendRedirect(basePath + action);
%>
