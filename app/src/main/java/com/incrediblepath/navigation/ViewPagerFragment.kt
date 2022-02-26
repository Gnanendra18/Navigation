package com.incrediblepath.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2


class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)
        val viewpager = view.findViewById<ViewPager2>(R.id.view_pager)
        viewpager.adapter = ViewPagerAdapter(
            arrayListOf<Fragment>(
                FirstFragment(),
                FirstFragment(),
                FirstFragment()
            ), activity!!.supportFragmentManager, lifecycle
        )
        return view;
    }

}