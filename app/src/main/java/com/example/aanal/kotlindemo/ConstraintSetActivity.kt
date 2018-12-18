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

class ConstraintSetActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addAnimationOperations()
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private fun addAnimationOperations() {
        var set = false
        var count = 0
        val constraint1 = ConstraintSet()
        constraint1.clone(root)
        val constraint2 = ConstraintSet()
        constraint2.clone(this, R.layout.activity_main_1)
        val constraint3 = ConstraintSet()
        constraint3.clone(this, R.layout.activity_main_2)
        val constraint4 = ConstraintSet()
        constraint4.clone(this, R.layout.activity_main_3)
        findViewById<ImageView>(R.id.imageView).setOnClickListener{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                val autoTransition = AutoTransition()
                autoTransition.duration = 1000
                TransitionManager.beginDelayedTransition(root, autoTransition)
                var constraint = ConstraintSet()
                when(count) {
                    0 -> {
                        constraint = constraint2
                        count++
                    }
                    1 -> {
                        constraint = constraint3
                        count++
                    }
                    2 -> {
                        constraint = constraint4
                        count++
                    }
                    3 -> {
                        constraint = constraint1
                        count = 0
                    }
                }
                constraint.applyTo(root)
                set = !set
            }
        }
    }
}
