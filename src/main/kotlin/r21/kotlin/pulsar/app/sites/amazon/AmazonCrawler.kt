package r21.kotlin.pulsar.app.sites.amazon.AmazonCrawler

import ai.platon.pulsar.context.PulsarContexts

fun main() = PulsarContexts.createSession().scrapeOutPages(
    "https://www.amazon.com/Best-Sellers/zgbs",
    "-headless -outLink a[href~=/dp/]",
    mapOf("title" to "#title", "ratings" to "#acrCustomerReviewText")
).let { println(it) }