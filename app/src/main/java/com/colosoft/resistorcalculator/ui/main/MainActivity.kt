package com.colosoft.resistorcalculator.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.colosoft.resistorcalculator.R
import android.widget.Toast
import com.colosoft.resistorcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    private var first=0.0
    private var second=0.0
    private var third=1.0
    private var tolerance=0.05
    private var total = 0.0
    private var tolerance_calculation = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root


        setContentView(view)

        mainBinding.toggleButtonGroup1.addOnButtonCheckedListener { toggleButtonGroup1, chekedId, isChecked ->
            if (isChecked){
                when (chekedId){
                    R.id.black_button1 -> first=    0.0
                    R.id.brown_button1 -> first=    10.0
                    R.id.red_button1 -> first=      20.0
                    R.id.orange_button1 -> first=   30.0
                    R.id.yellow_button1 -> first=   40.0
                    R.id.green_button1 -> first=    50.0
                    R.id.blue_button1 -> first=     60.0
                    R.id.purple_button1 -> first=   70.0
                    R.id.gray_button1 -> first=     80.0
                    R.id.white_button1 -> first=    90.0
                }
            }

        }

        mainBinding.toggleButtonGroup2.addOnButtonCheckedListener { toggleButtonGroup2, chekedId, isChecked ->
            if (isChecked){
                when (chekedId){
                    R.id.black_button2 -> second=   0.0
                    R.id.brown_button2 -> second=   1.0
                    R.id.red_button2 -> second=     2.0
                    R.id.orange_button2 -> second=  3.0
                    R.id.yellow_button2 -> second=  4.0
                    R.id.green_button2 -> second=   5.0
                    R.id.blue_button2 -> second=    6.0
                    R.id.purple_button2 -> second=  7.0
                    R.id.gray_button2 -> second=    8.0
                    R.id.white_button2 -> second=   9.0
                }
            }
        }

        mainBinding.toggleButtonGroup3.addOnButtonCheckedListener { toggleButtonGroup3, chekedId, isChecked ->
            if (isChecked){
                when (chekedId){
                    R.id.black_button3 -> third=    1.0
                    R.id.brown_button3 -> third=    10.0
                    R.id.red_button3 -> third=      100.0
                    R.id.orange_button3 -> third=   1000.0
                    R.id.yellow_button3 -> third=   10000.0
                    R.id.green_button3 -> third=    100000.0
                    R.id.blue_button3 -> third=     1000000.0
                    R.id.purple_button3 -> third=   10000000.0
                    R.id.gray_button3 -> third=     100000000.0
                    R.id.white_button3 -> third=    1000000000.0
                }
            }
        }

        mainBinding.toggleButtonGroup4.addOnButtonCheckedListener { toggleButtonGroup4, chekedId, isChecked ->
            if (isChecked){
                when (chekedId){
                    R.id.golden_button1 -> tolerance=    0.05
                    R.id.silver_button1 -> tolerance=    0.1
                }
            }
        }
        with(mainBinding) {
            calculateButton.setOnClickListener {
                total = (first+second)*third
                tolerance_calculation = total*tolerance
                ohmTextView.text = getString(R.string.info,total.toString(),tolerance_calculation.toString())
            }
        }
    }
}