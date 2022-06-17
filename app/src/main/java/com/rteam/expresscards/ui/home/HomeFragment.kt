package com.rteam.expresscards.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.AbsListView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rteam.expresscards.R
import com.rteam.expresscards.base.BaseFragment
import com.rteam.expresscards.customview.CustomCardViewHolder
import com.rteam.expresscards.customview.CustomSpinner
import com.rteam.expresscards.customview.CustomTry
import com.rteam.expresscards.model.CategoriesDataModel
import com.rteam.expresscards.ui.bottomsheet.CardsBottomFragment
import com.rteam.expresscards.ui.bottomsheet.CategoryDetailsBottomFragment
import com.rteam.expresscards.utils.MockDatas
import com.rteam.expresscards.utils.checkClickedCategory
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : BaseFragment() {
    private val customCardViewHolder get() = view?.findViewById<CustomCardViewHolder>(R.id.customCardHolder)
    private val customSpinners get() = view?.findViewById<CustomSpinner>(R.id.customSpinners)
    private val wheelSpinCu get() = view?.findViewById<CustomTry>(R.id.wheelSpin)
    private var selectedYear:Int?=null
    private var selectedMonth:String?=null
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
            selectedYear = it
           // Toast.makeText(requireContext(), "Year here $it", Toast.LENGTH_SHORT).show()
        }
        customSpinners?.monthOnClickListener = {
            selectedMonth = it
           // Toast.makeText(requireContext(), "Month here $it", Toast.LENGTH_SHORT).show()
        }
        customCardViewHolder?.setOnClickListener { openBottomSheet() }
        setUpCategoriesRecyler()
        setUpSectionWheelClickListener()


    }

    private fun setUpSectionWheelClickListener() {
        wheelSpinCu?.setOnTouchListener { v, event ->
            Toast.makeText(requireContext(),checkClickedCategory(event, wheelSpinCu!!), Toast.LENGTH_SHORT).show()
           // Toast.makeText(requireContext(),"Sections are detectable! Dont Have time to implement rest :(", Toast.LENGTH_SHORT).show()
            false
        }
    }

    private fun setUpCategoriesRecyler() {
         val recyclerView = view?.findViewById<RecyclerView>(R.id.categoriesRV)
        recyclerView?.layoutManager= LinearLayoutManager(requireContext())
        val adapter = CategoriesRecyclerAdapter(MockDatas.categoriesListMock,CategoriesRecyclerAdapter.CategoryClick{
            openCategoryDetails(it)
        })
        recyclerView?.adapter=adapter
        val animationDown: Animation = AnimationUtils.loadAnimation(requireContext(),R.anim.scaledownanim)
        animationDown.setAnimationListener(object:Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                wheelContainer?.visibility=View.GONE
            }

            override fun onAnimationRepeat(animation: Animation?) {
                animation?.cancel()
            }

        })
        val animationUp: Animation = AnimationUtils.loadAnimation(requireContext(),R.anim.scaleupanim)
        animationUp.setAnimationListener(object:Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
                wheelContainer?.visibility=View.VISIBLE
            }

            override fun onAnimationEnd(animation: Animation?) {

            }

            override fun onAnimationRepeat(animation: Animation?) {
            animation?.cancel()
            }

        })
        var outerDy=0
        recyclerView?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
               outerDy = dy
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_FLING) {
                    Log.e("test", "scrol state fling: ", )
                } else if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    Log.e("test", "scrol state touch scrol: ", )
                } else {
                    if (outerDy > 0) {
                        wheelContainer?.startAnimation(animationDown)
                        // visible to gone anim goes here

                    } else  if (outerDy < 0){
                        // reverse anim goes here
                        wheelContainer?.startAnimation(animationUp)

                    }
                }
            }
        })
    }

    private fun openCategoryDetails(model: CategoriesDataModel) {
        val bottomSheet = CategoryDetailsBottomFragment(model,selectedYear!!,selectedMonth!!)
        bottomSheet.show(childFragmentManager, bottomSheet.tag)
    }

    private fun openBottomSheet() {
        val bottomSheet = CardsBottomFragment(){
            customCardViewHolder?.setSelectedCard(it)
        }

        bottomSheet.show(childFragmentManager, bottomSheet.tag)
    }



}