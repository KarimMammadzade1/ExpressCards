package com.rteam.expresscards.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.rteam.expresscards.R
import com.rteam.expresscards.base.BaseFragment
import com.rteam.expresscards.customview.CustomCardViewHolder
import com.rteam.expresscards.customview.CustomSpinner

import com.rteam.expresscards.ui.bottomsheet.CardsBottomFragment
import kotlinx.android.synthetic.main.activity_main.*

class HomeFragment : BaseFragment() {
private val customCardViewHolder get() = view?.findViewById<CustomCardViewHolder>(R.id.customCardHolder)
private val customSpinners get() = view?.findViewById<CustomSpinner>(R.id.customSpinners)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        customSpinners?.yearOnClickListener = {
            Toast.makeText(requireContext(), "Year here $it", Toast.LENGTH_SHORT).show()
        }
        customSpinners?.monthOnClickListener = {
            Toast.makeText(requireContext(), "Month here $it", Toast.LENGTH_SHORT).show()
        }
        customCardViewHolder?.setOnClickListener { openBottomSheet()}


    }

    private fun openBottomSheet() {
        val bottomSheet = CardsBottomFragment(){
            customCardViewHolder?.setSelectedCard(it)
        }

        bottomSheet.show(childFragmentManager, bottomSheet.tag)
    }



}