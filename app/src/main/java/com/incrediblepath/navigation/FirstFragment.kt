package com.incrediblepath.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation


class FirstFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_first, container, false)
        view.setOnClickListener{

            //one way of Navigation
            //Navigation.findNavController(view).navigate(R.id.navigate_to_second)

            //Second way of Navigation
            //val action = FirstFragmentDirections.navigateToSecond()
            //Navigation.findNavController(view).navigate(action)

            //Third way of Navigation with arguments specifically from code
            val action = FirstFragmentDirections.navigateToSecond("These arguments are sending from code")
            Navigation.findNavController(view).navigate(action)

        }
        return view;
    }

}