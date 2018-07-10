<?php
    # Simple get request. Token is secure here - client can not access php code
    $response = file_get_contents("http://localhost:8888/onlinePlayers?token=testToken");
    echo "There are currently: " . $response . " people on the server.<br>";


?>
