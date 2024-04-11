package com.tripplanner.ui.searchListing

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tripplanner.R
import com.tripplanner.routing.Screen
import com.tripplanner.ui.model.TripModel
import com.tripplanner.ui.theme.TripPlannerAppTheme
import com.tripplanner.ui.theme.green

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchScreen(navController: NavController) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    val list = arrayListOf<TripModel>().apply {
        add(TripModel(name = "Jaipur to Jaisalmar", distance = "420 km", budget = "1000/- per each"))
        add(TripModel(name = "Jaipur to Jaisalmar", distance = "420 km", budget = "1000/- per each"))
        add(TripModel(name = "Jaipur to Jaisalmar", distance = "420 km", budget = "1000/- per each"))
        add(TripModel(name = "Jaipur to Jaisalmar", distance = "420 km", budget = "1000/- per each"))
        add(TripModel(name = "Jaipur to Jaisalmar", distance = "420 km", budget = "1000/- per each"))
        add(TripModel(name = "Jaipur to Jaisalmar", distance = "420 km", budget = "1000/- per each"))
        add(TripModel(name = "Jaipur to Jaisalmar", distance = "420 km", budget = "1000/- per each"))
        add(TripModel(name = "Jaipur to Jaisalmar", distance = "420 km", budget = "1000/- per each"))
        add(TripModel(name = "Jaipur to Jaisalmar", distance = "420 km", budget = "1000/- per each"))
        add(TripModel(name = "Jaipur to Jaisalmar", distance = "420 km", budget = "1000/- per each"))
        add(TripModel(name = "Jaipur to Jaisalmar", distance = "420 km", budget = "1000/- per each"))
        add(TripModel(name = "Jaipur to Jaisalmar", distance = "420 km", budget = "1000/- per each"))
        add(TripModel(name = "Jaipur to Jaisalmar", distance = "420 km", budget = "1000/- per each"))
        add(TripModel(name = "Jaipur to Jaisalmar", distance = "420 km", budget = "1000/- per each"))
        add(TripModel(name = "Jaipur to Jaisalmar", distance = "420 km", budget = "1000/- per each"))

    }
    TripPlannerAppTheme {
        Scaffold {
            Column(
                modifier = Modifier
                    .background(color = green)
                    .padding(top = 40.dp)
                    .verticalScroll(scrollState)
            ) {
                SmallTopAppBar(
                    title = {
                        Text(
                            text = "Search Trip", color = Color.White,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                navController.navigateUp()
                            }
                        ) {
                            Icon(imageVector = Icons.Rounded.ArrowBack,
                                tint = Color.White,
                                contentDescription = "Back")
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = green,
                        titleContentColor = Color.White
                    )
                )
                Spacer(Modifier.height(10.dp))
                Column {
                    list.forEachIndexed { index, saloonModel ->
                        Card(
                            modifier = Modifier
                                .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
                                .fillMaxWidth()
                                .height(260.dp)
                                .clickable {
                                    navController.navigate(Screen.Detail.route)
                                },
                            shape = RoundedCornerShape(10.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_trip_planner),
                                contentDescription = "Image",
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(160.dp)
                            )
                            Text(
                                saloonModel.name ?: "",
                                fontSize = 14.sp,
                                color = Color.Black,
                                modifier = Modifier
                                    .padding(vertical = 5.dp, horizontal = 10.dp)
                            )
                            Text(
                                "Distance : ${saloonModel.distance ?: ""}" ,
                                fontSize = 14.sp,
                                color = Color.Black,
                                modifier = Modifier
                                    .padding(vertical = 5.dp, horizontal = 10.dp)
                            )
                            Text(
                                "Budget : ${saloonModel.budget ?: ""}" ,
                                fontSize = 14.sp,
                                color = Color.Black,
                                modifier = Modifier
                                    .padding(vertical = 5.dp, horizontal = 10.dp)
                            )
                        }
                    }
                }
            }
        }


    }

}