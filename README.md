<h1 align="center">Cloudflare Bypass</h1><br>
<p align="center">
💠️A coroutine based kotlin library which bypasses the Cloudflare IUAM page.<br>
Inspired by <a href="https://github.com/KyranRana/cloudflare-bypass">KyranRana/cloudflare-bypass</a>
</p>
<br>

<p align="center">
  <a href="https://circleci.com/gh/Marplex/CloudflareBypass"><img alt="CircleCI" src="https://circleci.com/gh/Marplex/CloudflareBypass.svg"/></a>
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://github.com/Marplex"><img alt="License" src="https://img.shields.io/static/v1?label=GitHub&message=marplex&color=005cb2"/></a> 
</p>

## Features

- [x] HTTP `GET`/`POST`
- [x] Bypasses regular anti-bot page 

## Dependencies

- OkHttp 4
- Mozilla Rhino

## Installation
Add jcenter repository
```gradle
repositories {
    jcenter()
}
```

And add a dependency code

```gradle
implementation 'me.marplex.cloudflarebypass:cloudflare-bypass:1.1'
```

## Usage

Requesting a cloudflare-protected webpage.

```kotlin
runBlocking {
    val client = CloudflareHTTPClient()

    //Returns an OkHttp Response object
    val url = "https://www.example.com".toHttpUrlOrNull()!!
    val response = client.get(url)
}
```

Requesting a cloudflare-protected webpage with custom headers

```kotlin
runBlocking {
    val client = CloudflareHTTPClient()

    //Returns an OkHttp Response object
    val url = "https://www.example.com".toHttpUrlOrNull()!!
    val response = client.get(url) {
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
    val url = "https://www.example.com".toHttpUrlOrNull()!!
    val response = client.post(url, formBody)
}
```

Create a custom HTTP client

```kotlin
val client = CloudflareHTTPClient() {
    delay = 8000
    httpClient = {
        //cookieJar(...)
        //connectionSpecs(...)
    }
}
```

## Todo

- [ ] Implement every HTTP methods
- [ ] Make this library more portable (Android)
- [ ] Try to bypass captcha