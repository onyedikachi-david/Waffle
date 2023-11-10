package com.example.waffle.injection

import com.solana.mobilewalletadapter.clientlib.RpcCluster

interface IRpcConfig {
    val solanaRpcUrl: String
    val rpcCluster: RpcCluster
}