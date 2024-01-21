fun main(){
    val items = listOf("apple", "banana", "strawberry")

    for(item in items) {
        println(item)
    }

    println()

    for(item in items) println(item) // short version

    // or
    println()

    for(index in items.indices){ // indices method return list with indices of list
        println("$index. ${items[index]}")
    }

    // also
    println()

    for((index, item) in items.withIndex()){ // return list of pair indices and item (0, apple), (1, banana) and etc
        println("$index. $item")
    }

}