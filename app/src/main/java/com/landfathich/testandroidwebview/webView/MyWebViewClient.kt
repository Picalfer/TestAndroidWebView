package com.landfathich.testandroidwebview.webView

import android.graphics.Bitmap
import android.util.Log
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import com.landfathich.testandroidwebview.MainActivity
import com.landfathich.testandroidwebview.R

class MyWebViewClient : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
        view.loadUrl(request.url.toString())
        Log.d("TEST", request.url.toString())
        val id = request.url.toString().substringAfter("id=").substringBefore("&uuid")
        val uuid = request.url.toString().substringAfter("uuid=")
        Log.d("TEST ID", id)
        Log.d("TEST UUID", uuid)
        return true
    }

    override fun onPageFinished(view: WebView, url: String) {
        super.onPageFinished(view, url)
        val context = view.context as MainActivity
        val progressBar = context.findViewById<ProgressBar>(R.id.progress_bar)
        progressBar.visibility = View.GONE
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
    }
}