package com.example;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class TestReporter extends RunListener {
    
    @Override
    public void testRunStarted(Description description) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("🚀 API TEST RAPORU BAŞLIYOR");
        System.out.println("=".repeat(50) + "\n");
    }
    
    @Override
    public void testStarted(Description description) {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("📌 TEST BAŞLIYOR: " + description.getMethodName());
        System.out.println("-".repeat(50));
    }

    @Override
    public void testFinished(Description description) {
        System.out.println("-".repeat(50));
        System.out.println("✅ TEST TAMAMLANDI: " + description.getMethodName());
        System.out.println("-".repeat(50) + "\n");
    }

    @Override
    public void testFailure(Failure failure) {
        System.out.println("\n" + "!".repeat(50));
        System.out.println("❌ TEST BAŞARISIZ: " + failure.getDescription().getMethodName());
        System.out.println("Hata Detayı: " + failure.getMessage());
        System.out.println("!".repeat(50) + "\n");
    }

    @Override
    public void testRunFinished(Result result) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("📊 TEST SONUÇLARI ÖZETİ");
        System.out.println("=".repeat(50));
        
        // Test istatistikleri
        System.out.println("\n📈 İSTATİSTİKLER:");
        System.out.println("   • Toplam Test Sayısı: " + result.getRunCount());
        System.out.println("   • Başarılı Test: " + (result.getRunCount() - result.getFailureCount()));
        System.out.println("   • Başarısız Test: " + result.getFailureCount());
        System.out.println("   • Atlanan Test: " + result.getIgnoreCount());
        
        // Performans bilgisi
        System.out.println("\n⚡ PERFORMANS:");
        System.out.println("   • Toplam Süre: " + result.getRunTime() + " ms");
        
        if (result.getRunTime() < 1000) {
            System.out.println("   • ✅ Tüm testler 1 saniyenin altında tamamlandı!");
        } else {
            System.out.println("   • ⚠️ Bazı testler 1 saniyeden uzun sürdü!");
        }
        
        // Başarı oranı
        double successRate = ((double)(result.getRunCount() - result.getFailureCount()) / result.getRunCount()) * 100;
        System.out.println("\n📊 BAŞARI ORANI:");
        System.out.println("   • " + String.format("%.2f", successRate) + "% başarılı");
        
        System.out.println("\n" + "=".repeat(50));
    }
} 