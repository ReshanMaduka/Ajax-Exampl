<?php
/**
 * Created by IntelliJ IDEA.
 * User: DK
 * Date: 10/25/2017
 * Time: 11:50 AM
 */

$customerId = $_GET['customerID'];
$customerName = $_GET['customerName'];
$customerAddress = $_GET['customerAddress'];

$connection = mysqli_connect("localhost","root","madushanka123","company");
if(!$connection){
    echo mysqli_connect_err();
}else{

$result= mysqli_query($connection,"Update customer set name='$customerName',  address='$customerAddress' WHERE  id='$customerId'");
    if($result && mysqli_affected_rows($connection)>0){
        echo "Customer SuccessFully Updated";
        header("Location:manage-customers.php");
    }else{
        echo "failed Updated Customer","<br>",mysqli_err($connection);

    }
    mysqli_close($connection);
}