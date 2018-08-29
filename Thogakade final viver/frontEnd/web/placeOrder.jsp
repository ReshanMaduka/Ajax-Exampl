<%--
  Created by IntelliJ IDEA.
  User: sandunDilhan
  Date: 8/20/2018
  Time: 9:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../css/style.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="https://unpkg.com/flickity@2/dist/flickity.min.css">

    <title>ThogaKade-Place Order</title>

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

    function loadCustomerId() {
        var ajaxConfig={
            method:"GET",
            url:"http://localhost:8080/api/v1/customers",
            async:true
        }

        $.ajax(ajaxConfig).done(function (response) {
            response.forEach(function (customer) {
                var html="<option>"+customer.id+"</option>"
                $("#cmbCustomerId").append(html)
            })
        });

        var ajaxConfig={
            method:"GET",
            url:"http://localhost:8080/api/v1/items",
            async:true
        }

        $.ajax(ajaxConfig).done(function (response) {
            response.forEach(function (customer) {
                var html="<option>"+customer.code+"</option>"
                $("#cmbItemCode").append(html)
            })
        });
    }
    
    function selectCustomer() {
        var cusId=document.getElementById("cmbCustomerId").value;

        var ajaxConfig={
            method:"GET",
            url:"http://localhost:8080/api/v1/customers/"+cusId,
            async:true
        }

        $.ajax(ajaxConfig).done(function (response) {
            document.getElementById("txtCustomerName").value=response['name'];
        });
    }

    function selectItem() {
        var iCode=document.getElementById("cmbItemCode").value;
        var ajaxConfig={
            method:"GET",
            url:"http://localhost:8080/api/v1/items/"+iCode,
            async:true
        }

        $.ajax(ajaxConfig).done(function (response) {
            document.getElementById("txtItemDesc").value=response['description'];
            document.getElementById("txtItemQtyOnHand").value=response['qtyOnHand'];
            document.getElementById("txtUnitPrice").value=response['unitPrice'];
        });
    }

    function createOrder() {
        var table = document.getElementById("tblPlaceOrder");

        var itemCode = document.getElementById("cmbItemCode").value;
        var desc = document.getElementById("txtItemDesc").value;
        var price = document.getElementById("txtUnitPrice").value;
        var qty = document.getElementById("txtQty").value;
        var amount = +price * +qty;

        var qtyOnHand = document.getElementById("txtItemQtyOnHand").value;
        console.log(qtyOnHand +" : "+qty)
//        if(qty  <= qtyOnHand){
            var row = table.insertRow(-1);

            var cell1 = row.insertCell(0);
            var cell2 = row.insertCell(1);
            var cell3 = row.insertCell(2);
            var cell4 = row.insertCell(3);
            var cell5 = row.insertCell(4);

            if(table.rows.length === 2){
                console.log("working first time");
                cell1.innerHTML = itemCode;
                cell2.innerHTML = desc;
                cell3.innerHTML = price;
                cell4.innerHTML = qty;
                cell5.innerHTML = amount;
                document.getElementById("txtTotalAmount").value=amount;
            }else{
                var sQty=0;
                var sAmount=0;
                for (var i = 1; i < table.rows.length; i++) {
                    console.log("sada : " + table.rows[i].cells[0].innerHTML);
                    console.log("sdsd : " + itemCode);
                    if ((table.rows[i].cells[0].innerHTML) === itemCode) {
                        console.log("working table : "+i);
                        sQty=table.rows[i].cells[3].innerHTML;
                        sAmount=table.rows[i].cells[4].innerHTML;
                        table.deleteRow(i);
                    }
                }
                console.log("working second time");
                cell1.innerHTML = itemCode;
                cell2.innerHTML = desc;
                cell3.innerHTML = price;
                cell4.innerHTML = +qty + +sQty;
                cell5.innerHTML = +amount + +sAmount;

                var am=document.getElementById("txtTotalAmount").value;
                document.getElementById("txtTotalAmount").value=+am + +amount;
            }
//        }else{
//            alert("maximum insert "+qtyOnHand+" qty");
//        }
    }

    function saveOrder() {
        var custId=document.getElementById("cmbCustomerId").value;
        var amount=document.getElementById("txtTotalAmount").value;
        console.log("custID : "+custId)
        var ajaxConfig={
            method:"GET",
            url:"http://localhost:8080/api/v1/customers/"+custId,
            async:false
        };

        var custAddress="";
        $.ajax(ajaxConfig).done(function (response) {
           custAddress=response['address'];
        })
        var custName=document.getElementById("txtCustomerName").value;

        console.log(custName+" : "+custAddress);

        var ajaxConfig={
            method:"GET",
            url:"http://localhost:8080/api/v1/orders",
            async:false
        };

        var orderId="";
        $.ajax(ajaxConfig).done(function (response) {
            orderId=+response+ +1 ;
        })
        var oId="OD00"+orderId;

        var table = document.getElementById("tblPlaceOrder");
        var jsonArr = [];
        for(var i = 1; i < table.rows.length; i++){
//            var col = row.cells;
            console.log(table.rows[i].cells[0].innerHTML)
            var ajaxConfig={
                method:"GET",
                url:"http://localhost:8080/api/v1/items/"+table.rows[i].cells[0].innerHTML,
                async:false
            };

            var unitP=0;
            var qtyOnH=0;
            $.ajax(ajaxConfig).done(function (response) {
                unitP=response['unitPrice'];
                qtyOnH=response['qtyOnHand'];
            })
            var jsonObj = {
                qty : table.rows[i].cells[3].innerHTML,
                total : table.rows[i].cells[4].innerHTML,
                itemDTO :{
                    code: table.rows[i].cells[0].innerHTML,
                    description: table.rows[i].cells[1].innerHTML,
                    unitPrice: unitP,
                    qtyOnHand: qtyOnH
                }
            }
            console.log(jsonObj)

            jsonArr.push(jsonObj);
        }
        console.log(jsonArr);

        var addOrder={
            orderId:oId,
            orderDetailDTOList:jsonArr,
            customerDTO:{
                id: custId,
                name: custName,
                address: custAddress
            },
            totalAmount:amount
        }
        var x=confirm("Are you sure!!! you want to save "+oId+" ?");
        if(x===true){
            var ajaxConfig2={
                method:"PUT",
                contentType : 'application/json; charset=utf-8',
//                dataType : 'json',
                url:"http://localhost:8080/api/v1/placeOrders/",
                data:JSON.stringify(addOrder),
                async:true
            }

            $.ajax(ajaxConfig2).done(function (response) {
                console.log("correct");
                if(response==="save success"){
                    alert("Order has been successfully save");
                    window.location.href="placeOrder.jsp";
                }
            });
        }
    }
