package example.com.kotlintest.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import example.com.kotlintest.R

class RomeNumberActivity : AppCompatActivity() {

    var editNumber : EditText? = null
    var btnConvert : Button? = null
    var textAnswer : TextView? = null
    private val buttonClickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.btn_convert -> {
                if(editNumber?.text.toString().trim() != "" && editNumber?.text.toString().trim().matches("-?\\d+(\\.\\d+)?".toRegex())) {
                    textAnswer?.text = covertNumberToRomeNumber(editNumber?.text.toString().trim())
                    editNumber?.text?.clear()
                } else {
                    Toast.makeText(this@RomeNumberActivity, "You not enter number", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_romenumber)
        findView()
    }

    private fun findView() {
        editNumber = findViewById(R.id.edit_number)
        btnConvert = findViewById(R.id.btn_convert)
        textAnswer = findViewById(R.id.text_answer)
        btnConvert?.setOnClickListener(buttonClickListener)
    }

    private fun covertNumberToRomeNumber(number : String) : String {

        val numberInt = number.toInt()
        var romeNumber = ""

        when (numberInt) {

            in 100..100 -> {
                romeNumber = "C"
            }

            in 50..89 -> {
                romeNumber = "L"
                if(numberInt - 50 > 0 && (numberInt - 50) / 10 > 0) {
                    // 十位數
                    for(i in 1..(numberInt - 50) / 10) {
                        romeNumber = romeNumber.plus("X")
                    }
                }
                if(numberInt - 50 > 0 && (numberInt - 50) % 10 > 0) {
                    // 個位數
                    when {
                        (numberInt - 50) % 10 >= 5 -> {
                            romeNumber = romeNumber.plus("V")
                            for(i in 1..((numberInt - 50) % 10) - 5) {
                                romeNumber = romeNumber.plus("I")
                            }
                        }
                        (numberInt - 50) % 10 in 1..3 -> {
                            for(i in 1..3) {
                                romeNumber = romeNumber.plus("I")
                            }
                            romeNumber = romeNumber.plus("V")
                        }
                        else -> romeNumber = romeNumber.plus("I").plus("V")
                    }
                }
            }

            in 1..3 -> {
                for(i in 1..numberInt) {
                    romeNumber = romeNumber.plus("I")
                }
            }

            in 7..8 -> {

            }

        }

        return romeNumber

    }

}