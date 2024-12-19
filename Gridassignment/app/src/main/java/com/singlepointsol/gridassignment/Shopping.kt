package com.singlepointsol.gridassignment



data class Shopping(val shoppingImage: Int, val shoppingName: String, val shoppingDetails: String)

fun getAllShopping(): ArrayList<Shopping> {
    return arrayListOf(
        Shopping(R.drawable.saree, "Georgette Saree", "This saree is available in different colors and suitable for partywear"),
        Shopping(R.drawable.banita, "Banita Saree", "This saree contains floral work and looks very beautiful"),
        Shopping(R.drawable.chavari, "Chavari Saree", "This saree is available in different colors"),
        Shopping(R.drawable.jivika, "Jivika Saree", "This contains mixed colors and is available in different colors as well"),
        Shopping(R.drawable.lyca, "Lyca Saree", "This saree looks very beautiful and is very attractive")
    )
}

