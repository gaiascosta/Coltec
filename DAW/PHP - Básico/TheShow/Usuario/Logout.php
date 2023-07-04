<?php
session_start();
$username =  $_SESSION["logado"]['login'];
//Cookie de última sessão
setcookie($username."tempo", date('d/m H:i'), time() + 86400, '/');
session_destroy();
header("Location: " . $_SERVER['HTTP_REFERER']);
exit();
?>