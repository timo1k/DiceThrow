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

    private var valKey = "key"
    private var sides = 1
    lateinit var dieTextView: TextView
    private var rollVal = 0


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

        savedInstanceState?.run{
            rollVal = getInt(valKey, 0)
        }
        if (rollVal == 0) throwDie() else throwDie(rollVal)

//        view.setOnClickListener{
//            throwDie()
//        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(valKey, rollVal)
    }

    fun throwDie() {
        rollVal = (Random.nextInt(sides) + 1)
        throwDie(rollVal)
    }

    fun throwDie(currentVal: Int){
        dieTextView.text = currentVal.toString()
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