</script>
<body class="animated fadeIn delay-5s" style="background: linear-gradient(to right, #f7f8f8, #acbb78);" onload="loadCustomerId()">
<div id="includedNavigationBar"></div>

<div class="container">
    <div class="row">
        <div class="col-sm-1 col-md-1 col-lg-1 col-xl-1" style="color: white">
            <p>customer</p>
        </div>
        <div class="col-sm-11 col-md-11 col-lg-11 col-xl-11">
            <hr>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-2 col-md-2 col-lg-2 col-xl-2">
            <p><b>Customer Id  :  </b></p>
        </div>
        <div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
            <select id="cmbCustomerId" style="margin-left: -15%;width: 69%;height: 5%;" onload="loadCustomerId()" onchange="selectCustomer()">
                <option>select customer</option>
            </select>
        </div>
        <div class="col-sm-2 col-md-2 col-lg-2 col-xl-2">
            <p><b>Customer Name  :  </b></p>
        </div>
        <div class="col-sm-5 col-md-5 col-lg-5 col-xl-5">
            <input type="text" id="txtCustomerName" readonly style="width: 90%;background-color: black;color: white">
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-sm-1 col-md-1 col-lg-1 col-xl-1" style="color: white">
            <p>Item</p>
        </div>
        <div class="col-sm-11 col-md-11 col-lg-11 col-xl-11">
            <hr>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-2 col-md-2 col-lg-2 col-xl-2">
            <p><b>Item Code  :  </b></p>
        </div>
        <div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
            <select id="cmbItemCode" style="margin-left: -15%;width: 69%;height: 5%;" onchange="selectItem()">
                <option>select item</option>
            </select>
        </div>
        <div class="col-sm-2 col-md-2 col-lg-2 col-xl-2">
            <p><b>Item Description  :  </b></p>
        </div>
        <div class="col-sm-5 col-md-5 col-lg-5 col-xl-5">
            <input type="text" id="txtItemDesc" readonly style="width: 90%;background-color: black;color: white">
        </div>
    </div>
    <div class="row">
        <div class="col-sm-2 col-md-2 col-lg-2 col-xl-2">
            <p><b>Qty On Hand  :  </b></p>
        </div>
        <div class="col-sm-2 col-md-2 col-lg-2 col-xl-2">
            <input type="text" id="txtItemQtyOnHand" readonly style="margin-left: -24%;background-color: black;color: white">
        </div>
        <div class="col-sm-1 col-md-1 col-lg-1 col-xl-1">
            <p><b>Price  :  </b></p>
        </div>
        <div class="col-sm-2 col-md-2 col-lg-2 col-xl-2">
            <input type="text" id="txtUnitPrice" readonly style="background-color: black;color: white">
        </div>
        <div class="col-sm-2 col-md-2 col-lg-2 col-xl-2">
            <p style="margin-left: 76%;"><b>Qty  :  </b></p>
        </div>
        <div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
            <input type="text" id="txtQty" style="margin-left: 13%">
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-xl-12">
            <button class="btn btn-success" onclick="createOrder()" style="margin-left: 84%;width: 12%;">add</button>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-sm-1 col-md-1 col-lg-1 col-xl-1" style="color: white">
            <p>PlaceOrder</p>
        </div>
        <div class="col-sm-11 col-md-11 col-lg-11 col-xl-11">
            <hr>
        </div>
    </div>
