<?php
/**
 * Created by IntelliJ IDEA.
 * User: DK
 * Date: 10/30/17
 * Time: 12:42 PM
 */
$id = $_POST["itemID"];
$name = $_POST["itemName"];
$unitPrice = $_POST["unitPrice"];
$qtyOnHand = $_POST["qtyOnHand"];
$check = $_POST["save"];
$find = "validate";
$error = "";

if (preg_match("/^[I|i]\d{3}$/", $id) != 1) {
    $error = "id,";
}

if (preg_match("/^[A-Za-z ]+$/", $name) != 1) {
    $error .= "name,";
}

if (preg_match("/^\d+(:?[.]\d{2})$/", $unitPrice) != 1) {
    $error .= "unitPrice,";
}

if (preg_match("/^\d+$/", $qtyOnHand) != 1) {
    $error .= "qtyOnHand,";
}

if ($error === "") {
    if ($check === "additem") {
        header("Location: save-item.php?itemID={$id}&itemName={$name}&unitPrice={$unitPrice}&qtyOnHand={$qtyOnHand}");
    } elseif ($check === "updateitem") {
        header("Location: UpdateItem.php?itemID={$id}&itemName={$name}&unitPrice={$unitPrice}&qtyOnHand={$qtyOnHand}");
    }
} else {
    if ($check === "additem") {
        header("Location: addItem.php?itemID={$id}&itemName={$name}&unitPrice={$unitPrice}&qtyOnHand={$qtyOnHand}&error={$error}");
    } elseif ($check === "updateitem") {
        header("Location: update-item.php?itemID={$id}&itemName={$name}&unitPrice={$unitPrice}&qtyOnHand={$qtyOnHand}&findthis=[$find]&error={$error}");
    }
}



