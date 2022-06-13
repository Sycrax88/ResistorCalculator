package com.colosoft.resistorcalculator.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var multiplier = 1
    private var mutableFirst = 0.0
    private var mutableSecond = 0.0
    private var mutableThird = 1.0
    private var mutableTolerance = 0.05

    private val mutableTotal: MutableLiveData<Double> = MutableLiveData()
    val mutableTotalDone: LiveData<Double> = mutableTotal

    private val mutableTotalTolerance: MutableLiveData<Double> = MutableLiveData()
    val mutableTotalToleranceDone: LiveData<Double> = mutableTotalTolerance


    fun initialize() {
        mutableTotal.value = 0.0
    }

    fun assignValue(colorName: String, column: Int) {

        if (column == 1) {
            multiplier = 10
            when (colorName) {
                "black" -> mutableFirst = 0.0 * multiplier
                "brown" -> mutableFirst = 1.0 * multiplier
                "red" -> mutableFirst = 2.0 * multiplier
                "orange" -> mutableFirst = 3.0 * multiplier
                "yellow" -> mutableFirst = 4.0 * multiplier
                "green" -> mutableFirst = 5.0 * multiplier
                "blue" -> mutableFirst = 6.0 * multiplier
                "purple" -> mutableFirst = 7.0 * multiplier
                "gray" -> mutableFirst = 8.0 * multiplier
                "white" -> mutableFirst = 9.0 * multiplier
            }
        } else if (column == 2) {
            multiplier = 1
            when (colorName) {
                "black" -> mutableSecond = 0.0 * multiplier
                "brown" -> mutableSecond = 1.0 * multiplier
                "red" -> mutableSecond = 2.0 * multiplier
                "orange" -> mutableSecond = 3.0 * multiplier
                "yellow" -> mutableSecond = 4.0 * multiplier
                "green" -> mutableSecond = 5.0 * multiplier
                "blue" -> mutableSecond = 6.0 * multiplier
                "purple" -> mutableSecond = 7.0 * multiplier
                "gray" -> mutableSecond = 8.0 * multiplier
                "white" -> mutableSecond = 9.0 * multiplier
            }
        } else if (column == 3) {
            when (colorName) {
                "black" -> mutableThird = 1.0
                "brown" -> mutableThird = 10.0
                "red" -> mutableThird = 100.0
                "orange" -> mutableThird = 1000.0
                "yellow" -> mutableThird = 10000.0
                "green" -> mutableThird = 100000.0
                "blue" -> mutableThird = 1000000.0
                "purple" -> mutableThird = 10000000.0
                "gray" -> mutableThird = 100000000.0
                "white" -> mutableThird = 1000000000.0
            }
        } else if (column == 4) {
            when (colorName) {
                "golden" -> mutableTolerance = 0.05
                "silver" -> mutableTolerance = 0.1
            }
        }

    }

    fun calculateTotal() {
        mutableTotal.value = (mutableFirst + mutableSecond) * mutableThird
    }

    fun calculateTotalTolerance() {
        mutableTotalTolerance.value =
            ((mutableFirst + mutableSecond) * mutableThird) * mutableTolerance
    }
}

