package com.rteam.expresscards.ui.bottomsheet

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rteam.expresscards.R
import com.rteam.expresscards.model.CardViewDataModel
import com.rteam.expresscards.utils.MockDatas
import kotlinx.android.synthetic.main.fragment_cards_bottom.*

class CardsBottomFragment(val selectedCard:(CardViewDataModel)->Unit): MyBottomSheetDialog() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_cards_bottom, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.bottomsheetcardsrv)
        recyclerView?.layoutManager=LinearLayoutManager(requireContext())
        val adapter =  BottomCardsRecyclerAdapter(MockDatas.bottomCardsList,BottomCardsRecyclerAdapter.BottomCardClick{
            selectedCard.invoke(it)
            this@CardsBottomFragment.dismiss()
        })
        recyclerView?.adapter =adapter



    }
}