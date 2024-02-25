fun main(){ // ranges take a number [start, end]
    // ranges in if

    val x = 4

    if(x in 1..10){
        println("x in range")
    }else{
        println("x not in range ")
    }

    // with using negation
    if(x !in 1..10){
        println("x not in range")
    }else{
        println("x in range ")
    }



    // ranges in loop
    for(index in 1..10){
        println(index)
    }

    // step

    for(index in 1..10 step 5){ // index, index + 5
        println(index)
    }

    //regression
    for(index in 10 downTo 1 step 4){ // 10, 6 = 10 - 4,  2 = 6 - 4
        println("What you want?")
    }


}