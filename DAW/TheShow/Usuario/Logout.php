<?php
    require "User.php";

    session_start();
    $username = $_SESSION['logadoTrue']['login'];
    setcookie($username . "tempo", date('d/m H:i'), time() + 86400, '/');
    session_destroy();

    header("Location: ../index.php");

    exit();
?>