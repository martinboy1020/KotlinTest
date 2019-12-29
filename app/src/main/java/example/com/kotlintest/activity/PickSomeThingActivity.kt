package example.com.kotlintest.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import example.com.kotlintest.R

class PickSomeThingActivity : AppCompatActivity() {

    private var btnPick : Button? = null
    private var btnAdd : Button? = null
    private var editWish : EditText? = null
    private var textSomething : TextView? = null
    private val bucketList = mutableListOf("Go Skiing", "Go Diving", "Horse Riding")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_something)
        findView()
        btnPick?.setOnClickListener {
            val random = (Math.random() * bucketList.count()).toInt()
            textSomething?.text = bucketList[random]
        }
        btnAdd?.setOnClickListener{
            val textWish = editWish?.text.toString()
//            if(textWish != "" && !bucketList.contains(textWish)) {
//                bucketList.add(textWish)
//            } else {
//                if(textWish == "") {
//                    Toast.makeText(this, "No Text", Toast.LENGTH_SHORT).show()
//                } else {
//                    Toast.makeText(this, "This Thing is Added", Toast.LENGTH_SHORT).show()
//                }
//            }

            when {
                textWish != "" && !bucketList.contains(textWish) -> bucketList.add(textWish)
                else -> when (textWish) {
                    "" -> Toast.makeText(this, "No Text", Toast.LENGTH_SHORT).show()
                    else -> Toast.makeText(this, "This Thing is Added", Toast.LENGTH_SHORT).show()
                }
            }

            editWish?.text?.clear()
        }
    }

    private fun findView() {
        btnPick = findViewById(R.id.btn_pick)
        btnAdd = findViewById(R.id.btn_add)
        editWish = findViewById(R.id.edit_wish)
        textSomething = findViewById(R.id.text_something)
    }
}