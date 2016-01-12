cordova.define("com.phonegap.plugins.linkedinconnect.LinkedINPlugin", function(require, exports, module) {

    "use strict";

var exec = require('cordova/exec');

function LinkedINPlugin() {
 console.log("LinkedINPlugin.js: is created");
}




LinkedINPlugin.prototype.login = function(aString){
 console.log("LinkedINPlugin.js: login");

 exec(function(result){
    alert("OK" + result);
   // console.log("OK LinkedINPlugin.js: login");
   },
  function(result){
   alert("Error" + result);
   // console.log("Error LinkedINPlugin.js: login");
   },"LinkedINPlugin",aString,[]);
}

 var linkedINPlugin = new LinkedINPlugin();
 module.exports = linkedINPlugin;
 });