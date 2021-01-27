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
 * @license BSD-2-Clause
 * @author Andrey Ivanov <berkut126@gmail.com>
 */

/**
 * Element constants - shared across the application
 * @type {HTMLElement}
 * @private
 */
// Element constants - shared across the application
const _lessons = document.getElementById("lessons");
/**
 * Element constants - shared across the application
 * @type {HTMLElement}
 * @private
 */
const _homework = document.getElementById("homework");
/**
 * Element constants - shared across the application
 * @type {HTMLElement}
 * @private
 */
const _holder = document.getElementById("holder");
/**
 * Element constants - shared across the application
 * @type {HTMLElement}
 * @private
 */
const _loading = document.getElementById("loading");
/**
 * Element constants - shared across the application
 * @type {HTMLElement}
 * @private
 */
const _user = document.getElementById('user');
/**
 * Element constants - shared across the application
 * @type {HTMLElement}
 * @private
 */
const _title = document.getElementById("title");

/**
 * Updates the subject's homework by calling @see {@link getDataAndFill},
 * replacing "para" with "§" and the '"' quote mark with a backslash-escaped quote mark as required by the backend.
 *
 * @param {string} name The subject's name
 * @param {string} value The new homework for the subject
 */
function processUpdate(name, value){
    value = value.replace(/"/g, "\\\"").replace(/para/g, "§");
    getDataAndFill(
        getCurrentLocation(),
        {
            update: "update",
            what: value,
            name: name
        },
        true
    );
}

/**
 * Sets the input's value with its placeholder attribute value
 *
 * @param {HTMLInputElement} input The input on which the operation is to be carried out
 */
function setValueToPlaceholder(input){
    input.value = input.getAttribute("placeholder");
}

/**
 * Get's the current view, lessons by default
 *
 * @returns {string} Current view
 */
function getCurrentLocation(){
    let currentLocation = (window.location.hash || "#lessons");
    return currentLocation.substr(1, location.length);
}

/**
 * Hides an element by changing the class of object from .flex-display to .no-display. The actual update is due to
 * the css display value being flex for the primer and none for the latter.
 * To show an element, use @see {@link show}
 *
 * @param {HTMLElement} element
 */
function hide(element){
    if(element.classList.contains("flex-display")){
        element.classList.toggle("no-display");
        element.classList.toggle("flex-display");
    }
}

/**
 * Shows an element by changing the class of object from .no-display to .flex-display. The actual update is due to
 * the css display value being none for the primer and flex for the latter.
 * To hide an element, use @see {@link hide}
 *
 * @param {HTMLElement} element
 */
function show(element){
    if(element.classList.contains("no-display")){
        element.classList.toggle("flex-display");
        element.classList.toggle("no-display");
    }
}

/**
 * Adds or updates an object's property with a new value
 *
 * @param {*} object The object that is changed
 * @param {string} property The property being added/updated
 * @param {string} value New value for the property
 * @returns {*}
 */
function assignToObjectAndReturnIt(object, property, value){
    object[property] = value;
    return object;
}

/**
 * String representation of an object - just like Object#toString() in Java.
 * An empty object returns an empty string.
 * A string returns itself.
 * Anything else returns the string with a shallow property listing, the ampersand '&' is the delimiter
 *
 * @param {*} object The object which string representation is needed
 * @returns {string} The string representation of the object supplied
 */
function toString(object) {

    if(!object){
        return "";
    }

    else if(typeof object === "string"){
        return object;
    }

    else if(typeof object === "object"){

        let string = "";

        for(let property in object){

            if(object.hasOwnProperty(property) && typeof property !== "function"){

                string += property+"="+object[property]+"&";

            }

        }

        return string.substr(0, string.length - 1);

    }

}

/**
 * Performs an XMLHttpRequest wrapped in a Promise to supplied location, sending the supplied data by get or post,
 * based on post value.
 *
 * @param {string} location The XHR location
 * @param {string=} data The data to be sent
 * @param {boolean=false} post Marks which method (POST=true or GET=false) to use
 * @returns {Promise<string>}
 */
