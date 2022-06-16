package com.rteam.expresscards.utils

import com.rteam.expresscards.R
import com.rteam.expresscards.model.CardViewDataModel
import com.rteam.expresscards.model.CategoriesDataModel

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

    val categoriesListMock = listOf<CategoriesDataModel>(
        CategoriesDataModel(CategoryTypes.AIRLINES,"Airlines","24","1250",R.drawable.airlinesicon,"#4BAFF8"),
        CategoriesDataModel(CategoryTypes.RENTACAR,"Rent A Car","48","1231",R.drawable.rentacaricon,"#9B2FF5"),
        CategoriesDataModel(CategoryTypes.HOTELS,"Hotels","42","2341",R.drawable.hotelmotelicon,"#5723E1"),
        CategoriesDataModel(CategoryTypes.TRANSPORT,"Transport","52","232",R.drawable.transporticon,"#C3291C"),
        CategoriesDataModel(CategoryTypes.CARS,"Cars","24","123412",R.drawable.carsicon,"#3255F4"),
        CategoriesDataModel(CategoryTypes.GOVERNMENT,"Government","12","312421",R.drawable.governmenticon,"#9D8980"),
        CategoriesDataModel(CategoryTypes.PERSONAL,"Personal","35","23423",R.drawable.personalicon,"#50B5D0"),
        CategoriesDataModel(CategoryTypes.BUSINESS,"Buniness","66","232",R.drawable.businessicon,"#212121"),
        CategoriesDataModel(CategoryTypes.CLOTHING,"Clothing","55","4432",R.drawable.clothingicon,"#E1325A"),
        CategoriesDataModel(CategoryTypes.REPAIR,"Repair","33","433",R.drawable.repairicon,"#55BCA6"),
        CategoriesDataModel(CategoryTypes.ENTERTAINTMENT,"Entertainment","24","43",R.drawable.entertainmentico,"#FAA61A"),
        CategoriesDataModel(CategoryTypes.HEALTH,"Health","24","232",R.drawable.healthicon,"#FF001F"),
        CategoriesDataModel(CategoryTypes.OTHERSERVICES,"Other Services","43","333",R.drawable.otherservicesicon,"#5E6DBA"),


    )
}