package r21.kotlin.pulsar.app.sites.shein.SheinCrawler

import ai.platon.pulsar.browser.common.BrowserSettings
import ai.platon.pulsar.context.PulsarContexts

fun main() {
    BrowserSettings.headless()
    val portalUrl = "https://br.shein.com/New-in-Trends-sc-00654187.html"
    val args = "-i 1d -ii 5d -ol a[href~=-cat-] -ignoreFailure"
    PulsarContexts.createSession().loadOutPages(portalUrl, args)
}
