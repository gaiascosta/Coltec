<?php
if (isset($_SESSION['logadoTrue']['login'])) {
    if (isset($_COOKIE[$_SESSION['logadoTrue']['login'] . "tempo"])) {
        echo "Última sessão: " . $_COOKIE[$_SESSION['logadoTrue']['login'] . "tempo"];
        echo "<br>";
    }

    if (isset($_COOKIE[$_SESSION['logadoTrue']['login'] . "ultimaPontuacao"])) {
        echo "Última pontuação: " . $_COOKIE[$_SESSION['logadoTrue']['login'] . "ultimaPontuacao"];
        echo "<br>";
    }
}

if (isset($_SESSION['logadoTrue'])) {
    echo "Recorde: " . $_SESSION['logadoTrue']['recorde'];
}
?>