/*
 *  Copyright (c) 2019 Mattel, Inc. All rights reserved.
 *  All information and code contained herein is the property of Mattel, Inc.
 *  Any unauthorized use, storage, duplication, and redistribution of this
 *  material without written permission from Mattel, Inc. is strictly prohibited.
 *  
 *
 */

package com.martinboy.fragmentlib

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.martinboy.fragmentlib.test", appContext.packageName)
    }
}
