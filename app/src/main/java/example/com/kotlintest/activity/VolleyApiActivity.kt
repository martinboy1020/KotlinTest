package example.com.kotlintest.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import example.com.kotlintest.volleytool.JavaVolley


class VolleyApiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getData()
    }

    private fun getData() {
//        val volleyTool = VolleyTool()
//        volleyTool.runNetApi(this)
        val javaVolley = JavaVolley()
        javaVolley.runNetApi(this)
    }
}