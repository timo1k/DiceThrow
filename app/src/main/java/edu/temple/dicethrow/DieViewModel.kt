package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DieViewModel : ViewModel() {
    private val dieSide = MutableLiveData<Int>() //null value on init

    fun getDieRoll() : LiveData<Int> {
        return dieSide
    }

    fun setDieRoll(dieNum : Int){
        dieSide.value = dieNum
    }

}