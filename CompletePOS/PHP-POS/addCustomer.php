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

?>
<h1>Add Customer</h1>
<div class="container-fluid">
    <form action="validate-customer.php" method="POST" enctype="application/x-www-form-urlencoded">
        <p class="form-group">
            <label>Customer ID:</label>
            <input class="form-control <?= isInvalid($splittedText, "id") ?>" name="customerID" placeholder="Enter customer ID" value="<?= $id ?>">
            <small>(C001)</small>
        </p>
        <p class="form-group">
            <label>Customer Name:</label>
            <input class="form-control <?= isInvalid($splittedText, "name") ?>" name="customerName" placeholder="Enter customer Name" value="<?= $name ?>">
        </p>
        <p class="form-group">
            <label>Customer Address:</label>
            <input class="form-control <?= isInvalid($splittedText, "address") ?>" name="customerAddress" placeholder="Enter customer Address" value="<?= $address ?>">
        </p>
        <p>
            <button type="submit" class="btn btn-primary" name="save" value="addcustomer" style="color: #0ea432">Save Customer</button>
        </p>
    </form>
</div>
<?php
include "footer.php";
?>
