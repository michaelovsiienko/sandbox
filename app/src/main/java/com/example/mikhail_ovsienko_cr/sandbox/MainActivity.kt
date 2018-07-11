package com.example.mikhail_ovsienko_cr.sandbox

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.mikhail_ovsienko_cr.sandbox.main.MainFrag
import com.example.mikhail_ovsienko_cr.sandbox.map.MapFrag
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.bundleOf

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        replaceFragment(newFragmentInstance<MainFrag>(), false)

        replaceFragment(newFragmentInstance<MapFrag>())
    }


    protected fun replaceFragment(fragment: Fragment, needToAddToBackStack: Boolean = true) {
        val name = fragment.javaClass.simpleName
        supportFragmentManager.beginTransaction().apply {
            replace(container.id, fragment, name)
            if (needToAddToBackStack) addToBackStack(name)
        }.commit()
    }

    protected inline fun <reified T : Fragment> newFragmentInstance(vararg params: Pair<String, Any?>) =
            T::class.java.newInstance().apply {
                arguments = bundleOf(*params)
            }
}
