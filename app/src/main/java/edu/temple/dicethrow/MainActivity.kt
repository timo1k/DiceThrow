package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    fun buttonClick(){
        (supportFragmentManager.findFragmentById(R.id.dieContainer) as DieFragment).throwDie()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment1 = DieFragment.newInstance(20)

        //ffree fragment manager but now we use this we have to impleement saving state itself


        if (supportFragmentManager.findFragmentById(R.id.dieContainer) !is DieFragment)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.dieContainer, fragment1)
                .commit()

//        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
//
//            //returns ref of type fragment but we need to access the dieFrag
//            //type cast
//            (supportFragmentManager.findFragmentById(R.id.dieContainer) as DieFragment).throwDie()
//        }

    }
}