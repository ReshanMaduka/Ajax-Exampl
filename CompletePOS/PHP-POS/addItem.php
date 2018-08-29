<?php
include "header.php";

$id = "";
if (!empty($_GET["itemID"])) {
    $id = $_GET["itemID"];
}

$name = "";
if (!empty($_GET["itemName"])) {
    $name = $_GET["itemName"];
}

$unitPrice = "";
if (!empty($_GET["unitPrice"])) {
    $unitPrice = $_GET["unitPrice"];
}

$qtyOnHand = "";
if (!empty($_GET["qtyOnHand"])) {
    $qtyOnHand = $_GET["qtyOnHand"];
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

<h1>Add Item</h1>
<div class="container-fluid">
    <form action="validate-item.php" method="POST" enctype="application/x-www-form-urlencoded">
        <p class="form-group">
            <label>Item ID:</label>
            <input class="form-control <?= isInvalid($splittedText, "id") ?>" name="itemID" placeholder="Enter item ID" value="<?= $id ?>">
        </p>
        <p class="form-group">
            <label>Item Name:</label>
            <input class="form-control <?= isInvalid($splittedText, "name") ?>" name="itemName" placeholder="Enter item Name" value="<?= $name?>">
        </p>
        <p class="form-group">
            <label>Unit Price:</label>
            <input class="form-control <?= isInvalid($splittedText, "unitPrice") ?>" name="unitPrice" placeholder="Enter Unit Price" value="<?= $unitPrice ?>">
        </p>
        <p class="form-group">
            <label>Qty On Hand:</label>
            <input class="form-control <?= isInvalid($splittedText, "qtyOnHand") ?>" name="qtyOnHand" placeholder="Enter Qty On Hand" value="<?= $qtyOnHand ?>">
        </p>
        <p>
            <button type="submit" class="btn btn-primary" name="save" value="additem">Save Item</button>
        </p>
    </form>
</div>
<?php
include "footer.php";
?>
