package com.yfl.navigation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.yfl.navigation.databinding.FragmentOneBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentOne.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentOne : Fragment() {
     lateinit var fragmentOneBinding: FragmentOneBinding
    private var param1: String? = null
    private var param2: String? = null
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentOne().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentOneBinding= FragmentOneBinding.inflate(layoutInflater,container,false)
        return fragmentOneBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentOneBinding.btnStartFragmentTwo.setOnClickListener {
            val data=Bundle().apply {
                putString("name","小明")
            }
            it.findNavController().navigate(R.id.action_fragmentOne_to_fragmentTwo,data)
        }
        fragmentOneBinding.btnStartTest.setOnClickListener {
            startActivity(Intent(activity,TestActivity::class.java))
        }


    }


}