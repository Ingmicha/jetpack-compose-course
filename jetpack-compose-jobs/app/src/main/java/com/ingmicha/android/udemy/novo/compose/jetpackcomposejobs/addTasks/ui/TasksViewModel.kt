package com.ingmicha.android.udemy.novo.compose.jetpackcomposejobs.addTasks.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ingmicha.android.udemy.novo.compose.jetpackcomposejobs.addTasks.data.domain.AddTaskUseCase
import com.ingmicha.android.udemy.novo.compose.jetpackcomposejobs.addTasks.data.domain.DeleteTaskUseCase
import com.ingmicha.android.udemy.novo.compose.jetpackcomposejobs.addTasks.data.domain.GetTasksUseCase
import com.ingmicha.android.udemy.novo.compose.jetpackcomposejobs.addTasks.data.domain.UpdateTaskUseCase
import com.ingmicha.android.udemy.novo.compose.jetpackcomposejobs.addTasks.ui.TasksUiState.Success
import com.ingmicha.android.udemy.novo.compose.jetpackcomposejobs.addTasks.ui.model.TaskModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(
    private val addTaskUseCase: AddTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    getTasksUseCase: GetTasksUseCase
) : ViewModel() {

    val uiState: StateFlow<TasksUiState> = getTasksUseCase().map(::Success)
        .catch { Error(it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), TasksUiState.Loading)

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

    fun onDialogClose() {
        _showDialog.value = false
    }

    fun onTasksCreated(task: String) {
        _showDialog.value = false
        viewModelScope.launch {
            addTaskUseCase(TaskModel(task = task))
        }
    }

    fun onShowDialogClick() {
        _showDialog.value = true
    }

    fun onCheckBoxSelected(taskModel: TaskModel) {
        viewModelScope.launch {
            updateTaskUseCase(taskModel.copy(selected = !taskModel.selected))
        }
    }

    fun onItemRemove(taskModel: TaskModel) {
        viewModelScope.launch {
            deleteTaskUseCase(taskModel)
        }
    }

}