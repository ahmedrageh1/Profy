package com.rageh.profy.data.repository.base

import androidx.lifecycle.liveData
import com.rageh.profy.data.databse.dao.base.BaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

open class BaseRepo<T> @Inject constructor(private val baseDao: BaseDao<T>) {

    suspend fun insert(item: T) = baseDao.insert(item)

    fun insertLive(item: T) = flow{ emit(baseDao.insert(item)) }.flowOn(Dispatchers.IO)

    suspend fun update(item: T) {
        withContext(Dispatchers.IO) {
            baseDao.update(item)
        }
    }

    suspend fun delete(item: T) {
        withContext(Dispatchers.IO) {
            baseDao.delete(item)
        }
    }
}