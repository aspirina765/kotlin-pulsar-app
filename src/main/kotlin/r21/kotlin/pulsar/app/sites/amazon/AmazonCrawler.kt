package r21.kotlin.pulsar.app.sites.amazon.AmazonCrawler

import ai.platon.pulsar.browser.common.BrowserSettings
import ai.platon.pulsar.context.PulsarContexts

fun main() {
    BrowserSettings.headless()
    PulsarContexts.createSession().scrapeOutPages(
        "https://www.amazon.com/Best-Sellers/zgbs",
        "-outLink a[href~=/dp/]",
        mapOf("title" to "#title", "ratings" to "#acrCustomerReviewText")
    ).let { println(it) }
}