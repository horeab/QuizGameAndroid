package com.habapps;

import org.robovm.apple.foundation.NSBundle;

import libgdx.implementations.skelgame.GameIdEnum;


public enum GameProperties {

    geoquiz(
            GameIdEnum.quizgame,
            NSBundle.getMainBundle().getLocalizedString("language","en","InfoPlist"),
            NSBundle.getMainBundle().getLocalizedString("CFBundleDisplayName","en","InfoPlist"),
            "ca-app-pub-9894292627655692~3492378443",
            "ca-app-pub-9894292627655692/1794447109",
            "ca-app-pub-9894292627655692/9535058525",
            "ca-app-pub-9894292627655692/8168283767",
            "1480826003",
            "1480826003"),
    hangman(
            GameIdEnum.hangman,
            NSBundle.getMainBundle().getLocalizedString("language","en","InfoPlist"),
            NSBundle.getMainBundle().getLocalizedString("CFBundleDisplayName","en","InfoPlist"),
            "ca-app-pub-9432399956064043~3884511098",
            "ca-app-pub-9432399956064043/9051161572",
            "ca-app-pub-9432399956064043/5111916566",
            "ca-app-pub-9432399956064043/8945266083",
            "1495590555",
            "1495590555"),

    hangmanarena(GameIdEnum.hangmanarena,
            NSBundle.getMainBundle().getLocalizedString("language","en","InfoPlist"),
            NSBundle.getMainBundle().getLocalizedString("CFBundleDisplayName","en","InfoPlist"),
            "ca-app-pub-9432399956064043~8102577188",
            "ca-app-pub-9432399956064043/9224087161",
            "ca-app-pub-9432399956064043/2028123422",
            "ca-app-pub-9432399956064043/5775796745",
            "1462044086",
            "1462044086"),

    kennstde(
            GameIdEnum.kennstde,
            NSBundle.getMainBundle().getLocalizedString("language","en","InfoPlist"),
            NSBundle.getMainBundle().getLocalizedString("CFBundleDisplayName","en","InfoPlist"),
            "ca-app-pub-9432399956064043~3746870529",
            "ca-app-pub-9432399956064043/6319340774",
            "ca-app-pub-9432399956064043/1067014099",
            "ca-app-pub-9432399956064043/4814687410",
            "1462328494",
            "1462328494"),

    anatomy(
            GameIdEnum.anatomy,
            NSBundle.getMainBundle().getLocalizedString("language","en","InfoPlist"),
            NSBundle.getMainBundle().getLocalizedString("CFBundleDisplayName","en","InfoPlist"),
            "ca-app-pub-9432399956064043~2183898720",
            "ca-app-pub-9432399956064043/3938149317",
            "ca-app-pub-9432399956064043/1892733617",
            "ca-app-pub-9432399956064043/9870817051",
            "1486431352",
            "1486431352"),
    paintings(
            GameIdEnum.paintings,
            NSBundle.getMainBundle().getLocalizedString("language","en","InfoPlist"),
            NSBundle.getMainBundle().getLocalizedString("CFBundleDisplayName","en","InfoPlist"),
            "ca-app-pub-9432399956064043~9668937812",
            "ca-app-pub-9432399956064043/6934963264",
            "ca-app-pub-9432399956064043/7042774478",
            "ca-app-pub-9432399956064043/2876777681",
            "1491886284",
            "1491886284"),
    judetelerom(
            GameIdEnum.judetelerom,
            NSBundle.getMainBundle().getLocalizedString("language","ro","InfoPlist"),
            NSBundle.getMainBundle().getLocalizedString("CFBundleDisplayName","ro","InfoPlist"),
            "ca-app-pub-9432399956064043~9668937812",
            "ca-app-pub-9432399956064043/7175394584",
            "ca-app-pub-9432399956064043/5862312918",
            "ca-app-pub-9432399956064043/7269450277",
            "1492916130",
            "1492916130"),

    conthistory(
            GameIdEnum.conthistory,
            NSBundle.getMainBundle().getLocalizedString("language","en","InfoPlist"),
            NSBundle.getMainBundle().getLocalizedString("CFBundleDisplayName","en","InfoPlist"),
            "ca-app-pub-9432399956064043~6768337490",
            "ca-app-pub-9432399956064043/8244785286",
            "ca-app-pub-9432399956064043/2884647393",
            "ca-app-pub-9432399956064043/1571565723",
            "1497805644",
            "1497805932"),

    astronomy(
            GameIdEnum.astronomy,
            NSBundle.getMainBundle().getLocalizedString("language","en","InfoPlist"),
            NSBundle.getMainBundle().getLocalizedString("CFBundleDisplayName","en","InfoPlist"),
            "ca-app-pub-9432399956064043~6602393911",
            "ca-app-pub-9432399956064043/1266306750",
            "ca-app-pub-9432399956064043/8953225080",
            "ca-app-pub-9432399956064043/6327061745",
            "1501300649",
            "1501301238"),


    periodictable(
            GameIdEnum.periodictable,
            NSBundle.getMainBundle().getLocalizedString("language","en","InfoPlist"),
            NSBundle.getMainBundle().getLocalizedString("CFBundleDisplayName","en","InfoPlist"),
            "ca-app-pub-9432399956064043~6064073956",
            "ca-app-pub-9432399956064043/4228302004",
            "ca-app-pub-9432399956064043/2915220333",
            "ca-app-pub-9432399956064043/3227045672",
            "1507682070",
            "1507682070"),


    flags(
            GameIdEnum.flags,
            NSBundle.getMainBundle().getLocalizedString("language","en","InfoPlist"),
            NSBundle.getMainBundle().getLocalizedString("CFBundleDisplayName","en","InfoPlist"),
            "ca-app-pub-9432399956064043~2525083922",
            "ca-app-pub-9432399956064043/1212002250",
            "ca-app-pub-9432399956064043/7585838911",
            "ca-app-pub-9432399956064043/2333512238",
            "1511413265",
            "1511413265"),;

    private GameIdEnum gameIdEnum;
    private String language;
    private String appName;
    private String adMobAppId;
    private String bannerAdId;
    private String interstitialAdId;
    private String rewardAdId;
    private String storeAppId;
    private String proVersionStoreAppId;

    GameProperties(GameIdEnum gameIdEnum,
                   String language,
                   String appName,
                   String adMobAppId,
                   String bannerAdId,
                   String interstitialAdId,
                   String rewardAdId,
                   String storeAppId,
                   String proVersionStoreAppId) {
        this.gameIdEnum = gameIdEnum;
        this.language = language;
        this.appName = appName;
        this.adMobAppId = adMobAppId;
        this.bannerAdId = bannerAdId;
        this.interstitialAdId = interstitialAdId;
        this.rewardAdId = rewardAdId;
        this.storeAppId = storeAppId;
        this.proVersionStoreAppId = proVersionStoreAppId;
    }

    public GameIdEnum getGameIdEnum() {
        return gameIdEnum;
    }

    public String getLanguage() {
        return language;
    }

    public String getAppName() {
        return appName;
    }

    public String getAdMobAppId() {
        return adMobAppId;
    }

    public String getBannerAdId() {
        return bannerAdId;
    }

    public String getInterstitialAdId() {
        return interstitialAdId;
    }

    public String getRewardAdId() {
        return rewardAdId;
    }

    public String getStoreAppId() {
        return storeAppId;
    }

    public String getProVersionStoreAppId() {
        return proVersionStoreAppId;
    }
}
