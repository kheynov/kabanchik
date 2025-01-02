package ru.kheynov.kabanchik

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform