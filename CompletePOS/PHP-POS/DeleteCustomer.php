<?php
/**
 * Created by IntelliJ IDEA.
 * User: DK
 * Date: 10/25/2017
 * Time: 11:50 AM
 */

$connection = mysqli_connect("localhost","root","madushanka123","company");

if (!$connection) {
    echo mysqli_connect_error();
} else {
    if (isset($_POST['id'])) {
        foreach ($_POST['id'] as $value) {
            $query = "delete from customer where id='$value' ";
            $result = mysqli_query($connection, $query);

            if ($result && mysqli_affected_rows($connection) > 0) {
                header("Location: manage-customers.php?title=Manage Customers");
            } else {
                header("Location: DeleteCustomer.php?title=Manage Customers");
                mysqli_error($connection);
            }
        }
    }
}
mysqli_close($connection);