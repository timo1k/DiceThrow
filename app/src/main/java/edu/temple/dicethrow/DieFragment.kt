package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import kotlin.random.Random

const val DIE_KEY = "dieSidesNumber"

class DieFragment : Fragment() {

    private var valKey = "key"
    private var sides = 1
    lateinit var dieTextView: TextView

    lateinit var dieViewModel: DieViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { it ->
            // If we find the specific argument
            it.getInt(DIE_KEY)?.let {
                sides = it
            }
        }
        //can only put it in places where it will be attached to frag
        //whose owner , and which class we want a instance of
        dieViewModel = ViewModelProvider(requireActivity())[DieViewModel::class.java]
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

        dieViewModel.getDieRoll().observe(viewLifecycleOwner) {
            //observer - kotlin lingo
            dieTextView.text = it.toString()
        }

        if (dieViewModel.getDieRoll().value == null){
            throwDie()
        }

//        view.setOnClickListener{
//            throwDie()
//        }
    }

    fun throwDie() {
        dieViewModel.setDieRoll(Random.nextInt(sides) + 1)
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