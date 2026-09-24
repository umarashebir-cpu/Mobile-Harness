package com.jarves.mh.runtime

internal fun supportsNativeRuntime(supportedAbis: Array<String>, osArchitecture: String?): Boolean {
    val kernelIsArm = osArchitecture.equals("aarch64", ignoreCase = true) ||
        osArchitecture.equals("arm64", ignoreCase = true) ||
        osArchitecture.equals("arm", ignoreCase = true) ||
        osArchitecture.equals("armv7l", ignoreCase = true)
    return kernelIsArm && supportedAbis.any {
        it.equals("arm64-v8a", ignoreCase = true) ||
            it.equals("armeabi-v7a", ignoreCase = true)
    }
}
