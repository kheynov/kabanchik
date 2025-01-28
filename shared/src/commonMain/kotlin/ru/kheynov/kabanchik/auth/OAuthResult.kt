package ru.kheynov.kabanchik.auth

sealed interface OAuthResult {
    data class Success(val token: OAuthToken) : OAuthResult
    data class Failure(val reason: String? = null, val throwable: Throwable? = null) : OAuthResult
    data object Cancelled : OAuthResult
}