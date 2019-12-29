package example.com.kotlintest.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import example.com.kotlintest.R

class AFragment : Fragment() {

    private var text_fragment: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
        val view : View = inflater.inflate(R.layout.fragment_test, container, false)
        findView(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun findView(view : View?) {
//        var b : Bundle? = arguments
//        var bundleString : String = b!!.getString("bundle", "")
        val args = arguments
        Log.d("args", args.toString())
        var bundleString : String? = args?.getString("bundle", "")
        text_fragment = view?.findViewById(R.id.text_fragment)
        text_fragment?.setText("this is AFragment " + bundleString)
    }


}