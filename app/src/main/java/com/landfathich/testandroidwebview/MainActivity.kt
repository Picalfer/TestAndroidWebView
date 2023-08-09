package com.landfathich.testandroidwebview

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.landfathich.testandroidwebview.Constants.URL
import com.landfathich.testandroidwebview.databinding.ActivityMainBinding
import com.landfathich.testandroidwebview.storage.AppPreferences
import com.landfathich.testandroidwebview.webView.MyWebViewClient

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var appPreferences: AppPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        appPreferences = AppPreferences(this)

        binding.apply {
            if (appPreferences?.getStringValue(Constants.ID) != null &&
                appPreferences?.getStringValue(Constants.UUID) != null
            ) {
                tvInfoStart.visibility = View.VISIBLE
                val id = appPreferences?.getStringValue(Constants.ID)
                val uuid = appPreferences?.getStringValue(Constants.UUID)
                tvInfoStart.text = "id = $id \nuuid = $uuid"
            }

            btnDownload.setOnClickListener {
                btnDownload.visibility = View.GONE
                progressBar.visibility = View.VISIBLE
                initWebView()
            }
        }
    }

    private fun initWebView() = with(binding) {
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