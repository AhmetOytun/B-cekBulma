//İsim=Ahmet Oytun Kurtuldu
//Numara=22120205009
//Mailimi Geri Aldım :)
import java.io.BufferedReader;
import java.io.FileReader;

class Main{
    public static void main(String[] args) throws Exception {
        int bocekbaslangici=0;                 //----------------------------------------------------------------------------------------------------------------------------
        int bocekgovdesi=0;                    //Burada Böceği 3 Kısıma Ayırdım Eğer txt Dosyasında Kafası Var Gövdesi Yok Tipi Bir Durum Olursa Onu Böcek Olarak Saymayacak.
        int bocekbitisi=0;                     //----------------------------------------------------------------------------------------------------------------------------
        int boceksayisi=0;                     //Böcek Sayısını Tutan Değişken
        BufferedReader br1=new BufferedReader(new FileReader("arazi.txt"));//arazi.txt Dosyasını Okutuyoruz.
        Fonksiyonlar fonk=new Fonksiyonlar();//Fonksiyonumu Ayrı Bir Classa Koydum Daha Rahat Okunsun Diye.
        String line=br1.readLine();//Okunan Satırı String Değişkenine Atıyorum.
        while(line!=null){//txt Dosyası Boş Olmadığı Sürece Okumaya Devam Edicek.
            if(line.contains("|    _")){
                bocekbaslangici+=fonk.tekrarbul("|    _", line);//Eğer Satırda Varsa Ne Kadar Olduğunu Kontrol Ediyor.
            }
            if(line.contains("###O")){//Pattern Varlığını Kontrol Ediyor.
                bocekgovdesi+=fonk.tekrarbul("###O", line);//Eğer Satırda Varsa Ne Kadar Olduğunu Kontrol Ediyor.
            }
            if(line.contains("|")){//Pattern Varlığını Kontrol Ediyor.
                bocekbitisi+=fonk.tekrarbul("|", line);//Eğer Satırda Varsa Ne Kadar Olduğunu Kontrol Ediyor.
            }
            line=br1.readLine();//Diğer Satıra Geçiyor
        }
        if(bocekbitisi<=bocekbaslangici){//--------------------------------------------------------------------------------------
            if(bocekbitisi<=bocekgovdesi){//Hangi Sayı Daha Küçük Onu Kontrol Ediyoruz, En Küçük Sayı Bize Böcek Sayısını Verecek.
                boceksayisi=bocekbitisi;//---------------------------------------------------------------------------------------
            }
        } else if(bocekgovdesi<=bocekbaslangici){//------------------------------------------------------------------------------
            if(bocekgovdesi<=bocekbitisi){//Hangi Sayı Daha Küçük Onu Kontrol Ediyoruz, En Küçük Sayı Bize Böcek Sayısını Verecek.
                boceksayisi=bocekgovdesi;//--------------------------------------------------------------------------------------
            }
        }
        else{
            boceksayisi=bocekbaslangici;//Hangi Sayı Daha Küçük Onu Kontrol Ediyoruz, En Küçük Sayı Bize Böcek Sayısını Verecek.
        }
        System.out.println("Bocek Sayisi="+boceksayisi);//Böcek Sayısını Yazdırıyoruz.
        br1.close();//Okuyucuyu Kapatıyoruz.
    }
}
class Fonksiyonlar{
    int tekrarbul(String bulunacakpattern,String line){
        int tekrarsayisi=0;  
        int indexnumarasi=0;  
        for(; ;){ //Verilen Stringin İçinde Sonsuz Döngü Açıyoruz(break İle Çıkıcaz).
        int index = line.indexOf(bulunacakpattern, indexnumarasi); //bulunacakpattern'a İstediğimiz Stringi Giriyoruz Sonrasında İse indexnumarası Değişkenindeki Sayının Bulunduğu Yerden Başlayarak Kontrolü Sağlıyoruz.
        if(index >= 0){  //İçinde Varsa Tekrar Sayısını Arttırıyoruz
        tekrarsayisi = tekrarsayisi + 1;  
        indexnumarasi = index + 1;  //Bir Sonraki Indexe Geçiyoruz Ki Önceki Tekrarlanmasın.
        }  
        else{  //İçinde Yoksa Çıkmasını Sağlıyoruz
        break;  
        }  
    }
    return tekrarsayisi;//Sayıyı Döndürüyoruz.
}
}