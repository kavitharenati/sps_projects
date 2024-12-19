package com.singlepointsol.versionslazycolumn

data class Version(val versionImage:Int, val versionName:String, val versionDetails:String )
fun getAllVersions(): ArrayList<Version>{
    return arrayListOf(
        Version(R.drawable.milk,"milkshake","It is available in diff flavours"),
        Version(R.drawable.pnk,"Rose","It is available in diff colors"),
        Version(R.drawable.sun,"sunflower","It is available in yellow and purple colors"),
        Version(R.drawable.welcome,"welcome","welcome to my world"),

    )
}
