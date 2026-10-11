package com.example.ui.components

import android.app.Activity
import android.content.Context
import com.yandex.mobile.ads.appopenad.AppOpenAd
import com.yandex.mobile.ads.appopenad.AppOpenAdLoader
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.common.AdRequestError
import com.yandex.mobile.ads.appopenad.AppOpenAdLoadListener

object YandexAppOpenAdManager {
    private var appOpenAd: AppOpenAd? = null
    
    fun loadAd(context: Context, adUnitId: String) {
        val loader = AppOpenAdLoader(context)
        loader.setAdLoadListener(object : AppOpenAdLoadListener {
            override fun onAdLoaded(ad: AppOpenAd) {
                appOpenAd = ad
            }
            override fun onAdFailedToLoad(error: AdRequestError) {
                // Fail gracefully
            }
        })
        loader.loadAd(AdRequest.Builder().build())
    }

    fun showAd(activity: Activity) {
        appOpenAd?.show(activity)
    }
}
