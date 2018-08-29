<?php
/**
 * Created by IntelliJ IDEA.
 * User: DK
 * Date: 10/25/2017
 * Time: 10:18 AM
 */

$customerID= $_GET["customerID"];
$customerName= $_GET["customerName"];
$customerAddress= $_GET["customerAddress"];

$connection = mysqli_connect("localhost","root","madushanka123","company");

if(!$connection){
    echo mysqli_connect_error();
}else{
    $result=mysqli_query($connection,"insert into customer values('$customerID','$customerName','$customerAddress')");

    if($result){
        echo "Customer hass been successfully saved";
        header("Location:manage-customers.php");
    }else{
        echo "Faild to save the customer","<br>" ,mysqli_error($connection);
    }
    mysqli_close($connection);
}