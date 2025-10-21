package com.example.a30days

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30days.model.Scientist
import com.example.a30days.ui.theme.MonthTheme
import com.example.a30days.model.ScientistsRepository.scientists

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MonthTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ScientistApp()
                }
            }
        }
    }
}

@Composable
fun ScientistApp()
{
    Scaffold(
        topBar = { ScientistTopBar() }
    ) {
        ScientistList(scientists = scientists, contentPadding = it)
    }
}

@Composable
fun ScientistList(
    scientists: List<Scientist>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        items(scientists) {
            ScientistListItem(
                scientist = it,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun ScientistListItem(
    scientist: Scientist,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.primaryContainer,
    )
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .background(color = color)
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(scientist.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(500.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.FillHeight
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth().padding(top = 8.dp)
            ) {
                Text(
                    text = stringResource(scientist.nameRes),
                    style = MaterialTheme.typography.displayMedium,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Spacer(Modifier.weight(1f))
                ScientistItemButton(
                    expanded = expanded,
                    onClick = {expanded = !expanded}
                )
            }
            if (expanded) {
                Text(
                    text = stringResource(scientist.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
fun ScientistItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandMore else Icons.Filled.ExpandLess,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScientistTopBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Учёные люди",
                style = MaterialTheme.typography.displayLarge
            )
        },
        modifier = modifier
    )
}


@Preview()
@Composable
fun ScientistAppPreview() {
    MonthTheme(darkTheme = false) {
        ScientistApp()
    }
}

@Preview(showBackground = true)
@Composable
fun ScientistDarkThemePreview() {
    MonthTheme(darkTheme = true) {
        ScientistApp()
    }
}
