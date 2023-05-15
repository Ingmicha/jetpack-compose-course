package com.ingmicha.android.udemy.novo.compose.jetpackcomposejobs.addTasks.data.domain

import com.ingmicha.android.udemy.novo.compose.jetpackcomposejobs.addTasks.data.TaskRepository
import com.ingmicha.android.udemy.novo.compose.jetpackcomposejobs.addTasks.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(private val taskRepository: TaskRepository) {
    operator fun invoke(): Flow<List<TaskModel>> = taskRepository.tasks
}