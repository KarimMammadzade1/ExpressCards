package com.rteam.expresscards.utils

import com.rteam.expresscards.R
import com.rteam.expresscards.model.CardViewDataModel
import com.rteam.expresscards.model.CategoriesDataModel
import com.rteam.expresscards.model.HistoryItem

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

    val mockTransactions= listOf(
        HistoryItem(
            "Uber Odenisi",
            "13:08",
            "19.02.22",
            "8"
        ),
        HistoryItem(
            "Market Odenisi",
            "19:07",
            "22.02.22",
            "425"
        ),
        HistoryItem(
            "Express Kredit Odenisi",
            "21:21",
            "22.21.22",
            "1000"
        ),
        HistoryItem(
            "Elave Odenis",
            "00:00",
            "17.06.22",
            "999"
        ),
        HistoryItem(
            "Elave Odenis",
            "00:00",
            "17.06.22",
            "999"
        ),
        HistoryItem(
            "Elave Odenis",
            "00:00",
            "17.06.22",
            "999"
        ),
        HistoryItem(
            "Elave Odenis",
            "00:00",
            "17.06.22",
            "999"
        ),
        HistoryItem(
            "Elave Odenis",
            "00:00",
            "17.06.22",
            "999"
        ),
        HistoryItem(
            "Elave Odenis",
            "00:00",
            "17.06.22",
            "999"
        ),
        HistoryItem(
            "Elave Odenis",
            "00:00",
            "17.06.22",
            "999"
        )
    )
    val categoriesListMock = listOf<CategoriesDataModel>(
        CategoriesDataModel(CategoryTypes.AIRLINES,"Airlines","24","1250",R.drawable.airlinesicon,R.color.airlinesborder,
            mockTransactions),
        CategoriesDataModel(CategoryTypes.RENTACAR,"Rent A Car","48","1231",R.drawable.rentacaricon,R.color.rentecarborder,
            mockTransactions),
        CategoriesDataModel(CategoryTypes.HOTELS,"Hotels","42","2341",R.drawable.hotelmotelicon,R.color.hotelmotelborder,
            mockTransactions),
        CategoriesDataModel(CategoryTypes.TRANSPORT,"Transport","52","232",R.drawable.transporticon,R.color.transportborder,
            mockTransactions),
        CategoriesDataModel(CategoryTypes.CARS,"Cars","24","123412",R.drawable.carsicon,R.color.carsborder,
            mockTransactions),
        CategoriesDataModel(CategoryTypes.GOVERNMENT,"Government","12","312421",R.drawable.governmenticon,R.color.governmentborder,
            mockTransactions),
        CategoriesDataModel(CategoryTypes.PERSONAL,"Personal","35","23423",R.drawable.personalicon,R.color.personalborder,
            mockTransactions),
        CategoriesDataModel(CategoryTypes.BUSINESS,"Buniness","66","232",R.drawable.businessicon,R.color.businessborder,
            mockTransactions),
        CategoriesDataModel(CategoryTypes.CLOTHING,"Clothing","55","4432",R.drawable.clothingicon,R.color.clothingborder,
            mockTransactions),
        CategoriesDataModel(CategoryTypes.REPAIR,"Repair","33","433",R.drawable.repairicon,R.color.repairsborder,
            mockTransactions),
        CategoriesDataModel(CategoryTypes.ENTERTAINTMENT,"Entertainment","24","43",R.drawable.entertainmentico,R.color.entertainmentborder,
            mockTransactions),
        CategoriesDataModel(CategoryTypes.HEALTH,"Health","24","232",R.drawable.healthicon,R.color.healthborder,
            mockTransactions),
        CategoriesDataModel(CategoryTypes.OTHERSERVICES,"Other Services","43","333",R.drawable.otherservicesicon,R.color.otherservicesborder,
            mockTransactions),


    )
}