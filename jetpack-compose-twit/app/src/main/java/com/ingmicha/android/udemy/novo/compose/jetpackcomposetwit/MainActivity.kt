package com.ingmicha.android.udemy.novo.compose.jetpackcomposetwit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ingmicha.android.udemy.novo.compose.jetpackcomposetwit.ui.theme.JetpackComposeTwitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTwitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Column() {
                        TwitterCard()
                        TwitDivider()
                    }

                }
            }
        }
    }
}


@Preview
@Composable
fun TwitterCard() {

    var chat by remember {
        mutableStateOf(false)
    }

    var rt by remember {
        mutableStateOf(false)
    }

    var like by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFF161d26))
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "profile image",
            modifier = Modifier
                .clip(
                    CircleShape
                )
                .size(55.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                TextTitle(title = "Ingmicha", modifier = Modifier.padding(end = 8.dp))
                DefaultTitle(title = "@Ingmicha", modifier = Modifier.padding(end = 8.dp))
                DefaultTitle(title = "4h", modifier = Modifier.padding(end = 8.dp))
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = R.drawable.ic_dots),
                    contentDescription = "",
                    tint = Color.White
                )
            }
            TextBody(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
                modifier = Modifier.padding(16.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(10)),
                contentScale = ContentScale.Crop
            )

            Row(Modifier.padding(top = 16.dp)) {
                SocialIcon(modifier = Modifier.weight(1f), unSelectedIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_chat),
                        contentDescription = "",
                        tint = Color(0xFF7E8B98)
                    )
                }, selectedIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_chat_filled),
                        contentDescription = "",
                        tint = Color(0xFF7E8B98)
                    )
                }, isSelected = chat
                ) {
                    chat = chat
                }

                SocialIcon(modifier = Modifier.weight(1f), unSelectedIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_rt),
                        contentDescription = "",
                        tint = Color(0xFF7E8B98)
                    )
                }, selectedIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_rt),
                        contentDescription = "",
                        tint = Color(0xFF7E8B98)
                    )
                }, isSelected = rt
                ) {
                    rt = rt
                }

                SocialIcon(modifier = Modifier.weight(1f), unSelectedIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_like),
                        contentDescription = "",
                        tint = Color(0xFF7E8B98)
                    )
                }, selectedIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_like_filled),
                        contentDescription = "",
                        tint = Color(0xFF7E8B98)
                    )
                }, isSelected = like
                ) {
                    like = like
                }
            }
        }
    }
}

@Composable
fun SocialIcon(
    modifier: Modifier,
    unSelectedIcon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit,
    isSelected: Boolean,
    onItemSelected: () -> Unit
) {
    val defaultValue = 1

    Row(
        modifier = modifier.clickable { onItemSelected },
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isSelected) {
            selectedIcon()
        } else {
            unSelectedIcon()
        }

        Text(
            text = if (isSelected) {
                (defaultValue + 1).toString()
            } else {
                defaultValue.toString()
            }, color = Color.Gray, fontSize = 12.sp, modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Composable
fun TextBody(text: String, modifier: Modifier = Modifier) {
    Text(text = text, color = Color.White, fontWeight = FontWeight.ExtraBold, modifier = modifier)

}

@Composable
fun TextTitle(title: String, modifier: Modifier) {
    Text(text = title, color = Color.White, fontWeight = FontWeight.ExtraBold, modifier = modifier)
}

@Composable
fun DefaultTitle(title: String, modifier: Modifier) {
    Text(text = title, color = Color.Gray, modifier = modifier)
}

@Composable
fun TwitDivider() {
    Divider(
        Modifier
            .padding(top = 4.dp)
            .height(0.5.dp)
            .fillMaxWidth(), color = Color(0xFF8E8B98)
    )
}