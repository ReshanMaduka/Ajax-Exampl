<?php
include "header.php";
?>
<?php
/**
 * Created by IntelliJ IDEA.
 * User: DK
 * Date: 10/30/2017
 * Time: 1:18 PM
 */

$connection = mysqli_connect("localhost","root","madushanka123","company");

if (!$connection) {
    echo mysqli_connect_error();
} else {
    $resultSet = mysqli_query($connection, "select * from item");
}
?>
<form id="frmCustomer" action="" method="POST" enctype="application/x-www-form-urlencoded">
    <div class="eight wide column div-cols">

        <button id="addItem" type="button" class="btn btn-primary">Add Item</button>
        <button id="deleteItem" type="button" class="btn btn-dark">Delete Item</button>
        <br>
        <br>
        <span>List of Items</span>

        <table id="tblStudents" class="ui celled padded table selectable unstackable">

            <thead>
            <tr>
                <th></th>
                <th>Item ID</th>
                <th>Item Name</th>
                <th>Unit Price</th>
                <th>Qty On Hand</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <?php
            $id = 0;
            $find="update";
            while ($rowData = mysqli_fetch_row($resultSet)) {
                $id++;
                echo "<tr>
                            <td><input type=\"checkbox\" value=$rowData[0] name=\"itemID[]\"></td>
                            <td>$rowData[0]</td>
                            <td>$rowData[1]</td>
                            <td>$rowData[2]</td>
                            <td>$rowData[3]</td>
                            <td> <a class='edit' href='update-item.php? itemID=$rowData[0]&&itemName=$rowData[1]&&unitPrice=$rowData[2]&&qtyOnHand=$rowData[3]&&&&findthis=$find'>
                            <i class=\"fa fa-pencil\" aria-hidden=\"true\"></a></td>
                          </tr>";
            }
            mysqli_free_result($resultSet);

            mysqli_close($connection);
            ?>
            </tbody>
            <tfoot>
            </tfoot>
        </table>
    </div>
</form>
<?php
include "footer.php";
?>
