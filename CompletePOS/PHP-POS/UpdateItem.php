<?php
/**
 * Created by IntelliJ IDEA.
 * User: DK
 * Date: 10/30/2017
 * Time: 10:50 PM
 */
$itemID = $_GET['itemID'];
$itemName = $_GET['itemName'];
$unitPrice = (double)$_GET['unitPrice'];
$qtyOnHand = (int)$_GET['qtyOnHand'];

$connection = mysqli_connect("localhost","root","madushanka123","company");
if(!$connection){
    echo mysqli_connect_err();
}else{

$result= mysqli_query($connection,"Update Items set itemName='$itemName',  unitPrice='$unitPrice',  qtyOnHand='$qtyOnHand' WHERE  itemID='$itemID'");
    if($result && mysqli_affected_rows($connection)>0){
        echo "Item SuccessFully Updated";
        header("Location:manage-items.php");
    }else{
        echo "Failed Updated Item","<br>",mysqli_err($connection);

    }
    mysqli_close($connection);
}