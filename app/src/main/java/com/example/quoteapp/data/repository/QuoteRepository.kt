package com.example.quoteapp.data.repository

import com.example.quoteapp.data.model.Quote
import com.example.quoteapp.utils.ResultWrapper
import kotlinx.coroutines.flow.Flow

interface QuoteRepository{
    fun getRandomQuotes() : Flow<ResultWrapper<List<Quote>>>
}