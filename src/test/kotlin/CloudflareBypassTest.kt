import io.marplex.cloudflarebypass.CloudflareHTTPClient
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CloudflareBypassTest {

    private val client = CloudflareHTTPClient()

    @Test
    fun shouldReturnResponseWithouthBypassing() = runBlocking {
        val response = client.get("https://www.example.com")
        assertTrue(response.code == 200)
    }

    @Test
    fun shouldReturnRealWebpage() = runBlocking {
        val response = client.get("https://www.seriehd.moda")
        val body = response.body!!.string()
        val bodyPart = body.substring(260, 281)

        assertEquals("Serie TV Streaming HD", bodyPart)
    }
}