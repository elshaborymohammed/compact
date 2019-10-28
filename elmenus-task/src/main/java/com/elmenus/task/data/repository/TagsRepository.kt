package com.elmenus.task.data.repository

import com.compact.executor.WorkerThread
import com.elmenus.task.data.local.dao.TagsDao
import com.elmenus.task.data.local.entity.TagRoom
import com.elmenus.task.data.remote.requester.RequesterTagsApi
import com.elmenus.task.domain.model.Tag
import com.elmenus.task.domain.protocol.ITagsProtocol
import io.reactivex.Single
import io.reactivex.functions.Consumer
import javax.inject.Inject
import javax.inject.Singleton

/**
 * this Repository responsible for manipulate Tags from remote api and local database
 */
@Singleton
class TagsRepository @Inject constructor(
        private val api: RequesterTagsApi,
        private val dao: TagsDao,
        private val workerThread: WorkerThread
) : ITagsProtocol {

    /**
     * get data from database first if it's empty get from remote api
     *  and insert data that loaded from api into database
     */
    override fun get(): Single<List<Tag>> {
        return fetchFromApi(1)
    }

    override fun get(page: Int): Single<List<Tag>> {
        return fetchFromApi(page)
    }

    /**
     * insert data that loaded from api into database
     */
    private fun onSuccess(): Consumer<List<Tag>> {
        return Consumer { list ->
            val tags: ArrayList<TagRoom> = ArrayList()
            list.forEach {
                tags.add(TagRoom(it.name, it.photo))
            }
            dao.insert(tags.toList())
        }
    }

    /**
     * get data from remote api
     */
    private fun fetchFromApi(page: Int): Single<List<Tag>> {
        return api.get(page).map { it.data }
    }
}