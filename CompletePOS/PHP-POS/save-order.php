<?php
/**
 * Created by IntelliJ IDEA.
 * User: DK
 * Date: 11/2/2017
 * Time: 9:57 PM
 */

$orderID=$_POST["Oid"];
$orderDate=$_POST["Odate"];
$totalPrice=$_POST["totalPrice"];
$customerID=$_POST["Cid"];
$itemID=$_POST["Iid"];
$qtyOnHand=$_POST["Qtoh"];
$qty=$_POST["Qt"];
$remainingQty=$qtyOnHand-$qty;

$connection = mysqli_connect("localhost","root","madushanka123","company");

if (!$connection) {
    echo mysqli_connect_error();
} else {
    mysqli_autocommit($connection, FALSE);

    $addOrder = mysqli_query($connection, "insert into orders values('$orderID','$customerID','$orderDate','$totalPrice')");

    if ($addOrder) {

        $updateItem = mysqli_query($connection, "update item set qtyOnHand='$remainingQty' where itemID='$itemID'");
        if ($updateItem) {
            mysqli_commit($connection);
            echo "Order successfully saved";
        } else {
            mysqli_rollback($connection);
            echo "Order faild to add";
        }
    } else {
        mysqli_rollback($connection);
        echo "Faild to save order", "<br>", mysqli_error($connection);
    }
    mysqli_autocommit($connection, TRUE);
    mysqli_close($connection);
}