package com.example.myandroid.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.myandroid.R
import com.example.myandroid.databinding.FragmentFirstBinding

class FirstFragment : BaseFragment() {

    private val binding: FragmentFirstBinding by lazy {
        FragmentFirstBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(logTag, "onCreateView")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnNext.setOnClickListener {
            (activity as? ExampleFragmentActivity)?.run {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace<SecondFragment>(R.id.fragment_container_view)
                    addToBackStack(null)
                }
            }
        }
    }
}