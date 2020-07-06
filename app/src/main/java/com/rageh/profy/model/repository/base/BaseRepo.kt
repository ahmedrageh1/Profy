package com.rageh.profy.model.repository.base

import com.rageh.profy.model.databse.dao.base.BaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

open class BaseRepo<T> @Inject constructor(private val baseDao: BaseDao<T>) {
    suspend fun insertIntoDB(item: T) {
        withContext(Dispatchers.IO) {
            baseDao.insert(item)
        }
    }

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