$("#addItem").click(function () {
    $("#frmCustomer").attr("action","addItem.php");
    $("#frmCustomer").submit();
});

$("#deleteItem").click(function () {
    $("#frmCustomer").attr("action", "DeleteItem.php");
    $("#frmCustomer").submit();
});
