<?php
if (isset($_SESSION['logado']['login'])) {
    if (isset($_COOKIE[$_SESSION['logado']['login'] . "tempo"])) {
        echo "Última sessão: " . $_COOKIE[$_SESSION['logado']['login'] . "tempo"];
        echo "<br>";
    }

    if (isset($_COOKIE[$_SESSION['logado']['login'] . "lastScore"])) {
        echo "Última pontuação: " . $_COOKIE[$_SESSION['logado']['login'] . "lastScore"];
        echo "<br>";
    }
}

if (isset($_SESSION['logado'])) {
    echo "Recorde: " . $_SESSION['logado']['recorde'];
}
?>