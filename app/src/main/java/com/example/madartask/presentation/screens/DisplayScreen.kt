package com.example.madartask.presentation.screens


import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.madartask.presentation.viewmodel.DisplayViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.material3.*
import com.example.madartask.domain.model.User
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayScreen(viewModel: DisplayViewModel = hiltViewModel(), onBack: () -> Unit) {
    val users by viewModel.users.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("All Users") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        if (users.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text("No users found", style = MaterialTheme.typography.bodyMedium)
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp)
            ) {
                items(users) { user ->
                    UserCard(user = user)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }

}

@Composable
fun UserCard(user: User) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Name: ${user.name}")
            Text("Age: ${user.age}")
            Text("Job Title: ${user.jobTitle}")
            Text("Gender: ${user.gender}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserCardPreview() {
    val user = User(
        id = 1,
        name = "Jane Doe",
        age = 30,
        jobTitle = "Software Engineer",
        gender = "Female"
    )
    UserCard(user = user)
}
