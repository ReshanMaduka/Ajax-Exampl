<%--
  Created by IntelliJ IDEA.
  User: sandunDilhan
  Date: 8/19/2018
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../css/style.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="https://unpkg.com/flickity@2/dist/flickity.min.css">

    <title>ThogaKade-Dashboard</title>

    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.13.0/umd/popper.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/animate.css@3.5.2/animate.min.css">
</head>
<script>
    $(function () {
        $("#includedNavigationBar").load("../includes/navigationBar.jsp");
    });

    function getCount() {
        var ajaxConfig={
            method:"GET",
            url:"http://localhost:8080/api/v1/customers",
            async:true
        }

        $.ajax(ajaxConfig).done(function (response) {
            document.getElementById("numberOfCustomers").innerHTML=response.length;
        });

        var ajaxConfig1={
            method:"GET",
            url:"http://localhost:8080/api/v1/items",
            async:true
        }

        $.ajax(ajaxConfig1).done(function (response) {
            document.getElementById("numberOfItems").innerHTML=response.length;
        });

        var ajaxConfig2={
            method:"GET",
            url:"http://localhost:8080/api/v1/orders",
            async:true
        }

        $.ajax(ajaxConfig2).done(function (response) {
            document.getElementById("numberOfOrders").innerHTML=response;
        });
    }
</script>
<body class="animated fadeIn delay-5s"
      style="background: linear-gradient(to right, #f7f8f8, #acbb78);" onload="getCount()">
<div id="includedNavigationBar"></div>

<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-12 col-lg-3 col-xl-3 animated bounceInLeft delay-5s slower"
             style="background-color: #1488cc;height: 30%;box-shadow: 10px 10px 10px rgba(0, 0, 0, 0.6);">
            <img src="image/icons8-todo-list-96.png">
            <h1 class="numberH1"><span><a href="placeOrder.jsp" style="font-size: 22px;color: black">order </a></span><span id="numberOfOrders"></span></h1>
        </div>
        <div class="col-lg-1 col-xl-1"></div>
        <div class="col-sm-12 col-md-12 col-lg-3 col-xl-3 animated bounceInDown delay-5s slower"
             style="background-color: #076585;height: 30%;box-shadow: 10px 10px 10px rgba(0, 0, 0, 0.6);">
            <img src="image/icons8-trolley-96.png">
            <h1 class="numberH1"><span><a href="item.jsp" style="font-size: 22px;color: black">item </a></span><span id="numberOfItems"></span></h1>
        </div>
        <div class="col-lg-1 col-xl-1"></div>
        <div class="col-sm-12 col-md-12 col-lg-3 col-xl-3 animated bounceInRight delay-5s slower"
             style="background-color:  #bbd2c5;height: 30%;box-shadow: 10px 10px 10px rgba(0, 0, 0, 0.6);">
            <img src="image/icons8-customer-96.png">
            <h1 class="numberH1"><span><a href="customer.jsp" style="font-size: 22px;color: black">customer </a></span><span id="numberOfCustomers"></span></h1>
        </div>
        <div class="col-lg-1 col-xl-1"></div>
    </div>
</div>
<div class="container" style="margin-top: 7%;">
    <img src="image/Shopping-PNG-Picture-180x180.png" style="margin-left: 35%;">
</div>
</body>
</html>
