package com.softcross.context

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.softcross.context.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // This for the viewBinding we will see next lessons
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            //this -> Activity Context from MainActivity
            //text -> text message
            //Toast.LENGTH_LONG -> toast message duration time
            Toast.makeText(this, "Toast Message", Toast.LENGTH_LONG).show()
            Toast.makeText(this@MainActivity, "Toast Message", Toast.LENGTH_LONG).show()
        }
        binding.textView.text = this.getText(R.string.app_name)

        // Sample application context usage;
        // This for the hilt, we will see next lessons
        /*
        @Module
        @InstallIn(SingletonComponent::class)
        object AppModule {

            @Provides
            @Singleton
            fun provideApplicationContext(application: MyApplication): Context = application.applicationContext
        }
         */

    }
}

/**
 * Context
Simply, Context is the interface that contain global information about application environment. Context
allows to access global resources(images, strings, wifi service, location service, etc.) on local
or system level.

! Context is everything on a android app.

We have a few context type, context type specified on usage place.
--- Application Context ---
This context is singleton, every reach is same instance. This execute depended apps lifecycle,
context will be running while app works. We can reach application context on Activity or Service
with "getApplication()" command. Also this context don't relation with UI, in UI process we shouldn't use this.

--- Activity Context ---
Activity is inherited to "ContextWrapper" class, so this contains context. This context depended activity
lifecycle, Every activity have own context they independent from each other. We can reach context im
activity with "getContext()" or "this" command.

Activity inheritance order;
Activity -> ContextThemeWrapper -> ContextWrapper -> Context

We can inflate XML with activity context, this reason activity inherited to "ContextThemeWrapper", also
we can reach resources, we can use this for the start another activity, used context in fragment is
activity context to contain this fragment.

!!! We shouldn't hide somewhere context as static, this directly create memory leak. Static variables
is hided on memory while lifecycle, so garbage collector don't interact with this variables, this
situation create memory leak.

--- Service ---
Each service have own context, this context is depended to service lifecycle and they are independent
from each other. They similar to activity context but this isn't related with UI.

--- Broadcast Receiver ---
Broadcast Receivers isn't have own context, but system provide a context for the "onReceive()" method,
also each context inside of onReceive method are independent from another onReceive method context.
onReceive() method is response each intent. This isn't related with UI.

--- Content Provider ---
They don't contain own context like broadcast receivers but when a content provider created, system
assign a application context for this content provider, so they usage like application context, anywise
they aren't related with UI.
 */