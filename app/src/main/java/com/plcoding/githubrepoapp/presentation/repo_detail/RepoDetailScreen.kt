package com.plcoding.githubrepoapp.presentation.repo_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.flowlayout.FlowRow
import com.plcoding.githubrepoapp.presentation.repo_detail.components.ProjectState
import com.plcoding.githubrepoapp.presentation.repo_detail.components.RepoLicense
import com.plcoding.githubrepoapp.presentation.repo_detail.components.TopicListItem

@Composable
fun RepoDetailScreen(
    viewModel: RepoDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.repo?.let { repo ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        val myId = "inlineContent"

                        val text = buildAnnotatedString {
                            append("${repo.name}:  ")
                            if(repo.forks > 0 )
                                append("${repo.forks} forks, ")
                            if(repo.stargazers_count > 0) {
                                append("${repo.stargazers_count} ")
                                // Append a placeholder string "[icon]" and attach an annotation "inlineContent" on it.
                                appendInlineContent(myId, "[icon]")
                            }
                        }

                        val inlineContent = mapOf(
                            Pair(
                                // This tells the [CoreText] to replace the placeholder string "[icon]" by
                                // the composable given in the [InlineTextContent] object.
                                myId,
                                InlineTextContent(
                                    // Placeholder tells text layout the expected size and vertical alignment of
                                    // children composable.
                                    Placeholder(
                                        width = 12.sp,
                                        height = 12.sp,
                                        placeholderVerticalAlign = PlaceholderVerticalAlign.AboveBaseline
                                    )
                                ) {
                                    // This Icon will fill maximum size, which is specified by the [Placeholder]
                                    // above. Notice the width and height in [Placeholder] are specified in TextUnit,
                                    // and are converted into pixel by text layout.

                                    Icon(Icons.Filled.Star,"",tint = Color.Yellow)
                                }
                            )
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = text,
                                modifier = Modifier
                                    .width(250.dp),
                                inlineContent = inlineContent,
                                style = MaterialTheme.typography.body1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                overflow = TextOverflow.Ellipsis,
                                text = repo.language ?: "",
                                fontStyle = FontStyle.Italic,
                                textAlign = TextAlign.End,
                                style = MaterialTheme.typography.body2,
                                modifier = Modifier.align(CenterVertically)
                            )
                        }

                    }

                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Description",
                        style = MaterialTheme.typography.h3
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = repo.description?: "",
                        style = MaterialTheme.typography.body2
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    if(repo.topics.isNotEmpty()) {
                        Text(
                            text = "Related topics",
                            style = MaterialTheme.typography.h3
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        FlowRow(
                            mainAxisSpacing = 10.dp,
                            crossAxisSpacing = 10.dp,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            repo.topics.forEach { topic ->
                                TopicListItem(topic = topic)
                            }
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                    repo.license?.let {
                        Text(
                            text = "License ",
                            style = MaterialTheme.typography.h3
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        RepoLicense(
                            license = it
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = "Project State ",
                        style = MaterialTheme.typography.h3
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    ProjectState(
                        repoDetail = repo
                    )

                }
            }
        }
        if(state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}