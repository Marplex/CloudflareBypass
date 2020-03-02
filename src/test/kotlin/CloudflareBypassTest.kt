import it.marplex.cloudflarebypass.CloudflareHTTPClient
import kotlinx.coroutines.runBlocking
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

        val check = body.indexOf("Serie TV Streaming HD") > 0
        assertTrue(check)
    }
}