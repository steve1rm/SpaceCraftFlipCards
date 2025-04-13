package me.androidbox.spacecraftflipcards

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform