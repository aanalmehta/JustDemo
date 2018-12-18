package com.example.aanal.kotlindemo

import android.annotation.TargetApi
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addAnimationOperations()
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    fun addAnimationOperations() {
        var set = false
        val constraint1 = ConstraintSet()
        constraint1.clone(root)
        val constraint2 = ConstraintSet()
        constraint2.clone(this, R.layout.activity_main_new)
        findViewById<ImageView>(R.id.imageView).setOnClickListener{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                val autoTransition = AutoTransition();
                autoTransition.duration = 1000
                TransitionManager.beginDelayedTransition(root, autoTransition)
                val constraint = if(set) constraint1 else constraint2
                constraint.applyTo(root)
                set = !set
            }
        }
    }
}
