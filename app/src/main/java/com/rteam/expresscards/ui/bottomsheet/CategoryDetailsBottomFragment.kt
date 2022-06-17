package com.rteam.expresscards.ui.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rteam.expresscards.R
import com.rteam.expresscards.model.CategoriesDataModel
import com.rteam.expresscards.utils.MockDatas
import kotlinx.android.synthetic.main.fragment_category_details_bottom.*

class CategoryDetailsBottomFragment(val categoryDetails:CategoriesDataModel,val sYear:Int,val sMonth:String):MyBottomSheetDialog() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_category_details_bottom, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCatDetails()
        initRecycler()




    }

    private fun initRecycler() {

        val recyclerView = view?.findViewById<RecyclerView>(R.id.categoryDetailRecycler)
        recyclerView?.layoutManager= LinearLayoutManager(requireContext())
        val adapter =  CategoryDeetailsAdapter(categoryDetails.categoryHistory)
        recyclerView?.adapter =adapter
    }

    private fun initCatDetails() {
        totalExpencesText.text = "Expences for $sMonth $sYear"
        categoryNameHeader.text = categoryDetails.categoryName
        totalSummText.text = "${categoryDetails.totalSumm} AZN"
        categoryImage.setImageResource(categoryDetails.icon)
    }

}