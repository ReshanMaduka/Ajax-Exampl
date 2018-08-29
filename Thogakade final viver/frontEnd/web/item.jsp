<%--
  Created by IntelliJ IDEA.
  User: sandunDilhan
  Date: 8/19/2018
  Time: 12:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../css/style.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="https://unpkg.com/flickity@2/dist/flickity.min.css">

    <title>ThogaKade-Item</title>

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
        document.getElementById("txtItemCode").value="";
        document.getElementById("txtDesc").value="";
        document.getElementById("txtQty").value="";
        document.getElementById("txtPrice").value="";
        document.getElementById("txtItemCode").readOnly = false;
        document.getElementById("txtItemCode").style.backgroundColor = "white";
        document.getElementById("txtItemCode").style.color = "black";
    }

    function cancelItemForm() {
        document.getElementById("createItemDivId").style.display="none";
        document.getElementById("saveBtn").style.display= "block";
    }

    function loadAllItem() {

        var ajaxConfig = {
            method: "GET",
            url:"http://localhost:8080/api/v1/items",
            async: true
        };

        $.ajax(ajaxConfig).done(function(response){
            response.forEach(function (item){
                console.log(item.code);
                var html = "<tr>" +
                    "<td>" + item.code + "</td>" +
                    "<td>" + item.description + "</td>" +
                    "<td>" + item.qtyOnHand + "</td>" +
                    "<td>" + item.unitPrice + "</td>" +
                    '<td>' +
                    '<button class="btn btn-outline-warning" type="button" onclick="loadItemUpdateText()">edit</button>' +
                    '<button class="btn btn-outline-danger" type="button" onclick="removeItem()">remove</button>' +
                    '</td>' +
                    "</tr>";

                $("#tableItem tbody").append(html);
            });
        });
    }

    function removeItem() {

        var table = document.getElementById('tableItem');

        for(var i = 1; i < table.rows.length; i++)
        {
            table.rows[i].onclick = function() {
                var itemCode = this.cells[0].innerHTML;
                console.log(itemCode);
                var x=confirm("Are you sure!!! you want to remove "+itemCode+" ?")
                if(x===true){
                    var ajaxConfig={
                        method: "DELETE",
                        url:"http://localhost:8080/api/v1/items/"+itemCode,
                        async:true
                    }

                    $.ajax(ajaxConfig).done(function (response) {
                        if(response==="deleted Success"){
                            alert("Item has been successfully deleted");
                            window.location.href="item.jsp";
                        }else{
                            alert("Item has been remove failed");
                        }
                    });
                }
            };
        }
    }

    function loadItemUpdateText() {
        var table = document.getElementById('tableItem');
        for(var i=1;i<table.rows.length;i++){
            table.rows[i].onclick=function () {
                document.getElementById("txtItemCode").value=this.cells[0].innerHTML;
                document.getElementById("txtDesc").value=this.cells[1].innerHTML;
                document.getElementById("txtQty").value=this.cells[2].innerHTML;
                document.getElementById("txtPrice").value=this.cells[3].innerHTML;
            }
        }
        document.getElementById("createItemDivId").style.display="block";
        document.getElementById("txtItemCode").readOnly = true;
        document.getElementById("txtItemCode").style.backgroundColor = "black";
        document.getElementById("txtItemCode").style.color = "white";
        document.getElementById("saveBtn").style.display= "none";
        document.getElementById("updateBtn").style.display= "block";
    }

    function saveItem() {

        var itemCode=document.getElementById("txtItemCode").value;
        var itemdesc=document.getElementById("txtDesc").value;
        var itemQty=document.getElementById("txtQty").value;
        var itemPrice=document.getElementById("txtPrice").value;
        console.log(itemCode+" : "+itemdesc+" : "+itemQty+" : "+itemPrice);

        var addItem={
            "code":itemCode,
            "description":itemdesc,
            "qtyOnHand":itemQty,
            "unitPrice":itemPrice
        }

        var x=confirm("Are you sure!!! you want to save "+itemCode+" ?");
        if(x===true){
            var ajaxConfig2={
                method:"PUT",
                contentType : 'application/json; charset=utf-8',
//                dataType : 'json',
                url:"http://localhost:8080/api/v1/items/",
                data:JSON.stringify(addItem),
                async:true
            }

            $.ajax(ajaxConfig2).done(function (response) {
                console.log("correct");
                if(response==="save success"){
                    alert("Item has been successfully save");
                    window.location.href="item.jsp";
                }
            });
        }
    }

    function updateItem() {

        var itemCode=document.getElementById("txtItemCode").value;
        var itemdesc=document.getElementById("txtDesc").value;
        var itemQty=document.getElementById("txtQty").value;
        var itemPrice=document.getElementById("txtPrice").value;
        console.log(itemCode+" : "+itemdesc+" : "+itemQty+" : "+itemPrice);

        var updateItem={
            "code":itemCode,
            "description":itemdesc,
            "qtyOnHand":itemQty,
            "unitPrice":itemPrice
        }

        var x=confirm("Are you sure!!! you want to update "+itemCode+" ?");
        if(x===true){
            var ajaxConfig={
                method:"POST",
                contentType : 'application/json; charset=utf-8',
//                dataType : 'json',
                url:"http://localhost:8080/api/v1/items/"+itemCode,
                data:JSON.stringify(updateItem),
                async:true
            };
            console.log("working");

            $.ajax(ajaxConfig).done(function (response) {
                console.log("correct : "+response);
                if(response==="update success"){
                    alert("Item has been successfully update");
                    window.location.href="item.jsp";
                }
            });

            console.log("working2");
        }
    }
</script>
<body class="animated fadeIn delay-5s" style="background: linear-gradient(to right, #f7f8f8, #acbb78);" onload="loadAllItem()">
    <div id="includedNavigationBar"></div>

    <div class="container">
        <table class="table table-sm table-hover animated bounce delay-5s" id="tableItem" style="margin-top: 11%;" onload="loadAllItem()">
            <thead style="background-color: cornflowerblue">
            <tr>
                <th>Item Code</th>
                <th>Description</th>
                <th>Qty On Hand</th>
                <th>Price</th>
            </tr>
            </thead>
            <tbody>
            <%--<tr class="itemTableRow">--%>
                <%--<th scope="row">1</th>--%>
                <%--<td>John</td>--%>
                <%--<td>Doe</td>--%>
                <%--<td>jdoe@gmail.com</td>--%>
                <%--<td>--%>
                    <%--<button class="btn btn-outline-warning" type="button">update</button>--%>
                    <%--<button class="btn btn-outline-danger" type="button">remove</button>--%>
                <%--</td>--%>
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
            <p class="itemP">Item Code</p>
            <input type="text" id="txtItemCode" style="margin-left: 12%">
        </div>
        <br>
        <div class="row">
            <p class="itemP">Description</p>
            <input type="text" id="txtDesc" style="margin-left: 11%;width: 60%;">
        </div>
        <br>
        <div class="row">
            <p class="itemP">Qty</p>
            <input type="text" id="txtQty" style="margin-left: 18%">
        </div>
        <br>
        <div class="row">
            <p class="itemP">Price</p>
            <input type="text" id="txtPrice" style="margin-left: 17%">
        </div>
        <br>
        <div class="row">
            <button class="btn btn-success" style="margin-left: 86%;width: 92px;" id="saveBtn" type="button" onclick="saveItem()">save</button>
            <button class="btn btn-warning" style="margin-left: 86%;width: 92px; margin-top: -4.5%;height: 37px;" id="updateBtn" type="button" onclick="updateItem()" >update</button>
        </div>
        <br>

    </ul>
</div>
</body>
</html>
