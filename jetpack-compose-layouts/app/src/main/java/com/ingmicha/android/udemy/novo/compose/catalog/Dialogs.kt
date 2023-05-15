package com.ingmicha.android.udemy.novo.compose.catalog

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun MyAlertDialog(
    show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit
) {
    if (show) {
        AlertDialog(onDismissRequest = {},
            title = { Text(text = "Titulo") },
            text = { Text(text = "Description") },
            confirmButton = {
                TextButton(onClick = { onConfirm }) {
                    Text(text = "Confirm Button")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss }) {
                    Text(text = "Dismiss Button")
                }
            })
    }
}

@Composable
fun MySimpleCustomDialog(
    show: Boolean, onDismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = { onDismiss },
        properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Example MySimple Dialog")
        }
    }
}

@Composable
fun MyCustomDialog(
    show: Boolean, onDismiss: () -> Unit
) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss }) {
            MyTitleDialog("Set backup account")
            AccountItem(email = "example@gmail.com", drawable = R.drawable.ic_launcher_foreground)
            AccountItem(email = "example@gmail.com", drawable = R.drawable.ic_launcher_foreground)
            AccountItem(email = "example@gmail.com", drawable = R.drawable.ic_launcher_foreground)
        }
    }
}

@Composable
fun MyTitleDialog(title: String, modifier: Modifier = Modifier.padding(bottom = 12.dp)) {
    Text(
        text = title,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )
}

@Preview(name = "AccountItem", showBackground = true)
@Composable
fun AccountItem(email: String = "", @DrawableRes drawable: Int = R.drawable.ic_launcher_background) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(shape = CircleShape)
        )
        Text(
            text = email, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun MyConfirmationDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                MyTitleDialog(title = "Phone ringtones", modifier = Modifier.padding(24.dp))
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                )
                var status by remember {
                    mutableStateOf("")
                }
                MyRadioButtonList(name = status, onItemSelected = { status = it })
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                )
                Row(
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(8.dp)
                ) {
                    TextButton(onClick = {}) {
                        Text(text = "Cancel")
                    }
                    TextButton(onClick = {}) {
                        Text(text = "OK")
                    }
                }
            }
        }
    }
}