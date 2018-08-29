$("#addCustomer").click(function () {
    $("#frmCustomer").attr("action","addCustomer.php");
    $("#frmCustomer").submit();
});

$("#deleteCustomer").click(function () {
    $("#frmCustomer").attr("action", "DeleteCustomer.php");
    $("#frmCustomer").submit();
});
