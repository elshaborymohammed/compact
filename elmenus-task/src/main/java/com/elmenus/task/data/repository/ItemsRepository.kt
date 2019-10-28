package com.elmenus.task.data.repository

import com.compact.executor.WorkerThread
import com.elmenus.task.data.local.dao.ItemsDao
import com.elmenus.task.data.remote.requester.RequesterItemsApi
import com.elmenus.task.domain.model.Item
import com.elmenus.task.domain.protocol.IItemsProtocol
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * this Repository responsible for manipulate Items from remote api and local database
 */
@Singleton
class ItemsRepository @Inject constructor(
        private val api: RequesterItemsApi,
        private val dao: ItemsDao,
        private val workerThread: WorkerThread
) : IItemsProtocol {

    /**
     * get data from database first if it's empty get from remote api
     * and insert data that loaded from api into database
     */
    override fun get(tagName: String): Single<List<Item>> {
        return fetchFromApi(tagName)
    }

    override fun getOne(name: String): Single<Item> {
        return dao.getOne(name).map { Item(id = it.id, name = it.name, photo = it.photo, description = it.description) }
    }

    /**
     * get data from remote api
     */
    private fun fetchFromApi(tagName: String): Single<List<Item>> {
        return api.get(tagName).map { it.data }
    }
}