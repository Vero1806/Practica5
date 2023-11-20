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
import androidx.compose.foundation.layout.Row
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
fun WaterCounter(modifier: Modifier = Modifier){ //remberSaveable matiene los cambios cuando giro la pantalla
    //var count = 0;

    Column (modifier = Modifier.padding(16.dp)){
        var count by rememberSaveable {mutableStateOf(0)} //: MutableState <Int> =

        if (count>0){
          //  var showTask by remember {mutableStateOf(true)}
          //  if(showTask){
          //      WellnessTaskItem(taskName = "¿Has estado ando tus 15 minutos diarios hoy?",
          //      onClose = {showTask = false})
          //  }
        }

        if (count == 0){
            Text(
                text = "Llevas $count vasos de agua hoy.", //count.value
                modifier = modifier.padding(16.dp)
            )}

        else if (count >= 1) {Text(
            text = "Llevas $count vasos de agua hoy.", //count.value
            modifier = modifier.padding(16.dp)
        )}

    Row (modifier = modifier .padding(top = 8.dp)){

    Button(onClick = {count ++}, //count.value++
    modifier, enabled = count <10  // desactiva el botón cuando llega a 10

    ) {
        Text("Bebete otro vaso de agua")
    }
     //   if (count > 0){
     //   Button(onClick = {count = 0}, modifier,) {
     //       Text(text = "Ya vale de basos de agua por hoy")
     //   }
     //   }
    }
    }
}
@Composable
fun statelessCounter(name: String, count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier){

    Column(modifier = Modifier.padding(16.dp)) {
        if (count == 0) {
            Text(
                text = "Llevas $count vasos de $name hoy.", //count.value
                modifier = modifier.padding(16.dp)
            )
        } else if (count >= 1) {
            Text(
                text = "Llevas $count vasos de $name hoy.", //count.value
                modifier = modifier.padding(16.dp)
            )
        }

        Row(modifier = modifier.padding(top = 8.dp)) {

            Button(
                onClick = onIncrement, //count.value++
                modifier, enabled = count < 10  // desactiva el botón cuando llega a 10
            ) {
                Text("Bebete otro vaso de agua")
            }
        }
    }
}

@Composable
fun StatefulCounter (modifier: Modifier = Modifier){
    var waterCount by rememberSaveable {mutableStateOf(0)}
    var juiceCount by rememberSaveable {mutableStateOf(0)}
    Column {
    statelessCounter(count = waterCount, onIncrement = {waterCount++}) // onIncrement incrementa el contador en una función pero sustituyendo con vectores.
    statelessCounter(count = juiceCount, onIncrement = {juiceCount++})
    }
}

@Preview
@Composable
fun  WaterCounterPreview(){

    StatefulCounter()
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




