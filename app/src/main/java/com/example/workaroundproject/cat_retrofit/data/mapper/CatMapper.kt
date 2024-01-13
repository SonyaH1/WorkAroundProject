package com.example.workaroundproject.cat_retrofit.data.mapper

import com.example.workaroundproject.cat_retrofit.domain.model.CatFact
import com.example.workaroundproject.cat_retrofit.data.entities.CatFactDto

internal fun CatFactDto.toDomainCatFact(): CatFact {
    return CatFact(fact = fact)
}