<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>index</title>
</head>
<body>
<!--head-->
<div class="head" ,background-color="red" ,width="100%" ,height="20px">网页头部</div>
<!--body-->
<div class="body">
    <form action="test1" ,method="POST">
        <select name="Selecttion">
            <option value="最高价(元)">最高价(元)</option>
            <option value="最低价(元)">最低价(元)</option>
            <option value="换手率(%)">换手率(%)</option>
            <option value="成交金额(元)">成交金额(元)</option>
        </select>
        <input type="submit" ,value="Submit">
    </form>
</div>
</body>
</html>