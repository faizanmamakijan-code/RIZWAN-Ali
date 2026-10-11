package com.example.ui.components

import android.app.Activity
import android.content.Context
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.common.AdRequestError
import com.yandex.mobile.ads.interstitial.InterstitialAd
import com.yandex.mobile.ads.interstitial.InterstitialAdLoader
import com.yandex.mobile.ads.interstitial.InterstitialAdLoadListener

object YandexInterstitialAdManager {
    private var interstitialAd: InterstitialAd? = null

    fun loadAd(context: Context, adUnitId: String) {
        val loader = InterstitialAdLoader(context)
        loader.setAdLoadListener(object : InterstitialAdLoadListener {
            override fun onAdLoaded(ad: InterstitialAd) {
                interstitialAd = ad
            }
            override fun onAdFailedToLoad(error: AdRequestError) {}
        })
        loader.loadAd(AdRequest.Builder().setAdUnitId(adUnitId).build())
    }

    fun showAd(activity: Activity) {
        interstitialAd?.show(activity)
        interstitialAd = null
    }
}
