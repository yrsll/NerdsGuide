package com.example.nerdsguide.util

sealed class DrawerEvents {
    data class OnItemClick( val title:String, val index: Int):DrawerEvents()
}
