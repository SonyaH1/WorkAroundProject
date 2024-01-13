package com.example.workaroundproject.cat_retrofit.data.datastore

import com.example.workaroundproject.cat_retrofit.domain.datastore.RemoteRepository
import com.example.workaroundproject.cat_retrofit.domain.model.CatFact
import com.example.workaroundproject.cat_retrofit.data.api.CatFactService
import com.example.workaroundproject.cat_retrofit.data.mapper.toDomainCatFact

class CatFactRepository(
    val api: CatFactService
) : RemoteRepository {
    override suspend fun getCatFact(): CatFact {
        return api.getCatFact().toDomainCatFact()
    }


//other way of doing things to make it more robust
//    override suspend fun getCatFact(): CatFact  = withContext(Dispatchers.IO){
//        api.getCatFact().toDomainCatFact()
//    }

}