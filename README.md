# PROJECT REYCLERVIEW
**PROJECT REYCLERVIEW** biasanya merujuk pada pembuatan aplikasi Android yang menampilkan data dalam bentuk daftar atau grid menggunakan RecyclerView, yaitu salah satu komponen UI di Android yang lebih efisien dibandingkan komponen lama seperti ListView.

## 📱 Aplikasi RecyclerView – Data Siswa
Aplikasi ini merupakan hasil dari tugas praktikum yang bertujuan untuk memahami cara kerja komponen RecyclerView pada Android Studio. Dalam aplikasi ini, RecyclerView digunakan untuk menampilkan daftar siswa dalam bentuk list yang rapi, efisien, dan mudah dikelola. Komponen ini dipilih karena memiliki performa yang lebih baik dibandingkan ListView dalam menampilkan data jumlah banyak secara dinamis.

## 📄 Penjelasan RecyclerView 
RecyclerView adalah salah satu komponen tampilan (view) yang disediakan oleh Android untuk menampilkan kumpulan data dalam jumlah besar secara efisien. Komponen ini bekerja dengan cara menampilkan hanya item yang terlihat di layar dan mendaur ulang (recycle) tampilan item yang sudah tidak terlihat agar dapat digunakan kembali untuk data berikutnya. Dengan metode ini, performa aplikasi menjadi lebih baik dan penggunaan memori menjadi lebih efisien.

Dibandingkan dengan ListView, RecyclerView memiliki fleksibilitas yang lebih tinggi. RecyclerView memungkinkan pengembang untuk mengatur tata letak item menggunakan LayoutManager seperti LinearLayoutManager, GridLayoutManager, atau StaggeredGridLayoutManager. Selain itu, RecyclerView juga mendukung penggunaan dekorasi item (item decoration) dan animasi transisi data, sehingga tampilan daftar menjadi lebih menarik.

## 👥 Tim
- Aditya Rasya Dafa Putra (01)
- Arrumi Asna Salsabilla (05)
- Elsye Sukma Argita (12)
- Hafidhah Nurina Amajida (16)

## 🔄 Penjelasan Alur Data
1. Student.kt (Model)
Berisi data class Student yang digunakan untuk menyimpan informasi setiap siswa, seperti nama, NIS, kelas, dan foto. Model ini menjadi acuan struktur data yang akan ditampilkan di aplikasi.

2. StudentAdapter.kt (Adapter)
Berfungsi sebagai penghubung antara data siswa dan tampilan di RecyclerView. Adapter ini mengatur bagaimana setiap data siswa akan dimasukkan ke dalam layout item yang sudah dibuat.

3. item_student.xml (Layout Item)
Merupakan layout yang digunakan untuk menampilkan satu item siswa dalam daftar RecyclerView. Layout ini biasanya berisi elemen gambar siswa, nama, NIS, dan kelas.

4. MainActivity.kt
Bertanggung jawab untuk menampilkan data siswa pada RecyclerView. Di sini, data dimasukkan ke dalam adapter dan diatur menggunakan LayoutManager agar tampil dalam bentuk list.

5. DetailActivity.kt
Menampilkan detail lengkap siswa yang dipilih dari daftar. Data dikirimkan dari MainActivity melalui Intent.

## ⚙️ Fitur Aplikasi
1. Menampilkan daftar siswa menggunakan RecyclerView dengan tata letak vertikal
2. Setiap item siswa berisi foto, nama, NIS, dan kelas.
3. Pengguna dapat melihat detail lengkap siswa melalui halaman DetailActivity.
4. Tersedia tombol Edit untuk mengubah data siswa.
5. Tersedia tombol Hapus untuk menghapus data siswa dari daftar.

## 🔧 Teknologi
1. Kotlin
2. Android Studio
3. Git + GitHub

