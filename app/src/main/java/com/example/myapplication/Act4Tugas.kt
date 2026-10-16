package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.Text
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Card
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.app.DatePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay
import java.util.Calendar

@Composable
fun TugasACT4Tugas(modifier: Modifier = Modifier) {
    var namaDepan by remember { mutableStateOf("") }
    var namaBelakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tanggalLahir by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }

    var androidDipilih by remember { mutableStateOf(false) }
    var uiuxDipilih by remember { mutableStateOf(false) }
    var webDipilih by remember { mutableStateOf(false) }
    var tampilkanHasil by remember { mutableStateOf(false) }
    val calendar = Calendar.getInstance()
    val context = androidx.compose.ui.platform.LocalContext.current
    var experienceExpanded by remember { mutableStateOf(false) }

    LaunchedEffect(tampilkanHasil) {
        if (tampilkanHasil) {
            delay(5000)
            tampilkanHasil = false
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.background_form),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.78f)
                .padding(bottom = 16.dp)
                .align(Alignment.BottomCenter),
            shape = RoundedCornerShape(
                topStart = 28.dp,
                topEnd = 28.dp
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(R.color.putih_form)
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.judul_form),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.ungu_form)
                )

                Text(
                    text = stringResource(R.string.petunjuk_form),
                    fontSize = 12.sp,
                    color = colorResource(R.color.abu_form)
                )

                Spacer(modifier = Modifier.padding(28.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = namaDepan,
                        onValueChange = { namaDepan = it },
                        label = {
                            Text(stringResource(R.string.nama_depan))
                        },
                        modifier = Modifier.weight(1f),
                        singleLine = true,
                        shape = RoundedCornerShape(14.dp)
                    )

                    OutlinedTextField(
                        value = namaBelakang,
                        onValueChange = { namaBelakang = it },
                        label = {
                            Text(stringResource(R.string.nama_belakang))
                        },
                        modifier = Modifier.weight(1f),
                        singleLine = true,
                        shape = RoundedCornerShape(14.dp)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = {
                        Text(stringResource(R.string.email))
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    singleLine = true,
                    shape = RoundedCornerShape(14.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = tanggalLahir,
                        onValueChange = {},
                        readOnly = true,
                        label = {
                            Text(stringResource(R.string.tgl_lahir))
                        },
                        trailingIcon = {
                            Text(
                                text = "▦",
                                modifier = Modifier.clickable {
                                    DatePickerDialog(
                                        context,
                                        { _, year, month, day ->
                                            tanggalLahir = "%02d/%02d/%04d".format(
                                                day, month + 1, year
                                            )
                                        },
                                        calendar.get(Calendar.YEAR),
                                        calendar.get(Calendar.MONTH),
                                        calendar.get(Calendar.DAY_OF_MONTH)
                                    ).show()
                                }
                            )
                        },
                        modifier = Modifier.weight(1f),
                        singleLine = true,
                        shape = RoundedCornerShape(14.dp)
                    )


                    Box(modifier = Modifier.weight(1f)) {
                        OutlinedTextField(
                            value = experience,
                            onValueChange = {},
                            readOnly = true,
                            label = {
                                Text(stringResource(R.string.experience))
                            },
                            trailingIcon = {
                                Text(
                                    text = "▾",
                                    modifier = Modifier.clickable {
                                        experienceExpanded = true
                                    }
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    experienceExpanded = true
                                },
                            singleLine = true,
                            shape = RoundedCornerShape(14.dp)
                        )

                        DropdownMenu(
                            expanded = experienceExpanded,
                            onDismissRequest = {
                                experienceExpanded = false
                            }
                        ) {
                            listOf("Beginner", "Intermediate", "Advanced").forEach { pilihan ->
                                DropdownMenuItem(
                                    text = { Text(pilihan) },
                                    onClick = {
                                        experience = pilihan
                                        experienceExpanded = false
                                    }
                                )
                            }
                        }
                    }

                }
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = stringResource(R.string.pilih_skill),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    fontSize = 14.sp
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = androidDipilih,
                            onCheckedChange = { androidDipilih = it }
                        )
                        Text(stringResource(R.string.skill_android))
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = uiuxDipilih,
                            onCheckedChange = { uiuxDipilih = it }
                        )
                        Text(stringResource(R.string.skill_uiux))
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = webDipilih,
                            onCheckedChange = { webDipilih = it }
                        )
                        Text(stringResource(R.string.skill_web))
                    }
                }


                    Spacer(modifier = Modifier.height(18.dp))

                    Button(
                        onClick = {
                            tampilkanHasil = true
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.ungu_form)
                        )
                    ) {
                        Text(
                            text = stringResource(R.string.proceed),
                            color = colorResource(R.color.putih_form)
                        )
                    }

                    if (tampilkanHasil) {
                        AlertDialog(
                            onDismissRequest = {
                                tampilkanHasil = false
                            },
                            title = {
                                Text("Biodata Berhasil Disubmit!")
                            },
                            text = {
                                Column {
                                    Text("Nama: $namaDepan $namaBelakang")
                                    Text("Email: $email")
                                    Text("Tanggal Lahir: $tanggalLahir")
                                    Text("Experience: $experience")
                                    Text(
                                        "Skill: " + listOfNotNull(
                                            if (androidDipilih)
                                                stringResource(R.string.skill_android)
                                            else null,
                                            if (uiuxDipilih)
                                                stringResource(R.string.skill_uiux)
                                            else null,
                                            if (webDipilih)
                                                stringResource(R.string.skill_web)
                                            else null
                                        ).joinToString(", ")
                                    )
                                }
                            },
                            confirmButton = {
                                TextButton(
                                    onClick = {
                                        tampilkanHasil = false
                                    }
                                ) {
                                    Text("Tutup")
                                }
                            }
                        )
                    }
                }
            }
        }
    }