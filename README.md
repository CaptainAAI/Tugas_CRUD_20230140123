POST 
http://localhost:8080/ktp
--------------------------------------
{
  "nomorKTP": "32010101444132143",
  "nama": "Budi bahlol",
  "alamat": "Jl. Merdeka No. 10",
  "tanggalLahir": "2005-01-55",
  "jenisKelamin": "Netral"
}
--------------------------------------
GET *ALL
http://localhost:8080/ktp
--------------------------------------
GET BY id
http://localhost:8080/ktp/x
(replace x with id)
--------------------------------------
PUT
http://localhost:8080/ktp/X
(replace x with id)
--------------------------------------
DELETE
http://localhost:8080/ktp/X
(replace x with id)
--------------------------------------
