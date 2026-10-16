package com.example.myapplication

import android.R
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.Text
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TugasACT4Tugas(modifier: Modifier = Modifier){
    var namaDepan by remember { mutableStateOf("") }
    var namaBelakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tanggalLahir by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }

    var androidDipilih by remember { mutableStateOf(false) }
    var uiuxDipilih by remember { mutableStateOf(false) }
    var webDipilih by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize(),
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
            modifier =  Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = {
                    Text(stringResource(R.string.tgl_lahir))
                },
                modifier = Modifier.weight(1f),
                singleLine = true,
                shape = RoundedCornerShape(14.dp)
            )

            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = {
                    Text(stringResource(R.string.experience))
                },
                modifier = Modifier.weight(1f),
                singleLine = true,
                shape = RoundedCornerShape(14.dp)
            )
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
                        checked = false,
                        onCheckedChange = {}
                    )
                    Text(stringResource(R.string.skill_android))
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = false,
                        onCheckedChange = {}
                    )
                    Text(stringResource(R.string.skill_uiux))
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = false,
                        onCheckedChange = {}
                    )
                    Text(stringResource(R.string.skill_web))
                }
            Spacer(modifier = Modifier.padding(18.dp))

            Button(
                onClick = {},
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
        }
    }
}