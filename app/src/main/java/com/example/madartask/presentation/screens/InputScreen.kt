package com.example.madartask.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.madartask.presentation.viewmodel.InputViewModel
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun InputScreen(
    onUserSaved: () -> Unit,
    viewModel: InputViewModel = hiltViewModel()
) {
    val state = viewModel.uiState
    var genderExpanded by remember { mutableStateOf(false) }
    val genderOptions = listOf("Male", "Female", "Other")

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = state.name,
            onValueChange = viewModel::onNameChange,
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = state.age,
            onValueChange = viewModel::onAgeChange,
            label = { Text("Age") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = state.jobTitle,
            onValueChange = viewModel::onJobChange,
            label = { Text("Job Title") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box {
            OutlinedTextField(
                value = state.gender,
                onValueChange = {},
                label = { Text("Gender") },
                modifier = Modifier.fillMaxWidth(),
                readOnly = true
            )
            DropdownMenu(
                expanded = genderExpanded,
                onDismissRequest = { genderExpanded = false }
            ) {
                genderOptions.forEach {
                    DropdownMenuItem(
                        onClick = {
                            viewModel.onGenderChange(it)
                            genderExpanded = false
                        },
                        text = {
                            Text(it)
                        }
                    )
                }
            }

            Spacer(
                Modifier
                    .matchParentSize()
                    .clickable { genderExpanded = true }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { viewModel.addUser { onUserSaved() } },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save User")
        }
    }
}
