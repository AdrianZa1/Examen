/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.examen.data

import android.adservices.topics.Topic
import android.os.ext.SdkExtensions
import androidx.annotation.RequiresExtension

import com.example.inventory.R

object DataSource {
    @RequiresExtension(extension = SdkExtensions.AD_SERVICES, version = 4)
    val topics = listOf(
        Topic(R.string.culinary.toLong(), 58, R.drawable.culinary),
        Topic(R.string.design.toLong(), 30, R.drawable.design),
        Topic(R.string.drawing.toLong(), 90, R.drawable.drawing),
        Topic(R.string.ecology.toLong(), 121, R.drawable.ecology),
        Topic(R.string.engineering.toLong(), 78, R.drawable.engineering),
                                    
    )
}
