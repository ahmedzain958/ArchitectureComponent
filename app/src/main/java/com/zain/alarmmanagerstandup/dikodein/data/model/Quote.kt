package com.zain.alarmmanagerstandup.dikodein.data.model

data class Quote(val text: String = "", val author: String = "") {
    override fun toString(): String = "$text - $author"


}

fun main(args: Array<String>) {
    print(Quote("quote 1","zain"))

}