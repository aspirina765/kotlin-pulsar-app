package r21.kotlin.pulsar.app.sites.ebay.EbayCrawler

import ai.platon.pulsar.context.PulsarContexts

import ai.platon.pulsar.browser.common.BrowserSettings


fun main() {
    BrowserSettings.headless()
    val portalUrl = "https://www.ebay.com/b/Dolce-Gabbana-Bags-Handbags-for-Women/169291/bn_716146"
    val args = "-i 1s -ii 5d -ol a[href~=itm] -ignoreFailure -headless"
    PulsarContexts.createSession().loadOutPages(portalUrl, args)
}
