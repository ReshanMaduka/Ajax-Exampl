$(document).ready(function () {
    $("#txtOrderID").focus();

    $(document).on("change", "#cmbCustomer", function () {

        $("#txtCid").val(this.value);

    })

    $(document).on("change", "#cmbItem", function () {

        $("#txtIid").val(this.value);

    })
});


var totalPrice;

$("#btnAddToTable").click(function () {

    var orderID = $("#txtOrderID").val();

    var orderDate = $("#txtOrderDate").val();

    var customerName = $("#customerName").val();

    var itemCode = $("#cmbItem").val();

    var description = $("#description").val();

    var unitPrice = $("#unitPrice").val();

    var qtyOnHand = $("#qtyOnHand").val();

    var qty = $("#qty").val();

    var regExpOrderID = /^[O|o]\d{3}$/;

    var regExpOrderDate = /^\d{4}-\d{2}-\d{2}$/;

    var regExpQty = /^\d+$/;

    totalPrice = unitPrice * qty;

    if (!regExpOrderID.test(orderID)) {
        $("#txtOrderID").focus();
        $("#txtOrderID").addClass("error");
        return;

    } else {
        $("#txtOrderID").removeClass("error");
    }

    if (!regExpOrderDate.test(orderDate)) {
        $("#txtOrderDate").focus();
        $("#txtOrderDate").addClass("is-invalid");
        return;

    } else {
        $("#txtOrderID").removeClass("error");
    }

    if (!regExpQty.test(qty)) {
        $("#qty").focus();
        $("#qty").addClass("is-invalid");
        return;

    } else {
        $("#txtOrderID").removeClass("error");
    }

    if (customerName.trim().length === 0) {
        $("#cmbCustomer").focus();
        $("#cmbCustomer").addClass("error");
        return;
    } else {
        $("#cmbCustomer").removeClass("error");
    }

    if (description.trim().length === 0) {
        $("#cmbItem").focus();
        $("#cmbItem").addClass("error");
        return;
    } else {
        $("#cmbItem").removeClass("error");
    }

    $("#txtOid").val(orderID);
    $("#txtODate").val(orderDate);
    $("#txtQtoh").val(qtyOnHand);
    $("#txtQt").val(qty);

    $("#tblOrder tbody").append('<tr>' +
        '<td>' + itemCode + '</td>' +
        '<td>' + description + '</td>' +
        '<td>' + unitPrice + '</td>' +
        '<td>' + qty + '</td>' +
        '<td>' + totalPrice + '</td>' +
        '<td class="garbage"></td>' +
        '</tr>');

    getTotalPrice();
    showTableFooter();

    $("#txtOrderID").val("");
    $("#txtOrderDate").val("");
    $("#customerName").val("");
    $("#description").val("");
    $("#unitPrice").val("");
    $("#qtyOnHand").val("");
    $("#qty").val("");
    totalPrice="";
    $("#txtOrderID").focus();

    $("#tblOrder tbody tr td:first-child").click(function () {
        var row = $(this).parents("tr");
        $(row).fadeOut(400);
        setTimeout(function () {
            $(row).remove();
            showTableFooter();
        }, 500);
        $("#txtOrderID").val(orderID);
        $("#txtOrderDate").val(orderDate);
        $("#customerName").val(customerName);
        $("#description").val(description);
        $("#unitPrice").val(unitPrice);
        $("#qtyOnHand").val(qtyOnHand);
        $("#qty").val(qty);
        $("#txtTotalPrice").val("");
    });

    $("#tblOrder tbody tr td:last-child").click(function () {
        var row = $(this).parents("tr");
        $(row).fadeOut(400);
        setTimeout(function () {
            $(row).remove();
            showTableFooter();
        }, 500);

        orderID = "";
        orderDate = "";
        customerName = "";
        itemCode = "";
        description = "";
        unitPrice = "";
        qtyOnHand = "";
        qty = "";
    });
});

function showTableFooter() {

    if ($("#tblOrder tbody tr").length > 0) {
        $("#tblOrder tfoot").addClass("t-footer");
    } else {
        $("#tblOrder tfoot").removeClass("t-footer");
    }

}

function getTotalPrice() {

    var totPrice = 0;
    if ($("#tblOrder tbody tr").length > 0) {
        for (var i = 0; i <= $("#tblOrder tbody tr").length; i++) {
            var data = $('#tblOrder' + ' td:nth-child' + '(5)').map(function () {
                return $(this).text();
            }).get();
        }
    }
    $("#txtTotalPrice").val(totalPrice);
}