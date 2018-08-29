<?php
include "header.php";
?>
<?php
/**
 * Created by IntelliJ IDEA.
 * User: DK
 * Date: 10/25/2017
 * Time: 10:18 AM
 */

$connection = mysqli_connect("localhost","root","madushanka123","company");

if (!$connection) {
    echo mysqli_connect_error();
} else {
    $resultSet = mysqli_query($connection, "select * from customer");
}
?>
<form id="frmCustomer" action="" method="POST" enctype="application/x-www-form-urlencoded">
    <div class="eight wide column div-cols">

        <button id="addCustomer" type="button" class="btn btn-primary">Add Customer</button>
        <button id="deleteCustomer" type="button" class="btn btn-dark">Delete Customer</button>
        <br>
        <br>
        <span>List of Customers</span>

        <table id="tblStudents" class="ui celled padded table selectable unstackable">

            <thead>
            <tr>
                <th></th>
                <th>Customer ID</th>
                <th>Customer Name</th>
                <th>Customer Address</th>
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
                            <td><input type=\"checkbox\" value=$rowData[0] name=\"id[]\"></td>
                            <td>$rowData[0]</td>
                            <td>$rowData[1]</td>
                            <td>$rowData[2]</td>
                            <td> <a class='edit' href='update-customer.php? id=$rowData[0]&&name=$rowData[1]&&address=$rowData[2]&&findthis=$find'><i class=\"fa fa-pencil\" aria-hidden=\"true\"></a></td>
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
