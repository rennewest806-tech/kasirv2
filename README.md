# 📱 KasirKu POS Pro - Modern Android App

Aplikasi Kasir & Point of Sale (POS) modern berbasis **Kotlin & Jetpack Compose** dengan arsitektur Material 3, Room Database Offline, Camera Barcode Scanner, dan integrasi Printer Thermal Bluetooth.

---

## 🚀 Cara Convert ke APK via GitHub (Paling Cepat & Otomatis)

Anda **tidak perlu** menginstal Android Studio di komputer. Cukup push zip ini ke GitHub dan biarkan **GitHub Actions** meng-compile file APK secara otomatis!

### Langkah-langkah:
1. Ekstrak file zip ini ke folder baru di komputer Anda.
2. Buat repository baru di [GitHub](https://github.com/new) (misal bernama `kasirku-android`).
3. Buka terminal / command prompt di folder hasil ekstrak, lalu jalankan:
   ```bash
   git init
   git add .
   git commit -m "Initial commit KasirKu Android App"
   git branch -M main
   git remote add origin https://github.com/USERNAME-ANDA/kasirku-android.git
   git push -u origin main
   ```
4. Masuk ke tab **Actions** di repository GitHub Anda.
5. GitHub akan menjalankan workflow `Build Android APK` (~2-3 menit).
6. Setelah selesai (tanda centang hijau ✅), klik nama workflow dan unduh file **`KasirKu-Debug-APK.zip`** yang ada di bagian **Artifacts**.
7. Ekstrak dan pasang file `.apk` langsung ke smartphone Android Anda!

---

## 💻 Cara Menjalankan di Android Studio

1. Download & Instal [Android Studio Ladybug/Hedgehog](https://developer.android.com/studio).
2. Pilih **Open Existing Project**, lalu pilih folder hasil ekstrak.
3. Tunggu proses **Gradle Sync** selesai (pastikan koneksi internet stabil).
4. Pilih emulator atau hubungkan smartphone Android dengan USB Debugging aktif.
5. Klik tombol **Run (Segitiga Hijau)** atau tekan `Shift + F10`.
6. Untuk build APK lokal: Pilih menu **Build > Build Bundle(s) / APK(s) > Build APK(s)**.

---

## 🛠️ Spesifikasi Teknologi
- **Bahasa**: Kotlin 2.0+
- **UI Toolkit**: Jetpack Compose + Material 3 (Dynamic Colors)
- **Local DB**: Room Database SQLite
- **Architecture**: MVVM + Clean Architecture + StateFlow
- **Min SDK**: Android 8.0 (API 26)
- **Target SDK**: Android 15 (API 35)