function getData(location, data, post) {

    if(typeof location === "string"){

        return new Promise((resolve, reject) => {

            let xhr;

            if (window.XMLHttpRequest) {
                // code for modern browsers
                xhr = new XMLHttpRequest();
            } else {
                // code for old IE browsers
                xhr = new ActiveXObject("Microsoft.XMLHTTP");
            }

            xhr.onreadystatechange = function () {

                if (this.readyState === 4) {

                    if(this.status === 200) resolve(this.responseText);

                    else if(this.status === 404 || this.status >= 500) reject(
                        `Could not get data, server responded: ${this.statusText}`
                    );

                }

            };

            data = toString(data);

            if(post === true){

                xhr.open("POST", location, true);

                xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

            }

            else{

                xhr.open("GET", location + "?" + data, true);

            }

            xhr.send(data);

        });
    }
}

/**
 * Creates an HTMLElement from an object.
 * All object.classes are transformed into a space-separated string which is assigned to the className attribute.
 * If object.id is set, it's also set on the created element.
 * object.value is going to be the innerText attribute value.
 * All object.attributes are also copied into the element.
 * If object.content is set, a deep
 *
 * @param object The object to be transformed into HTLMElement
 * @param {string} object.element The html tag (div, h1, ...)
 * @param {string[]} object.classes The array of element's classes
 * @param {string} object.id Object's id
 * @param {string} object.value innerText of object
 * @param {string} object.attributes.name Object's attribute name
 * @param {string} object.attributes.value Object's attribute value
 * @param {*[]} object.content Children of the element (recursive)
 * @returns {HTMLElement} The object's html representation
 */
function createElementFromObject(object) {

    let element = document.createElement(object.element);

    if(object.classes){
        element.className = object.classes.reduce((total, current) => {return total + current}, "");
    }

    if(object.id){
        element.id = object.id;
    }

    if(object.value){
        element.innerText = object.value;
    }

    if(object.attributes){
        object.attributes.forEach(attr =>
            element.setAttributeNode(
                assignToObjectAndReturnIt(
                    document.createAttribute(attr.name),
                    "value",
                    attr.value
                )
            )
        );
    }

    if(object.content){
        object.content.forEach(item => element.appendChild(createElementFromObject(item)));
    }

    return element;

}

function getDataAndFill(location, dataToSendToServer, usePost){
    _title.innerText = (location === "lessons") ? "Расписание" : "Домашнее задание";
    if(document.cookie.indexOf("logedIn") !== -1){
        _user.innerText = "Выйти";
        _user.href = "/Web/auth/logout.php?location="+getCurrentLocation();
    }
    hide(_holder);
    show(_loading);
    let dataFromServer = getData("/Web/src/json/"+location+".php", dataToSendToServer, usePost);
    let data;
    let fail = true;
    dataFromServer.then(datum => {
        data = JSON.parse(datum);
        fail = false;
    }).catch(() => {
        fail = true;
        data = {
            content: [
                {
                    element: "div",
                    classes: ["content"],
                    content: [
                        {
                            element: "div",
                            classes: ["contentHeader"],
                            content: [
                                {
                                    element: "h1",
                                    classes: ["subtitle"],
                                    id: "first",
                                    value: "Ошибка"
                                }
                            ]
                        },
                        {
                            element: "p",
                            classes: ["error"],
                            value: "Произошла ошибка. Попробуем через 15 секунд!"
                        }
                    ]
                }
            ]
        };
    }).then(() => {
        document.body.style.setProperty("--content-count", data.content.length.toString());
        _holder.innerHTML = "";
        data.content.forEach(current => _holder.appendChild(createElementFromObject(current)));
        hide(_loading);
        show(_holder);
        if(fail){
            setTimeout(() => getDataAndFill(location, dataToSendToServer, usePost), 15000);
        }
    });
}

_lessons.addEventListener("click", (event) => {
    event.preventDefault();
    getDataAndFill("lessons");
});
_homework.addEventListener("click", (event) => {
    event.preventDefault();
    getDataAndFill("homework")
});

getDataAndFill(getCurrentLocation());

window.onload = () => {
    if(document.cookie.indexOf("logedIn") !== -1){
        _user.innerText = "Выйти";
        let a = getCurrentLocation();
        _user.href = "/Web/auth/logout.php?location=" + a;
    }
};
