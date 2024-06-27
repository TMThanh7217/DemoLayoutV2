package com.example.demolayoutv2

// adding private to prevent JvmName clash problem
class CardItem(private var card_item_name: String, private var imgid: Int) {

    fun getCardItem_name(): String {
        return card_item_name
    }

    fun setCardItem_name(card_item_name: String) {
        this.card_item_name = card_item_name
    }

    fun getImgid(): Int {
        return imgid
    }

    fun setImgid(imgid: Int) {
        this.imgid = imgid
    }
}