package example.com.kotlintest.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import example.com.kotlintest.R
import example.com.kotlintest.TestAdapter
import example.com.kotlintest.TestItem

class RecycleViewActivity : AppCompatActivity() {

    var recyclerView: RecyclerView? = null
    val userItems = ArrayList<TestItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)

        findView()
        initData()
        setData()

    }

    private fun findView() {
        recyclerView = findViewById(R.id.recycler_view)
    }

    private fun initData() {
        for(index in 0..4) {
            userItems.add(TestItem("測試$index"))
        }
    }

    private fun setData() {
        val tAdapter = TestAdapter(userItems)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.adapter = tAdapter
        tAdapter.notifyDataSetChanged()
    }

}