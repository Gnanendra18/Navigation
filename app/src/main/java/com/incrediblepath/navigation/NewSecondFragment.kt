package com.incrediblepath.navigation

import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.navArgs


class NewSecondFragment : Fragment() {

    val args: NewSecondFragmentArgs by navArgs<NewSecondFragmentArgs>()
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_new_second, container, false)
        val textView = view.findViewById<TextView>(R.id.default_args)
        textView.text = args.data
        textView.setTextColor(activity!!.resources.getColor(R.color.material_dynamic_primary10,activity?.theme))
        return view
    }


}