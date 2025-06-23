# 🛡️ API Gateway Design Pattern - Microservices

Bu proje, Spring Boot ve Spring Cloud teknolojileri ile geliştirilmiş, **API Gateway Design Pattern**'ını uygulamalı olarak gösteren bir mikroservis mimarisidir. Merkezi bir **API Gateway** üzerinden, kimlik doğrulama ve yönlendirme işlemleri yapılır. Ayrıca Redis tabanlı rate limiter, JWT ile güvenlik, Docker Compose ile kurulum gibi modern yazılım bileşenlerini içermektedir.

---

## 🎯 Amaç

- Mikroservislerde istemci taleplerini merkezi bir geçit (API Gateway) üzerinden yönlendirmek
- JWT tabanlı authentication / authorization yapısı kurmak
- Redis ile rate limiting (yük dengeleme) uygulamak
- Modüler, ölçeklenebilir Spring Boot mimarisi oluşturmak

---

## 🧱 Mimaride Yer Alan Servisler

```
apigatewaydesignpattern/
├── backend/
│   ├── apigateway/       --> Spring Cloud Gateway (router + filter + rate limiter)
│   ├── authservice/      --> Kullanıcı giriş ve JWT üretimi
│   └── userservice/      --> Kimlik doğrulama gerektiren örnek servis
├── docker-compose.yml    --> Redis ve PostgreSQL servisi tanımları
└── README.md             --> Proje tanıtım ve kurulum dökümanı
```

---

## 🛠️ Kullanılan Teknolojiler

- Java 17  
- Spring Boot  
- Spring Cloud Gateway  
- Spring Security + JWT  
- Redis (Rate Limiting için)  
- PostgreSQL  
- Docker & Docker Compose  
- Maven (multi-module yapı)

---

## 🚀 Uygulamayı Çalıştırma

### 🔁 Git Reposunu Klonla
```bash
git clone https://github.com/mutlukodcu/apigatewaydesignpattern.git
cd apigatewaydesignpattern
```

### 🐳 Docker Servislerini Başlat
```bash
docker-compose up -d
```
> PostgreSQL: `localhost:5432`  
> Redis: `localhost:6379`

---

## 🔐 JWT Authentication Akışı

1. Kullanıcı `/auth/login` endpoint’ine kullanıcı adı ve şifresi ile istek gönderir.  
2. `authservice`, doğru bilgilerle JWT üretir.  
3. Kullanıcı bu JWT’yi **Authorization Header**’a ekleyerek `userservice`'e istek gönderir.  
4. `apigateway`, bu token’ı doğrular ve isteği yönlendirir.  

---

## ⚙️ Yapılandırma Dosyaları

Her servisin kendi `application.yml` dosyası bulunmaktadır:

- `authservice`: Veritabanı bağlantısı ve JWT ayarları  
- `userservice`: JWT doğrulaması için gerekli secret konfigürasyonu  
- `apigateway`: Route tanımları ve Rate Limiter kuralları  

---

## ✨ Geliştirici

**Demet Bektaş**  
🔗 [LinkedIn](https://www.linkedin.com/in/demetbekta%C5%9F/)  
✍️ [Medium Blog](https://medium.com/@mutlukodcu)

---

## 🪪 Lisans

MIT Lisansı

---

## 📌 Notlar

Proje, geliştirilmeye ve özelleştirilmeye açık bir yapıdadır. Swagger dokümantasyonu, merkezi konfigürasyon yönetimi, service discovery (Eureka) gibi eklemeler yapılabilir.
