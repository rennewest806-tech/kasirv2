package com.droidgen.kasirku.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidgen.kasirku.data.model.ProductItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    var cartCount by remember { mutableIntStateOf(3) }
    var totalAmount by remember { mutableLongStateOf(64000L) }

    val sampleProducts = remember {
        listOf(
            ProductItem(1, "Kopi Susu Gula Aren", 18000, 48, "Minuman"),
            ProductItem(2, "Roti Bakar Coklat Keju", 22000, 15, "Makanan"),
            ProductItem(3, "Matcha Latte Ice", 24000, 32, "Minuman"),
            ProductItem(4, "French Fries Extra Cheese", 16000, 8, "Snack"),
            ProductItem(5, "Croissant Butter", 20000, 24, "Bakery")
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header Section
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "KasirKu POS",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Shift Pagi • Budi Santoso",
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            IconButton(
                onClick = { /* Launch Barcode Camera */ },
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primaryContainer, shape = RoundedCornerShape(12.dp))
            ) {
                Icon(
                    Icons.Default.QrCodeScanner,
                    contentDescription = "Scan Barcode",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Daily Summary Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
            shape = RoundedCornerShape(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text("Total Penjualan Hari Ini", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text("Rp 3.850.000", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text("Transaksi", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text("42 Struk", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Product Catalog / Quick Add
        Text(
            text = "Katalog Cepat",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(sampleProducts) { item ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(item.name, fontWeight = FontWeight.Medium, fontSize = 15.sp)
                            Text("Stok: ${item.stock} pcs • ${item.category}", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            Text("Rp ${item.price}", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                        }
                        FilledTonalButton(
                            onClick = {
                                cartCount++
                                totalAmount += item.price
                            },
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Icon(Icons.Default.Add, contentDescription = "Tambah")
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Tambah")
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Checkout Button
        Button(
            onClick = { /* Process payment */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(14.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Receipt, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Keranjang (${cartCount} item)", fontWeight = FontWeight.SemiBold)
                }
                Text("Rp ${totalAmount}", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
        }
    }
}
