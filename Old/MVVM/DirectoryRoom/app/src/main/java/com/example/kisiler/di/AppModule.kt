package com.example.kisiler.di

import android.content.Context
import androidx.room.Room
import com.example.kisiler.data.repo.KisilerDaoRepository
import com.example.kisiler.room.KisilerDao
import com.example.kisiler.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


/*
İhtiyaç duyulan değerleri sağlayacak olan sınıf
Yani Inject edeceğimiz değerler

@Module açıklaması yazmış olduğumuz sınıf içinde üretilen örneklerin
uygulamanın başka bir yerinde kullanılacağını Hilte bildirmemizi sağlar.

@InstallIn açıklaması ise oluşturulan bu örneklerin uygulamanın
hangi yaşam döngüsü içinde var olacağını belirtmemizi sağlar.

SingletonComponent burdan bir nesne oluşturulacak ve heryerde kullanılacak demek

En son örneğimizde @Provide açıklamasını görmüş olmalısınız.
@Provide açıklaması bize başka kütüphanelerden elde ettiğimiz örnekleri Hilt ile uygulamamızda
başka sınıflarda enjekte etmemizi sağlarlar.
 */

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    //Sağlayıcı demek için
    @Provides
    @Singleton
    fun provideKrepo(kdao:KisilerDao): KisilerDaoRepository {
        return KisilerDaoRepository(kdao)
    }

    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context: Context): KisilerDao {
        // Hangi veritabanını kopyalayacağını belirten veritabanı classından bir nesne olutşurduk
        val vt = Room.databaseBuilder(context, Veritabani::class.java,"mvvmRehber.sqlite")
            .createFromAsset("mvvmRehber.sqlite").build()
        return vt.getKisilerDao()
    }
}