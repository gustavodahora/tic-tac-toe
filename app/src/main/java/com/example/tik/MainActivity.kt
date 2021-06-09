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
    }

    // RESET
    fun reset(v: View) {
        setReset()
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
        binding.firstFirst.text = currentlyKey
        firstFirst = currentlyKey
        typeCheck = 1
        setCurrentlyKey()
        if (binding.firstFirst.text != " ") {
            checkWin()
        }
    }

    fun first_second(v: View) {
        binding.firstSecond.text = currentlyKey
        firstSecond = currentlyKey
        typeCheck = 2
        setCurrentlyKey()
        if (binding.firstSecond.text != " ") {
            checkWin()
        }
    }

    fun first_third(v: View) {
        typeCheck = 3
        binding.firstThird.text = currentlyKey
        firstThird = currentlyKey
        setCurrentlyKey()
        if (binding.firstThird.text != " ") {
            checkWin()
        }
    }

    fun second_first(v: View) {
        binding.secondFirst.text = currentlyKey
        secondFirst = currentlyKey
        typeCheck = 4
        setCurrentlyKey()
        if (binding.secondFirst.text != " ") {
            checkWin()
        }
    }

    fun second_second(v: View) {
        binding.secondSecond.text = currentlyKey
        secondSecond = currentlyKey
        typeCheck = 5
        setCurrentlyKey()
        if (binding.secondSecond.text != " ") {
            checkWin()
        }
    }

    fun second_third(v: View) {
        binding.secondThird.text = currentlyKey
        secondThird = currentlyKey
        typeCheck = 6
        setCurrentlyKey()
        if (binding.secondThird.text != " ") {
            checkWin()
        }
    }

    fun third_first(v: View) {
        binding.thirdFirst.text = currentlyKey
        thirdFirst = currentlyKey
        typeCheck = 7
        setCurrentlyKey()
        if (binding.thirdFirst.text != " ") {
            checkWin()
        }
    }

    fun third_second(v: View) {
        binding.thirdSecond.text = currentlyKey
        thirdSecond = currentlyKey
        typeCheck = 8
        setCurrentlyKey()
        if (binding.thirdSecond.text != " ") {
            checkWin()
        }
    }

    fun third_third(v: View) {
        binding.thirdThird.text = currentlyKey
        thirdThird = currentlyKey
        typeCheck = 9
        setCurrentlyKey()
        if (binding.thirdThird.text != " ") {
            checkWin()
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
                startCheck = true
            }

            // first Second
            2 -> {
                firstLine()
                secondColumn()
                startCheck = true
            }

            // first Third
            3 -> {
                firstLine()
                thirdColumn()
                rightLeftDiagonal()
                startCheck = true
            }

            // SECOND LINE
            // Second first
            4 -> {
                secondLine()
                firstColumn()
                startCheck = true
            }

            // Second second
            5 -> {
                secondColumn()
                secondLine()
                leftRightDiagonal()
                rightLeftDiagonal()
                startCheck = true
            }

            // Second third
            6 -> {
                secondLine()
                thirdColumn()
                startCheck = true
            }

            // THIRD LINE
            // third first
            7 -> {
                thirdLine()
                firstColumn()
                rightLeftDiagonal()
                startCheck = true
            }
            // third second
            8 -> {
                thirdLine()
                secondColumn()
                startCheck = true
            }

            // third third
            9 -> {
                thirdLine()
                thirdColumn()
                startCheck = true
            }

        }
    }
    fun firstLine() {
        if (!win && startCheck) {
            win = firstFirst == firstSecond && firstSecond == firstThird
            setPoint()
        }
        win = false
    }

    fun secondLine() {
        if (!win && startCheck) {
            win = secondFirst == secondSecond && secondSecond == secondThird
            setPoint()
        }
        win = false
    }

    fun thirdLine() {
        if (!win && startCheck) {
            win = thirdFirst == thirdSecond && thirdSecond == thirdThird
            setPoint()
        }
        win = false
    }

    fun firstColumn() {
        if (!win && startCheck) {
            win = firstFirst == secondFirst && secondFirst == thirdFirst
            setPoint()
        }
        win = false
    }

    fun secondColumn() {
        if (!win && startCheck) {
            win = firstSecond == secondSecond && secondSecond == thirdSecond
            setPoint()
        }
        win = false
    }

    fun thirdColumn() {
        if (!win && startCheck) {
            win = firstThird == secondThird && secondThird == thirdThird
            setPoint()
        }
        win = false
    }

    fun leftRightDiagonal() {
        if (!win && startCheck) {
            win = firstFirst == secondSecond && secondSecond == thirdThird
            setPoint()
        }
        win = false
    }

    fun rightLeftDiagonal() {
        if (!win && startCheck) {
            win = firstThird == secondSecond && secondSecond == thirdFirst
            setPoint()
        }
        win = false
    }

    // Set point
    fun setPoint() {

        if (win) {
            if (currentlyKey == "O") {
                pointsX++
                setReset()
                setPointValue()
                win = false
                startCheck = false
                setPointColor()
            } else if (currentlyKey == "X") {
                pointsO++
                setReset()
                setPointValue()
                win = false
                startCheck = false
                setPointColor()
            }
            win = false
        }
    }

    fun setPointColor() {
        if (pointsO > pointsX) {
            binding.oValue.setBackgroundColor(ContextCompat.getColor(this, R.color.winning))
            binding.xValue.setBackgroundColor(ContextCompat.getColor(this, R.color.gray))
        } else if (pointsX > pointsO) {
            binding.xValue.setBackgroundColor(ContextCompat.getColor(this, R.color.winning))
            binding.oValue.setBackgroundColor(ContextCompat.getColor(this, R.color.gray))
        } else {
            binding.xValue.setBackgroundColor(ContextCompat.getColor(this, R.color.draw_point))
            binding.oValue.setBackgroundColor(ContextCompat.getColor(this, R.color.draw_point))
        }
    }

    fun setPointValue() {
        binding.oValue.text = pointsO.toString()
        binding.xValue.text = pointsX.toString()
    }

}