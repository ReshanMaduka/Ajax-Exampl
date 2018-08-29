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
    if (isset($_POST['itemID'])) {
        foreach ($_POST['itemID'] as $value) {
            $query = "delete from item where itemID='$value' ";
            $result = mysqli_query($connection, $query);

            if ($result && mysqli_affected_rows($connection) > 0) {
                header("Location: manage-items.php?title=Manage Items");
            } else {
                header("Location: DeleteItem.php?title=Manage Items");
                mysqli_error($connection);
            }
        }
    }
}
mysqli_close($connection);