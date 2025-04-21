// Tyler Radke
// Color Fragments App
// ColorFragment.kt

package edu.msudenver.cs3013.colorfragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ColorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ColorFragment : Fragment(R.layout.fragment_color) {
    private val chosenColorTV: TextView?
        get() = view?.findViewById(R.id.mycolor)
    private var myIndex: Int = -1

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        //If this is the first time the fragment is created, increment count and assign index to the count
        if (savedInstanceState == null) {
            fragmentCount += 1
            myIndex = fragmentCount
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //get color choice passed into the fragment
        val choiceId = arguments?.getInt("COLOR CHOICE", 0) ?: 0

        //update background based on user selection 1 for blue 2 for red
        when (choiceId) {
            1 -> {
                chosenColorTV?.text = "GENERIC BLUE FRAGMENT - UID $myIndex"
                chosenColorTV?.setBackgroundColor(Color.rgb(150, 150, 255))
            }
            2 -> {
                chosenColorTV?.text = "GENERIC RED FRAGMENT - UID $myIndex"
                chosenColorTV?.setBackgroundColor(Color.rgb(255, 150, 150))
            }
        }
    }

    companion object {
        var fragmentCount: Int = 0
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ColorFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(choice: Int): ColorFragment =
            ColorFragment().apply {
                arguments = Bundle().apply   {
                    putInt("COLOR CHOICE", choice)
                }
            }
    }
}