package example.com.kotlintest.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import example.com.kotlintest.R

class MainActivity : AppCompatActivity() {

    private lateinit var btnActivityRecycleView : Button
    private var btnActivityPickSomething : Button? = null
    private var btnActivityFragment : Button? = null
    private var btnActivityRomeNumber : Button? = null
    private var btnActivityNetApiRetroFit : Button? = null
    private var btnActivityRetrofitTest : Button? = null
    private var btnActivityVolleytTest : Button? = null
    private val buttonClickListener = View.OnClickListener { view ->
        setGoToPage(view.id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findView()
        setOnClick()
    }

    private fun findView() {
        btnActivityRecycleView = findViewById(R.id.btn_activity_recycle_view)
        btnActivityPickSomething = findViewById(R.id.btn_activity_pick_something)
        btnActivityFragment = findViewById(R.id.btn_activity_fragment)
        btnActivityRomeNumber = findViewById(R.id.btn_activity_rome_number)
        btnActivityNetApiRetroFit = findViewById(R.id.btn_activity_net_api_retrofit)
        btnActivityRetrofitTest = findViewById(R.id.btn_activity_retrofit_test)
        btnActivityVolleytTest = findViewById(R.id.btn_activity_volley_test)
    }

    private fun setOnClick() {
        btnActivityRecycleView.setOnClickListener(buttonClickListener)
        btnActivityPickSomething?.setOnClickListener(buttonClickListener)
        btnActivityFragment?.setOnClickListener(buttonClickListener)
        btnActivityRomeNumber?.setOnClickListener(buttonClickListener)
        btnActivityNetApiRetroFit?.setOnClickListener(buttonClickListener)
        btnActivityRetrofitTest?.setOnClickListener(buttonClickListener)
        btnActivityVolleytTest?.setOnClickListener(buttonClickListener)
    }

    private fun setGoToPage(id : Int?) {

        when(id) {
            R.id.btn_activity_recycle_view -> {
                val intent = Intent(this@MainActivity, RecycleViewActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_activity_pick_something -> {
                val intent = Intent(this@MainActivity, PickSomeThingActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_activity_fragment -> {
                val intent = Intent(this@MainActivity, FragmentActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_activity_rome_number -> {
                val intent = Intent(this@MainActivity, RomeNumberActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_activity_net_api_retrofit -> {
                val intent = Intent(this@MainActivity, NetApiActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_activity_retrofit_test -> {
                val intent = Intent(this@MainActivity, RetrofitApiTestActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_activity_volley_test -> {
                val intent = Intent(this@MainActivity, VolleyApiActivity::class.java)
                startActivity(intent)
            }
        }

    }

}
