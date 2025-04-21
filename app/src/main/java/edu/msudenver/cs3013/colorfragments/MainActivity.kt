// Tyler Radke
// Color Fragments App
// MainActivity.kt

package edu.msudenver.cs3013.colorfragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainerView

//Interface for listening to user choices
interface ChoiceListener {
    fun onSelected(id: Int)
}

class MainActivity : AppCompatActivity(), ChoiceListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Only adding if its the first time its created
        if (savedInstanceState == null) {
            val cfv = findViewById<FragmentContainerView>(R.id.upperfragment_container)
            val choiceFragment = ChoiceFragment()

            supportFragmentManager.beginTransaction().add(cfv.id, choiceFragment).commit()
        }

    }
    //Called when user makes selection
    override fun onSelected(choiceID: Int) {
        //Gets the reference to lower fragment container and makes new color fragment
        val fcv = findViewById<FragmentContainerView>(R.id.lowerfragment_container)
        val colorFragment = ColorFragment.newInstance(choiceID)

        supportFragmentManager.beginTransaction().replace(fcv.id, colorFragment).addToBackStack(null).commit()
    }
}