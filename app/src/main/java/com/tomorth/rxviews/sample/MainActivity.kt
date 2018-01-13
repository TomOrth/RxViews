package com.tomorth.rxviews.sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.tomorth.rxviews.RxView
import com.tomorth.rxviews.views.RxTextView
import io.reactivex.disposables.CompositeDisposable

class MainActivity : AppCompatActivity() {

    val composite = CompositeDisposable()
    lateinit var btn: Button
    lateinit var txtInput: EditText
    lateinit var txtOutput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.btnToast)
        txtInput = findViewById(R.id.txtInput)
        txtOutput = findViewById(R.id.txtOutput)

        composite.add(RxView.clicks(btn).subscribe { Toast.makeText(this, "Hello Rx developer", Toast.LENGTH_SHORT).show() })
        composite.add(RxTextView.textChanges(txtInput).subscribe { txtOutput.setText("My name is: " + it) })
    }

    override fun onDestroy() {
        super.onDestroy()
        composite.clear()
    }
}
