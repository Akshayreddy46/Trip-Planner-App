package com.tripplanner.ui.main

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.navigation.NavController
import com.tripplanner.R
import com.tripplanner.routing.Screen
import com.tripplanner.ui.TripPreference.TripPreference
import com.tripplanner.ui.drawer.DrawerBody
import com.tripplanner.ui.drawer.DrawerHeader
import com.tripplanner.ui.drawer.TopBar
import com.tripplanner.ui.model.TripModel
import com.tripplanner.ui.theme.TripPlannerAppTheme
import com.tripplanner.ui.theme.black
import com.tripplanner.ui.theme.green
import com.tripplanner.ui.theme.white
import com.tripplanner.utils.CustomSearchView
import com.tripplanner.utils.GradientButton
import com.tripplanner.utils.RoundedButton
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavController) {
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    var isLogout by remember { mutableStateOf(false) }
    val preferenceManager = remember {
        TripPreference(context)
    }
    val scrollState = rememberScrollState()
    var search by remember { mutableStateOf("") }
    val list = arrayListOf<TripModel>().apply {
        add(TripModel(name = "New Delhi to Europe Trip"))
        add(TripModel(name = "New Delhi to Paris Trip"))
        add(TripModel(name = "New Delhi to Amsterdam Trip"))
        add(TripModel(name = "New Delhi to Switzerland Trip"))
        add(TripModel(name = "New Delhi to London Trip"))

    }
    TripPlannerAppTheme {
        androidx.compose.material.Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                TopBar(
                    navController = navController,
                    onNavigationIconClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }
                )
            },
            modifier = Modifier.background(color = white),
            drawerContent = {
                DrawerHeader()
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = white)
                ) {
                    DrawerBody(onContact = {
                        navController.navigate(Screen.ContactUsScreen.route)
                        scope.launch {
                            scaffoldState.drawerState.close()
                        }
                    }, onLogout = {
                        isLogout = true
                        scope.launch {
                            scaffoldState.drawerState.close()
                        }
                    })
                }

            },
            backgroundColor = green,
            contentColor = green,
            drawerContentColor = white,
            drawerBackgroundColor = green
        ) { paddingValues ->
            Modifier.padding(
                bottom = paddingValues.calculateBottomPadding()
            )
            Column(
                modifier = Modifier
                    .background(color = green)
                    .verticalScroll(scrollState)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    CustomSearchView(search = search, onValueChange = {
                        search = it
                    }, onClick = {
                        navController.navigate(Screen.SearchList.route)
                    })
                }
                Spacer(Modifier.height(10.dp))
                Column {
                    list.forEachIndexed { index, model ->
                        var isTaveller by rememberSaveable {
                            mutableStateOf(false)
                        }
                        val taveller = arrayListOf(
                            "1","2", "3",
                            "4", "5",
                            "6"
                        )
                        var selectedTraveller by remember { mutableStateOf("") }
                        Card(
                            modifier = Modifier
                                .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
                                .fillMaxWidth()
                                .height(IntrinsicSize.Min),
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
                                model.name ?: "",
                                fontSize = 14.sp,
                                color = Color.Black,
                                modifier = Modifier
                                    .padding(vertical = 5.dp, horizontal = 10.dp)
                            )
                            Spacer(Modifier.height(10.dp))
                            OutlinedTextField(
                                value = if (selectedTraveller != "") selectedTraveller else "Select Number of travellers",
                                onValueChange = { selectedTraveller = it },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                                    .clickable { isTaveller = !isTaveller },
                                enabled = false,
                                trailingIcon = {
                                    Icon(
                                        if (isTaveller)
                                            Icons.Filled.KeyboardArrowUp
                                        else
                                            Icons.Filled.KeyboardArrowDown,
                                        "contentDescription",

                                        )
                                },
                                textStyle = TextStyle(color = black)
                            )
                            Box {
                                if (isTaveller) {
                                    Popup(
                                        alignment = Alignment.TopCenter,
                                        properties = PopupProperties(
                                            excludeFromSystemGesture = true,
                                        ),
                                        onDismissRequest = { isTaveller = false }
                                    ) {

                                        Column(
                                            modifier = Modifier
                                                .border(width = 1.dp, color = Color.Gray)
                                                .background(white),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                        ) {

                                            taveller.onEachIndexed { index, item ->
                                                if (index != 0) {
                                                    Divider(thickness = 1.dp, color = Color.LightGray)
                                                }
                                                Box(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(10.dp)
                                                        .clickable {
                                                            selectedTraveller = item
                                                            isTaveller = !isTaveller
                                                        },
                                                    contentAlignment = Alignment.Center
                                                ) {
                                                    Text(text = item, style = TextStyle(color = black))
                                                }
                                            }

                                        }
                                    }
                                }
                            }
                            Spacer(Modifier.height(10.dp))
                            Row(
                                modifier = Modifier
                            ) {
                                GradientButton(
                                    onClick = {
                                        if(selectedTraveller.isEmpty()) {
                                            Toast.makeText(context, "Please select number of travellers.", Toast.LENGTH_SHORT).show()
                                        }else {
                                            navController.navigate(Screen.Detail.route + "/${model.name}" + "/${index}")
                                        }

                                    },
                                    modifier = Modifier
                                        .padding(vertical = 5.dp)
                                        .fillMaxWidth(),
                                    textColor = white,
                                    isEnabled = true,
                                    gradient = Brush.horizontalGradient(listOf(green, green)),
                                    text = "Select Trip"
                                )
                            }

                        }
                    }
                }
            }
        }
        if (isLogout) {
            AlertDialog(
                onDismissRequest = {
                    isLogout = false
                },
                title = { Text(stringResource(id = R.string.app_name)) },
                text = { Text("Are you sure you want to logout ?") },
                confirmButton = {
                    RoundedButton(
                        text = "Logout",
                        backgroundColor = white,
                        textColor = green,
                        onClick = {
                            preferenceManager.saveData("isLogin", false)
                            navController.navigate(
                                Screen.LoginScreen.route
                            ) {
                                popUpTo(Screen.MainScreen.route) {
                                    inclusive = true
                                }
                            }
                            isLogout = false
                        }
                    )

                },
                dismissButton = {
                    RoundedButton(
                        text = "Cancel",
                        backgroundColor = white,
                        textColor = green,
                        onClick = { isLogout = false }
                    )
                }
            )
        }

    }

}