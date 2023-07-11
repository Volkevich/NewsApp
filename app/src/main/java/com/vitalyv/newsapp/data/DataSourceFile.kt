package com.vitalyv.newsapp.data

import com.vitalyv.newsapp.R
import com.vitalyv.newsapp.model.NewsItemModel

class DataSourceFile {
    fun loadNews():List<NewsItemModel>{

        return listOf(
            NewsItemModel(image = R.drawable.one,
            titleView = R.string.titleOneNews,
            content = R.string.newsOne),
            NewsItemModel(image = R.drawable.two,
                titleView = R.string.titleTwoNews,
                content = R.string.newsTwo),
            NewsItemModel(image = R.drawable.tree,
                titleView = R.string.titleThreeNews,
                content = R.string.newsThree),
            NewsItemModel(image = R.drawable.four,
                titleView = R.string.titleFourNews,
                content = R.string.newsFour),
            NewsItemModel(image = R.drawable.five,
                titleView = R.string.titleFiveNews,
                content = R.string.newsFive),
            NewsItemModel(image = R.drawable.six,
                titleView = R.string.titleSixNews,
                content = R.string.newsSix),

        )
    }



}
