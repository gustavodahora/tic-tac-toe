package com.example.tik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.tik.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var checkedThemeGlobal = false
    private var currentlyKey = "O"
    private var typeCheck = 1
    var firstFirst = "-"
    var firstSecond = "-"
    var firstThird = "-"
    var secondFirst = "-"
    var secondSecond = "-"
    var secondThird = "-"
    var thirdFirst = "-"
    var thirdSecond = "-"
    var thirdThird = "-"
    var checkOne = false
    var checkTwo = false
    var checkThree = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
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

    fun reset(v: View) {
        binding.firstFirst.text = "-"
        binding.firstSecond.text = "-"
        binding.firstThird.text = "-"
        binding.secondFirst.text = "-"
        binding.secondSecond.text = "-"
        binding.secondThird.text = "-"
        binding.thirdFirst.text = "-"
        binding.thirdSecond.text = "-"
        binding.thirdThird.text = "-"
    }

    fun first_first(v: View) {
        binding.firstFirst.text = currentlyKey
        firstFirst = currentlyKey
        typeCheck = 1
        setCurrentlyKey()
        checkWin()
    }

    fun first_second(v: View) {
        binding.firstSecond.text = currentlyKey
        firstSecond = currentlyKey
        typeCheck = 3
        setCurrentlyKey()
        checkWin()
    }

    fun first_third(v: View) {
        typeCheck = 8
        binding.firstThird.text = currentlyKey
        firstThird = currentlyKey
        setCurrentlyKey()
        checkWin()
    }

    fun second_first(v: View) {
        binding.secondFirst.text = currentlyKey
        secondFirst = currentlyKey
        typeCheck = 6
        setCurrentlyKey()
        checkWin()
    }

    fun second_second(v: View) {
        binding.secondSecond.text = currentlyKey
        secondSecond = currentlyKey
        setCurrentlyKey()
        typeCheck = 7
        checkWin()
    }

    fun second_third(v: View) {
        binding.secondThird.text = currentlyKey
        secondThird = currentlyKey
        setCurrentlyKey()
        typeCheck = 4
        checkWin()
    }

    fun third_first(v: View) {
        binding.thirdFirst.text = currentlyKey
        thirdFirst = currentlyKey
        setCurrentlyKey()
        typeCheck = 9
        checkWin()
    }

    fun third_second(v: View) {
        binding.thirdSecond.text = currentlyKey
        thirdSecond = currentlyKey
        setCurrentlyKey()
        typeCheck = 5
        checkWin()
    }

    fun third_third(v: View) {
        binding.thirdThird.text = currentlyKey
        thirdThird = currentlyKey
        setCurrentlyKey()
        typeCheck = 2
        checkWin()
    }

    // Points
    fun checkWin() {
        when (typeCheck) {
            // first first
            1 -> {
                checkOne = firstFirst == firstSecond && firstSecond == firstThird
                checkTwo = firstFirst == secondFirst && secondFirst == thirdFirst
                checkThree = firstFirst == secondSecond && secondSecond == thirdThird
                getWin()
            }
            // third third
            2 -> {
                checkOne = firstThird == secondThird && secondThird == thirdThird
                checkTwo = thirdFirst == thirdSecond && thirdSecond == thirdThird
                checkThree = firstFirst == secondSecond && secondSecond == thirdThird
                getWin()
            }

            // first Second
            3 -> {
                Toast.makeText(applicationContext, "chama", Toast.LENGTH_SHORT).show()

                checkOne = firstFirst == firstSecond && firstSecond == firstThird
                checkTwo = secondFirst == secondSecond && secondSecond == secondThird
                checkThree = true
                getWin()
                checkThree = false
            }
            // second third
            4 -> {
                checkOne = secondFirst == secondSecond && secondSecond == secondThird
                checkTwo = firstThird == secondThird && secondThird == thirdThird
                checkThree = true
                getWin()
                checkThree = false

            } // third second
            5 -> {
                checkOne = firstThird == secondThird && secondThird == thirdThird
                checkTwo = thirdFirst == thirdSecond && thirdSecond == thirdThird
                checkThree = true
                getWin()
                checkThree = false

            } // Second first
            6 -> {
                checkOne = secondFirst == secondSecond && secondSecond == secondThird
                checkTwo = firstFirst == firstSecond && firstSecond == firstThird
                checkThree = true
                getWin()
                checkThree = false
            }
            // second second
            7 -> {
                checkOne = secondFirst == secondSecond && secondSecond == secondThird
                checkTwo = firstSecond == secondSecond && secondSecond == thirdSecond
//                firstThird == secondSecond && secondSecond == thirdFirst
                checkThree = true
                getWin()
                checkThree = false
            }
            // first third
            8 -> {
                checkOne = firstFirst == firstSecond && firstSecond == firstThird
                checkTwo = firstFirst == secondFirst && secondFirst == thirdFirst
                checkThree = firstFirst == secondSecond && secondSecond == thirdThird
                getWin()
            }
            // third first
            9 -> {
                checkOne = firstThird == secondThird && secondThird == thirdThird
                checkTwo = thirdFirst == thirdSecond && thirdSecond == thirdThird
                checkThree = firstFirst == secondSecond && secondSecond == thirdThird
                getWin()
            }
        }
    }

    fun getWin() {

        if (checkOne || checkTwo || checkThree) {
//            Toast.makeText(applicationContext, "chama", Toast.LENGTH_SHORT).show()
        }
    }
}