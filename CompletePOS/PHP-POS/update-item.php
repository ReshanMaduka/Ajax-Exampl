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

$checkUpdate = $_GET["findthis"];
if ($checkUpdate === "update") {
    $itemID = $_GET["itemID"];
    $itemName = $_GET["itemName"];
    $unitPrice = (double)$_GET["unitPrice"];
    $qtyOnHand = (int)$_GET["qtyOnHand"];
} elseif ($checkUpdate === "validate") {
    $itemID = $_POST["itemID"];
    $itemName = $_POST["itemName"];
    $unitPrice = (double)$_POST["unitPrice"];
    $qtyOnHand = (int)$_POST["qtyOnHand"];
}

?>
    <div class="container">
        <br>
        <h1>Update Selected Item </h1>
        <br>
        <form action="validate-item.php" method="POST" enctype="application/x-www-form-urlencoded" id="frmItem">
            <p class="form-group">
                <label>Item ID:</label>
                <input class="form-control <?= isInvalid($splittedText, "id") ?>" name="itemID" readonly
                       value="<?= $id ?>">
            <p/>
            <p class="form-group">
                <label>Item Name:</label>
                <input class="form-control <?= isInvalid($splittedText, "name") ?>" name="itemName"
                       value="<?= $name ?>">
            </p>
            <p class="form-group">
                <label>Unit Price:</label>
                <input class="form-control <?= isInvalid($splittedText, "unitPrice") ?>" name="unitPrice"
                       value="<?= $unitPrice ?>">
            </p>
            <p class="form-group">
                <label>Qty On Hand:</label>
                <input class="form-control <?= isInvalid($splittedText, "qtyOnHand") ?>" name="qtyOnHand"
                       value="<?= $qtyOnHand ?>">
            </p>
            <p>
                <button class="btn btn-primary" id="btnUpdate" type="submit" name="save" value="updateitem">Update This
                    Item
                </button>
            </p>
            <p>

            </p>
        </form>
    </div>
<?php
include "footer.php";
?>