package com.example.recycler2

data class Product(val outfitType:OutfitType,
                   val priseOfOutfit:Int,
                   val outfitName:String) {

}

enum class OutfitType{
    PARTY,
    BEACH,
    CAMPING,
    RENDOM,
    ALL
}