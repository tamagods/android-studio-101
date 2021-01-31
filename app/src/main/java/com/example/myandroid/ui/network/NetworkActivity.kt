package com.example.myandroid.ui.network

import android.os.Bundle
import android.util.Log
import com.example.myandroid.R
import com.example.myandroid.navigate.BaseNavigateActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class NetworkActivity : BaseNavigateActivity() {

    private val viewModel: NetworkViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        viewModel.displayUser.observe(this, {
            Log.d(logTag, "displayUser: $it")
        })

        viewModel.executeGetUser("1")
    }
}