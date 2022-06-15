package com.rteam.expresscards.ui.bottomsheet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.rteam.expresscards.R
import com.rteam.expresscards.model.CardViewDataModel
import kotlinx.android.synthetic.main.cardsbottomsheet.view.*

class BottomCardsRecyclerAdapter(private val cardsList:List<CardViewDataModel>,val clicklistener:BottomCardClick): RecyclerView.Adapter<BottomCardsRecyclerAdapter.ViewHolder>() {


    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.bottom_card_image)
        val textView: TextView = itemView.findViewById(R.id.cardNamebottom)
        val rootView:ConstraintLayout = itemView.findViewById(R.id.bottomrootview)
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardsbottomsheet, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.imageView.setImageResource(cardsList[position].cardImage)
        holder.textView.text = cardsList[position].cardName
        holder.rootView.setOnClickListener {
            clicklistener.onClick(cardsList[position])
        }
    }

    override fun getItemCount() = cardsList.size

    class BottomCardClick(val clickListener: (model: CardViewDataModel) -> Unit) {
        fun onClick(model: CardViewDataModel) = clickListener(model)
    }
}