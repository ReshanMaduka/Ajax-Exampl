<?php

if (!empty($_GET["title"])){
    $title = $_GET["title"];
}else{
    $title = "Overview";
}

?>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>PHP POS - IJSE : <?= $title ?></title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/semantic.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/customstyle.css">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-transparent">
    <a class="navbar-brand" href="index.php"><img src="images/poslogo.png" id="imgPOS"></a>
    <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="index.php">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Settings</a>
            </li>

        </ul>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <nav class="col-sm-3 col-md-2 d-none d-sm-block bg-light sidebar">
            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link <?= ($title === "Overview")? "active" : ""  ?>" href="index.php">Overview <span class="sr-only"></span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <?= ($title === "Manage Customers")? "active" : ""  ?>" href="manage-customers.php">Manage Customers</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <?= ($title === "Manage Items")? "active" : ""  ?>" href="manage-items.php">Manage Items</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <?= ($title === "Place Order")? "active" : ""  ?>" href="place-order.php">Place Orders</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <?= ($title === "Reports")? "active" : ""  ?>" href="reports.php">Reports</a>
                </li>
            </ul>
        </nav>

        <main class="col-sm-9 ml-sm-auto col-md-10 pt-3" role="main">

            <h1><?= $title ?></h1>