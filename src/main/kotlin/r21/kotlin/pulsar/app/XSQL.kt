package r21.kotlin.pulsar.app

import ai.platon.pulsar.common.sql.ResultSetFormatter
import ai.platon.pulsar.ql.context.SQLContexts

import ai.platon.pulsar.browser.common.BrowserSettings
import ai.platon.pulsar.common.options.LoadOptions
import ai.platon.pulsar.context.PulsarContexts.createSession
import ai.platon.pulsar.crawl.fetch.driver.WebDriver
import ai.platon.pulsar.session.PulsarSession
import org.slf4j.LoggerFactory

/**
 * Demonstrates how to use X-SQL to query the Web.
 * */
fun main() {
    BrowserSettings.headless()

    val context = SQLContexts.create()
    val sql = """
select
      dom_first_text(dom, '#productTitle') as title,
      dom_first_text(dom, '#bylineInfo') as brand,
      dom_first_text(dom, '#price tr td:matches(^Price) ~ td, #corePrice_desktop tr td:matches(^Price) ~ td') as price,
      dom_first_text(dom, '#acrCustomerReviewText') as ratings,
      str_first_float(dom_first_text(dom, '#reviewsMedley .AverageCustomerReviews span:contains(out of)'), 0.0) as score
  from load_and_select('https://www.amazon.com/dp/B09V3KXJPB -i 1s -njr 3', 'body');
            """
    val rs = context.executeQuery(sql)
    println(ResultSetFormatter(rs, withHeader = true))
}