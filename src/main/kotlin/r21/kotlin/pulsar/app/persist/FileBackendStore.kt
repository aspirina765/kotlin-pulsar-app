package r21.kotlin.pulsar.app.persist.FileBackendStore

import ai.platon.pulsar.browser.common.BrowserSettings
import ai.platon.pulsar.common.urls.UrlUtils
import ai.platon.pulsar.persist.WebPage
import ai.platon.pulsar.persist.WebPageExt
import ai.platon.pulsar.persist.gora.FileBackendPageStore
import java.nio.file.Files
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class FileBackendStore {
    private val url = "https://www.amazon.com/dp/B082P8J28M"
    private val persistDirectory = Files.createTempDirectory("pulsar-test")
    private val store = FileBackendPageStore(persistDirectory)
    private lateinit var page: WebPage

    fun setup() {
        page = WebPageExt.newTestWebPage(url)
    }

    fun whenWritePage_ThenAvroFileExists() {
        val path = store.getPersistPath(url, ".avro")
        store.writeAvro(page)
        assertTrue { Files.exists(path) }

        val key = UrlUtils.reverseUrl(url)
        val loadedPage = store.readAvro(key)
        assertNotNull(loadedPage)
    }

    fun whenWritePage_ThenReadSuccess() {
        store.writeAvro(page)

        val key = UrlUtils.reverseUrl(url)
        val loadedPage = store.readAvro(key)
        assertNotNull(loadedPage)
    }
}

fun main() {
    BrowserSettings.headless()
//    val url = "https://www.amazon.com/dp/B09V3KXJPB"
//    val args = "-refresh -parse"
//    val session = PulsarContexts.createSession()
    val url = "https://www.amazon.com/dp/B082P8J28M"
    val persistDirectory = Files.createTempDirectory("pulsar-test")
    val store = FileBackendPageStore(persistDirectory)
//    lateinit var page: WebPage
    val page = FileBackendStore().setup()
//    FileBackendStore().whenWritePage_ThenAvroFileExists()
//    FileBackendStore().whenWritePage_ThenReadSuccess()

}

