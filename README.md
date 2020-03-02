# Cloudflare Bypass

A coroutine based kotlin library which bypasses the Cloudflare IUAM page.

This library is inspired by [KyranRana/cloudflare-bypass](https://github.com/KyranRana/cloudflare-bypass)
#### Dependencies

- OkHttp 4
- Mozilla Rhino

#### Installation
...

#### Usage

Requesting a cloudflare-protected webpage.

```kotlin
runBlocking {
    val client = CloudflareHTTPClient()

    //Returns an OkHttp Response object
    val response = client.get("https://www.example.com")
}
```

Requesting a cloudflare-protected webpage with custom headers

```kotlin
runBlocking {
    val client = CloudflareHTTPClient()

    //Returns an OkHttp Response object
    val response = client.get("https://www.example.com") {
        addHeader("X-Custom", "1")
    }
}
```

Performing a post request to a cloudflare-protected webpage

```kotlin
runBlocking {
    val client = CloudflareHTTPClient()

    val formBody = FormBody.Builder()
        .add("testParams", "itWorks")
        .build()

    //Returns an OkHttp Response object
    val response = client.post("https://www.example.com", formBody)
}
```

Create a custom HTTP client

```kotlin
val client = CloudflareHTTPClient() {
    //cookieJar(...)
    //connectionSpecs(...)
}
```