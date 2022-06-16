package com.rteam.expresscards.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rteam.expresscards.R
import com.rteam.expresscards.base.BaseFragment
import com.rteam.expresscards.customview.CustomCardViewHolder
import com.rteam.expresscards.customview.CustomSpinner
import com.rteam.expresscards.customview.CustomTry
import com.rteam.expresscards.ui.bottomsheet.CardsBottomFragment
import com.rteam.expresscards.utils.MockDatas
import com.rteam.expresscards.utils.checkClickedCategory

class HomeFragment : BaseFragment() {
    private val customCardViewHolder get() = view?.findViewById<CustomCardViewHolder>(R.id.customCardHolder)
    private val customSpinners get() = view?.findViewById<CustomSpinner>(R.id.customSpinners)
    private val wheelSpinCu get() = view?.findViewById<CustomTry>(R.id.wheelSpin)
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
        customCardViewHolder?.setOnClickListener { openBottomSheet() }
        setUpCategoriesRecyler()

        wheelSpinCu?.setOnTouchListener { v, event ->
            Toast.makeText(requireContext(),checkClickedCategory(event, wheelSpinCu!!), Toast.LENGTH_SHORT).show()
            Toast.makeText(requireContext(),"Sections are detectable! Dont Have time to implement rest :(", Toast.LENGTH_SHORT).show()
            false
        }

        //  }









    }

    private fun setUpCategoriesRecyler() {
         val recyclerView = view?.findViewById<RecyclerView>(R.id.categoriesRV)
        recyclerView?.layoutManager= LinearLayoutManager(requireContext())
        val adapter = CategoriesRecyclerAdapter(MockDatas.categoriesListMock)
        recyclerView?.adapter=adapter
    }

    private fun openBottomSheet() {
        val bottomSheet = CardsBottomFragment(){
            customCardViewHolder?.setSelectedCard(it)
        }

        bottomSheet.show(childFragmentManager, bottomSheet.tag)
    }



}