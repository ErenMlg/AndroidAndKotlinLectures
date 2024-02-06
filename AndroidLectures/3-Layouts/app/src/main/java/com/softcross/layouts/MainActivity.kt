package com.softcross.layouts

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

/**
 * What is the component?
They are every piece of our design, they known as Widget too. TextView, ImageView, etc.

 * What is the layout?
They are graphical interface for our project. They create inside of app > res > layout file.
Can create right click layout file > new > layout resource file.
They format is '.xml'.

 * Layout Types;

1- Linear Layout
A Linear Layout is primarily employed to arrange components either horizontally or vertically.
To specify the alignment, you can adjust the 'orientation' attribute in the options

Use-case: Perfect for forms or any content that follows a linear progression.
Sample: linear_layout.xml

2- Relative Layout
Every view is positioned relative to another view or the parent container.

Use-case: Useful when you want a flexible UI without specifying exact positions.
Sample: relative_layout.xml

3- Frame Layout
Holds a single view, but multiple views can be stacked.

Use-case: Ideal for displaying one view at a time, like fragments.
Sample: frame_layout.xml

4- Constraint Layout
This is a modern, flexible, and performance-optimized layout that allows developers to
create large and complex layouts with a flat view hierarchy.

Use-case: Versatile for most UI designs and reduces nesting, which improves performance.
Sample: constraint_layout.xml

5- ScrollView

 * Which one is best? How to optimize UI/UX

Reduce Nested Layouts:
The fewer nested layouts you have, the faster your UI will render.

Use Styles and Themes:
Consistent design looks professional and enhances user experience. Instead of hardcoding attributes, define styles.

Use Vector Graphics:
They are scalable without losing clarity and use less memory.

Test on Multiple Devices:
Android devices come in different sizes and resolutions. Ensure your app looks and functions well across the spectrum.

 * Comparison: LinearLayout vs RelativeLayout vs FrameLayout vs ConstraintLayout;

LinearLayout: Efficient when there’s a linear progression. But nested LinearLayouts can degrade performance.

RelativeLayout: More flexible than LinearLayout but can be complex and might require more calculation for positioning.

FrameLayout: Most efficient when stacking views. Not suitable for complex layouts.

ConstraintLayout: Built for flexibility and performance. Reduces need for nested layouts which improves rendering speed.

Render sizes for 3 views one below the other;
Constraint Layout -> 7 sec
Linear Layout -> 1 sec

Render sizes for centered view inside a another view;
Constraint Layout -> 1.8 sec
Linear Layout -> 0.7 sec
Frame Layout -> 0.6 sec

Inside of one line 2 view as aligned different 2 way;
Constraint Layout -> 2.8 sec
Linear Layout -> 2 sec
Relative Layout -> 1.9 sec

Nested views, Sample: image, text, icon views inside of a card view;
Constraint Layout -> 3.2 sec
Linear Layout -> 2.8 sec

Constraint Layout Principle

First Calculate Phase, each view inside of constraint layout scanning and calculating how much size, this Phase realized as linear(Top to bottom), when a view group scanning also this view group child views calculating too.

Order Phase, determination of each view location with used calculate results.

Draw Phase, system is create a canva object for the send draw commands list to processor.This command contains position and size information.
 */