Aplikasi saat diuji pada emulator, selesai login mengalami stop working, padahal sebelum selesai, aplikasi masih dapat dijalankan.

Saat diuji dengan Samsung Galaxy S7 dan Samsung Tab, aplikasi dapat dijalankan, hanya saja perbedaan resolusi membuat beberapa bagian ada yang terpotong di Samsung Galaxy seperti bagian reference di My Profile (Reference dari youtube dan stackoverflow).
Ditambahkan zip screenshot.

Aplikasi dimulai pada halaman login:
1. apabila Username dan Password salah, maka akan muncul tulisan berwarna merah "Username dan Password salah".
2. apabila Username salah, maka akan muncul tulisan berwarna merah "Username salah".
3. apabila Password salah, maka akan muncul tulisan berwarna merah "Password salah".
4. apabila Username dan Password kosong, maka akan muncul tulisan berwarna merah "Username dan Password tidak boleh kosong".

Terdapat checkbox untuk memperlihatkan password.

Apabila soft keyboard menghalangi tempat pengisian password, dapat menggunakan Enter/Next pada edittext username untuk berpindah ke edittext password.

Pada edittext password, dapat menggunakan Enter/Done untuk login atau tekan tombol login.

Setelah login dan masuk ke Activity selanjutnya, akan muncul allow permission request dengan pilihan allow atau deny.

Secara coding, apabila deny dipilih, akan menampilkan AlertDialog Need Permissions dengan tombol GOTO Settings dan Cancel.

Namun, pada hp yang diuji, apabila deny yang dipilih maka listview tidak akan menampilkan lagu yang ada pada hp yg diuji.
 
Setelah allow request dipilih akan muncul AlertDialog Selamat Datang, nama dan nim lalu ada button OK.

Semakin banyak lagu yang ada pada hp yang dicoba, semakin lama filenya akan dibaca.

Ketika salah 1 lagu di klik, akan menuju PlayerActivity dengan nama toolbar "NOW PLAYING" dimana lagu yang dimainkan dapat di pause, dapat di next dan dapat di previous.
Terdapat juga seekbar yang menunjukkan berapa persen lagu sudah dimainkan, dapat dimajukan dan dimundurkan.
Namun, begitu lagu selesai dimainkan, tidak dapat memainkan lagu berikutnya.
Berbeda dengan menggunakan tombol next (>|), maka lagu berikutnya akan dimainkan.
Hal ini juga sama dengan menggunakan tombol previous (|<), maka lagu sebelumnya akan dimainkan.

Pada layout PlayerActivity, digunakan GifImageView untuk dapat menggunakan file Gif, hal ini bertujuan agar tampilan semakin keren.
Dalam hal ini, ada beberapa tambahan pada build.gradlenya.

Apabila tombol panah disebelah "NOW PLAYING" pada toolbar ditekan, akan kembali ke Activity awal dan muncul AlertDialog Selamat Datang lagi.

Terdapat icon search, namun tidak dapat dilakukan pencarian, hanya bisa diketik.

Selain itu, terdapat icon 3 titik dimana ketika diklik, akan muncul My Profile, Sort Ascending, Sort Descending dan LOGOUT.

Apabila My Profile di klik, akan menuju activity "MY PROFILE" yang menampilkan foto saya beserta nama dan nim, juga referensi saya.
Terdapat tombol panah disebelah "MY PROFILE" pada toolbar, apabila ditekan, akan kembali ke Activity awal dan muncul AlertDialog Selamat Datang lagi.

Apabila LOGOUT di klik, akan muncul Alert Dialog Are you sure? dengan 2 tombol cancel dan logout.
Apabila tombol logout di klik, akan kembali ke activity login, sehingga harus memasukkan username dan password kembali.
Namun, lagu yang diputar tetap menyala meskipun sudah logout.

Sort Ascending dan Sort Descending belum dapat diimplementasikan karena mengakibatkan aplikasi crash sehingga hanya ditampilkan Alert Dialog PENGUMUMAN.


