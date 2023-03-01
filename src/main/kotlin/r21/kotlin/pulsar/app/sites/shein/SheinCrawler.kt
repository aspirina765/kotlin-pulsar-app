package r21.kotlin.pulsar.app.sites.shein.SheinCrawler

import ai.platon.pulsar.context.PulsarContexts

fun main() {
    val portalUrl = "https://us.shein.com/New-in-Trends-sc-00654187.html"
    val args = "-i 1d -ii 5d -ol a[href~=-cat-] -ignoreFailure -headless"
    PulsarContexts.createSession().loadOutPages(portalUrl, args)
}