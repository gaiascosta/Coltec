<?php
require "Usuario.php";
session_start();
$username = $_SESSION["logado"]["login"];
//Cookie de última sessão
setcookie($username."tempo", date('d/m H:i'), time() + 86400, '/');
session_destroy();
header("Location: ../index.php");
exit();
?>