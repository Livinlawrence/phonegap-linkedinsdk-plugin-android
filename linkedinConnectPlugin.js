

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
   alert("Error on js function call" + result);
   // console.log("Error LinkedINPlugin.js: login");
   },"LinkedINPlugin",aString,[]);
}

 var linkedINPlugin = new LinkedINPlugin();
 module.exports = linkedINPlugin;
 