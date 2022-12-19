package com.nowik.numberslight.ui.viewmodels

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class NetworkStateViewModel(app: Application) : AndroidViewModel(app) {

    val connectivityState = MutableStateFlow(true)

    init {
        val manager =
            getApplication<Application>().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkRequest = NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .build()
        manager.registerNetworkCallback(networkRequest, object : NetworkCallback() {
            override fun onAvailable(network: Network) {
                changeConnectivityState(true)
            }

            override fun onLost(network: Network) {
                changeConnectivityState(false)
            }

            override fun onUnavailable() {
                changeConnectivityState(false)
            }
        })
    }

    fun changeConnectivityState(enabled: Boolean) = viewModelScope.launch(Dispatchers.IO) {
        connectivityState.emit(enabled)
    }
}