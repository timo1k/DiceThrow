package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

const val DIE_KEY = "dieSidesNumber"

class DieFragment : Fragment() {

    private var sides = 1
    lateinit var dieTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { it ->
            // If we find the specific argument
            it.getInt(DIE_KEY)?.let {
                sides = it
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        throwDie()
        view.setOnClickListener{
            throwDie()
        }
    }

    fun throwDie() {
        dieTextView.text = (Random.nextInt(sides) + 1).toString()
    }

    companion object {
        fun newInstance(dieSides: Int) =
            DieFragment().apply {
                arguments = Bundle().apply {
                    putInt(DIE_KEY, dieSides)
                }
            }
    }
}