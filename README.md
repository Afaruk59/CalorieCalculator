<div align="center">

# 🍏 Calorie Calculator

**Gelişmiş, yerel veri tabanlı ve kullanıcı dostu bir Masaüstü Beslenme, Antrenman ve Vücut İstatistikleri Takip Uygulaması.**

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)
[![Java Swing](https://img.shields.io/badge/Java_Swing-007396?style=for-the-badge&logo=java&logoColor=white)](#)
[![FlatLaf](https://img.shields.io/badge/FlatLaf-Theme-4B8BBE?style=for-the-badge)](#)
[![JFreeChart](https://img.shields.io/badge/JFreeChart-Stats-brightgreen?style=for-the-badge)](#)
[![Version](https://img.shields.io/badge/Version-3.3.0-blue?style=for-the-badge)](#)

</div>

---

## 📖 Proje Hakkında

**Calorie Calculator**, Java Swing altyapısı kullanılarak geliştirilmiş, kişisel sağlık ve fitness hedeflerinizi tek bir ekrandan profesyonelce yönetmenizi sağlayan masaüstü bir uygulamadır. 

Modern ve şık arayüzü (FlatLaf destekli), kapsamlı grafiksel istatistikleri (JFreeChart) ve tamamen yerel ortamda çalışan (offline-first) mimarisi ile kullanıcıların günlük makro besinlerini takip etmelerine, antrenman programlarını oluşturmalarına ve vücut kompozisyonlarını hesaplamalarına olanak tanır.

---

## ✨ Temel Özellikler

### 📊 Beslenme ve Makro Takibi (Diary & Foods)
- **Detaylı Makro Takibi:** Günlük Protein, Karbonhidrat, Yağ ve Kalori alımını hassas bir şekilde hesaplar ve kaydeder.
- **İlerleme Durumu:** Hedeflerinize ne kadar yaklaştığınızı interaktif ilerleme çubukları (Progress Bars) ile anlık olarak takip edin.
- **Genişletilebilir Besin Veritabanı:** 
  - Sistemde varsayılan olarak gelen İngilizce ve Türkçe besin listeleri.
  - Kendi öğünlerinizi ve besin değerlerini (Özel Yemekler) ekleyebilme.
  - Sık kullanılan yiyecekleri Favorilere ekleyerek hızlı erişim sağlama.

### 🎯 Hedef ve İstatistik Yönetimi (Goals & Charts)
- **Özelleştirilebilir Hedefler:** Günlük bazda kişisel kalori ve makro hedeflerinizi belirleyebilirsiniz.
- **Görsel Veri Analizi:** 
  - **Pasta Grafikler (Pie Chart):** Günlük makro alımınızın ve hedeflerinizin oransal dağılımını görselleştirir.
  - **Bar ve Çizgi Grafikler (Bar & Line Chart):** Son 7 günün makro besin tüketim trendlerini ve günlük kalori dalgalanmalarını detaylı olarak raporlar.

### 🏋️ Antrenman Planlayıcısı (Training Plan)
- Kendi antrenman rutininizi oluşturun.
- Her bir egzersiz için **Set, Tekrar ve Ağırlık (kg/lbs)** bilgilerini tablo sistemine kaydedin ve günlük olarak takip edin.

### 🧮 Gelişmiş Vücut Hesaplayıcıları (Body Calculators)
- **Vücut Yağ Oranı Hesaplayıcı:** ABD Donanması (US Navy) metodunu kullanarak (Cinsiyet, Boy, Boyun, Bel ve kadınlar için Kalça ölçüleri ile) gerçeğe en yakın yağ oranını hesaplar.
- **Vücut Kitle İndeksi (VKİ/BMI):** Boy ve kilo oranınıza göre mevcut durumunuzu analiz eder.
- **Günlük Kalori İhtiyacı (BMR & TDEE):** Bazal Metabolizma Hızınızı ve seçtiğiniz aktivite seviyesini (Sedanter, Aktif vb.) baz alarak kilonuzu korumak, zayıflamak veya kilo almak için gereken kaloriyi hesaplar.

### 🎨 Kişiselleştirme ve Deneyim (Settings)
- **Modern Temalar:** FlatLaf entegrasyonu sayesinde göz yormayan **Karanlık (Dark)** ve ferah **Aydınlık (Light)** tema seçenekleri.
- **Çoklu Dil Desteği:** Türkçe ve İngilizce dilleri arasında tek tıkla geçiş yapabilme.
- **Ambiyans Sesleri:** Çalışırken veya uygulamayı kullanırken odaklanmanızı artıracak entegre arka plan ses ve müzik oynatıcısı (Java Sound API).

---

## 🛠️ Kullanılan Teknolojiler ve Mimari

Bu proje, dışa bağımlılığı en aza indirgeyecek şekilde Standart Java kütüphaneleri kullanılarak modüler bir yapıda inşa edilmiştir:

- **Programlama Dili:** Java SE (Standard Edition)
- **Kullanıcı Arayüzü (GUI):** Java Swing, AWT
- **Tema Motoru:** [FlatLaf](https://www.formdev.com/flatlaf/) (Modern Look and Feel)
- **Veri Görselleştirme:** [JFreeChart](https://www.jfree.org/jfreechart/) (İstatistiksel grafiklerin çizimi için)
- **Veri Saklama (I/O):** Java `java.io` kütüphanesi ve `.acc` formatlı özel metin dosyaları kullanılarak kullanıcıya özgü (`users/{username}/`) yerel depolama.
- **Ses Yönetimi:** `javax.sound.sampled` (Hata sesleri, buton efektleri ve arka plan müzikleri)

---

## 📂 Proje Dizin Yapısı

```text
CalorieCalculator/
│
├── src/                        # Kaynak kod (Java Sınıfları)
│   ├── Main.java               # Uygulama başlangıç noktası ve modül yükleyici
│   ├── gUI.java                # Temel Swing arayüzü ve olay dinleyicileri (Event Listeners)
│   ├── Data.java               # Dosya I/O işlemleri, profil kaydetme ve okuma mekanizmaları
│   ├── Body.java               # Yağ, BMI ve Kalori hesaplama algoritmaları
│   ├── Charts.java             # JFreeChart grafik oluşturma sınıfları
│   ├── User.java               # Kullanıcı giriş, kayıt ve dizin oluşturma işlemleri
│   ├── Language.java           # Çoklu dil veri setleri
│   └── ...diğer modüller (Ambients, Effects, SyncFoods, vb.)
│
├── lib/                        # Harici Kütüphaneler (.jar)
│   ├── flatlaf-3.1.1.jar       # Tema altyapısı
│   └── jfreechart-1.5.4.jar    # Grafik altyapısı
│
└── resources/                  # Statik Kaynaklar
    ├── lang/                   # Dil konfigürasyonları
    ├── img/                    # İkonlar ve logolar (logo.png vb.)
    ├── sound/                  # Efekt ve ambiyans müzikleri
    ├── defFoodsEng.acc         # İngilizce varsayılan besin veritabanı
    └── defFoodsTr.acc          # Türkçe varsayılan besin veritabanı
```

---

## 🚀 Kurulum ve Çalıştırma

Projeyi kendi bilgisayarınızda çalıştırmak veya geliştirmek için aşağıdaki adımları izleyin:

### Gereksinimler
- **Java Development Kit (JDK) 8** veya daha üzeri bir sürüm.
- Tercih edilen bir Java IDE'si (Eclipse, IntelliJ IDEA, VS Code vb.)

### Adımlar

1. **Projeyi Klonlayın:**
   ```bash
   git clone https://github.com/Afaruk59/CalorieCalculator.git
   cd CalorieCalculator
   ```

2. **Kütüphaneleri (Libraries) Ekleyin:**
   Kullandığınız IDE üzerinden, projenin içindeki `lib` klasöründe bulunan `flatlaf-3.1.1.jar` ve `jfreechart-1.5.4.jar` dosyalarını projenizin "Build Path" (Derleme Yolu) alanına dahil edin.

3. **Uygulamayı Başlatın:**
   `src/Main.java` dosyasını çalıştırın. Uygulama sizden bir kullanıcı oluşturmanızı isteyecek ve sonrasında ana ekrana yönlendirecektir.

---

## 💾 Veri Saklama Mekanizması Nasıl Çalışır?

Uygulama tamamen bulut bağımsızdır. Sisteme kayıt olan her kullanıcı için ana dizinde `users/<KullaniciAdi>/` adında bir klasör oluşturulur. Bu klasör altında:
- `profile.acc`: Kullanıcı hedefleri, mevcut dil, tema, ses ayarları ve 7 günlük tarihçe.
- `foods.acc`: Kullanıcının eklediği özel yiyecekler ve günlük beslenme listesi.
- `exercises.acc`: Antrenman programındaki tablo verileri.
tutulur. Kullanıcı silindiğinde veya sıfırlandığında bu dosyalar güvenli bir şekilde yönetilir.

---

## 🤝 Katkıda Bulunma

Bu proje açık kaynaklıdır ve her türlü katkıya (Pull Request, Bug Report, Feature Request) açıktır. 
1. Projeyi Fork'layın.
2. Kendi özellik dalınızı oluşturun (`git checkout -b feature/YeniOzellik`).
3. Değişikliklerinizi commit edin (`git commit -m 'Yeni bir özellik eklendi'`).
4. Dalınızı push edin (`git push origin feature/YeniOzellik`).
5. Bir Pull Request açın.

---

## 📞 İletişim & Yazar

**Geliştirici:** Afaruk59  
**GitHub:** [@Afaruk59](https://github.com/Afaruk59)  

Projeyle ilgili geri bildirimleriniz, fikirleriniz veya bulduğunuz hatalar için GitHub üzerinden Issue açmaktan çekinmeyin!

---
<div align="center">
<i>Sağlıklı günler ve iyi antrenmanlar dileriz! 💪🍏</i>
</div>
