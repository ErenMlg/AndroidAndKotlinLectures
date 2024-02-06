package com.softcross.androidcomponents

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Usage of the services.
        val serviceIntent = Intent(this, ServiceSample::class.java)
        startService(serviceIntent)

        val intentServiceIntent = Intent(this, IntentServiceSample::class.java)
        startService(intentServiceIntent)

        // Broadcast Receiver Specify with code
        val intentFilter = IntentFilter();
        val myBroadcastReceiver = MyBroadcastReceiver()
        intentFilter.addAction("ACTİON NAME");
        registerReceiver(myBroadcastReceiver, intentFilter);
        // unregisterReceiver(MyReceiver); -> For the cancel listening work.
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onPause() {
        super.onPause()
    }
}

/**
 ** Android Components;
- This base components define android app's structure and functionality

 * Activities
- Activities is simple, they focus on user's possible interaction. They represent a user interface,
another definition is they are to bring to live UI designs for the user interactions.

Each activity must be specified in manifest file.

Activities have own lifecycle;
https://developer.android.com/guide/components/images/activity_lifecycle.png

onCreate()  -> Activity will create with this method.
onStart()   -> Activity will set visible for the user with this method.
onResume()  -> User can interact with application when this method called.
onPause()   -> Activity will paused, any code will not work and it can't accept any interact from user.
onStop()    -> Activity will set non visible for the user with this method
onDestroy() -> This callback is called before the activity is destroyed by the system.
onRestart() -> This callback is called when the activity restarts after stopping it.

 * Services
Service is the one of the critical application component, they can perform long-time operations.
A sample for the service, spotify services can play music on background even if the app is closed etc.

!! Services run in the main thread of in hosting process, not create its own thread,
so developers should run any blocking operations on the separate thread(manage yourself)
for avoiding Application Not Responding (ANR) errors.
Usage Sample: ServiceSample.kt

Services have three different type;

-- Foreground Services --
This services that perform operations in the background that is noticeable for the users. They
must display a Notification and it should continue running even user is not interact with app.
Foreground Services have own lifecycle independent from activity or fragment. Samples;
Music player app (current song notification)
Fitness app (show distance)

!! WorkManager provide more flexible and nearly same way as foreground services, in many cases
developers should use WorkManager instead of Foreground services.

-- Background Services --
This services perform operations background too, but they don't give and information to user about
performed operation. They have own lifecycle like Foreground Services. Developers can use this to compact
its storage.


!! System imposes restrictions on running background services on devices that use API Level 26 or higher,
For example developer should not access location from the background. Alternatively, schedule tasks using WorkManager.

-- Bound Services --
Type of services that offers a client-server interface that allows components(Activity,
content provider and service can bind to the Bound service) to interact with the service,
send requests, receive results, and even do so across processes with interprocess communication (IPC).
Bound Services not have own lifecycle like background or foreground. That's reason they use the lifecycle
of the activity or fragment they were bounded. They can work only when application components is bounded to it.
Multiple components can bind to service at once, but when all of them unbind, service is destroyed.

https://developer.android.com/static/images/service_lifecycle.png

- Intent Services
They is an extension of the Services, They can handle asynchronous request on demand. They can expressed as
Intent.They handle each intent one by one with the worker thread(not using main thread) and when work is done
stops automatically. They may be sometimes time-consuming because all request controlled with single worker thread.
However, they do not interfere main loop of application.

!! This class was deprecated in API level 30. Alternatively WorkManager or JobIntentService.
Usage Sample: IntentServiceSample.kt

!! Services must be specified in Manifest file. You can look manifest file for the sample usage.

 * Broadcast Receivers
They answer to broadcast messages from another application or system, for example, battery low message,
no wifi connection message. They can answer this types of message. They can take message another apps.
They have some types, SMS broadcast receiver, Batery state etc. you can create own custom broadcast receiver.
Usage Sample MyBroadcastReceiver.kt

 * Content Providers
This provide us access to data from storaged our app or another apps as safely. For example,
Whatsapp can access our contacts and numbers saved on the phone with content providers.
Usage Sample: AppProvider.kt
 */