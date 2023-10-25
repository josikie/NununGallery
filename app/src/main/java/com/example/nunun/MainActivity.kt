package com.example.nunun

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nunun.ui.theme.ArtSpaceTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.example.nunun.ui.theme.Gray80
import com.example.nunun.ui.theme.Purple40
import com.example.nunungallery.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceUI()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceUI(modifier: Modifier = Modifier) {
    var artPicture by remember { mutableStateOf(1) }
    val imageResource = when (artPicture) {
        1 -> R.drawable.nunun_1
        2 -> R.drawable.nunun_2
        3 -> R.drawable.nunun_3
        4 -> R.drawable.nunun_4
        5 -> R.drawable.nunun_5
        6 -> R.drawable.nunun_6
        7 -> R.drawable.nunun_7
        8 -> R.drawable.nunun_8
        9 -> R.drawable.nunun_9
        10 -> R.drawable.nunun_10
        else -> R.drawable.nunun_7
    }

    val descResource = when (artPicture) {
        1 -> R.string.nunun_1
        2 -> R.string.nunun_2
        3 -> R.string.nunun_3
        4 -> R.string.nunun_4
        5 -> R.string.nunun_5
        6 -> R.string.nunun_6
        7 -> R.string.nunun_7
        8 -> R.string.nunun_8
        9 -> R.string.nunun_9
        10 -> R.string.nunun_10
        else -> R.string.unknown_pict
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        Spacer(modifier = modifier.padding(20.dp))
        //Image
        BoxWithConstraints() {
            if (maxWidth < 500.dp) {
                ArtPictureUI(picture = imageResource, pictureDescription = descResource)
            }else{
                ArtPictureUI(photoSize = 500.dp,picture = imageResource, pictureDescription = descResource)
            }
        }
        //Art Title
        //Back and next buttons
        Spacer(modifier = modifier.padding(40.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ArtTitleUI(descResource, R.string.artist_josi, R.string.year_taken_2023)
            Spacer(modifier = modifier.height(30.dp))
            BoxWithConstraints() {
                if (maxWidth > 500.dp) {
                    Row(
                        modifier = modifier.fillMaxWidth().padding(bottom = 20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        // button previous
                        Button(onClick = {
                            // update to the previous image
                            // update to the previous art title
                            // update to the previous artist
                            // update to the previous taken created
                            if (artPicture > 1) {
                                artPicture -= 1
                            }

                        }, modifier = modifier
                            .width(200.dp)
                            .height(60.dp),
                            colors = ButtonDefaults.buttonColors(Purple40)
                        ) {
                            Text(text = stringResource(id = R.string.previous_text_button), fontSize = 22.sp)
                        }
                        // button next
                        Button(
                            onClick = {
                                // update to the next image
                                // update to the next art title
                                // update to the next artist
                                // update to the next taken created
                                if (artPicture < 4) {
                                    artPicture += 1
                                }
                            },
                            modifier = modifier
                                .width(200.dp)
                                .height(60.dp),
                            colors = ButtonDefaults.buttonColors(Purple40)
                        ) {
                            Text(text = stringResource(id = R.string.next_text_button), fontSize = 22.sp)
                        }
                    }
                } else {
                    Row(
                        modifier = modifier.fillMaxWidth().padding(bottom = 20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        // button previous
                        Button(onClick = {
                            // update to the previous image
                            // update to the previous art title
                            // update to the previous artist
                            // update to the previous taken created
                            if (artPicture > 1) {
                                artPicture -= 1
                            }

                        }, modifier = modifier
                            .width(120.dp)
                            .height(40.dp),
                            colors = ButtonDefaults.buttonColors(Purple40)
                        ) {
                            Text(text = stringResource(id = R.string.previous_text_button))
                        }
                        // button next
                        Button(
                            onClick = {
                                // update to the next image
                                // update to the next art title
                                // update to the next artist
                                // update to the next taken created
                                if (artPicture < 10) {
                                    artPicture += 1
                                }
                            },
                            modifier = modifier
                                .width(120.dp)
                                .height(40.dp),
                            colors = ButtonDefaults.buttonColors(Purple40)
                        ) {
                            Text(text = stringResource(id = R.string.next_text_button))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ArtPictureUI(
    photoSize: Dp = 270.dp,
    picture: Int = R.drawable.nunun_3,
    pictureDescription: Int = R.string.nunun_1,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        color = Color.White,
        shape = RectangleShape,
        shadowElevation = 8.dp,
    ) {
        Image(
            painter = painterResource(id = picture),
            contentDescription = stringResource(id = pictureDescription),
            modifier = modifier
                .padding(38.dp)
                .size(photoSize)
        )
    }
}

@Composable
fun ArtTitleUI(
    pictureDescription: Int = R.string.unknown_pict,
    pictureArtist: Int = R.string.unknown_artist,
    yearTaken: Int = R.string.unknown_year,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints() {
        if (maxWidth > 500.dp) {
            Column(
                modifier = modifier.background(color = Gray80)
            ) {
                Text(
                    text = stringResource(id = pictureDescription),
                    modifier = modifier
                        .padding(start = 10.dp, bottom = 0.dp, end = 10.dp, top = 10.dp),
                    fontWeight = FontWeight.W300,
                    fontSize = 30.sp,
                    fontFamily = FontFamily.SansSerif
                )
                Row(modifier = modifier
                    .padding(start = 10.dp, bottom = 10.dp, end = 10.dp)
                ) {
                    Text(
                        text = stringResource(id = pictureArtist),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 24.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                    Spacer(modifier = modifier.padding(2.dp))
                    Text(
                        text = stringResource(id = yearTaken),
                        fontWeight = FontWeight.W300,
                        fontSize = 24.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
        }else {
            Column(
                modifier = modifier.background(color = Gray80)
            ) {
                Text(
                    text = stringResource(id = pictureDescription),
                    modifier = modifier
                        .padding(start = 10.dp, bottom = 0.dp, end = 10.dp, top = 10.dp),
                    fontWeight = FontWeight.W300,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif
                )
                Row(
                    modifier = modifier
                        .padding(start = 10.dp, bottom = 10.dp, end = 10.dp)
                ) {
                    Text(
                        text = stringResource(id = pictureArtist),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                    Spacer(modifier = modifier.padding(2.dp))
                    Text(
                        text = stringResource(id = yearTaken),
                        fontWeight = FontWeight.W300,
                        fontSize = 18.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtPictureUI()
    }
}