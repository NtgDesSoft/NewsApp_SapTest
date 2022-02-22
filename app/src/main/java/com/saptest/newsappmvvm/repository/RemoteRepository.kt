package com.saptest.newsappmvvm.repository

import com.saptest.newsappmvvm.model.Article
import com.saptest.newsappmvvm.network.NewsApi
import javax.inject.Inject


class RemoteRepository @Inject constructor(
    private val newsApi: NewsApi
) : BaseRepository() {

    suspend fun getBreakingNews(): MutableList<Article>? {
        return safeApiCall(
            call = { newsApi.getBreakingNews() },
            error = "Error fetching news"
        )?.articles?.toMutableList()
    }

    suspend fun searchNews(searchQuery: String): MutableList<Article>? {
        return safeApiCall(
            call = { newsApi.searchForNews(searchQuery) },
            error = "Error fetching news"
        )?.articles?.toMutableList()
    }
}