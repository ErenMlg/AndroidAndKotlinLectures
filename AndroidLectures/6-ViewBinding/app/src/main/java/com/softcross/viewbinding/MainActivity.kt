package com.softcross.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.softcross.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.text = "Hello viewBinding"
        binding.button.setOnClickListener {
            Toast.makeText(this, "Button Clicked", Toast.LENGTH_LONG).show()
        }
    }
}

/**
 * What is viewBinding?
In android we have views for interact with user.
Yes we have, but if we want to do some actions when interact user with view,
then we must use viewBinding, dataBinding or findViewById. They are provide us to encode the
background of the view.

View binding is a feature that makes it easier to write code that interacts with views.

 * What is difference between viewBinding, dataBinding or findViewById?
 *
In android every view have own ID, findViewById command try to reach view with id and encode the
background of the view.
dataBinding is try to pass our function name to layout for the view.

 * viewBinding vs findViewById;
- Null safety: if invalid id passed to findViewById this causes the null pointer exception,
However view binding creates direct references to views, there’s no risk of a null pointer exception.
- Type safety: if two views have the same id and we pass that id to findViewById, the referenced
view types cannot match, which can cause a class cast exception.

 * viewBinding vs dataBinding;

- View binding requires no annotation processing, so compile time are faster.
- Basically viewBinding only bind views to code, while dataBinding bind data from code to views.
- View binding doesn’t require specially tagged XML layout files, so it’s faster to adopt in your apps.
Once you enable view binding in module, it applies all of that module’s layouts automatically,
but if you want to use data binding you must tagged XML layout files.

 * Usage of view binding;
android {
...
buildFeatures {
viewBinding = true
}
}
you must set viewbinding true from the build gradle on module level.
Then on our fragment or activity page we must bind layout to a variable;
 */