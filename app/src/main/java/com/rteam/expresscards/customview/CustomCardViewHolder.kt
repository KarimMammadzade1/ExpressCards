package com.rteam.expresscards.customview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.textfield.TextInputLayout
import com.rteam.expresscards.R
import com.rteam.expresscards.model.CardViewDataModel
import com.rteam.expresscards.utils.MockDatas
import kotlinx.android.synthetic.main.custom_cardview_holder_layout.view.*
import org.koin.core.KoinApplication.Companion.init

class CustomCardViewHolder:RelativeLayout {
 val rootView get() = findViewById<ConstraintLayout>(R.id.cardRootView)
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
        inflate(context, R.layout.custom_cardview_holder_layout, this)
    }
    fun setSelectedCard(card:CardViewDataModel){
        cardImage.setImageResource(card.cardImage)
        cardPanText.text = card.cardPan
        cardNameText.text = card.cardName
    }
}