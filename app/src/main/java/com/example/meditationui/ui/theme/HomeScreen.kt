package com.example.meditationui
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.asAndroidPath
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditationui.ui.theme.*

@Composable
fun HomeScreen(){
   Box(modifier = Modifier
       .background(DeepBlue)
       .fillMaxSize())
   {
       Column {
           GreetingSection(name = "Pranjal")
           chipSection(chips = listOf("Sweet Sleep","Isomonia","Depression"))
           Meditation()
           FeatureSection(
               features = listOf(
                   Feature(
                       title = "Sleep meditation",
                       R.drawable.ic_headphone,
                       BlueViolet1,
                       BlueViolet2,
                       BlueViolet3
                   ),
                   Feature(
                       title = "Tips for sleeping",
                       R.drawable.ic_videocam,
                       LightGreen1,
                       LightGreen2,
                       LightGreen3
                   ),
                   Feature(
                       title = "Night island",
                       R.drawable.ic_headphone,
                       OrangeYellow1,
                       OrangeYellow2,
                       OrangeYellow3
                   ),
                   Feature(
                       title = "Calming sounds",
                       R.drawable.ic_headphone,
                       Beige1,
                       Beige2,
                       Beige3
                   )
               )
           )
       }
       BottomMenu(
           items = listOf(
               BottomMenuContent(title = "Home", iconId = R.drawable.ic_home ),
               BottomMenuContent(title = "Meditate", iconId = R.drawable.ic_bubble ),
               BottomMenuContent(title = "Music", iconId = R.drawable.ic_music ),
               BottomMenuContent(title = "Sleep", iconId = R.drawable.ic_moon ),
               BottomMenuContent(title = "Profile", iconId = R.drawable.ic_profile )
           ),
           modifier = Modifier.align(Alignment.BottomCenter)
       )
   }
}


@Composable
fun BottomMenu(
    items : List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighLightColor : Color = ButtonBlue,
    activeTextColor : Color = Color.White,
    inactiveTextColor : Color  = AquaBlue,
    initialSelectedItemIndex : Int = 0
)
{
    var selectedItem by remember{
        mutableStateOf(initialSelectedItemIndex)
    }
    Row (
        horizontalArrangement =Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
            ){
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItem,
                activeHighLightColor = activeHighLightColor,
                inactiveTextColor = inactiveTextColor,
                activeTextColor = activeTextColor
            ){
                selectedItem = index
            }
        }
    }
}


@Composable
fun BottomMenuItem(
    item : BottomMenuContent,
    isSelected : Boolean = false,
    activeHighLightColor : Color = ButtonBlue,
    activeTextColor : Color = Color.White,
    inactiveTextColor : Color  = AquaBlue,
    onClick : () -> Unit
){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onClick()
        }
            ){
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(
                    if (isSelected) activeHighLightColor
                    else Color.Transparent
                )
                .padding(10.dp)
        )
        {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = null,
                tint = if(isSelected) activeTextColor
            else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            color = if(isSelected) activeTextColor else inactiveTextColor
        )
    }
}

@Composable
fun GreetingSection(
    name : String
){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "Hello $name",
                style = MaterialTheme.typography.h2
            )
            Text(
                text = "We wish you have a good day",
                style = MaterialTheme.typography.body1
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            modifier = Modifier.size(24.dp),
            tint = Color.White
        )
    }
}


@Composable
fun chipSection(chips : List<String>){
    var selectedchip  by remember{
        mutableStateOf(0)
    }
    LazyRow{
        items(chips.size)
        {
           Box(
               modifier = Modifier
                   .padding(bottom = 15.dp, start = 15.dp, top = 15.dp)
                   .clickable {
                       selectedchip = it
                   }
                   .clip(RoundedCornerShape(10.dp))
                   .background(
                       if (selectedchip == it) ButtonBlue
                       else DarkerButtonBlue
                   )
                   .padding(15.dp),
               contentAlignment = Alignment.Center
           )
           {
               Text(text = chips[it], color = TextWhite)
           }
        }
    }
}

@Composable
fun Meditation()
{
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(LightRed)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    )
    {
        Column() {
            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.h2
            )
            Text(
                text = "Meditation.3-10 min",
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
        }
        Box(modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(ButtonBlue)
            .padding(10.dp),
            contentAlignment = Alignment.Center
        )
        {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }

    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeatureSection(features: List<Feature>)
{
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Features",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(15.dp)
        )
        
        LazyVerticalGrid(cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
        modifier = Modifier.fillMaxHeight( ))
        {
            items(features.size){
               featureItem(feature = features[it])
            }
        }
    }
}


@Composable
fun featureItem(
    feature : Feature
)
{
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        val mediumColouredPoint1 = Offset(0f,0.3f)
        val mediumColouredPoint2 = Offset(0.1f,0.35f)
        val mediumColouredPoint3 = Offset(0.4f,0.05f)
        val mediumColouredPoint4 = Offset(0.75f,0.7f)
        val mediumColouredPoint5 = Offset(1.4f,-height.toFloat())


        val mediumColoredPath = Path().apply {
            moveTo(mediumColouredPoint1.x,mediumColouredPoint1.y)
            standardQuadto(mediumColouredPoint1,mediumColouredPoint2)
            standardQuadto(mediumColouredPoint2,mediumColouredPoint3)
            standardQuadto(mediumColouredPoint3,mediumColouredPoint4)
            standardQuadto(mediumColouredPoint4,mediumColouredPoint5)

            lineTo(width.toFloat()+100f,height.toFloat()+100f)
            lineTo(-100f,height.toFloat()+100f)
            close()
        }

        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.75f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadto(lightPoint1, lightPoint2)
            standardQuadto(lightPoint2, lightPoint3)
            standardQuadto(lightPoint3, lightPoint4)
            standardQuadto(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        Canvas(modifier = Modifier.fillMaxSize())
        {
            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        }

        Box(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp))
        {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.h2,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Text(
                text = "Start",
                color = TextWhite,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier
                    .clickable {
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }
    }
}