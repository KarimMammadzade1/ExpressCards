package com.rteam.expresscards.utils

import com.rteam.expresscards.R
import com.rteam.expresscards.model.CardViewDataModel

object MockDatas {

    val yearsList = listOf<String>("2022","2021","2020","2019","2018")
    val monthsList = listOf<String>( "January", "February", "March", "April", "May", "June", "July","August", "September", "October", "November", "December", )
    val bottomCardsList = listOf<CardViewDataModel>(
        CardViewDataModel(0,R.drawable.expressocard,"Bonus Kart","** 2255"),
        CardViewDataModel(1,R.drawable.expressocard,"Debet Kartim","** 2266"),
        CardViewDataModel(2,R.drawable.expressocard,"Kredit Kart","** 2277"),
        CardViewDataModel(3,R.drawable.expressocard,"Maas Karti","** 2299"),
        CardViewDataModel(4,R.drawable.expressocard,"Adsiz Kart","** 2244"),

    )

}