## 💻 Penjelasan code penting
1. 📄 Penjelasan Kode **DetailActivity.kt**
<img width="1886" height="2160" alt="carbon (2)" src="https://github.com/user-attachments/assets/dd00716f-7755-49f0-8ba6-90aad36e7f36" />
DetailActivity.kt berfungsi untuk menampilkan detail lengkap dari siswa yang dipilih pada daftar RecyclerView di MainActivity. Activity ini memanggil layout activity_detail.xml untuk menampilkan data. Pada awalnya, semua komponen TextView (nama, NIS, kelas, jurusan, sekolah) dihubungkan dengan ID masing-masing melalui findViewById(). Selanjutnya, data siswa dikirim dari MainActivity menggunakan Intent dan diterima di DetailActivity dengan metode getStringExtra() berdasarkan key yang sudah ditentukan. Setelah data berhasil diambil, setiap TextView diisi dengan informasi siswa yang dilengkapi keterangan, misalnya “Nama: …” atau “NIS: …”. Selain itu, terdapat pengaturan padding menggunakan ViewCompat.setOnApplyWindowInsetsListener agar tampilan menyesuaikan posisi status bar dan navigation bar sehingga teks tidak tertimpa.


2. 📄 Penjelasan Kode **DummyData.kt**
<img width="2048" height="1452" alt="carbon (3)" src="https://github.com/user-attachments/assets/24d8a1c5-04a7-469b-b81a-41d09c5c40bc" />
DummyData.kt adalah sebuah object di Kotlin yang berfungsi untuk menyediakan data contoh (dummy) bagi aplikasi. File ini berada di dalam package com.smkth.app3_recycleview.data dan digunakan untuk mengisi daftar siswa pada RecyclerView tanpa perlu mengambil data dari database atau server. Di dalamnya terdapat fungsi getStudentList() yang mengembalikan sebuah MutableList<Student>. List ini berisi objek-objek Student yang masing-masing memiliki informasi lengkap, seperti nama siswa, NIS, kelas, jurusan, dan nama sekolah. Data tersebut dibuat secara manual di dalam kode sebagai data statis.

Dengan adanya file ini, aplikasi dapat menampilkan daftar siswa secara langsung saat dijalankan. Hal ini mempermudah proses pengujian aplikasi, karena pengembang tidak perlu menunggu integrasi dengan sumber data asli. Dummy data ini biasanya digunakan untuk tahap pengembangan atau demo aplikasi.


3. 📄 Penjelasan Kode **MainActivity.kt**
<img width="1886" height="5400" alt="carbon (4)" src="https://github.com/user-attachments/assets/7f42bdc5-7e65-42c9-b0e3-1d4ba7776738" />
MainActivity.kt adalah activity utama yang digunakan untuk menampilkan daftar siswa pada aplikasi menggunakan RecyclerView. Activity ini memanggil layout activity_main.xml dan mengatur seluruh logika utama seperti menampilkan data, melakukan pencarian, serta menambah dan mengedit data siswa.

Pada saat onCreate(), aplikasi menyesuaikan tampilan menggunakan ViewCompat.setOnApplyWindowInsetsListener agar konten tidak tertimpa status bar atau navigation bar. Data awal diambil dari DummyData.getStudentList() dan disimpan dalam variabel studentList. Data ini kemudian dihubungkan ke StudentAdapter yang bertugas menampilkan setiap item siswa di RecyclerView.

Terdapat fitur FloatingActionButton untuk menambah data siswa baru. Saat tombol ditekan, method showFormDialog() akan dipanggil untuk menampilkan form input menggunakan AlertDialog. Form ini juga digunakan untuk mengedit data jika parameter isEdit bernilai true. Setelah data disimpan, adapter diperbarui dengan updateData() agar perubahan langsung muncul di layar.

Selain itu, tersedia fitur pencarian data siswa menggunakan SearchView. Fungsi setOnQueryTextListener() digunakan untuk memfilter daftar siswa berdasarkan teks yang diketik pengguna, baik saat tombol submit ditekan (onQueryTextSubmit) maupun saat teks berubah (onQueryTextChange).

Dengan demikian, MainActivity menjadi pusat pengaturan data pada aplikasi, mulai dari menampilkan daftar, mencari, menambah, hingga mengedit data siswa, semua dilakukan secara langsung di dalam activity ini.


4. 📄 Penjelasan Kode **Student Adapter**
<img width="2048" height="4692" alt="carbon (5)" src="https://github.com/user-attachments/assets/cfe2a306-78c6-446f-85a8-6cbe3fd0cc1b" />

