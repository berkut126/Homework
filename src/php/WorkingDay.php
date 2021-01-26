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
 * Class WorkingDay
 * Represents a localization-supporting (kinda) class holding the nearest and second-nearest
 *  working day.
 * Mon to Thu those are the days themselves and the next one.
 * For Fri: Fri and Mon
 * For weekends: Mon and Tue
 *
 * @author Andrey Ivanov <berkut126@gmail.com>
 * @copyright BSD-2-Clause
 */
class WorkingDay{

    private array $today;
    private array $tomorrow;

    /**
     * WorkingDay constructor.
     *
     * This class constructs the working day's names based on the current time. The timezone is set to
     * Moscow/Amsterdam.
     * @todo Change the timezone to production server's (or move it to the constructor)
     */
    function __construct(){
        date_default_timezone_set("Europe/Amsterdam");
        $day = date("l");
        if($day == "Friday"){
            $offset = array("+1 second", "+3 day");
        }
        else if($day == "Saturday"){
            $offset = array("+2 day", "+3 day");
        }
        else if($day == "Sunday"){
            $offset = array("+1 day", "+2 day");
        }
        else{
            $offset = array("+1 second", "+1 day");
        }

        setlocale(LC_ALL, 'ru_RU.UTF-8');

        $this->today = array(
            "Ru" => strftime("%A", strtotime($offset[0])),
            "En" => date("l", strtotime($offset[0]))
        );

        $this->tomorrow = array(
            "Ru" => strftime("%A", strtotime($offset[1])),
            "En" => date("l", strtotime($offset[1]))
        );

    }

    /**
     * Return the closest working day's name (current for Mon to Fri and Mon for Sat to Sun)
     * in the specified language.
     *
     * @param string $language Default En, other permitted is Ru
     * @return string
     */
    function getToday($language = "En"): string
    {
        return $this->today[$language];
    }

    /**
     * Return the second closest working day's name
     * (next for Mon to Thu, Mon for Fri and Tue for Sat and Sun)in the specified language.
     *
     * @param string $language Default En, other permitted is Ru
     * @return string
     */
    function getTomorrow($language = "En"){
        return $this->tomorrow[$language];
    }

}
?>
