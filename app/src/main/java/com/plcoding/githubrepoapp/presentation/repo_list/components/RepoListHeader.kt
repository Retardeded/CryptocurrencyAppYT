package com.plcoding.githubrepoapp.presentation.repo_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.plcoding.githubrepoapp.domain.model.Owner
import com.plcoding.githubrepoapp.domain.model.Repo

@Composable
fun RepoListHeader(
    owner:Owner,
    numOfRepos:Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = rememberImagePainter(owner.avatar_url),
            contentDescription = null,
            modifier = Modifier.size(80.dp),
            alignment = Alignment.BottomCenter
        )
        Text(
            text = "Currently owns ${numOfRepos} public github repositories",
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(CenterVertically)
        )
    }
}