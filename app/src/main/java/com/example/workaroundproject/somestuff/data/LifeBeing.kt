package com.example.workaroundproject.somestuff.data

import androidx.annotation.DrawableRes

sealed class LifeBeing(val type: ItemType) {

    data class Cat(val name: String, var age: Int, @DrawableRes val drawable: Int) :
        LifeBeing(type = ItemType.ITEM_CAT)

    data class Human(val name: String, var age: Int) : LifeBeing(type = ItemType.ITEM_HUMAN)

    data class Bug(val name: String) : LifeBeing(type = ItemType.ITEM_BUG)
}

enum class ItemType(val value: Int) {
    ITEM_HUMAN(0),
    ITEM_CAT(1),
    ITEM_BUG(2);
}