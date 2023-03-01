package r21.kotlin.pulsar.app.sites.amazon.AmazonCrawler

import ai.platon.pulsar.context.PulsarContexts
import ai.platon.pulsar.browser.common.BrowserSettings
import ai.platon.pulsar.common.options.LoadOptions
import ai.platon.pulsar.context.PulsarContexts.createSession
import ai.platon.pulsar.crawl.fetch.driver.WebDriver
import ai.platon.pulsar.session.PulsarSession
import org.slf4j.LoggerFactory

fun main() = PulsarContexts.createSession().scrapeOutPages(
    BrowserSettings.headless()

    "https://www.amazon.com/Best-Sellers/zgbs",
    "-outLink a[href~=/dp/]",
    mapOf("title" to "#title", "ratings" to "#acrCustomerReviewText")
).let { println(it) }