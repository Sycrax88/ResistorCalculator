package com.colosoft.resistorcalculator.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.colosoft.resistorcalculator.R
import com.colosoft.resistorcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel


    private var total = 0.0
    private var tolerance_calculation = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainViewModel.mutableTotalDone.observe(this) { mutableTotal ->
            total = mutableTotal
        }
        mainViewModel.mutableTotalToleranceDone.observe(this) { mutableTotalTolerance ->
            tolerance_calculation = mutableTotalTolerance
        }

        mainViewModel.initialize()


        mainBinding.toggleButtonGroup1.addOnButtonCheckedListener { toggleButtonGroup1, chekedId, isChecked ->
            if (isChecked) {
                when (chekedId) {
                    R.id.black_button1 -> mainViewModel.assignValue("black", 1)
                    R.id.brown_button1 -> mainViewModel.assignValue("brown", 1)
                    R.id.red_button1 -> mainViewModel.assignValue("red", 1)
                    R.id.orange_button1 -> mainViewModel.assignValue("orange", 1)
                    R.id.yellow_button1 -> mainViewModel.assignValue("yellow", 1)
                    R.id.green_button1 -> mainViewModel.assignValue("green", 1)
                    R.id.blue_button1 -> mainViewModel.assignValue("blue", 1)
                    R.id.purple_button1 -> mainViewModel.assignValue("purple", 1)
                    R.id.gray_button1 -> mainViewModel.assignValue("gray", 1)
                    R.id.white_button1 -> mainViewModel.assignValue("white", 1)
                }
            }

        }

        mainBinding.toggleButtonGroup2.addOnButtonCheckedListener { toggleButtonGroup2, chekedId, isChecked ->
            if (isChecked) {
                when (chekedId) {
                    R.id.black_button2 -> mainViewModel.assignValue("black", 2)
                    R.id.brown_button2 -> mainViewModel.assignValue("brown", 2)
                    R.id.red_button2 -> mainViewModel.assignValue("red", 2)
                    R.id.orange_button2 -> mainViewModel.assignValue("orange", 2)
                    R.id.yellow_button2 -> mainViewModel.assignValue("yellow", 2)
                    R.id.green_button2 -> mainViewModel.assignValue("green", 2)
                    R.id.blue_button2 -> mainViewModel.assignValue("blue", 2)
                    R.id.purple_button2 -> mainViewModel.assignValue("purple", 2)
                    R.id.gray_button2 -> mainViewModel.assignValue("gray", 2)
                    R.id.white_button2 -> mainViewModel.assignValue("white", 2)
                }
            }
        }

        mainBinding.toggleButtonGroup3.addOnButtonCheckedListener { toggleButtonGroup3, chekedId, isChecked ->
            if (isChecked) {
                when (chekedId) {
                    R.id.black_button3 -> mainViewModel.assignValue("black", 3)
                    R.id.brown_button3 -> mainViewModel.assignValue("brown", 3)
                    R.id.red_button3 -> mainViewModel.assignValue("red", 3)
                    R.id.orange_button3 -> mainViewModel.assignValue("orange", 3)
                    R.id.yellow_button3 -> mainViewModel.assignValue("yellow", 3)
                    R.id.green_button3 -> mainViewModel.assignValue("green", 3)
                    R.id.blue_button3 -> mainViewModel.assignValue("blue", 3)
                    R.id.purple_button3 -> mainViewModel.assignValue("purple", 3)
                    R.id.gray_button3 -> mainViewModel.assignValue("gray", 3)
                    R.id.white_button3 -> mainViewModel.assignValue("white", 3)
                }
            }
        }

        mainBinding.toggleButtonGroup4.addOnButtonCheckedListener { toggleButtonGroup4, chekedId, isChecked ->
            if (isChecked) {
                when (chekedId) {
                    R.id.golden_button1 -> mainViewModel.assignValue("golden", 4)
                    R.id.silver_button1 -> mainViewModel.assignValue("silver", 4)
                }
            }
        }
        with(mainBinding) {
            calculateButton.setOnClickListener {
                mainViewModel.calculateTotal()
                mainViewModel.calculateTotalTolerance()
                ohmTextView.text =
                    getString(R.string.info, total.toString(), tolerance_calculation.toString())
            }
        }
    }
}