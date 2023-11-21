/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.codelabs.state

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.magnifier
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier

@Composable
private fun WellnessTasksList() = List(30) {
        i ->WellnessTask(i,"Task #$i")
}


@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    list: List <WellnessTask> = rememberSaveable {
        getWellnessTasks()
    }
)
{
    LazyColumn(modifier = modifier){
        item(list){
                task -> WellnessTaskItem(taskName = task.label)
        }
    }
}