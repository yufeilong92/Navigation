package com.yfl.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.yfl.navigation.databinding.FragmentTwoBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentTwo.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentTwo : Fragment() {
    private var param1: String? = null
    lateinit var fragmentTwoBinding: FragmentTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString("name")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentTwoBinding= FragmentTwoBinding.inflate(layoutInflater,container,false)
        return fragmentTwoBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentTwoBinding.tvContent.text="接受到的参数:$param1"
        fragmentTwoBinding.btnStartfragmentThree.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragmentTwo_to_fragmentThree)
        }
    }
}