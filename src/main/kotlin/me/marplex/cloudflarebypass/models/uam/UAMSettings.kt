package me.marplex.cloudflarebypass.models.uam

import okhttp3.OkHttpClient

data class UAMSettings(var delay: Long = 4000, var httpClient:(OkHttpClient.Builder.() -> Unit)? = null)