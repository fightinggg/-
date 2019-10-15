<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Dao.*" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>最低价信息如下</title>
</head>

<body>


<canvas id="canvas" width="500px" height="300px" style="border:1px solid black;float:left;"></canvas>
<script>
    var list = "<%=(List<Double>) request.getAttribute("list")%>";
    var data=[];

    for(var i=1;i<list.length;i+=100) {
        data.push({xAxis:i,yAxis:list[i]});
    }
    getPolygonalChart(data);

    //获取折线图
    function getPolygonalChart(data) {
        // var data = [{xAxis: "15:08", yAxis: 15}, {xAxis: "15:09", yAxis: 25}, {xAxis: "15:10", yAxis: 35}]
        var canvas = document.getElementById('canvas');
        var yFictitious = 10;//y轴每段长度
        var yNunmber = 10;//y轴段数
        var title = "折线图";
        var titlePosition = "top";
        coordinateAxis(canvas, yFictitious, yNunmber, data, title, titlePosition);
    }

    //画坐标轴
    function coordinateAxis(canvas, yFictitious, yNunmber, data, title, titlePosition) {
        var ctx = canvas.getContext('2d');
        var width = canvas.width;//获取当前画布的宽度
        var height = canvas.height;//获取当前画布的高度
        var padding = 50;// 坐标轴到canvas边框的边距，留边距写文字
        ctx.beginPath();//由 ctx.beginPath() 开始一条新的路径
        ctx.lineWidth = 1;//设置线条宽度

        ctx.moveTo(padding + 0.5, height - padding + 0.5);//ctx.moveTo(x,y) 定义y轴线条的起点
        ctx.lineTo(padding + 0.5, padding + 0.5);//ctx.lineTo(x1,y1) 定义y轴线条的终点
        ctx.stroke();//最后 ctx.stroke() 把y轴起点和终点连成一条线

        ctx.moveTo(padding + 0.5, height - padding + 0.5);//ctx.moveTo(x,y) 定义x轴线条的起点
        ctx.lineTo(width - padding + 0.5, height - padding + 0.5);//ctx.lineTo(x1,y1) 定义x轴线条的终点
        ctx.stroke();//最后 ctx.stroke() 把x轴起点和终点连成一条线

        coordinatePoints(ctx, yNunmber, data, title, titlePosition, width, height, padding, yFictitious);
        mapping(ctx, data, width, height, padding, yFictitious, yNunmber);
    }

    //画坐标点
    //y轴上多少坐标点由自己来定义，需要获取到数据的最大值来计算y轴上的坐标值
    //x轴的点则由传入的数据长度决定，坐标值由传入数据的 xAxis 属性决定。坐标值就是文字
    //title 标题 titlePosition 标题位置 yNunmber y轴的段数 yFictitious y轴每段的长度
    function coordinatePoints(ctx, yNunmber, data, title, titlePosition, width, height, padding, yFictitious) {
        var yNumber = yNunmber;
        var yLength = Math.floor((height - padding * 2) / yNumber);// y轴每段的真实长度
        var xLength = Math.floor((width - padding * 2) / data.length);// x轴每段的真实长度
        ctx.beginPath();//由 ctx.beginPath() 开始一条新的路径
        ctx.textAlign = 'center';//设置或返回文本内容的当前对齐方式start:默认,在指定的位置开始,end:在指定的位置结束center:居中,left:左对齐,right:右对齐
        ctx.fillStyle = '#000000';//设置或返回用于填充绘画的颜色、渐变或模式 fillStyle=color|gradient|pattern;
        ctx.strokeStyle = '#000000';//设置或返回用于笔触的颜色、渐变或模式 strokeStyle=color|gradient|pattern;
        for (var i = 0; i < data.length; i++) {
            var xAxis = data[i].xAxis;
            var xlen = xLength * (i + 1);
            ctx.moveTo(xlen + 45, height - padding);// x轴线上的刻度起点
            ctx.lineTo(xlen + 45, height - padding + 5);// x轴线上的刻度终点
            ctx.stroke();// x轴线上的刻度
            ctx.fillText(xAxis, xlen + 45, height - padding + 15);// ctx.fillText(value, x, y) 填充文字,value 为文字值,x y 为值的坐标
        }
        for (var i = 0; i < yNumber; i++) {
            var y = yFictitious * (i + 1);
            var ylen = yLength * (i + 1);
            ctx.moveTo(padding, height - padding - ylen);// y轴线上的刻度起点
            ctx.lineTo(padding - 5, height - padding - ylen);// y轴线上的刻度终点
            ctx.stroke();// y轴线上的刻度
            ctx.fillText(y, padding - 20, height - padding - ylen + 5);// ctx.fillText(value, x, y) 填充文字,value 为文字值,x y 为值的坐标
        }
        ctx.textAlign = 'center';
        ctx.fillStyle = '#000000';// 颜色
        ctx.font = '16px Microsoft YaHei'
        if (titlePosition === 'bottom' && padding >= 40) {
            ctx.fillText(title, width / 2, height - 5)
        } else {
            ctx.fillText(title, width / 2, padding / 2)
        }
    }

    //画折线图
    function mapping(ctx, data, width, height, padding, Fictitious, yNunmber) {
        var xLength = Math.floor((width - padding * 2) / data.length);// x轴每段的真实长度
        for (var i = 0; i < data.length; i++) {
            if (i + 1 == data.length) {
                return false;
            }
            var xstart = xLength * (data.length - i);// 计算数据的x轴坐标
            var ystart = Math.round(data[i].yAxis / (Fictitious * yNunmber) * 100) / 100 * (height - padding * 2);// 计算数据的Y轴坐标

            var xend = xLength * (data.length - i - 1);// 计算数据的y轴坐标
            var yend = Math.round(data[i + 1].yAxis / (Fictitious * yNunmber) * 100) / 100 * (height - padding * 2);// 计算数据的Y轴坐标

            var startx = xstart + padding;
            var starty = height - padding - ystart;
            var endx = xend + padding;
            var endy = height - padding - yend;
            ctx.moveTo(xstart + 45, height - padding - ystart);//折线的启点
            ctx.lineTo(xend + 45, height - padding - yend);//折线的终点
            ctx.stroke();//链接折线两端
        }
    }
</script>

</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
<p>今日股票的最低价信息如下：</p>
<%
    List<Double> list = (List<Double>) request.getAttribute("list");
    for (Double x : list) {
        out.println("<span>" + x + "</span></br>");
    }
%>
</body>
</html>
