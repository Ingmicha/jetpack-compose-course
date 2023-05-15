package com.ingmicha.android.udemy.novo.compose.jetpackcomposejobs.addTasks.data.domain

import com.ingmicha.android.udemy.novo.compose.jetpackcomposejobs.addTasks.data.TaskRepository
import com.ingmicha.android.udemy.novo.compose.jetpackcomposejobs.addTasks.ui.model.TaskModel
import javax.inject.Inject

class AddTaskUseCase @Inject constructor(private val taskRepository: TaskRepository) {

    suspend operator fun invoke(taskModel: TaskModel) {
        taskRepository.add(taskModel)
    }

}