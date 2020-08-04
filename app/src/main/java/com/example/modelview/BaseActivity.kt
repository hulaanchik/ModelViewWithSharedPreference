package com.smartbank.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import com.example.modelview.R
import java.util.*


abstract class BaseActivity : AppCompatActivity(), LifecycleOwner {
    private lateinit var context: Context

    private var stack = Stack<Fragment>()
    var blockedBack: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //(this)
        context = this
    }

    fun blockBackPress(block: Boolean) {
        blockedBack = block
    }

    override fun onBackPressed() {
        if (blockedBack) {
            return
        }

        val preIndex = stack.size - 2;
        pop(preIndex)
    }

    fun popToEmpty() {
        while (stack.size > 0) {
            supportFragmentManager.popBackStackImmediate()
            stack.pop()
        }
    }

    private fun pop(index: Int) {
        if(index < 0) {
            super.finish()
            return
        }

        while (stack.size > index+1) {
            supportFragmentManager.popBackStackImmediate()
            stack.pop()
        }
        currentFragment()?.onResume()
    }


    fun addFragment(fragmentToAdd: Fragment, stateLoss: Boolean = false) {
        if (!isFinishing) {
            if (currentFragment() == null) {
                replaceFragment(fragmentToAdd)
                return
            }

            if (currentFragment() != fragmentToAdd) {
                val fm: FragmentManager = supportFragmentManager
                val transaction = fm.beginTransaction()
                currentFragment()?.let { transaction.hide(it) }

                stack.push(fragmentToAdd)
                transaction.add(R.id.fragment2, fragmentToAdd).addToBackStack(null)
                if (stateLoss)
                    transaction.commitAllowingStateLoss()
                else
                    transaction.commit()
            }
        }
    }

    fun currentFragment(): Fragment? {
        return if (stack.isEmpty()) null else stack.peek()
    }

    fun replaceFragment(fragmentToAdd: Fragment?, stateLoss: Boolean = false) {
        if (fragmentToAdd == null) return
        replaceFragment(fragmentToAdd, "", stateLoss)
    }


    fun replaceFragment(fragmentToAdd: Fragment?) {
        if (fragmentToAdd == null) return
        replaceFragment(fragmentToAdd, "")
    }

    fun replaceFragment(
        fragmentToAdd: Fragment,
        transitionName: String,
        stateLoss: Boolean = false
    ) {
        val fm: FragmentManager = supportFragmentManager
        val transaction = fm.beginTransaction()



        stack.clear()
        stack.push(fragmentToAdd)
        transaction.replace(R.id.fragment2, fragmentToAdd).addToBackStack(null)
        if (stateLoss)
            transaction.commitAllowingStateLoss()
        else
            transaction.commit()

    }

    fun popTo(index: Int) {
        pop(index)
    }

    override fun onDestroy() {
        super.onDestroy()
        stack.clear()
    }

}