StudentAdapter.kt adalah adapter yang menghubungkan data siswa dengan tampilan pada RecyclerView. File ini berada di package com.smkth.app3_recycleview.adapter dan mengimplementasikan RecyclerView.Adapter serta Filterable untuk mendukung fitur pencarian. Adapter ini menerima tiga parameter: Context, daftar siswa (studentList), dan sebuah callback onUpdateClick yang dipanggil ketika tombol edit ditekan.

Di dalamnya terdapat ViewHolder yang menyimpan referensi ke elemen-elemen tampilan di item_student.xml seperti nama, NIS, kelas, jurusan, sekolah, serta tombol Hapus dan Update. Metode onCreateViewHolder() bertugas membuat objek ViewHolder dari layout item, sedangkan onBindViewHolder() mengisi data siswa ke tampilan sesuai posisi.

Fitur hapus data menggunakan AlertDialog untuk konfirmasi sebelum menghapus siswa dari daftar. Fitur update data memanggil callback onUpdateClick dan mengirimkan data siswa serta posisi index-nya ke MainActivity. Klik pada item siswa akan membuka DetailActivity dengan mengirimkan data melalui Intent.

Adapter ini juga memiliki fitur pencarian dengan mengimplementasikan getFilter(). Proses filter dilakukan dengan mencocokkan kata kunci dengan nama, NIS, kelas, jurusan, atau sekolah siswa. Hasil pencarian disimpan dalam filteredList dan ditampilkan kembali melalui notifyDataSetChanged().

Selain itu, terdapat metode updateData() untuk memperbarui seluruh daftar siswa di adapter dan me-refresh tampilan. Dengan demikian, StudentAdapter berperan penting sebagai penghubung antara data siswa dan tampilan daftar yang interaktif di aplikasi.


5. 📄 Penjelasan Kode **Student**
<img width="974" height="744" alt="carbon (6)" src="https://github.com/user-attachments/assets/1b195b00-0efe-4186-acfb-52805e8aef0a" />
Student.kt adalah file model yang digunakan untuk merepresentasikan data siswa dalam aplikasi. File ini berada di package com.smkth.app3_recycleview.model dan menggunakan data class pada bahasa pemrograman Kotlin.

data class ini memiliki lima properti, yaitu:
1. **nama** → Menyimpan nama lengkap siswa.
2. **nis** → Menyimpan Nomor Induk Siswa.
3. **kelas** → Menyimpan informasi kelas siswa.
4. **jurusan** → Menyimpan jurusan atau program keahlian siswa.
5. **sekolah** → Menyimpan nama sekolah siswa.

Model Student ini berfungsi sebagai struktur data yang akan digunakan di seluruh bagian aplikasi, baik saat menampilkan daftar di RecyclerView, mengirim data antar activity melalui Intent, maupun ketika menambah atau mengedit data. Dengan penggunaan data class, pengelolaan data menjadi lebih sederhana karena otomatis menyediakan fungsi-fungsi seperti toString(), equals(), dan copy() tanpa perlu menulis kode tambahan.


6. 📄 Penjelasan Kode **activity_main.xml**
<img width="1548" height="1602" alt="carbon (7)" src="https://github.com/user-attachments/assets/406ccd00-5b24-48d7-846e-15e61080bc64" />
activity_main.xml adalah layout utama aplikasi yang digunakan oleh MainActivity. Layout ini menggunakan LinearLayout dengan orientasi vertikal, sehingga elemen-elemen di dalamnya disusun dari atas ke bawah. Padding sebesar 8dp diberikan agar tampilan tidak menempel pada tepi layar.

Komponen pertama adalah SearchView dengan id searchView yang digunakan untuk mencari data siswa berdasarkan kata kunci. Atribut queryHint diatur menjadi "Cari siswa..." untuk memberikan petunjuk kepada pengguna.

Di bawahnya terdapat RecyclerView dengan id recyclerView yang berfungsi menampilkan daftar siswa dalam bentuk list. RecyclerView memiliki tinggi 0dp dan menggunakan layout_weight="1" agar dapat memenuhi ruang kosong di antara SearchView dan FloatingActionButton secara proporsional.

