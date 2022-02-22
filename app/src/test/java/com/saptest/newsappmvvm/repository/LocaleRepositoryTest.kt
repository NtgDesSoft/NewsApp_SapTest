package com.saptest.newsappmvvm.repository

import com.saptest.newsappmvvm.db.ArticleDao
import com.saptest.newsappmvvm.model.Article
import com.saptest.newsappmvvm.model.Source
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class LocaleRepositoryTest {

    @Mock
    private lateinit var dao: ArticleDao

    @InjectMocks
    private lateinit var repository: LocaleRepository

    @Test
    fun testInsertDb() = runBlockingTest {
        // Given
        val articleItem = Article(
            1,
            "author",
            "content",
            "description",
            "publishedAt",
            Source(1, "name"),
            "title",
            "url",
            "urlToImage"
        )

        // When
        repository.insertNewsToDb(articleItem)

        // Then
        verify(dao).insertArticle(articleItem)
    }

    @Test
    fun testDeleteNews() = runBlockingTest {
        // Given
        val articleItem = Article(
            1,
            "author",
            "content",
            "description",
            "publishedAt",
            Source(1, "name"),
            "title",
            "url",
            "urlToImage"
        )

        // When
        repository.deleteNews(articleItem)

        // Then
        verify(dao).deleteArticle(articleItem)
    }

    @Test
    fun testGetSavedNews() {
        // Given
        val articleItem = Article(
            1,
            "author",
            "content",
            "description",
            "publishedAt",
            Source(1, "name"),
            "title",
            "url",
            "urlToImage"
        )

        // When
        repository.getSavedNews()

        // Then
        verify(dao).getSavedArticles()
    }
}