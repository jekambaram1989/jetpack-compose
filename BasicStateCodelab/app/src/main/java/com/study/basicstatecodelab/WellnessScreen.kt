package com.study.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(
        modifier = modifier
    ) {
        StatefulCounter()
        WellnessTaskList(
            list = wellnessViewModel.task,
            onCheckedTask = { task, checked ->
                wellnessViewModel.changedTaskChecked(task, checked)

            },
            onCloseTask = { task ->
                wellnessViewModel.remove(item = task)
            })
    }
}