package com.mnhyim.nexmediatechtest.ui.feature.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mnhyim.nexmediatechtest.ui.navigation.Routes

@Composable
fun Settings(
    onNavigate: (Routes) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    SettingsScreen(
        onSaveProduct = { name, price, stock -> viewModel.insertProduct(name, price, stock) },
        modifier = modifier
    )
}

@Composable
private fun SettingsScreen(
    onSaveProduct: (String, String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    var productName by remember { mutableStateOf("") }
    var productPrice by remember { mutableStateOf("") }
    var productStock by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        Column(
            modifier = Modifier
                .padding(16.dp, 0.dp, 16.dp, 16.dp)
                .background(
                    MaterialTheme.colorScheme.surfaceContainerHigh,
                    RoundedCornerShape(16.dp)
                )
                .padding(16.dp)
        ) {
            Text(
                text = "Add New Product",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            OutlinedTextField(
                value = productName,
                onValueChange = { productName = it },
                placeholder = { Text("Product Name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            Row {
                OutlinedTextField(
                    value = productPrice,
                    onValueChange = { productPrice = it },
                    placeholder = { Text("Price") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 4.dp)
                )
                OutlinedTextField(
                    value = productStock,
                    onValueChange = { productStock = it },
                    placeholder = { Text("Stock") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 4.dp)
                )
            }
            Button(
                enabled = productName.isNotBlank() && productPrice.isNotBlank() && productStock.isNotBlank(),
                onClick = {
                    onSaveProduct(productName, productPrice, productStock)
                    productName = ""
                    productPrice = ""
                    productStock = ""
                },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Text(text = "Save Products")
            }
        }
    }
}