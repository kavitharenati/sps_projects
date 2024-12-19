package com.singlepointsol.versionslazyassignment

data class Shopping(val shoppingImage:Int, val shoppingName:String, val shoppingDetails:String )
fun getAllShopping(): ArrayList<Shopping>{
    return arrayListOf(
        Shopping(R.drawable.saree,"georgete saree","This saree is availabe in different colors and suitable for partywear"),
        Shopping(R.drawable.banita,"Banita saree","This saree contains floral work and looks very beautiful"),
        Shopping(R.drawable.chavari,"Chavari saree","This saree is available in different colors"),
        Shopping(R.drawable.jivika,"Jivika saree","This contains mixed colors which is available in diff colors also "),
        Shopping(R.drawable.lyca,"Lyca saree","This saree looks very beautiful and very attractive ")

    )
}
