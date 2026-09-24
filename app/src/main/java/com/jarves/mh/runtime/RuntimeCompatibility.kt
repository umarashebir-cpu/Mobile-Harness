package com.jarves.mh.runtime

internal fun supportsNativeRuntime(supportedAbis: Array<String>, osArchitecture: String?): Boolean {
    // Build.SUPPORTED_ABIS is Android's authoritative native ABI declaration.
    // Some 32-bit Android builds report an empty, vendor-specific, or 64-bit
    // kernel os.arch value, so never reject a valid ARM ABI based on that hint.
    val hasArm32Abi = supportedAbis.any { it.equals("armeabi-v7a", ignoreCase = true) }
    val hasArm64Abi = supportedAbis.any { it.equals("arm64-v8a", ignoreCase = true) }
    return hasArm32Abi || hasArm64Abi
}
