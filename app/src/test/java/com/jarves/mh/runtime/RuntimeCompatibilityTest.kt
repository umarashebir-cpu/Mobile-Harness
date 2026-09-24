package com.jarves.mh.runtime

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class RuntimeCompatibilityTest {
    @Test
    fun acceptsNativeArm64Android() {
        assertTrue(supportsNativeRuntime(arrayOf("arm64-v8a", "armeabi-v7a"), "aarch64"))
    }

    @Test
    fun acceptsNativeArm32Android() {
        assertTrue(supportsNativeRuntime(arrayOf("armeabi-v7a"), "armv7l"))
    }

    @Test
    fun rejectsNonArmAndMissingArmAbi() {
        assertFalse(supportsNativeRuntime(arrayOf("arm64-v8a", "x86_64"), "x86_64"))
        assertFalse(supportsNativeRuntime(arrayOf("x86_64", "x86"), "x86_64"))
    }
}
