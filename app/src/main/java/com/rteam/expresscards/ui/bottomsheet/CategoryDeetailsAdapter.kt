package com.rteam.expresscards.ui.bottomsheet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rteam.expresscards.R
import com.rteam.expresscards.model.CategoriesDataModel
import com.rteam.expresscards.model.HistoryItem
import kotlinx.android.synthetic.main.category_detail_item.view.*
import org.w3c.dom.Text

class CategoryDeetailsAdapter(private val categoryDetails: List<HistoryItem>) : RecyclerView.Adapter<CategoryDeetailsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val nameTextView = itemView.findViewById<TextView>(R.id.mainContentDetail)
        val detailTime = itemView.findViewById<TextView>(R.id.detailTime)
        val detailDate = itemView.findViewById<TextView>(R.id.detailDate)
        val quantity = itemView.findViewById<TextView>(R.id.quantity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_detail_item, parent, false)

        return CategoryDeetailsAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.nameTextView.text = categoryDetails[position].mainContentName
       holder.detailDate.text=categoryDetails[position].trabsactionDate
       holder.detailTime.text=categoryDetails[position].transactionTime
       holder.quantity.text = categoryDetails[position].transactionCurreny + " ₼"
        holder.itemView.detailRootView.setOnClickListener {

        }
    }

    override fun getItemCount(): Int  = categoryDetails.size
}
