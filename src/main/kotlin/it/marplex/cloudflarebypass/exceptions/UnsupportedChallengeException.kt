package it.marplex.cloudflarebypass.exceptions

import java.lang.Exception

/**
 * Exception thrown by [CloudflareHTTPClient] when the page has an unsupported challenge.
 * Es: captcha challenge
 */
class UnsupportedChallengeException: Exception()