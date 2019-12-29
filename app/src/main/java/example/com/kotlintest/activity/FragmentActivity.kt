package example.com.kotlintest.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import example.com.kotlintest.R
import example.com.kotlintest.fragment.TestFragment

class FragmentActivity : AppCompatActivity() {

    private val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        firstSwitchToFragment(TestFragment::class.java, null, false)
    }

    private fun firstSwitchToFragment(nextFragmentClass: Class<out Fragment>, args: Bundle?, needStack: Boolean?) {

        val trans = manager.beginTransaction()
        val frag: Fragment = nextFragmentClass.newInstance()
        val tag: String = nextFragmentClass.simpleName

        Log.d("tag1", "trans $trans")
        Log.d("tag1", "frag $frag")
        Log.d("tag1", "tag $tag")
        Log.d("tag1", "needStack $needStack")

        trans.setCustomAnimations(R.anim.poc_fade_entry_from_right, R.anim.poc_fade_exit_from_left,
                R.anim.poc_fade_entry_from_left, R.anim.poc_fade_exit_from_right)

        trans.replace(R.id.layout_main, frag, tag)

        when {
            args != null -> frag.arguments = args
        }

        when {
            needStack != null && needStack -> trans.addToBackStack(tag)
        }

        trans.commitAllowingStateLoss()
    }

    fun switchToFragment(nextFragmentClass: Class<out Fragment>, args: Bundle?, needStack: Boolean?) {

        val trans = manager.beginTransaction()
        val frag: Fragment = nextFragmentClass.newInstance()
        val tag: String = nextFragmentClass.simpleName

        Log.d("tag1", "trans $trans")
        Log.d("tag1", "frag $frag")
        Log.d("tag1", "tag $tag")
        Log.d("tag1", "args $args")
        Log.d("tag1", "needStack $needStack")

        trans.setCustomAnimations(R.anim.poc_fade_entry_from_right, R.anim.poc_fade_exit_from_left,
                R.anim.poc_fade_entry_from_left, R.anim.poc_fade_exit_from_right)

        val ls : List<Fragment> = manager.fragments
        for(i in ls) {
            trans.hide(i)
        }

        if(frag.isAdded) {
            trans.show(frag)
        } else {
            trans.add(R.id.layout_main, frag, tag)
        }

        when {
            args != null -> frag.arguments = args
        }

        when {
            needStack != null && needStack -> trans.addToBackStack(tag)
        }

        trans.commitAllowingStateLoss()

    }
}