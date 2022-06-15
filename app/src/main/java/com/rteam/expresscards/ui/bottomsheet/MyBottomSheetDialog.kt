package com.rteam.expresscards.ui.bottomsheet

import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.rteam.expresscards.R

open class MyBottomSheetDialog: BottomSheetDialogFragment() {


    override fun getTheme(): Int {
        return R.style.BottomSheetDialog
    }
}