package com.example.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.yandex.mobile.ads.banner.BannerAdSize
import com.yandex.mobile.ads.banner.BannerAdView
import com.yandex.mobile.ads.common.AdRequest

@Composable
fun YandexBannerView(
    adUnitId: String,
    modifier: Modifier = Modifier
) {
    AndroidView(
        modifier = modifier.fillMaxWidth(),
        factory = { context ->
            BannerAdView(context).apply {
                setAdSize(BannerAdSize.sticky(context, 320))
                loadAd(AdRequest.Builder().setAdUnitId(adUnitId).build())
            }
        }
    )
}
