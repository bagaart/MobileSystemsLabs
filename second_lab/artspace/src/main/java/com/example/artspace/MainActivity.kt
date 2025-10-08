package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                ArtSpace()
            }
        }
    }
}

data class Landmark(
    @DrawableRes val imageId: Int,
    @StringRes val titleId: Int,
    @StringRes val descriptionId: Int
)

@Composable
fun ArtSpace() {
    val landmarks = listOf(
        Landmark(R.drawable.eiffel_tower, R.string.eiffel_tower_title, R.string.eiffel_tower_description),
        Landmark(R.drawable.great_wall, R.string.great_wall_title, R.string.great_wall_description),
        Landmark(R.drawable.colosseum, R.string.colosseum_title, R.string.colosseum_description),
        Landmark(R.drawable.pyramids, R.string.pyramids_title, R.string.pyramids_description),
        Landmark(R.drawable.statue_of_liberty, R.string.statue_of_liberty_title, R.string.statue_of_liberty_description)
    )

    var currentIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .weight(0.8f)
                .widthIn(max = 500.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ImageAndText(
                imageId = landmarks[currentIndex].imageId,
                titleId = landmarks[currentIndex].titleId,
                descriptionId = landmarks[currentIndex].descriptionId
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(max = 600.dp)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    currentIndex = (currentIndex - 1 + landmarks.size) % landmarks.size
                },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(10.dp),
                enabled = landmarks.size > 1
            ) {
                Text(
                    text = "Предыдущее",
                    textAlign = TextAlign.Center
                )
            }

            Spacer(Modifier.width(16.dp))

            Button(
                onClick = {
                    currentIndex = (currentIndex + 1) % landmarks.size
                },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(10.dp),
                enabled = landmarks.size > 1
            ) {
                Text(
                    text = "Следующее",
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(Modifier.height(24.dp))
    }
}

@Composable
fun ImageAndText(
    @DrawableRes imageId: Int,
    @StringRes titleId: Int,
    @StringRes descriptionId: Int
) {
    Surface(
        shadowElevation = 10.dp,
        shape = RoundedCornerShape(8.dp),
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(24.dp)
        ) {
            Image(
                painter = painterResource(imageId),
                contentDescription = stringResource(titleId),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(Modifier.height(16.dp))

            Text(
                text = stringResource(titleId),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = stringResource(descriptionId),
                fontSize = 16.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 800)
@Composable
fun PhonePreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}

@Preview(showBackground = true, widthDp = 800, heightDp = 600)
@Composable
fun TabletPreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}

@Preview(showBackground = true, widthDp = 1200, heightDp = 800)
@Composable
fun DesktopPreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}