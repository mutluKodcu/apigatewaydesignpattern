
# 🛡️ API Gateway Design Pattern - Microservices Example

Bu proje, Spring Boot tabanlı mikroservis mimarisinde **API Gateway Pattern** kullanımını temel alan bir örnek uygulamadır. Proje, kullanıcı kimlik doğrulaması, kullanıcı yönetimi ve istek yönlendirmesini Spring Cloud Gateway üzerinden merkezi olarak sağlar.

---

## 📦 Proje Modülleri

apigatewaydesignpattern/
├── backend/
│ ├── apigateway/ # API geçidi (JWT, Redis, Rate Limiter)
│ ├── authservice/ # Kullanıcı giriş işlemleri (JWT üretimi)
│ └── userservice/ # Kullanıcı CRUD işlemleri
│
├── nginx/ # NGINX reverse proxy yapılandırması
├── docker-compose.yml # Tüm servisleri ayağa kaldıran orchestrator
└── README.md # Bu dökümantasyon

---

## 🚀 Kullanılan Teknolojiler

| Teknoloji            | Açıklama                                    |
|----------------------|---------------------------------------------|
| Java 17              | Uygulama dili                               |
| Spring Boot          | Mikroservis temeli                          |
| Spring Cloud Gateway | API yönlendirme katmanı                     |
| Redis                | Rate Limiting altyapısı                     |
| PostgreSQL           | Veritabanı                                  |
| Docker Compose       | Servis orkestrasyonu                        |
| JWT                  | Kimlik doğrulama                           |
| Lombok               | Kod sadeleştirme                           |

---

## 🔐 Güvenlik ve Rate Limiting

- **JWT ile kimlik doğrulama**: API Gateway, gelen isteklerde `Authorization: Bearer <token>` başlığını kontrol eder.
- **Redis Rate Limiter**: Her kullanıcı için saniyede maksimum 5 istek ve 10 burst kapasite sınırı uygulanır.
- **Global JWT Filter**: Gateway’e gelen tüm istekler `JwtAuthenticationFilter` üzerinden kontrol edilir.

---
## 🔐 Güvenlik ve Rate Limiting
🔐 Kimlik Doğrulama (JWT)
📁 `backend/authservice`  
📄 `AuthController.java` — Giriş yapan kullanıcıya JWT üretir.

```java
@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody AuthRequest request) {
    // sabit kullanıcı kontrolü (demo)
    if ("demo".equals(request.getUsername()) && "demo123".equals(request.getPassword())) {
        String token = jwtUtil.generateToken(request.getUsername());
        return ResponseEntity.ok(new AuthResponse(token));
    }
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
}

## ⚙️ Çalıştırma Adımları

1. Projeyi klonlanlanması:
   ```bash
   git clone https://github.com/kullaniciadi/apigatewaydesignpattern.git
   cd apigatewaydesignpattern


2. Uygulamayı Docker ile başlatılması:
	docker-compose up --build

3. Tarayıcıda açmak için:
	Gateway: http://localhost:8080
	AuthService: http://localhost:8082/auth/login
	UserService: http://localhost:8081/users
	
🧪 Örnek Kullanım (Postman)
1. Login isteği 
	POST http://localhost:8082/auth/login
	Content-Type: application/json

	{
	  "username": "demo",
	  "password": "demo123"
	}

2. JWT token:
   GET http://localhost:8080/users/all
   Authorization: Bearer <TOKEN>
   
3. Swagger UI adresi:
   http://localhost:8081/swagger-ui.html
