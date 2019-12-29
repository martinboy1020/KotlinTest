package example.com.kotlintest.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import example.com.kotlintest.R
import example.com.kotlintest.activity.FragmentActivity

class TestFragment : Fragment() {

    private var text_fragment: TextView? = null
    private var btn_go: Button? = null
    private var mAct: FragmentActivity? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("tag1", "TestFragment onCreateView")
        val view : View = inflater.inflate(R.layout.fragment_test, container, false)
        findView(view)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mAct = context as FragmentActivity?
    }

    private fun findView(view : View?) {
        text_fragment = view?.findViewById(R.id.text_fragment)
        text_fragment?.setText("this is Test Fragment")
        btn_go = view?.findViewById(R.id.btn_go)
        btn_go?.setText("go to AFragment")
        val bundle = Bundle()
        bundle.putString("bundle", "from Test Fragment")
        btn_go?.setOnClickListener {
            mAct?.switchToFragment(AFragment::class.java, bundle, true)
        }
    }

}