Komponen terakhir adalah FloatingActionButton dengan id fabTambah yang ditempatkan di pojok kanan bawah layar (layout_gravity="bottom|end"). Tombol ini digunakan untuk menambah data siswa baru, dengan ikon ic_input_add sebagai penanda fungsi tambah.


7. 📄 Penjelasan Kode **item_student**
<img width="1868" height="3910" alt="carbon (8)" src="https://github.com/user-attachments/assets/72c95467-f372-4967-a39d-212a0cfb8eba" />
item_student.xml adalah layout yang digunakan untuk menampilkan satu item data siswa di dalam RecyclerView. Layout ini dibungkus dengan CardView agar setiap item memiliki sudut melengkung (cardCornerRadius="8dp") dan bayangan (cardElevation="4dp") sehingga tampilannya lebih menarik.

Di dalam CardView, terdapat LinearLayout horizontal yang menyusun komponen gambar dan teks secara sejajar. Bagian kiri berisi ImageView dengan ukuran 48dp x 53dp untuk menampilkan foto siswa yang diambil dari drawable (@drawable/fotosiswa).

Bagian kanan adalah LinearLayout vertikal yang memuat beberapa TextView untuk menampilkan informasi siswa, yaitu:
1. **tvNama** → Nama lengkap siswa (tebal dan ukuran 18sp).
2. **tvNis** → Nomor Induk Siswa.
3. **tvKelas** → Kelas siswa.
4. **tvJurusan** → Jurusan atau program keahlian.
5. **tvSekolah** → Nama sekolah.

Di bagian bawah informasi siswa, terdapat LinearLayout horizontal berisi dua tombol:
1. **btnHapus** → Untuk menghapus data siswa.
2. **btnUpdate** → Untuk mengedit data siswa (dengan margin kiri 20px agar ada jarak).

Layout ini digunakan oleh StudentAdapter untuk mengikat data siswa ke tampilan di setiap baris RecyclerView.


8. 📄 Penjelasan Kode **activity_detail**
<img width="1514" height="2830" alt="carbon (9)" src="https://github.com/user-attachments/assets/d0d23940-def2-44bd-a796-c3d8e10d52ce" />
activity_detail.xml adalah layout yang digunakan oleh DetailActivity untuk menampilkan informasi lengkap dari seorang siswa. Layout ini menggunakan LinearLayout dengan orientasi vertikal sehingga semua elemen ditampilkan dari atas ke bawah. Padding 20dp digunakan untuk memberi jarak dari tepi layar agar tampilan lebih rapi.

Bagian atas layout berisi TextView dengan teks "Biodata Siswa" (diambil dari string resource @string/biodata_siswa), ukuran font 40sp, warna hitam, dan posisi teks di tengah. Di bawahnya terdapat ImageView berukuran 80dp x 80dp dengan gambar siswa (@drawable/fotosiswa) yang diletakkan di tengah sebagai ikon profil.

Selanjutnya, terdapat beberapa TextView yang masing-masing memiliki id unik (tvNama, tvNis, tvKelas, tvJurusan, tvSekolah). Elemen-elemen ini akan diisi secara dinamis oleh DetailActivity dengan data siswa yang dikirim dari MainActivity. Masing-masing TextView memiliki ukuran teks bervariasi (18sp hingga 20sp), beberapa di antaranya menggunakan textStyle="bold" untuk menegaskan informasi penting seperti nama, jurusan, dan sekolah.

Layout ini berfungsi sebagai halaman detail yang menampilkan biodata siswa secara terpusat dan rapi, sehingga pengguna dapat melihat informasi lengkap dengan mudah.

9. 📄 Penjelasan Kode **addnupdate**
<img width="1480" height="1750" alt="carbon (10)" src="https://github.com/user-attachments/assets/ae1e345f-11a9-4558-917a-69f319adbd26" />
addnupdate.xml adalah layout yang digunakan sebagai form input untuk menambah atau mengedit data siswa di aplikasi. Layout ini dibungkus dengan ScrollView agar seluruh isi form dapat digulir jika melebihi tinggi layar, sehingga tetap nyaman digunakan pada perangkat dengan ukuran layar kecil.

