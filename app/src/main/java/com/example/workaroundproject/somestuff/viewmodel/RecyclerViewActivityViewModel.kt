package com.example.workaroundproject.somestuff.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.workaroundproject.R
import com.example.workaroundproject.somestuff.data.LifeBeing


class RecyclerViewActivityViewModel : ViewModel() {

    private val _listOfLifeBeingsLiveData = MutableLiveData(getListOfLifeBeings())

    fun listOfLifeBeingsLiveData() = _listOfLifeBeingsLiveData

    fun incrementAgeForAllElements(){
        val listOfLifeBeings = _listOfLifeBeingsLiveData.value
        listOfLifeBeings?.forEach {
            when (it){
                is LifeBeing.Cat -> { it.age += 1}
                is LifeBeing.Human -> {it.age += 1}
                else -> { //do nothing
                }
            }
        }
        _listOfLifeBeingsLiveData.value = listOfLifeBeings
    }

    private fun getListOfLifeBeings() : List<LifeBeing>{
        val listOfCats = listOf(
            LifeBeing.Cat(name = "Komaru", age = 6, drawable = R.drawable.komaru),
            LifeBeing.Cat(name = "Cocoa", age = 3, drawable = R.drawable.cocoa),
            LifeBeing.Cat(name = "Komugi", age = 8, drawable = R.drawable.komugi),
        )
        val listOfHuman = listOf(
            LifeBeing.Human(name = "Maximovich", age = 46),
            LifeBeing.Human(name = "AleGovna", age = 55),
            LifeBeing.Human(name = "Katuxa", age = 27),
        )
        val listOfBugs = listOf(
            LifeBeing.Bug(name = "Kolorad")
        )
        return listOfCats + listOfHuman + listOfBugs
    }
}