// Tyler Radke
// Color Fragments App
// ChoiceFragment.kt

package edu.msudenver.cs3013.colorfragments

import android.content.Context
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
 * Use the [ChoiceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChoiceFragment : Fragment() {

    private lateinit var choiceListener: ChoiceListener

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_choice, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //attach choice listener to talk with main activity
        if (context is ChoiceListener) {
            choiceListener = context
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //getting reference to red and blue text views
        val blueT = view.findViewById<TextView>(R.id.blueText)
        val redT = view.findViewById<TextView>(R.id.redText)

        //if blue is selected
        blueT.setOnClickListener {
            val choice = 1
            choiceListener.onSelected(choice)
        }

        //if red is selected
        redT.setOnClickListener {
            val choice = 2
            choiceListener.onSelected(choice)
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChoiceFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChoiceFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}