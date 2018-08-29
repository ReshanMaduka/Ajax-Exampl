<?php
/**
 * Created by IntelliJ IDEA.
 * User: ranjith-suranga
 * Date: 11/29/17
 * Time: 1:20 PM
 */

$id = $_POST['id'];
$name = $_POST['name'];
$address = $_POST['address'];
$salary = $_POST['salary'];

$connection = mysqli_connect("127.0.0.1","root","reshan7","thogakade","3306");

if (!$connection){
    echo "Something went wrong with the connection";
    die;
}else{

    $result = mysqli_query($connection, "INSERT INTO Customer VALUES('{$id}','{$name}','{$address}',$salary)");

    if (mysqli_affected_rows($connection) > 0){

        echo "Customer has been saved successfully";


    }else{

        echo "Failed to save the customer";

    }

    mysqli_close($connection);

}