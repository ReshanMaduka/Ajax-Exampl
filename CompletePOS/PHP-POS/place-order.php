<?php
include "header.php";

$connection = mysqli_connect("localhost","root","madushanka123","company");
if (!$connection) {
    echo mysqli_connect_err();
} else {
    $resultSet1 = mysqli_query($connection, "Select * from customer");

    $resultSet2 = mysqli_query($connection, "select * from item");
}

?>

    <script>

        var items = [];

        <?php

        $connection = mysqli_connect("localhost","root","madushanka123","company");

        if (!$connection) {
            echo mysqli_connect_error();
        } else {

            $resultset3 = mysqli_query($connection, "SELECT * FROM item");

            while ($rowData = mysqli_fetch_row($resultset3)) {

                echo "    
                items.push({
                    id : '$rowData[0]',
                    description: '$rowData[1]',
                    unitPrice: '$rowData[3]',
                    qty : '$rowData[2]'
                  });
                ";

            }

            mysqli_free_result($resultset3);
            mysqli_close($connection);

        }

        ?>

        function getValItem(sel) {
            var id = $(sel).val();

            for (var index in items) {
                var item = items[index];
                if (item.id === id) {
                    $('#description').val(item.description);
                    $('#unitPrice').val(item.unitPrice);
                    $('#qtyOnHand').val(item.qty);
                    break;
                }
            }
        }


    </script>

    <script>

        var customers = [];

        <?php

        $connection = mysqli_connect("localhost","root","madushanka123","company");

        if (!$connection) {
            echo mysqli_connect_error();
        } else {

            $resultset4 = mysqli_query($connection, "SELECT * FROM Customer");

            while ($rowData = mysqli_fetch_row($resultset4)) {

                echo "    
                customers.push({
                    id : '$rowData[0]',
                    name: '$rowData[1]',
                    address: '$rowData[2]'
                  });
                ";

            }

            mysqli_free_result($resultset4);
            mysqli_close($connection);

        }

        ?>

        function getvalCustomer(sel) {
            var id = $(sel).val();

            for (var index in customers) {
                var customer = customers[index];
                if (customer.id === id) {
                    $('#customerName').val(customer.name);
                    break;
                }
            }
        }

    </script>


    <div class="container-fluid">
        <br>
        <form id="frmCustomer" action="save-order.php" method="POST" enctype="application/x-www-form-urlencoded">
            <p class="form-group row">
                <label class="col-sm-1">Order ID</label>
                <input class="form-control col-sm-3" id="txtOrderID" name="orderID" placeholder="OrderID (O-001)" value="">
            </p>
            <p class="form-group row">
                <label class="col-sm-1">Order Date</label>
                <input class="form-control col-sm-3" id="txtOrderDate" name="orderDate" placeholder=" OrderDate(0000-00-00)"
                       value="">
            </p>
            <p class="form-group row">
                <label class="col-sm-1">Customer ID</label>
                <select class="form-control col-sm-3" name="customerID" id="cmbCustomer"
                        onchange="getvalCustomer(this);">
                    <?php
                    while ($rowData = mysqli_fetch_row($resultSet1)) {
                        echo "<option value=\"$rowData[0]\">$rowData[0]</option>";
                    }
                    mysqli_free_result($resultSet1);
                    mysqli_close($connection)
                    ?>

                </select>
            </p>
            <p class="form-group row">
                <label class="col-sm-1">Customer Name</label>
                <input class="form-control col-sm-3" name="customerName" id="customerName" placeholder=" "
                       readonly value="">
            </p>
            <div class="row">
                <label class="col-sm-2">Item Code</label>
                <label class="col-sm-2">Description</label>
                <label class="col-sm-2">Unit Price</label>
                <label class="col-sm-2">Qty On Hand</label>
                <label class="col-sm-2">Qty</label>
            </div>

            <div class="row">
                <select class="form-control col-sm-2" name="itemID" id="cmbItem" onchange="getValItem(this);">
                    <?php
                    while ($rowData = mysqli_fetch_row($resultSet2)) {
                        echo "<option value=\"$rowData[0]\">$rowData[0]</option>";
                    }
                    mysqli_free_result($resultSet2);
                    mysqli_close($connection)
                    ?>

                </select>
                <input class="form-control col-sm-2" id="description" name="description" placeholder=" "
                       readonly value="">
                <input class="form-control col-sm-2" id="unitPrice" name="unitPrice" placeholder=" " readonly
                       value="">
                <input class="form-control col-sm-2" id="qtyOnHand" name="qtyOnHand" placeholder=" " readonly
                       value="">
                <input class="form-control col-sm-2" id="qty" name="qty" placeholder=" " value="">


            </div>


            <table id="tblOrder" class="ui celled padded table selectable unstackable">

                <thead>
                <tr>
                    <th>Item Code</th>
                    <th>Description</th>
                    <th>Unit Price</th>
                    <th>Qty</th>
                    <th>Total</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>

                </tbody>
                <tfoot>

                </tfoot>
            </table>

            <div class="col-sm-2" id="lblTotalPrice">Total Price</div>
            <input class="form-control col-sm-2" id="txtTotalPrice" name="totalPrice" readonly value="">
            <button class="btn btn-dark" id="btnAddToTable" type="button">
                Include Table
            </button>
            <br>
            <button class="ui primary button col-sm-2" id="btnAddOrder" type="submit">
                Make Order
            </button>
            <input class="form-control col-sm-2" id="txtCid" name="Cid" type="hidden">
            <input class="form-control col-sm-2" id="txtIid" name="Iid" type="hidden">
            <input class="form-control col-sm-2" id="txtOid" name="Oid" type="hidden">
            <input class="form-control col-sm-2" id="txtODate" name="Odate" type="hidden">
            <input class="form-control col-sm-2" id="txtQtoh" name="Qtoh" type="hidden">
            <input class="form-control col-sm-2" id="txtQt" name="Qt" type="hidden">
        </form>
    </div>

<?php
include "footer.php";
?>