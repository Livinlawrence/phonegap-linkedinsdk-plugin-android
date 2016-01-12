# Cordova LinkedinSDK Plugin
This is an simple Android Cordova plugin used for logging with Linkedin
and get basic user information. The plugin is using example project from linkedin sample sdk for Android


## Install:
    Assuming the PhoneGap CLI is installed, from the command line run:
`cordova plugin add https://github.com/Livinlawrence/phonegap-linkedinsdk-plugin-android`

## Linkedin Requirements and Set-Up
   To use this plugin you will need to make sure you've registered your Linkedin app with Linkedin 
https://www.linkedin.com/developer/apps/
 * Ensure that you have filled out the "Android Package Names and Hashes" field, using the following information:

There are two types of key hashes: debug (i.e. development) and release (i.e. production).

Debug keys are required for LinkedIn to verify the authenticity of your application while it interacts with our APIs during your development cycle.  
A release key is required because all Android applications must be signed with one before they can be uploaded to the Play store for distribution.
https://developer.linkedin.com/docs/android-sdk

## Login
   `LinkedINPlugin.login('');`
    **NOTE** : You should call this function from your index.js

   *Quering params included in the project are:-*
   `id,first-name,last-name,maiden-name,formatted-name,site-standard-profile-request,industry,picture-url,picture-urls::(original),headline,email-address,location:(name),positions,date-of-birth`


####License
 	Copyright 2015 Livin Lawrence

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
