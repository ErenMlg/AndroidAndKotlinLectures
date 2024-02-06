package com.softcross.informationandroidprojectsdirectory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

/**
- Manifests file;
Every Android Application have AndroidManifest.xml file which define the structure and
metadata of application. Manifest files hold permissions, activities and other app information.
Manifest files extension is '.xml'

 * Here some sample information holded by manifest;
- User Features : It is declare in manifest to use core android features in our applications such NFC.
- User Permissions : Internet access, storage access, camera access etc. for our app.
- Activity : We must specify our activities in manifest file.
- Service : We must specify our services in manifest file.
- Broadcast Receivers : We must specify here the broadcast receivers that communicate with the system,
controlling various system actions.
- Intent-Filter : Intent Filter is a sub type of activity that specify which type of intent
we pass to another activity, service or broadcast receiver.

 * kotlin+Java file;
packageName.fileName is hold our activities, fragments, viewModels, data and every codes.
packageName.fileName(androidTest) is hold our UI test.
packageName.fileName(test) is hold our unit tests.

 * res file;
- drawable package : this package hold our pictures, icons, images, vectors, etc...
- layout package : this package hold our pages designs.
- mipmap : this package hold our app's icon with different sizes as responsive.
- values : this package hold our colors, dimensions, strings, themes, etc...

 * Gradle;
- build.gradle.kts(Project) is hold our projects plugins, The buildscript is defined here along
with the repositories. Any configuration options added here will be common to all modules.
- build.gradle.kts(Module) is hold our modules dependencies, info for specified module, minSDK, etc..
- settings.gradle — All the required modules for the project is defined here.
Any sort of configuration which might be required prior to initialization can be done here.

 */