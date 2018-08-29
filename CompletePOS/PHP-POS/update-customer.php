<?php
include "header.php";

$id = "";
if (!empty($_GET["customerID"])) {
    $id = $_GET["customerID"];
}

$name = "";
if (!empty($_GET["customerName"])) {
    $name = $_GET["customerName"];
}

$address = "";
if (!empty($_GET["customerAddress"])) {
    $address = $_GET["customerAddress"];
}

$error = "";
$splittedText = array();
if (!empty($_GET["error"])) {
    $error = $_GET["error"];
    $splittedText = explode(",", $error);
}

function isInvalid($splittedText, $input)
{
    if (!empty($splittedText)) {
        foreach ($splittedText as $string) {
            if ($string === $input) {
                return "is-invalid";
            }
        }
    }
    return "";
}

$checkUpdate=$_GET["findthis"];
if ($checkUpdate==="update"){
    $id=$_GET["id"];
    $name=$_GET["name"];
    $address=$_GET["address"];
}elseif ($checkUpdate==="validate"){
    $id=$_POST["id"];
    $name=$_POST["name"];
    $address=$_POST["address"];
}

?>
    <div class="container">
        <br>
        <h1>Update Selected Customer </h1>
        <br>
        <form action="validate-customer.php" method="POST" enctype="application/x-www-form-urlencoded" id="formCustomer">
            <p class="form-group">
                <label>Customer ID:</label>
                <input name="customerID" class="form-control <?= isInvalid($splittedText, "id") ?>" readonly value="<?= $id?>">
                <small>C001</small>
            <p/>
            <p class="form-group">
                <label>Customer Name:</label>
                <input class="form-control <?= isInvalid($splittedText, "name") ?>" name="customerName" value="<?= $name?>">
            </p>
            <p class="form-group">
                <label>Customer Address:</label>
                <input class="form-control <?= isInvalid($splittedText, "address") ?>" name="customerAddress" value="<?= $address?>">
            </p>
            <p>
                <button class="btn btn-primary" id="btnUpdate" type="submit" name="save" value="updatecustomer">Update This Customer</button>
            </p>
            <p>

            </p>
        </form>
    </div>
<?php
include "footer.php";
?>