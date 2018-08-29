<?php
/**
 * Created by IntelliJ IDEA.
 * User: DK
 * Date: 10/25/2017
 * Time: 10:18 AM
 */

$itemID = $_GET["itemID"];
$itemName = $_GET["itemName"];
$unitPrice = (double)$_GET["unitPrice"];
$qtyOnHand = (int)$_GET["qtyOnHand"];

$connection = mysqli_connect("localhost","root","madushanka123","company");

if (!$connection) {
    echo mysqli_connect_error();
} else {
    $result = mysqli_query($connection, "insert into item values('$itemID','$itemName','$unitPrice','$qtyOnHand')");

    if ($result) {
        echo "Item hass been successfully saved";
        header("Location:manage-items.php");
    } else {
        echo "Faild to save the item", "<br>", mysqli_error($connection);
    }
    mysqli_close($connection);
}
//create table items(
//    itemID varchar(100),
//    itemName varchar(100),
//    unitPrice decimal(10, 2),
//    qtyOnHand int(100)
//);
