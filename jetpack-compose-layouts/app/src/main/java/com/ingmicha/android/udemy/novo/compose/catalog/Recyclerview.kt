package com.ingmicha.android.udemy.novo.compose.catalog

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ingmicha.android.udemy.novo.compose.catalog.model.SuperHero
import kotlinx.coroutines.launch

@Composable
fun SimpleRecyclerView() {
    val myList = listOf("Aris", "Pepe", "Manolo", "Jaime")
    LazyColumn {
        item {
            Text(text = "Header")
        }
        item {
            Text(text = "Primer item")
        }
        items(7) {
            Text(text = "Este es el item $it")
        }
        items(myList) {
            Text(text = "Hola me llamo $it")
        }
        item {
            Text(text = "Footer")
        }
    }
}

@Composable
fun SuperHeroView() {
    val context = LocalContext.current
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHeroes()) {
            ItemHero(superHero = it) {
                Toast.makeText(context, it.superHeroName, Toast.LENGTH_LONG).show()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHeroStickyView() {
    val context = LocalContext.current
    var superheros = getSuperHeroes().groupBy { it.publisher }

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        superheros.forEach { (publisher, mySuperhero) ->

            stickyHeader {
                Text(
                    text = publisher,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Green),
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
            items(mySuperhero) {
                ItemHero(superHero = it) {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_LONG).show()
                }
            }

        }

    }
}

@Composable
fun SuperHeroGridView() {
    val context = LocalContext.current
    LazyVerticalGrid(columns = GridCells.Adaptive(100.dp), content = {
        items(getSuperHeroes()) {
            ItemHero(superHero = it) {
                Toast.makeText(context, it.superHeroName, Toast.LENGTH_LONG).show()
            }
        }
    }, contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp))
}

@Composable
fun SuperHeroWithSpecialControlsView() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutinesScope = rememberCoroutineScope()
    Column {
        LazyRow(
            state = rvState,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(getSuperHeroes()) {
                ItemHero(superHero = it) {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_LONG).show()
                }
            }
        }

        val showButton by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }

        rvState.firstVisibleItemScrollOffset

        if (showButton) {
            Button(
                onClick = {
                    coroutinesScope.launch {
                        rvState.animateScrollToItem(0)
                    }
                },
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(16.dp)
            ) {
                Text(text = "Soy un boton cool")
            }
        }
    }

}

@Composable
fun ItemHero(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .width(200.dp)
            .clickable { onItemSelected(superHero) }
            .padding(top = 8.dp, bottom = 8.dp, end = 16.dp, start = 16.dp)) {
        Column() {
            Image(
                painter = painterResource(id = superHero.photo),
                contentDescription = "Hero Photo",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superHero.superHeroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superHero.realName,
                fontSize = 12.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superHero.publisher,
                fontSize = 10.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp)
            )
        }
    }
}

fun getSuperHeroes(): List<SuperHero> {
    return listOf(
        SuperHero(
            "Spiderman",
            "Petter Parker",
            "Marvel",
            R.drawable.spiderman
        ),
        SuperHero(
            "Wolverine",
            "Logan",
            "Marvel",
            R.drawable.logan
        ),
        SuperHero(
            "Thor",
            "Thor Odinson",
            "Marvel",
            R.drawable.thor
        ),
        SuperHero(
            "Batman",
            "Bruce Wayne",
            "DC",
            R.drawable.batman
        ),
        SuperHero(
            "Flash",
            "Jay Garrick",
            "DC",
            R.drawable.flash
        ),
        SuperHero(
            "Green Lantern",
            "Alan Scott",
            "DC",
            R.drawable.green_lantern
        ),
        SuperHero(
            "Wonder Woman",
            "Princess Diana",
            "DC",
            R.drawable.wonder_woman
        )
    )
}