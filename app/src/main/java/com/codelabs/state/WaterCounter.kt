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

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
@SuppressLint("UnrememberedMutableState")
@Composable
fun WaterCounter(modifier: Modifier = Modifier){
    //var count = 0;

    Column (modifier = Modifier.padding(16.dp)){
        val count: MutableState <Int> = remember {mutableStateOf(0)}

    Text(
        text = "Llevas ${count.value} vasos de agua hoy.",
        modifier = modifier.padding(16.dp)
    )
    Button(onClick = {count.value++},
    modifier.padding(8.dp)
    ) {
        Text("Bebete otro vaso de agua")
    }
    }
}

@Preview
@Composable
fun  WaterCounterPreview(){

    WaterCounter()
}


//@Composable
//fun StatefulCounter(modifier: Modifier = Modifier) {
//    var count by rememberSaveable { mutableStateOf(0) }
//    StatelessCounter(
//        count = count,
//        onIncrement = { count++ },
//        modifier = modifier
//    )
//}
//
//@Composable
//fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
//    Column(modifier = modifier.padding(16.dp)) {
//        if (count > 0) {
//            Text("You've had $count glasses.")
//        }
//        Button(
//            onClick = onIncrement,
//            enabled = count < 10,
//            modifier = Modifier.padding(top = 8.dp)
//        ) {
//            Text("Add one")
//        }
//    }
//}




