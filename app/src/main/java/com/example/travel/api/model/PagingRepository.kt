package com.example.travel.api.model

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.travel.api.ApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PagingRepository @Inject constructor(
    private val service: ApiService
) {

    fun getSearchAttr(langType: LangType): Flow<PagingData<ATTR002_Rs>> {
        return Pager(
            config = PagingConfig(
                enablePlaceholders = false,
                pageSize = 30
            ),
            pagingSourceFactory = { AttrPagingSource(service, langType) }
        ).flow
    }
}
