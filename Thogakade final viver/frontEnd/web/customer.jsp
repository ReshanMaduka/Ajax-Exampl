<%--
  Created by IntelliJ IDEA.
  User: sandunDilhan
  Date: 8/19/2018
  Time: 9:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../css/style.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="https://unpkg.com/flickity@2/dist/flickity.min.css">

    <title>ThogaKade-Customer</title>

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

    function viewItemForm() {
        document.getElementById("createItemDivId").style.display="block";
        document.getElementById("updateBtn").style.display="none";
        document.getElementById("saveBtn").style.display="block";
        document.getElementById("customerIdTxt").value="";
        document.getElementById("customerNameTxt").value="";
        document.getElementById("customerAddressTxt").value="";
        document.getElementById("customerIdTxt").readOnly = false;
        document.getElementById("customerIdTxt").style.backgroundColor = "white";
        document.getElementById("customerIdTxt").style.color = "black";
    }

    function cancelItemForm() {
        document.getElementById("createItemDivId").style.display="none";
    }

    function loadAllCustomer() {
        var ajaxConfig={
            method:"GET",
            url:"http://localhost:8080/api/v1/customers",
            async:true
        }

        $.ajax(ajaxConfig).done(function (response) {
           response.forEach(function (customer) {
               console.log(customer.name);
               var html="<tr>" +
                       "<td>" + customer.id + "</td>" +
                       "<td>" + customer.name + "</td>" +
                       "<td>" + customer.address + "</td>" +
                       '<td>' +
                       '<button class="btn btn-outline-warning" type="button" onclick="loadCustomerUpdateText()">edit</button>' +
                       '<button class="btn btn-outline-danger" type="button" onclick="removeCustomer()">remove</button>' +
                       '</td>' +
                       "</tr>";

               $("#customerTable tbody").append(html);
           })
        });
    }

    function saveCustomer() {
        var customerId=document.getElementById("customerIdTxt").value;
        var customerName=document.getElementById("customerNameTxt").value;
        var customerAddress=document.getElementById("customerAddressTxt").value;
        var addCustomer={
            "id": customerId,
            "name": customerName,
            "address": customerAddress
        }

        var x=confirm("Are you sure!!! you want to save "+customerId + " , "+customerName+" ?");
        if(x===true){
            var ajaxConfig2={
                method:"PUT",
                contentType : 'application/json; charset=utf-8',
//                dataType : 'json',
                url:"http://localhost:8080/api/v1/customers",
                data:JSON.stringify(addCustomer),
                async:true
            }

            $.ajax(ajaxConfig2).done(function (response) {
                console.log("correct");
                if(response==="save customer"){
                    alert("customer has been successfully save");
                    window.location.href="customer.jsp";
                }
            });
        }
    }

    function removeCustomer() {
        var table=document.getElementById("customerTable");

        for(var i = 1; i < table.rows.length; i++)
        {
            table.rows[i].onclick = function() {
                var customerId = this.cells[0].innerHTML;
                var x=confirm("Are you sure!!! you want to remove "+customerId+" ?")
                if(x===true){
                    var ajaxConfig={
                        method: "DELETE",
                        url:"http://localhost:8080/api/v1/customers/"+customerId,
                        async:true
                    }

                    $.ajax(ajaxConfig).done(function (response) {
                        if(response==="delete customer"){
                            alert("customer has been successfully deleted");
                            window.location.href="customer.jsp";
                        }else{
                            alert("Customer has been remove failed");
                        }
                    });
                }
            };
        }
    }

    function loadCustomerUpdateText() {
        var table = document.getElementById('customerTable');
        for(var i=1;i<table.rows.length;i++){
            table.rows[i].onclick=function () {
                document.getElementById("customerIdTxt").value=this.cells[0].innerHTML;
                document.getElementById("customerNameTxt").value=this.cells[1].innerHTML;
                document.getElementById("customerAddressTxt").value=this.cells[2].innerHTML;
            }
        }
        document.getElementById("createItemDivId").style.display="block";
        document.getElementById("customerIdTxt").readOnly = true;
        document.getElementById("customerIdTxt").style.backgroundColor = "black";
        document.getElementById("customerIdTxt").style.color = "white";
        document.getElementById("saveBtn").style.display= "none";
        document.getElementById("updateBtn").style.display= "block";
    }

    function updateCustomer() {

        var customerId=document.getElementById("customerIdTxt").value;
        var customerName=document.getElementById("customerNameTxt").value;
        var customerAddress=document.getElementById("customerAddressTxt").value;

        var updateCustomer={
            "id": customerId,
            "name": customerName,
            "address": customerAddress
        }

        var x=confirm("Are you sure!!! you want to update "+customerId+" ?");
        if(x===true){
            var ajaxConfig={
                method:"POST",
                contentType : 'application/json; charset=utf-8',
//                dataType : 'json',
                url:"http://localhost:8080/api/v1/customers/"+customerId,
                data:JSON.stringify(updateCustomer),
                async:true
            };
            console.log("working");

            $.ajax(ajaxConfig).done(function (response) {
                if(response==="update customer"){
                    alert("Customer has been successfully update");
                    window.location.href="customer.jsp";
                }
            });

            console.log("working2");
        }
    }

</script>
<body class="animated fadeIn delay-5s" style="background: linear-gradient(to right, #f7f8f8, #acbb78);" onload="loadAllCustomer()">
<div id="includedNavigationBar"></div>

<div class="container">
    <table class="table table-sm table-hover animated bounce delay-5s" id="customerTable" style="margin-top: 11%;" onload="loadAllCustomer()">
        <thead style="background-color: cornflowerblue">
        <tr>
            <th>Customer Id</th>
            <th>Full Name</th>
            <th>Address</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
</div>

<div class="createItem">
    <button class="btn btn-outline-primary" type="button" style="width: 165%;color: white;background: #2b5876;" onclick="viewItemForm()"><b>create</b></button>
</div>

<div  class="createItemDiv animated rotateInDownLeft delay-5s" id="createItemDivId">
    <ul class="createItemUl">
        <br>
        <div class="row">
            <button class="btn btn-danger" style="margin-left: 86%;width: 92px;" type="button" onclick="cancelItemForm()">X</button>
        </div>
        <br>
        <div class="row">
            <p class="itemP">Customer Id</p>
            <input type="text" style="margin-left: 12%" id="customerIdTxt">
        </div>
        <br>
        <div class="row">
            <p class="itemP">Full Name</p>
            <input type="text" style="margin-left: 14%;width: 60%;" id="customerNameTxt">
        </div>
        <br>
        <div class="row">
            <p class="itemP">Address</p>
            <input type="text" style="margin-left: 16%" id="customerAddressTxt">
        </div>
        <br>
        <div class="row">
            <button class="btn btn-success" style="margin-left: 86%;width: 92px;" type="button" id="saveBtn" onclick="saveCustomer()">save</button>
            <button class="btn btn-warning" style="margin-left: 86%;width: 92px; margin-top: -4.5%;height: 37px;" id="updateBtn" type="button" onclick="updateCustomer()">update</button>
        </div>
        <br>
    </ul>
</div>
</body>
</html>