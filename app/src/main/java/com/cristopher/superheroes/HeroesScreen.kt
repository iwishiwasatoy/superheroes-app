package com.cristopher.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cristopher.superheroes.data.Hero
import com.cristopher.superheroes.data.HeroesRepository
import com.cristopher.superheroes.ui.theme.Shapes
import com.cristopher.superheroes.ui.theme.SuperheroesTheme

@Composable
fun HeroItem(hero: Hero = HeroesRepository.heroes[0], modifier: Modifier = Modifier){
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .sizeIn(minHeight = 72.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = stringResource(id = hero.nameRes), style = MaterialTheme.typography.displaySmall)
                Text(text = stringResource(id = hero.descriptionRes), style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(modifier = Modifier
                .size(72.dp)
                .clip(RoundedCornerShape(8.dp))){
                Image(
                    painter = painterResource(hero.imageRes),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    contentScale = ContentScale.FillWidth
                )
            }
        }
    }
}

@Composable
fun HeroesList(heroes: List<Hero>, modifier: Modifier = Modifier, paddingValues: PaddingValues){
    LazyColumn(contentPadding = paddingValues) {
        items(heroes){ hero ->
            HeroItem(hero = hero, modifier = Modifier.padding(8.dp))
        }
    }
}

//@Preview
//@Composable
//fun HeroItemPreview(){
//    HeroItem(hero = HeroesRepository.heroes[0])
//}

//@Preview
//@Composable
//fun HeroeListPreview(){
//    SuperheroesTheme {
//        HeroesList(heroes = HeroesRepository.heroes)
//    }
//}


