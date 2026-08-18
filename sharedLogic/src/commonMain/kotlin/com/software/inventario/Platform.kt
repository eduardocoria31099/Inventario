package com.software.inventario

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform