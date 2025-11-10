package com.mvp.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.mvp.R
import com.mvp.common.Contract
import com.mvp.model.Model
import com.mvp.presenter.Presenter

/**
 * https://www.geeksforgeeks.org/mvp-model-view-presenter-architecture-pattern-in-android-with-example/?ref=asr1
 *
 * https://www.geeksforgeeks.org/difference-between-mvc-and-mvp-architecture-pattern-in-android/?ref=asr2
 *
 * Activity implements our View contract
 */
class MainActivity : ComponentActivity(), Contract.View {
    //Activity implements View contract so we can pass this as reference to our View Contract interface
    private val presenter = Presenter(this, Model())
    private lateinit var nextButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
       //nextButton = findViewById(R.id.next_button)

        findViewById<Button>(R.id.next_button).setOnClickListener {
            presenter.fetchNextAlphabet()
        }
    }

    override fun onHideProgress() {
        findViewById<ProgressBar>(R.id.progressBar).visibility = View.INVISIBLE
    }

    override fun onShowProgress() {
        findViewById<ProgressBar>(R.id.progressBar).visibility = View.VISIBLE
    }

    override fun setData(result: String) {
        findViewById<TextView>(R.id.textView).text = result
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}

