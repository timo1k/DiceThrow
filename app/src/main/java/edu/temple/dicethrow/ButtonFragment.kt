package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentActivity

class ButtonFragment : Fragment() {
    lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_button, container, false).apply {
            button = findViewById(R.id.button)
            button.setOnClickListener{
                //increased coupling
                //define a interface with parents functionality - contract
                //(requireActivity() as MainActivity).buttonClick()

                (requireActivity() as ButtonInterface).buttonClick()
            }

        }
    }

    interface ButtonInterface {
        fun buttonClick(){}
    }

}

