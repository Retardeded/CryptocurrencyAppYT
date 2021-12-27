package com.plcoding.githubrepoapp.presentation.repo_detail.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.plcoding.githubrepoapp.data.remote.dto.License
import com.plcoding.githubrepoapp.domain.model.Owner
import com.plcoding.githubrepoapp.domain.model.RepoDetail

@Composable
fun ProjectState(
    repoDetail:RepoDetail,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Created at: ${repoDetail.created_at}",
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Last update: ${repoDetail.updated_at}",
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Current issues: ${repoDetail.open_issues_count}",
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(15.dp))

    }
}