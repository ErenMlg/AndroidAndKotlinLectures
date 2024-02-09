package com.softcross.lifecycle

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize network request library
        networkManager = NetworkManager()
        if (savedInstanceState == null) {
            // Perform initial network request
            networkManager.fetchData()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("App is", "Started")
        // Activity is visible for the user
    }

    override fun onResume() {
        super.onResume()
        Log.d("App is", "Resumed")
        // Activity can interact with user
    }

    override fun onPause() {
        super.onPause()
        Log.d("App is", "Paused")
        // Activity can't take any input or run code
    }

    override fun onStop() {
        super.onStop()
        Log.d("App is", "Stopped")
        // Activity is non visible
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("App is", "Destroyed")
        networkManager.cancelRequests();
    }
}

/**
Lifecycle is coordinate our app states for example, jobs for when a user sends a background to our application.
Lifecycles is important because if we want to best performance and secure app we must know lifecycles.
Lets see activities lifecycle;

1-) onCreate()
Called when the activity is first created. Initialization and setup tasks go here.
This method have savedInstanceState for the take saved viewModels, object or data exchange

2-) onStart()
This method called when the activity becomes visible but may not be in the foreground. You can perform tasks
like registering listeners.

3-) onResume()
Called when the activity is in the foreground and ready to interact with the user.
Start animations and acquire resources here.

4-) onPause()
Called when the activity loses focus. Save user data and stop animations here.

5-) onStop()
Called when the activity is no longer visible. Release resources and unregister listeners.

6-) onDestroy()
Called when the activity is being destroyed. Perform cleanup tasks here
 */