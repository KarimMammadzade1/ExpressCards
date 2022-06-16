package com.rteam.expresscards.ui.home

import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.rteam.expresscards.R
import com.rteam.expresscards.appContext
import com.rteam.expresscards.model.CategoriesDataModel
import com.rteam.expresscards.ui.bottomsheet.BottomCardsRecyclerAdapter
import org.koin.core.component.getScopeId
import java.util.*

class CategoriesRecyclerAdapter(val categoriesList:List<CategoriesDataModel>): RecyclerView.Adapter<CategoriesRecyclerAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val categoryName:TextView = itemView.findViewById(R.id.categoriesNameTextRV)
        val categoryPercent:TextView = itemView.findViewById(R.id.categoriesPercentText)
        val categoryCurrency:TextView = itemView.findViewById(R.id.categoriesCurrencyText)
        val categoryOutlineBorder:CircularProgressIndicator = itemView.findViewById(R.id.categoryOutlineBorder)
        val categoryImage:ImageView = itemView.findViewById(R.id.categoryImage)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.categoriesitem, parent, false)
        return CategoriesRecyclerAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesRecyclerAdapter.ViewHolder, position: Int) {
       holder.categoryCurrency.text = "${categoriesList[position].totalSumm} AZN"
       holder.categoryName.text = categoriesList[position].categoryName
       holder.categoryPercent.text = "${categoriesList[position].percent} %"
       holder.categoryImage.setImageResource(categoriesList[position].icon)

    }

    override fun getItemCount(): Int = categoriesList.size
}