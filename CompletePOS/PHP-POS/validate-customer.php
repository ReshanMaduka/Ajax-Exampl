<?php
/**
 * Created by IntelliJ IDEA.
 * User: DK
 * Date: 10/30/17
 * Time: 12:42 PM
 */
$id = $_POST["customerID"];
$name = $_POST["customerName"];
$address = $_POST["customerAddress"];
$check = $_POST["save"];
$find="validate";
$error = "";

if (preg_match("/^[C|c]\d{3}$/", $id) != 1) {
    $error = "id,";
}

if (preg_match("/^[A-Za-z ]+$/", $name) != 1) {
    $error .= "name,";
}

if (strlen(trim($address)) === 0) {
    $error .= "address,";
}

if ($error === "") {
    if ($check === "addcustomer") {
        header("Location: save-customer.php?customerID={$id}&customerName={$name}&customerAddress={$address}");
    } elseif ($check === "updatecustomer") {
        header("Location: UpdateCustomer.php?customerID={$id}&customerName={$name}&customerAddress={$address}");
    }
} else {
    if ($check === "addcustomer") {
        header("Location: addCustomer.php?customerID={$id}&customerName={$name}&customerAddress={$address}&error={$error}");
    } elseif ($check === "updatecustomer") {
        header("Location: update-customer.php?customerID={$id}&customerName={$name}&customerAddress={$address}&findthis=[$find]&error={$error}");
    }
}



