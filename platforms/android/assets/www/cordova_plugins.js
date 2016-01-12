cordova.define('cordova/plugin_list', function(require, exports, module) {
module.exports = [
    {
        "file": "plugins/linkedinConnectPlugin.js",
        "id": "com.phonegap.plugins.linkedinconnect.LinkedINPlugin",
        "clobbers": [
            "window.linkedinConnectPlugin"
        ]
    }
];
module.exports.metadata =
// TOP OF METADATA
{
    "com.phonegap.plugins.linkedinconnect": "0.5.1"
}
// BOTTOM OF METADATA
});