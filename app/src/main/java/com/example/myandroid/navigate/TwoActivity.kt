package com.example.myandroid.navigate

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.myandroid.R

class TwoActivity : BaseNavigateActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)


        val name = intent.getStringExtra("name")
        Log.d(logTag, "Name: $name")

        val twoModel = intent.getParcelableExtra<TwoModel>(EXTRA_TWO_MODEL)
        Log.d(logTag, "TwoModel: ${twoModel?.name}")
    }

    companion object {

        private const val EXTRA_NAME = "name"
        private const val EXTRA_TWO_MODEL = "two_model"

        fun startIntent(context: Context, name: String) {
            Intent(context, TwoActivity::class.java)
                .putExtra(EXTRA_NAME, name)
                .run { context.startActivity(this) }
        }

        fun startIntent(context: Context, twoModel: TwoModel) {
            Intent(context, TwoActivity::class.java)
                .putExtra(EXTRA_TWO_MODEL, twoModel)
                .run { context.startActivity(this) }
        }
    }
}