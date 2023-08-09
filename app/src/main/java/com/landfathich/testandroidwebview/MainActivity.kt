package com.landfathich.testandroidwebview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.landfathich.testandroidwebview.Constants.URL
import com.landfathich.testandroidwebview.databinding.ActivityMainBinding
import com.landfathich.testandroidwebview.webView.MyWebViewClient

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.apply {
            btnDownload.setOnClickListener {
                btnDownload.visibility = View.GONE
                progressBar.visibility = View.VISIBLE
                initWebView()
            }
        }
    }

    private fun initWebView() = with(binding){
        webView.webViewClient = MyWebViewClient()
        webView.settings.apply {
            allowFileAccess = true
            javaScriptEnabled = true
        }

        webView.loadUrl(URL)
    }

    override fun onBackPressed() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

}