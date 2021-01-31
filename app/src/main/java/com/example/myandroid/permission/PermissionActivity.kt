package com.example.myandroid.permission

import android.Manifest
import android.os.Bundle
import android.util.Log
import com.example.myandroid.databinding.ActivityPermissionBinding
import com.example.myandroid.navigate.BaseNavigateActivity
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.karumi.dexter.listener.single.PermissionListener

class PermissionActivity : BaseNavigateActivity() {

    private val binding: ActivityPermissionBinding by lazy {
        ActivityPermissionBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnRequestPermission.setOnClickListener {
            requestPermission()
        }
    }

//    private fun setUpView() {
//        binding.btnRequestPermission.setOnClickListener {
//            requestPermission()
//        }
//    }

    private fun requestPermission() {
        Dexter.withContext(this)
            .withPermissions(Manifest.permission.CAMERA, Manifest.permission.READ_CONTACTS)
            .withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(p0: MultiplePermissionsReport?) {
                    Log.d(logTag, "onPermissionsChecked")
                }

                override fun onPermissionRationaleShouldBeShown(
                    p0: MutableList<PermissionRequest>?,
                    p1: PermissionToken?
                ) {
                    Log.d(logTag, "onPermissionRationaleShouldBeShown")
                }
//                override fun onPermissionGranted(grantedResponse: PermissionGrantedResponse?) {
//                    Log.d(logTag, "onPermissionGranted")
//                }
//
//                override fun onPermissionDenied(grantedResponse: PermissionDeniedResponse?) {
//                    Log.d(logTag, "onPermissionDenied")
//                }
//
//                override fun onPermissionRationaleShouldBeShown(
//                    request: PermissionRequest?,
//                    token: PermissionToken?
//                ) {
//                    Log.d(logTag, "onPermissionRationaleShouldBeShown")
//                    token?.continuePermissionRequest()
//                }
            }).check()
    }
}
