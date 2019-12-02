package com.habapps;

import org.robovm.apple.foundation.NSBundle;

import libgdx.implementations.skelgame.GameIdEnum;


public enum GameProperties {

    geoquiz(
            GameIdEnum.quizgame,
            NSBundle.getMainBundle().getLocalizedString("language","en","InfoPlist"),
            NSBundle.getMainBundle().getLocalizedString("CFBundleDisplayName","en","InfoPlist"),
            "ca-app-pub-9432399956064043~7758141729",
            "ca-app-pub-9432399956064043/8792840034",
            "ca-app-pub-9432399956064043/9120637934",
            "ca-app-pub-9432399956064043/7479758360",
            "1480827008",
            "1480827008"),
    hangman(
            GameIdEnum.hangman,
            NSBundle.getMainBundle().getLocalizedString("language","en","InfoPlist"),
            NSBundle.getMainBundle().getLocalizedString("CFBundleDisplayName","en","InfoPlist"),
            "ca-app-pub-9432399956064043~7758141729",
            "ca-app-pub-9432399956064043/8792840034",
            "ca-app-pub-9432399956064043/9120637934",
            "ca-app-pub-9432399956064043/7479758360",
            "1481049289",
            "1481049289"),

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
            "1486431352"),;

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