Di dalam ScrollView terdapat LinearLayout dengan orientasi vertikal dan padding 16dp, sehingga setiap komponen ditampilkan dari atas ke bawah dengan jarak yang cukup dari tepi layar.

Form ini terdiri dari lima buah EditText yang masing-masing digunakan untuk mengisi atau mengubah data siswa, yaitu:
1. **edtNama** → Input nama siswa dengan hint "Nama".
2. **edtNis** → Input Nomor Induk Siswa dengan hint "NIS".
3. **edtKelas** → Input kelas siswa dengan hint "Kelas".
4. **edtJurusan** → Input jurusan atau program keahlian siswa dengan hint "Jurusan".
5. **edtSekolah** → Input nama sekolah siswa dengan hint "Sekolah".

Layout ini dipanggil di MainActivity melalui method showFormDialog() dan ditampilkan menggunakan AlertDialog saat pengguna ingin menambah atau mengedit data. Dengan penggunaan ScrollView dan susunan yang sederhana, form ini mudah digunakan dan responsif pada berbagai ukuran layar.


# 📸 Screenshot
![WhatsApp Image 2025-08-06 at 21 04 24_57a2e690](https://github.com/user-attachments/assets/256668d0-2569-4f09-ba02-b9a9f35d474e)
![WhatsApp Image 2025-08-06 at 21 04 22_ea78a2f0](https://github.com/user-attachments/assets/5edb2b2a-f4f4-400a-b8b8-c83d8d2dcab1)
![WhatsApp Image 2025-08-06 at 21 04 24_76d97585](https://github.com/user-attachments/assets/15ba3bea-7845-49de-a38e-a6f957187ed6)
![WhatsApp Image 2025-08-06 at 21 04 23_57a3fd0a](https://github.com/user-attachments/assets/4d83fe63-02d0-40ba-a582-5eb3e3a9813f)
![WhatsApp Image 2025-08-06 at 21 04 23_6c31ea4b](https://github.com/user-attachments/assets/5ac81069-84e9-457a-aecc-ef7b60464d9e)
![WhatsApp Image 2025-08-06 at 21 04 23_b8d5c1e4](https://github.com/user-attachments/assets/2c1423a4-1eeb-4f89-b44d-ea1155a36f1f)
![WhatsApp Image 2025-08-06 at 21 04 24_1e8a3a90](https://github.com/user-attachments/assets/49d98646-f84a-463e-8fc2-f6a0690872af)
![WhatsApp Image 2025-08-06 at 21 04 24_7224135a](https://github.com/user-attachments/assets/92fa37c2-76e3-41bc-936c-4d3449819e1a)
![WhatsApp Image 2025-08-06 at 21 04 24_b85bd773](https://github.com/user-attachments/assets/f8078653-6ea0-41be-a185-715e0fa91151)
![WhatsApp Image 2025-08-06 at 21 04 24_16986686](https://github.com/user-attachments/assets/35b9f6ed-c516-484d-ac36-304139136a57)
![WhatsApp Image 2025-08-06 at 21 04 24_ee2260a2](https://github.com/user-attachments/assets/53790395-838d-4ada-95d0-d59965a86437)
![WhatsApp Image 2025-08-06 at 21 04 24_c04f80be](https://github.com/user-attachments/assets/643e5ba7-75fb-4da0-bf99-34e0e0c6b6e9)
![WhatsApp Image 2025-08-06 at 21 04 24_9c594458](https://github.com/user-attachments/assets/a4468aa4-8c6d-46f5-81dc-02befb026f9b)
![WhatsApp Image 2025-08-06 at 21 04 24_6d80930a](https://github.com/user-attachments/assets/7b4fabb1-a846-4fac-b016-730826a20126)
![WhatsApp Image 2025-08-06 at 21 04 24_1c18ac94](https://github.com/user-attachments/assets/2c07c5de-31a1-4e0f-90c2-000615e089ea)
![WhatsApp Image 2025-08-06 at 21 04 24_735143af](https://github.com/user-attachments/assets/492cd1e5-a932-408f-8618-c1f7a51df491)
![WhatsApp Image 2025-08-06 at 21 04 24_d023dd9e](https://github.com/user-attachments/assets/c9f48992-af63-4af5-9e63-59ce15fe95a7)