</div>


<div class="container">
    <table class="table table-sm table-hover animated bounce delay-5s" id="tblPlaceOrder" style="margin-top: 0%;">
        <thead style="background-color: cornflowerblue">
        <tr>
            <th>Item Code</th>
            <th>Description</th>
            <th>Price</th>
            <th>Qty</th>
            <th>Amount</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
</div>

<div class="container">
    <div class="row">
        <div class="col-sm-2 offset-sm-10" style="border:none">
            <p style="display: inline"><b>Total Amount  :</b></p>
            <input type="text" id="txtTotalAmount" readonly style="background-color: black;color: white">
            <button class="btn btn-success" style="width: 180px;margin-top: 9%;" type="button" onclick="saveOrder()">save</button>
        </div>
    </div>
</div>

<%--<div class="createItem">--%>
    <%--<button class="btn btn-outline-primary" type="button" style="width: 165%;color: white" onclick="viewItemForm()"><b>view</b></button>--%>
<%--</div>--%>

<%--<div  class="createItemDiv animated rotateInDownLeft delay-5s" id="createItemDivId">--%>
    <%--<ul class="createItemUl">--%>
        <%--<div class="table-responsive">--%>
            <%--<table class="table">--%>
                <%--<thead>--%>
                <%--<tr>--%>
                    <%--<th>#</th>--%>
                    <%--<th>Order Id</th>--%>
                    <%--<th></th>--%>
                    <%--<th>Email</th>--%>
                <%--</tr>--%>
                <%--</thead>--%>
                <%--<tbody>--%>
                <%--<tr>--%>
                    <%--<th scope="row">1</th>--%>
                    <%--<td>John</td>--%>
                    <%--<td>Doe</td>--%>
                    <%--<td>jdoe@gmail.com</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<th scope="row">2</th>--%>
                    <%--<td>Will</td>--%>
                    <%--<td>Johnson</td>--%>
                    <%--<td>will@yahoo.com</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<th scope="row">3</th>--%>
                    <%--<td>Shannon</td>--%>
                    <%--<td>Williams</td>--%>
                    <%--<td>shannon@yahoo.com</td>--%>
                <%--</tr>--%>
                <%--</tbody>--%>
            <%--</table>--%>
        <%--</div>--%>
    <%--</ul>--%>
<%--</div>--%>
</body>
</html>

