<?php
/*
 *
 * Copyright (c) 2021 Andrey Ivanov <berkut126@gmail.com>
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */


/**
 * Prints login form
 * @todo Add CSRF
 */
function echoLoginForm(): void
{
    echo '<!DOCTYPE html>
<html lang="ru">
<head>
  <title>Login</title>
  <style>
    html, body{
      width: 100%;
      height: 100%;
      padding: 0;
      margin: 0;
    }
    body{
      display: flex;
      font-family: sans-serif;
      display: -webkit-flex;
      font-size: 40px;
    }
    form{
      margin: auto;
      display: flex;
      display: -webkit-flex;
      flex-direction: column;
      -webkit-flex-direction: column;
    }
    input{
      font-size: 40px;
    }
  </style>
</head>
<body style="width: 100%; height: 100%;">
  <form name="form" method="post" action="#" style="margin: auto;">
    <label>Логин: </label>
    <input type="text" name="login"/>
    <br/>
    <label>Пароль: </label>
    <input type="password" name="password"/>
    <br/>
    <input type="submit" value="Войти"/>
  </form>
</body>
</html>';
}

// TODO: add CSRF
// Check if login field is set
if(isset($_POST["login"])){

    // Bcrypt cost
    $cost = 10;
    // User-provided login and pass
    $password = $_POST["password"];
    $login = $_POST["login"];
    // Get request address header
    $remoteAddress = $_SERVER["REMOTE_ADDR"];
    // A proxy may be used, so get the auxiliary header
    $XForwardedFor = $_SERVER["HTTP_X_FORWARDED_FOR"];

    // TODO: move from hard-coded mysqli username and password to environment variables
    $connection = new mysqli("localhost", "u87086_drew", "FEm8%QsINtzn", "u87086_drew") or die("Unable to connect to database!");
    $connection->set_charset("utf8");

    $sql = "SELECT * FROM `People` WHERE `Login`='$login';";

    $result = $connection->query($sql) or die("Error!");

    // Check if user is found
    if ($result->num_rows > 0) {

        // User is found
        $row = $result->fetch_assoc();
        $hello = $row["Hash"];
        $id = $row["ID"];
        $hi = strlen($hello);
        // Extract salt and hash
        $salt = substr($hello, 0, 15);
        $hash = substr($hello, $hi - 30);
        $salt = $salt.substr($hello, 15 + ($hi - 31) / 2, 16);
        $hash = $hash.substr($hello, 15, ($hi - 31) / 2);

        // Securely check if hashes are the same
        if (hash_equals($hash, crypt($password, $salt)) ) {

            // Rehash the password with a new salt
            try {
                $salt = strtr(base64_encode(random_bytes(16)), '+', '.');
            } catch (Exception $e) {
                die();
            }
            $salt = sprintf("$2a$%02d$", $cost).$salt;
            $hash = crypt($password, $salt);
            $answer = substr($salt, 0, 15);
            $answer = $answer.substr($hash, strlen($hash) / 2);
            $answer = $answer.substr($salt, 15);
            $answer = $answer.substr($hash, 0, strlen($hash) /2);
            $sql = "UPDATE `People` SET `Hash` = '$answer' WHERE `Login` = '$login';";
            $connection->query($sql) or die("Error!");

            // Log user login success
            $sql = "INSERT INTO `Logins` (`Success`, `ID`, `REMOTE_ADDRESS`, `X_FORWARDED_FOR`) VALUES (
                                                                                    1, 
                                                                                    $id, 
                                                                                    '$remoteAddress', 
                                                                                    '$XForwardedFor');";
            $connection->query($sql) or die($connection->error."<br/>".$sql);
            $connection->close();

            // Set cookie
            // TODO: change cookie name to loggedIn
            $cookie_name = "logedIn";
            $cookie_value = $id;
            setcookie($cookie_name, $cookie_value, time() + 2400, "/");
            // Forward user to homepage
            header("Location:https://andrew.pokaza.net/#homework");

        }
        // Wrong password
        else{
            // Log user login unsuccessful
            $sql = "INSERT INTO `Logins` (`ID`, `REMOTE_ADDRESS`, `X_FORWARDED_FOR`) VALUES ($id, '$remoteAddress', '$XForwardedFor');";
            echoLoginForm();
        }
    }
    // User not found
    else{
        // Log user login unsuccessful
        $sql = "INSERT INTO `Logins` (`REMOTE_ADDRESS`, `X_FORWARDED_FOR`) VALUES ('$remoteAddress', '$XForwardedFor');";
        echoLoginForm();
    }
    $connection->query($sql) or die($connection->error."<br/>".$sql);
    $connection->close();
}
else{
    echoLoginForm();
}

?>
