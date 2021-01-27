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
 * Fetches data about HOMEWORK from $connection and returns an array representation of a table.
 * If a user is logged in as an admin (logedIn cookie is set), the result is returned with values
 * packed into inputs, which placeholders hold the current value. An onchange attribute is also
 * set @see https://random-fqdn.ru/js/spa.js
 *
 * Also, based on POST request values, the function updates, deletes or adds homework
 *
 * @todo change cookie name to loggedIn
 * @param mysqli $connection MySQLi connection to the DB that has data
 * @return array The table with homework
 */
function getData(mysqli $connection): array
{

    // Perform CRUD based on POST request value
    if(isset($_COOKIE["logedIn"]) && isset($_POST["update"]) && isset($_POST["name"]) && isset($_POST["what"])){

        $name = $_POST["name"];
        $what = $_POST["what"];
        $who = $_COOKIE["logedIn"];

        switch ($_POST["update"]) {
            case "remove":
                $sql = "DELETE FROM `Homework` WHERE `Lesson` = '$name' AND `Homework` = '$what';";
                $hi = "Couldn't remove such row!";
                break;
            case "insert":
                $sql = "INSERT INTO `Homework` (`Lesson`, `Homework`, `ByID`) VALUES('$name', '$what', $who);";
                $hi = "Couldn't insert such row!";
                break;
            case "update":
                $sql = "UPDATE `Homework` SET `Homework` = '$what', `ByID` = $who WHERE `Lesson` = '$name';";
                $hi = "Couldn't update such row!";
                break;
            default:
                $sql = "SELECT 1;";
        }
        $connection->query($sql) or die($connection->error."<br/>".$sql);
    }

    $sql = "SELECT `Lesson`, `Homework` FROM `Homework` ORDER BY `DateOfInsert`;";
    $result = $connection->query($sql);

    $tbody = array("element" => "tbody", "content" => array());

    while($row = $result->fetch_assoc()) {

        $tr = array("element" => "tr", "content" => array());

        foreach ($row as $key => $value) {
            $temp = array("element" => "td");

            // Check if user is logged in as an admin
            if(isset($_COOKIE["logedIn"])){

                if($key == "Lesson"){

                    $temp["value"] = $value;
                    $currentLesson = $value;

                }
                else{

                    // Return values packed as an input
                    /** @noinspection PhpUndefinedVariableInspection */
                    // Since LessonName field is the first in SQL query, $currentLesson is already set
                    $temp["content"] = array(
                        array(
                            "element" => "input",
                            "attributes" => array(
                                array("name" => "type", "value" => "text"),
                                array("name" => "placeholder", "value" => $value),
                                array("name" => "onchange", "value" => "processUpdate('$currentLesson', this.value)"),
                                array("name" => "onfocus", "value" => "setValueToPlaceholder(this)")
                            )
                        )
                    );

                }

            }

            else{

                $temp["value"] = $value;

            }

            $tr["content"][] = $temp;

        }

        $tbody["content"][] = $tr;

    }

    return $tbody;

}

require '../php/WorkingDay.php';

$nearestWorkingDays = new WorkingDay();

// TODO: move from hard-coded mysqli username and password to environment variables
$connection = new mysqli("localhost", "u87086_drew", "FEm8%QsINtzn", "u87086_drew");
$connection -> set_charset("utf8");

$result = array(
    "content" => array(
        array(
            "element" => "div",
            "attributes" => array(array("name" => "style", "value" => "overflow: auto;")),
            "classes" => array("content"),
            "content" => array(
                array(
                    "element" => "div",
                    "classes" => array("contentHeader"),
                    "content" => array(
                        array(
                            "element" => "h1",
                            "classes" => array("subtitle"),
                            "id" => "first",
                            "value" => "Домашка"
                        )
                    )
                ),
                array(
                    "element" => "table",
                    "classes" => array("contentFill"),
                    "content" => array(
                        array(
                            "element" => "thead",
                            "content" => array(
                                array(
                                    "element" => "tr",
                                    "content" => array(
                                        array(
                                            "element" => "th",
                                            "value" => "Урок"
                                        ),
                                        array(
                                            "element" => "th",
                                            "value" => "Задание"
                                        )
                                    )
                                )
                            )
                        ),
                        getData($connection)
                    )
                )
            )
        )
    )
);

$connection->close();

// This path should return json, so add the Content-Type header
header('Content-Type: application/json; charset=UTF-8');

echo json_encode($result, JSON_UNESCAPED_UNICODE);

?>
