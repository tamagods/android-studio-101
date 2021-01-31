package com.example.myandroid.navigate

import android.os.Bundle
import com.example.myandroid.databinding.ActivityOneBinding

class OneActivity : BaseNavigateActivity() {

    private val binding: ActivityOneBinding by lazy {
        ActivityOneBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpView()
    }

    private fun setUpView() {
        binding.btnNext.setOnClickListener {
            val name = binding.edtName.text.toString()

//            val intent = Intent(this, TwoActivity::class.java)
//            intent.putExtra("name", name)
//            startActivity(intent)
//            finish()

//            TwoActivity.startIntent(this, name)
            TwoActivity.startIntent(context = this, twoModel = TwoModel(name = name))
        }
    }
}