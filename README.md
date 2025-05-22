# Rest Assured API Testing Project

Bu proje, Rest Assured kütüphanesi kullanılarak API testlerinin nasıl yazılacağını gösteren bir örnek projedir.

## Proje Yapısı

- Java 11
- Maven
- Rest Assured 5.3.0
- JUnit 4
- Hamcrest

## Test Senaryoları

1. GET Request Testi
   - Endpoint: `/posts/1`
   - Status Code Kontrolü
   - Response Body Kontrolü
   - Response Time Kontrolü (< 1 saniye)

2. POST Request Testi
   - Endpoint: `/posts`
   - Request Body ile Yeni Post Oluşturma
   - Status Code Kontrolü
   - Response Body Kontrolü
   - Response Time Kontrolü (< 1 saniye)

## Projeyi Çalıştırma

1. Projeyi klonlayın
2. Maven bağımlılıklarını yükleyin:
   ```bash
   mvn clean install
   ```
3. Testleri çalıştırın:
   ```bash
   mvn test
   ```

## Test Sonuçları

Testler başarılı olduğunda:
- Status code kontrolleri geçer
- Response body içeriği beklenen değerlerle eşleşir
- Response time 1 saniyenin altındadır 