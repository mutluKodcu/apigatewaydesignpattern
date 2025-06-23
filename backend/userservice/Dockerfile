# Temel imaj: Java 17 JDK (Spring Boot için)
FROM eclipse-temurin:17-jdk-alpine

# Çalışma dizini oluştur
WORKDIR /app

# Maven build sonrası oluşan jar dosyasını kopyala (build aşaması lokal veya CI/CD'de yapılmalı)
COPY target/userservice-0.0.1-SNAPSHOT.jar app.jar

# Uygulamayı çalıştır
ENTRYPOINT ["java","-jar","app.jar"]
