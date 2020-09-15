package com.rageh.profy.data.repository.base

import androidx.lifecycle.liveData
import com.rageh.profy.data.databse.dao.base.BaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

open class BaseRepo<T> @Inject constructor(private val baseDao: BaseDao<T>) {

    fun insertIntoDB(item: T) = liveData(Dispatchers.IO) { emit(baseDao.insert(item)) }

    suspend fun updateInDB(item: T) {
        withContext(Dispatchers.IO) {
            baseDao.update(item)
        }
    }

    suspend fun deleteFromDB(item: T) {
        withContext(Dispatchers.IO) {
            baseDao.delete(item)
        }
    }
}