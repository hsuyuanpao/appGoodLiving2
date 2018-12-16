package com.hsuyuanpao.appgoodliving2;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;

public class AttrcationsNearByCVActivity extends AppCompatActivity{
    private static final String TAG = "AttractionsNearByCVActivity";

    private ListView mListView;

    CustomListAdapter3 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        mListView =  findViewById(R.id.listView);

        Toolbar toolbar = findViewById(R.id.toolBar2);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("          週邊景點介紹");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);

        ArrayList image_title = new ArrayList<>();
        ArrayList image_description = new ArrayList<>();

        image_title.add("朝天宮");
        image_title.add("北港老街");
        image_title.add("女兒橋");
        image_title.add("牛墟");
        image_title.add("北港水道頭");
        image_title.add("公館里彩繪社區");
        image_title.add("北港工藝坊");
        image_title.add("武德宮");
        image_title.add("北港觀光大橋");
        image_title.add("義民廟");

        image_description.add("        北港朝天宮，俗稱北港媽祖廟，位於臺灣雲林縣北港鎮中山路178號，是一座主要奉祀天上聖母的廟宇，1694年（清康熙33年），由樹璧和尚（臨濟正宗第34代）自福建省湄洲天后宮（朝天閣）迎請媽祖金身，於北港建廟收徒傳法。朝天宮被列為中華民國國定古蹟，自樹壁傳下17代禪宗法脈結束後，管理委員制取代原本僧侶管理系統，但至今仍聘請佛教僧侶任住持及駐廟法師。");
        image_description.add("        北港老街，台灣最長的一條特產老街，老街以北港朝天宮為核心，周圍環繞數十多條各具特色大小街道，最主要的宮口老街，朝天宮不但是台灣廟宇典範，也是分靈最多的媽祖信仰總本山。老街有數不清的在地特產店、美味小吃及零食、傳統工藝、新舊甘仔店、和農具店...，其古樸與豐富，令人目不暇給...，街上時常可見到來自各地的進香團和文武陣頭，此起彼落熱情演出。");
        image_description.add("        女兒橋，前身為台灣歷史最久的台糖蔗鐵橋—北港復興鐵橋，因洪水沖斷鐵橋，在民國103年重建而生。北港溪是孕育笨港文化的母親，鐵橋則像剛強的母親，共同守護著北港人，因而取名「女兒橋」。原隸屬台糖的北港溪鐵橋，建於1909年，由大日本製糖株式會社(北港糖廠)營運。早期用來運送甘蔗原料及肥料，是北港與嘉義之間的重要運輸鐵道。隨著糖業的發展，促進嘉南平原的開發，後來更連接縱貫線進而經營客貨運，直到民國71年停駛為止，共營運了65年，為北港地區居民共同的記憶。");
        image_description.add("        已有百年歷史的北港牛墟，是國內保留最具古農村風貌的傳統市集，每旬日期數字逢3、6、9日開市，深具特色，由於牛墟位在北港溪河床區的北港大橋下，配合水利署河川局動工進行北港溪魅力河川工程，負責管理牛墟的北港農會，從2018年起1年，把牛墟遷移至北港萬有紙廠對面的私人空地。北港文史人士吳登興等人也希望政府能把北港百年牛墟市集列為無形文化資產，永久保存，吳登興指出，目前台灣只剩鹽水、善化和北港三處舊市集，尤其北港牛墟相傳從清代就聚市至今，已演化成深具台灣農村特色的傳統市集，相當珍貴，值得永續長存。");
        image_description.add("        北港水塔(水道頭)，建於昭和5年(民國19年，1930)，已有68年歷史的北港水塔，為鋼筋混凝土建築，以北港溪流為水源，用來改善北港鎮居民的飲水。自來水廠日文稱為「水道」，有取水井、沈澱、過濾、消毒等設備，處理後的水送到每一戶住家的過程，被稱為「水道水」，為當時最完善的設計。水廠辦公室的特殊造型設計，頗具美感。光復後，北港水塔則由北港鎮自來水廠經營，現在合併於台灣省自來水公司。");
        image_description.add("        北港公館里彩繪社區，是北港第一個以3D為主的彩繪社區以可愛的邦尼熊為主角，打造「北港熊幸福」彩繪里主題性很廣，有朝天宮廟宇文化、古埃及、農村、恐龍、海洋世界及復古風等以3D繪畫手法呈現，畫風都蠻可愛的，拍照效果也不錯喔！");
        image_description.add("        北港工藝坊，位於雲林縣北港鎮共和街2號，是北港甕牆的所在地，也是稅務分局舊宿舍地址，在這美麗的地方經常會令人流連忘返，現在它的新名號為「北港工藝坊」，未來將與北港甕牆共存共榮。北港工藝坊是以北港工藝產業為主體的據點，於2013年12月初開館運作，邀請在地工藝師，地方文史工作者以及喜愛歷史人文旅遊的您，一起來參與及體會傳統工藝的美好。\n"+"        甕牆, 為巨商顏東義宅第圍牆一部份，該宅第建於道光年間，於光緒三十一年大地震後修建第宅甕牆被留下一部份。這座甕牆原本是商行「謙源號」的圍牆，是用壓船的酒甕及紅磚砌築而成，商行主人顏謙源將平常壓在船艙的酒甕及紅磚堆砌排列，將酒甕鑲在紅牆中，形成外觀獨特的甕牆，主要是希望後代子孫可以藉由此牆體會先人創業維艱、勤儉持家的精神。");
        image_description.add("        武德宮，創辦人陳茂霖是一位出身雲林縣水林鄉的中醫師；在遷居北港後，他在1955年購得該廟所在土地及店舖經營中醫事業。1961年前後，陳茂霖的妻子之身體健康出現問題；他在遍尋醫療方法而不得其解後開始尋求信仰及宗教上的協助。1963年，陳茂霖在新港東興宮池府千歲出巡行經北港時，獲得乩身扶乩指示其住宅內有「內神」，並指示其虔誠敬奉該神則其妻之問題可獲解決；隨後，陳茂霖依指示在自宅地上設置香爐並早晚虔誠敬奉，他的妻子也在不久後恢復健康。\n" +
                "        1970年前後，陳茂霖經扶乩得知該「內神」的真實身分為玄壇元帥趙公明，且其神尊乃於道光年間由一陳姓信徒自中國大陸迎請攜來，並曾在當地搭有簡易茅舍供人祭拜，又因時空變遷而被掩埋於陳茂霖所有的建築物之下。隨後，陳茂霖遵照扶乩所降指示為其雕塑金身，並於自宅設壇供人膜拜，成為日後武德宮的前身。1978年，陳茂霖考慮到原建物腹地狹窄，而過年或聖誕祭典信徒眾多，於是捐贈土地並邀集親人共同出資興建新廟，並於1980年於現址落成入火安座。\n" +
                "        1981年，主祀神武財公的鸞文開始預示其即將率眾返回其故鄉山東探視。1988年，陳茂霖依循鸞文指示率隊前往山東齊河縣趙官鎮拜訪武財公祖廟所在地，並在返回臺灣後獲武財公岀筆扶鸞指示以北港武德宮作兩岸及華人地區天官武財神開基祖廟。2010年代，北港武德宮成為臺灣地區規模最大的財神廟之一。");
        image_description.add("        北港觀光大橋，位於北港溪下游，連接雲林縣北港鎮與嘉義縣六腳鄉之間的交通。2001年8月正式動工，歷經二年，耗資新臺幣一億五千萬圓興建，於2003年11月完工啟用。主橋長268.5公尺。北引道長96公尺，南引道128公尺。");
        image_description.add("        義民廟，北港義民廟是一座位在臺灣北港的義民爺信仰廟宇。該廟建立並改建於當地群眾協同官府抵抗林爽文事件與戴潮春事件後，以紀念其人為抵禦此類民變而殉難之事跡。 該廟之主要祭典為每年農曆五月三十之義民爺過爐；當日，當地居民將在此舉行盛大祭拜儀式。");

        adapter = new CustomListAdapter3(AttrcationsNearByCVActivity.this, image_title, image_description);
        mListView.setAdapter(adapter);

    }
}

