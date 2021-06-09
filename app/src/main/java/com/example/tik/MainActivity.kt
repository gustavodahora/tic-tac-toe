package com.example.tik

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.example.tik.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var checkedThemeGlobal = false
    private var currentlyKey = "O"
    private var typeCheck = 1
    var firstFirst = " "
    var firstSecond = " "
    var firstThird = " "
    var secondFirst = " "
    var secondSecond = " "
    var secondThird = " "
    var thirdFirst = " "
    var thirdSecond = " "
    var thirdThird = " "
    var win = false
    var pointsO = 0
    var pointsX = 0
    var startCheck = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        pref.apply {
            val checked = getBoolean("checked", false)
            checkedThemeGlobal = checked
        }

        // Set them on startup
        setTheme()

    }

    fun theme(view: View?) {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()
        var checked = binding.darkTheme.isChecked
        editor.putBoolean("checked", checked).apply()
        checkedThemeGlobal = checked
        setTheme()
    }

    // Set theme
    fun setTheme() {
        binding.darkTheme.isChecked = checkedThemeGlobal
        if (checkedThemeGlobal) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    // tic tac toe functions
    fun setCurrentlyKey() {
        if (currentlyKey == "O") {
            currentlyKey = "X"
        } else {
            currentlyKey = "O"
        }
        resetTicColor()
    }

    // RESET
    fun reset(v: View) {
        startCheck = true
        setReset()
        pointsX = 0
        pointsO = 0
        setPointValue()
        setPointColor()
        resetTicColor()
    }

    fun setReset() {
        firstFirst = " "
        firstSecond = " "
        firstThird = " "
        secondFirst = " "
        secondSecond = " "
        secondThird = " "
        thirdFirst = " "
        thirdSecond = " "
        thirdThird = " "

        binding.firstFirst.text = " "
        binding.firstSecond.text = " "
        binding.firstThird.text = " "
        binding.secondFirst.text = " "
        binding.secondSecond.text = " "
        binding.secondThird.text = " "
        binding.thirdFirst.text = " "
        binding.thirdSecond.text = " "
        binding.thirdThird.text = " "
    }

    fun first_first(v: View) {
        if (binding.firstFirst.text == " ") {
            if (startCheck) {
                binding.firstFirst.text = currentlyKey
                firstFirst = currentlyKey
                typeCheck = 1
                setCurrentlyKey()
                if (binding.firstFirst.text != " ") {
                    checkWin()
                }
            }
        }

    }

    fun first_second(v: View) {
        if (binding.firstSecond.text == " ") {
            if (startCheck) {
                binding.firstSecond.text = currentlyKey
                firstSecond = currentlyKey
                typeCheck = 2
                setCurrentlyKey()
                if (binding.firstSecond.text != " ") {
                    checkWin()
                }
            }
        }


    }

    fun first_third(v: View) {
        if (binding.firstThird.text == " ") {
            if (startCheck) {
                typeCheck = 3
                binding.firstThird.text = currentlyKey
                firstThird = currentlyKey
                setCurrentlyKey()
                if (binding.firstThird.text != " ") {
                    checkWin()
                }
            }
        }

    }

    fun second_first(v: View) {
        if (binding.secondFirst.text == " ") {
            if (startCheck) {
                binding.secondFirst.text = currentlyKey
                secondFirst = currentlyKey
                typeCheck = 4
                setCurrentlyKey()
                if (binding.secondFirst.text != " ") {
                    checkWin()
                }
            }
        }

    }

    fun second_second(v: View) {
        if (binding.secondSecond.text == " ") {
            if (startCheck) {
                binding.secondSecond.text = currentlyKey
                secondSecond = currentlyKey
                typeCheck = 5
                setCurrentlyKey()
                if (binding.secondSecond.text != " ") {
                    checkWin()
                }
            }
        }

    }

    fun second_third(v: View) {
        if (binding.secondThird.text == " ") {
            if (startCheck) {
                binding.secondThird.text = currentlyKey
                secondThird = currentlyKey
                typeCheck = 6
                setCurrentlyKey()
                if (binding.secondThird.text != " ") {
                    checkWin()
                }
            }
        }

    }

    fun third_first(v: View) {
        if (binding.thirdFirst.text == " ") {
            if (startCheck) {
                binding.thirdFirst.text = currentlyKey
                thirdFirst = currentlyKey
                typeCheck = 7
                setCurrentlyKey()
                if (binding.thirdFirst.text != " ") {
                    checkWin()
                }
            }
        }

    }

    fun third_second(v: View) {
        if (binding.thirdSecond.text == " ") {
            if (startCheck) {
                binding.thirdSecond.text = currentlyKey
                thirdSecond = currentlyKey
                typeCheck = 8
                setCurrentlyKey()
                if (binding.thirdSecond.text != " ") {
                    checkWin()
                }
            }
        }

    }

    fun third_third(v: View) {
        if (binding.thirdThird.text == " ") {
            if (startCheck) {
                binding.thirdThird.text = currentlyKey
                thirdThird = currentlyKey
                typeCheck = 9
                setCurrentlyKey()
                if (binding.thirdThird.text != " ") {
                    checkWin()
                }
            }
        }

    }

    // Points
    fun checkWin() {

        when (typeCheck) {
            // FIRST LINE
            // first first
            1 -> {
                firstLine()
                firstColumn()
                leftRightDiagonal()
            }

            // first Second
            2 -> {
                firstLine()
                secondColumn()
            }

            // first Third
            3 -> {
                firstLine()
                thirdColumn()
                rightLeftDiagonal()
            }

            // SECOND LINE
            // Second first
            4 -> {
                secondLine()
                firstColumn()
            }

            // Second second
            5 -> {
                secondColumn()
                secondLine()
                leftRightDiagonal()
                rightLeftDiagonal()
            }

            // Second third
            6 -> {
                secondLine()
                thirdColumn()
            }

            // THIRD LINE
            // third first
            7 -> {
                thirdLine()
                firstColumn()
                rightLeftDiagonal()
            }
            // third second
            8 -> {
                thirdLine()
                secondColumn()
            }

            // third third
            9 -> {
                thirdLine()
                thirdColumn()
            }

        }
    }

    fun firstLine() {
        if (!win && startCheck) {
            win = firstFirst == firstSecond && firstSecond == firstThird
            if (win) {
                binding.secondFirst.setTextColor(ContextCompat.getColor(this, R.color.winning))
                binding.secondSecond.setTextColor(ContextCompat.getColor(this, R.color.winning))
                binding.secondThird.setTextColor(ContextCompat.getColor(this, R.color.winning))
            }
            setPoint()
        }
        win = false
    }

    fun secondLine() {
        if (!win && startCheck) {
            win = secondFirst == secondSecond && secondSecond == secondThird
            if (win) {
                binding.secondFirst.setTextColor(ContextCompat.getColor(this, R.color.winning))
                binding.secondSecond.setTextColor(ContextCompat.getColor(this, R.color.winning))
                binding.secondThird.setTextColor(ContextCompat.getColor(this, R.color.winning))
            }
            setPoint()
        }
        win = false
    }

    fun thirdLine() {
        if (!win && startCheck) {
            win = thirdFirst == thirdSecond && thirdSecond == thirdThird
            if (win) {
                binding.thirdFirst.setTextColor(ContextCompat.getColor(this, R.color.winning))
                binding.thirdSecond.setTextColor(ContextCompat.getColor(this, R.color.winning))
                binding.thirdThird.setTextColor(ContextCompat.getColor(this, R.color.winning))
            }
            setPoint()
        }
        win = false
    }

    fun firstColumn() {
        if (!win && startCheck) {
            win = firstFirst == secondFirst && secondFirst == thirdFirst
            if (win) {
                binding.firstFirst.setTextColor(ContextCompat.getColor(this, R.color.winning))
                binding.secondFirst.setTextColor(ContextCompat.getColor(this, R.color.winning))
                binding.thirdFirst.setTextColor(ContextCompat.getColor(this, R.color.winning))
            }
            setPoint()
        }
        win = false
    }

    fun secondColumn() {
        if (!win && startCheck) {
            win = firstSecond == secondSecond && secondSecond == thirdSecond
            if (win) {
                binding.firstSecond.setTextColor(ContextCompat.getColor(this, R.color.winning))
                binding.secondSecond.setTextColor(ContextCompat.getColor(this, R.color.winning))
                binding.thirdSecond.setTextColor(ContextCompat.getColor(this, R.color.winning))
            }
            setPoint()
        }
        win = false
    }

    fun thirdColumn() {
        if (!win && startCheck) {
            win = firstThird == secondThird && secondThird == thirdThird
            if (win) {
                binding.firstThird.setTextColor(ContextCompat.getColor(this, R.color.winning))
                binding.secondThird.setTextColor(ContextCompat.getColor(this, R.color.winning))
                binding.thirdThird.setTextColor(ContextCompat.getColor(this, R.color.winning))
            }
            setPoint()
        }
        win = false
    }

    fun leftRightDiagonal() {
        if (!win && startCheck) {
            win = firstFirst == secondSecond && secondSecond == thirdThird
            if (win) {
                binding.firstFirst.setTextColor(ContextCompat.getColor(this, R.color.winning))
                binding.secondSecond.setTextColor(ContextCompat.getColor(this, R.color.winning))
                binding.thirdThird.setTextColor(ContextCompat.getColor(this, R.color.winning))
            }
            setPoint()
        }
        win = false
    }

    fun rightLeftDiagonal() {
        if (!win && startCheck) {
            win = firstThird == secondSecond && secondSecond == thirdFirst
            if (win) {
                binding.firstThird.setTextColor(ContextCompat.getColor(this, R.color.winning))
                binding.secondSecond.setTextColor(ContextCompat.getColor(this, R.color.winning))
                binding.thirdFirst.setTextColor(ContextCompat.getColor(this, R.color.winning))
            }
            setPoint()
        }
        win = false
    }

    // Set point
    fun setPoint() {
        if (win) {
            if (currentlyKey == "O") {
                pointsX++
                setPointValue()
                win = false
                startCheck = false
                setPointColor()
                setWin()
            } else if (currentlyKey == "X") {
                pointsO++
                setPointValue()
                win = false
                startCheck = false
                setPointColor()
                setWin()
            }
            win = false
        }
    }

    fun setWin() {

    }

    fun setPointColor() {
        if (pointsO > pointsX) {
            binding.oValue.setBackgroundColor(ContextCompat.getColor(this, R.color.winning))
            binding.xValue.setBackgroundColor(ContextCompat.getColor(this, R.color.gray))
        } else if (pointsX > pointsO) {
            binding.xValue.setBackgroundColor(ContextCompat.getColor(this, R.color.winning))
            binding.oValue.setBackgroundColor(ContextCompat.getColor(this, R.color.gray))
        } else if (pointsX == pointsO && pointsX != 0) {
            binding.xValue.setBackgroundColor(ContextCompat.getColor(this, R.color.draw_point))
            binding.oValue.setBackgroundColor(ContextCompat.getColor(this, R.color.draw_point))
        } else {
            binding.xValue.setBackgroundColor(ContextCompat.getColor(this, R.color.gray))
            binding.oValue.setBackgroundColor(ContextCompat.getColor(this, R.color.gray))
        }
    }

    fun setPointValue() {
        binding.oValue.text = pointsO.toString()
        binding.xValue.text = pointsX.toString()
    }

    fun setDraw(v: View?) {
        startCheck = true
        setReset()
        pointsX++
        pointsO++
        setPointValue()
        setPointColor()
        resetTicColor()
    }

    fun newPoint(v: View?) {
        startCheck = true
        setReset()
        setPointValue()
        setPointColor()
        resetTicColor()
    }

    private fun resetTicColor() {

        if (checkedThemeGlobal) {
            binding.firstFirst.setTextColor(ContextCompat.getColor(this, R.color.white))
            binding.firstSecond.setTextColor(ContextCompat.getColor(this, R.color.white))
            binding.firstThird.setTextColor(ContextCompat.getColor(this, R.color.white))
            binding.secondFirst.setTextColor(ContextCompat.getColor(this, R.color.white))
            binding.secondSecond.setTextColor(ContextCompat.getColor(this, R.color.white))
            binding.secondThird.setTextColor(ContextCompat.getColor(this, R.color.white))
            binding.thirdFirst.setTextColor(ContextCompat.getColor(this, R.color.white))
            binding.thirdSecond.setTextColor(ContextCompat.getColor(this, R.color.white))
            binding.thirdThird.setTextColor(ContextCompat.getColor(this, R.color.white))
        } else {
            binding.firstFirst.setTextColor(ContextCompat.getColor(this, R.color.black))
            binding.firstSecond.setTextColor(ContextCompat.getColor(this, R.color.black))
            binding.firstThird.setTextColor(ContextCompat.getColor(this, R.color.black))
            binding.secondFirst.setTextColor(ContextCompat.getColor(this, R.color.black))
            binding.secondSecond.setTextColor(ContextCompat.getColor(this, R.color.black))
            binding.secondThird.setTextColor(ContextCompat.getColor(this, R.color.black))
            binding.thirdFirst.setTextColor(ContextCompat.getColor(this, R.color.black))
            binding.thirdSecond.setTextColor(ContextCompat.getColor(this, R.color.black))
            binding.thirdThird.setTextColor(ContextCompat.getColor(this, R.color.black))
        }


    }
}