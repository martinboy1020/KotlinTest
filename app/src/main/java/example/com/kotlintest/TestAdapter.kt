package example.com.kotlintest

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView

class TestAdapter internal constructor(private val navigationList: List<TestItem>) : RecyclerView.Adapter<TestAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return navigationList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = navigationList[position]
        holder.title.text = item.title
//        holder.layout_item.setOnClickListener(View.OnClickListener {
//            Toast.makeText(it.context, item.title, Toast.LENGTH_SHORT).show()
//        })

//        holder.layout_item.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                Toast.makeText(v!!.context, item.title, Toast.LENGTH_SHORT).show()
//            }
//        })

        holder.layout_item.setOnClickListener(buttonClickListener)
    }

    inner class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.title)
        var layout_item: RelativeLayout = view.findViewById(R.id.layout_item)
//        var year: TextView = view.findViewById(R.id.year)
//        var genre: TextView = view.findViewById(R.id.genre)
    }

    private val buttonClickListener = View.OnClickListener { view ->
        clickEvent(view.id)
    }

    private fun clickEvent(id : Int?) {

    }
}