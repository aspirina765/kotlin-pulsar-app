package r21.kotlin.pulsar.app.sites.shein.SheinCrawler

import ai.platon.pulsar.context.PulsarContexts

fun main() {
    val portalUrl = "https://www.mercadolivre.com.br/c/celulares-e-telefones#menu=categories"
    val args = "-i 1d -ii 5d -ol a[href~=-cat-] -ignoreFailure -headless"
    PulsarContexts.createSession().loadOutPages(portalUrl, args)
}