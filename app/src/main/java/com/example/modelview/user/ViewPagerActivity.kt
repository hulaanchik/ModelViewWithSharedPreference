package com.example.modelview.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.modelview.R
import com.example.modelview.SecondSlideFragment

private val Num_pages = 2
private const val MIN_SCALE = 0.85f
private const val MIN_ALPHA = 0.5f

class ViewPagerActivity : AppCompatActivity() {

    private lateinit var mPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        mPager = findViewById(R.id.pager)

        val pagerAdapter = SlideAdapter(supportFragmentManager)
        mPager.adapter = pagerAdapter
        val pageMargin = 30f
        val pageOffset = 30f
        mPager!!.setPageTransformer(false, ViewPager.PageTransformer { page, position ->
            val mOffset = position * -(2 * pageOffset + pageMargin)
            page.apply {
                val pageWidth = width
                val pageHeight = height
                when {
                    position < -1 -> {
                        alpha = 0f
                    }
                    position <= 1 -> {
                        val scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position))
                        val vertMargin = pageHeight * (1 - scaleFactor) / 2
                        val horzMargin = pageWidth * (1 - scaleFactor) / 2
                        translationX = if (position < 0) {
                            horzMargin - vertMargin / 2
                        } else {
                            horzMargin + vertMargin / 2
                        }

                        scaleX = scaleFactor
                        scaleY = scaleFactor

                        alpha = (MIN_ALPHA +
                                (((scaleFactor - MIN_SCALE) / (1 - MIN_SCALE)) * (1 - MIN_ALPHA)))
                    }
                    else -> {
                        alpha = 0f
                    }
                }
            }
        })
    }

    override fun onBackPressed() {
        if (mPager.currentItem == 0){
            super.onBackPressed()
        } else {
            mPager.currentItem = mPager.currentItem - 1
        }
    }

    private inner class SlideAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        override  fun getCount(): Int {
            return Num_pages
        }
        override  fun getItem(position: Int) : Fragment {
            var fragment: Fragment? = null
            when (position) {
                0 -> fragment = DataFragment()
                1 -> fragment = SecondSlideFragment()
            }
            return fragment!!
        }
    }
}