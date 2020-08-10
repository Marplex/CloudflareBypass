import me.marplex.cloudflarebypass.CloudflareHTTPClient
import kotlinx.coroutines.runBlocking
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CloudflareBypassTest {

    private val client = CloudflareHTTPClient()

    @Test
    fun shouldReturnResponseWithouthBypassing() = runBlocking {
        val url = "https://www.example.com".toHttpUrlOrNull()!!
        val response = client.get(url)
        assertTrue(response.code == 200)
    }

    @Test
    fun shouldReturnRealWebpage() = runBlocking {
        val url = "https://www.seriehd.moda".toHttpUrlOrNull()!!
        val response = client.get(url)
        val body = response.body!!.string()
        val bodyPart = body.substring(260, 281)

        assertEquals("Serie TV Streaming HD", bodyPart)
    }
}