package com.rteam.expresscards.customview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.*
import com.rteam.expresscards.R
import com.rteam.expresscards.utils.MockDatas

class CustomSpinner : RelativeLayout, AdapterView.OnItemSelectedListener {
    val spinnerYear get() = findViewById<Spinner>(R.id.spinnerYear)
    val spinnerMonth get() = findViewById<Spinner>(R.id.spinnerMonth)
    var yearOnClickListener:((Int)->Unit)?=null
    var monthOnClickListener:((String)->Unit)?=null


    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        inflate(context, R.layout.custom_spinnerlayout, this)
        setDatasTospinner()
    }

    private fun setDatasTospinner() {
        val yearArrayAdapter = ArrayAdapter(this.context, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,MockDatas.yearsList)
        val monthsArrayAdapter = ArrayAdapter(this.context, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,MockDatas.monthsList)
        yearArrayAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        monthsArrayAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        spinnerYear.apply {
            this.onItemSelectedListener = this@CustomSpinner
            this.adapter = yearArrayAdapter
            this.setSelection(0)
        }
        spinnerMonth.apply {
            this.onItemSelectedListener = this@CustomSpinner
            this.adapter = monthsArrayAdapter
            this.setSelection(5)
        }

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        when(parent){
            spinnerYear -> {
                yearOnClickListener?.invoke(spinnerYear.selectedItem.toString().toInt())

            }
            spinnerMonth -> {
                monthOnClickListener?.invoke(spinnerMonth.selectedItem.toString())

            }

        }

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

}