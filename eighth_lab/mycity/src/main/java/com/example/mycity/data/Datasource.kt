package com.example.mycity.data

import com.example.mycity.R

enum class Categories (name: String) {
    SIGHT(name = "Достопримечательности"),
    COFFEE_SHOP(name = "Кофейни"),
    PARK(name = "Парки"),
    SHOPPING_CENTER(name = "Торговые центры")

}
val categories = listOf(
    Category(1, R.string.sight, R.drawable.sight, Categories.SIGHT),
    Category(2, R.string.coffeeshop, R.drawable.coffeeshop, Categories.COFFEE_SHOP),
    Category(3, R.string.park, R.drawable.park, Categories.PARK),
    Category(4, R.string.shoppingcenter, R.drawable.shoppingcenter, Categories.SHOPPING_CENTER)
)

val places = listOf(
    Place(1, R.string.sight1, 4.7, R.drawable.sight1, Categories.SIGHT, R.string.sight1descr),
    Place(2, R.string.sight2, 4.7, R.drawable.sight2, Categories.SIGHT, R.string.sight2descr),
    Place(3, R.string.sight3, 4.8, R.drawable.sight3, Categories.SIGHT, R.string.sight3descr),
    Place(4, R.string.sight4, 4.7, R.drawable.sight4, Categories.SIGHT, R.string.sight4descr),
    Place(5, R.string.coffeeshop1, 4.8, R.drawable.coffeeshop1, Categories.COFFEE_SHOP, R.string.coffeeshop1descr),
    Place(6, R.string.coffeeshop2, 5.0, R.drawable.coffeeshop2, Categories.COFFEE_SHOP, R.string.coffeeshop2descr),
    Place(8, R.string.coffeeshop3, 4.9, R.drawable.coffeeshop3, Categories.COFFEE_SHOP, R.string.coffeeshop3descr),
    Place(9, R.string.park1, 4.8, R.drawable.park1, Categories.PARK, R.string.park1descr),
    Place(10, R.string.park2, 4.9, R.drawable.park2, Categories.PARK, R.string.park2descr),
    Place(11, R.string.park3, 5.0, R.drawable.park3, Categories.PARK, R.string.park3descr),
    Place(12, R.string.park3, 4.7, R.drawable.park4, Categories.PARK, R.string.park4descr),
    Place(13, R.string.shoppingcenter1, 5.0, R.drawable.shoppingcenter1, Categories.SHOPPING_CENTER, R.string.shoppingcenter1descr),
    Place(14, R.string.shoppingcenter2, 4.6, R.drawable.shoppingcenter2, Categories.SHOPPING_CENTER, R.string.shoppingcenter2descr),
    Place(15, R.string.shoppingcenter3, 5.0, R.drawable.shoppingcenter3, Categories.SHOPPING_CENTER, R.string.shoppingcenter3descr),
)