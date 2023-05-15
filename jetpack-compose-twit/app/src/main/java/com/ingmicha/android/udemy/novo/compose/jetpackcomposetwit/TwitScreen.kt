package com.ingmicha.android.udemy.novo.compose.jetpackcomposetwit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Preview(name = "TwitScreen", showBackground = true)
@Composable
fun TwitScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(color = 0xff181f2b))
    )
    {
        Body(modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 24.dp))
    }
}

@Composable
fun Body(modifier: Modifier) {
    Column() {
        Row(modifier = modifier) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "avatar logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .clip(shape = CircleShape)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Column(
                modifier = Modifier
                    .weight(2f)
            ) {
                Header()
                Spacer(modifier = Modifier.size(16.dp))
                Content()
                Spacer(modifier = Modifier.size(16.dp))
                ImageContent()
            }
        }
        Spacer(modifier = Modifier.size(16.dp))
        Footer()
        Spacer(modifier = Modifier.size(24.dp))
        Divider(
            modifier = Modifier
                .background(Color(0xff626870))
                .height(1.dp)
        )
    }
}

@Composable
fun Header() {
    Row() {
        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold, fontSize = 12.sp, color = Color.White
                )
            ) {
                append("Ingmicha ")
            }
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = Color(0xff626870)
                )
            ) {
                append("@Ingmicha 4h")
            }
        })
        Icon(
            painter = painterResource(id = R.drawable.ic_dots),
            contentDescription = "icon dots",
            tint = Color.White,
        )
    }
}

@Composable
fun Content() {
    Column() {
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
            color = Color.White
        )
    }
}
@Composable
fun Footer() {

    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        var (chatRowRef, rtRowRef, likeRowRef) = createRefs()

        Row(modifier = Modifier
            .constrainAs(chatRowRef) {
                start.linkTo(parent.start)
            }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_chat),
                contentDescription = "chat icon",
                tint = Color(0xff626870)
            )
            Text(text = "1", color = Color(0xff626870))
        }

        Row(modifier = Modifier
            .constrainAs(rtRowRef) {
                start.linkTo(chatRowRef.start)
                end.linkTo(likeRowRef.start)
            }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_rt),
                contentDescription = "chat icon",
                tint = Color(0xff2e9347)
            )
            Text(text = "1", color = Color(0xff626870))
        }

        Row(modifier = Modifier
            .constrainAs(likeRowRef) {
                end.linkTo(parent.end)
            }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_like_filled),
                contentDescription = "chat icon",
                tint = Color(0xffdf0b0e)
            )
            Text(text = "1", color = Color(0xff626870))
        }
        createHorizontalChain(
            elements = arrayOf(chatRowRef, rtRowRef, likeRowRef),
            chainStyle = ChainStyle.Spread
        )

    }
}

@Composable
fun ImageContent() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "image twit",
        modifier = Modifier.clip(RoundedCornerShape(16.dp))
    )
}