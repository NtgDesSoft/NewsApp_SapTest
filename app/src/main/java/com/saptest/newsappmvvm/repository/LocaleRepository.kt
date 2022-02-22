package com.saptest.newsappmvvm.repository

import com.saptest.newsappmvvm.db.ArticleDao
import com.saptest.newsappmvvm.model.Article

import javax.inject.Inject


class LocaleRepository @Inject constructor(
    val db: ArticleDao
) : BaseRepository() {

    suspend fun insertNewsToDb(article: Article) = db.insertArticle(article)

    suspend fun deleteNews(article: Article) = db.deleteArticle(article)

    fun getSavedNews() = db.getSavedArticles()
}