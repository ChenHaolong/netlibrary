package com.net.chl.okhttplibrary.model;

import java.util.List;

/**
 * Created by Administrator on 2018/3/14.
 */

public class WeatherBean {

    /**
     * shidu : 67%
     * pm25 : 236.0
     * pm10 : 0.0
     * quality : 重度污染
     * wendu : 11
     * ganmao : 老年人及心脏、呼吸系统疾病患者人群应停留在室内，停止户外运动，一般人群减少户外运动
     * yesterday : {"date":"14日星期三","sunrise":"06:30","high":"高温 17.0℃","low":"低温 6.0℃","sunset":"18:19","aqi":257,"fx":"东北风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"}
     * forecast : [{"date":"15日星期四","sunrise":"06:29","high":"高温 10.0℃","low":"低温 -1.0℃","sunset":"18:20","aqi":60,"fx":"东北风","fl":"3-4级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"16日星期五","sunrise":"06:27","high":"高温 9.0℃","low":"低温 0.0℃","sunset":"18:21","aqi":67,"fx":"南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"17日星期六","sunrise":"06:26","high":"高温 10.0℃","low":"低温 -1.0℃","sunset":"18:22","aqi":138,"fx":"西南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"18日星期日","sunrise":"06:24","high":"高温 11.0℃","low":"低温 3.0℃","sunset":"18:23","aqi":99,"fx":"西南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"19日星期一","sunrise":"06:22","high":"高温 10.0℃","low":"低温 3.0℃","sunset":"18:24","aqi":130,"fx":"西风","fl":"<3级","type":"阴","notice":"不要被阴云遮挡住好心情"}]
     */

    private String shidu;
    private double pm25;
    private double pm10;
    private String quality;
    private String wendu;
    private String ganmao;
    private YesterdayBean yesterday;
    private List<ForecastBean> forecast;

    public String getShidu() {
        return shidu;
    }

    public void setShidu(String shidu) {
        this.shidu = shidu;
    }

    public double getPm25() {
        return pm25;
    }

    public void setPm25(double pm25) {
        this.pm25 = pm25;
    }

    public double getPm10() {
        return pm10;
    }

    public void setPm10(double pm10) {
        this.pm10 = pm10;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public YesterdayBean getYesterday() {
        return yesterday;
    }

    public void setYesterday(YesterdayBean yesterday) {
        this.yesterday = yesterday;
    }

    public List<ForecastBean> getForecast() {
        return forecast;
    }

    public void setForecast(List<ForecastBean> forecast) {
        this.forecast = forecast;
    }

    public static class YesterdayBean {
        /**
         * date : 14日星期三
         * sunrise : 06:30
         * high : 高温 17.0℃
         * low : 低温 6.0℃
         * sunset : 18:19
         * aqi : 257.0
         * fx : 东北风
         * fl : <3级
         * type : 多云
         * notice : 阴晴之间，谨防紫外线侵扰
         */

        private String date;
        private String sunrise;
        private String high;
        private String low;
        private String sunset;
        private double aqi;
        private String fx;
        private String fl;
        private String type;
        private String notice;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getHigh() {
            return high;
        }

        public void setHigh(String high) {
            this.high = high;
        }

        public String getLow() {
            return low;
        }

        public void setLow(String low) {
            this.low = low;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public double getAqi() {
            return aqi;
        }

        public void setAqi(double aqi) {
            this.aqi = aqi;
        }

        public String getFx() {
            return fx;
        }

        public void setFx(String fx) {
            this.fx = fx;
        }

        public String getFl() {
            return fl;
        }

        public void setFl(String fl) {
            this.fl = fl;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getNotice() {
            return notice;
        }

        public void setNotice(String notice) {
            this.notice = notice;
        }
    }

    public static class ForecastBean {
        /**
         * date : 15日星期四
         * sunrise : 06:29
         * high : 高温 10.0℃
         * low : 低温 -1.0℃
         * sunset : 18:20
         * aqi : 60.0
         * fx : 东北风
         * fl : 3-4级
         * type : 多云
         * notice : 阴晴之间，谨防紫外线侵扰
         */

        private String date;
        private String sunrise;
        private String high;
        private String low;
        private String sunset;
        private double aqi;
        private String fx;
        private String fl;
        private String type;
        private String notice;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getHigh() {
            return high;
        }

        public void setHigh(String high) {
            this.high = high;
        }

        public String getLow() {
            return low;
        }

        public void setLow(String low) {
            this.low = low;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public double getAqi() {
            return aqi;
        }

        public void setAqi(double aqi) {
            this.aqi = aqi;
        }

        public String getFx() {
            return fx;
        }

        public void setFx(String fx) {
            this.fx = fx;
        }

        public String getFl() {
            return fl;
        }

        public void setFl(String fl) {
            this.fl = fl;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getNotice() {
            return notice;
        }

        public void setNotice(String notice) {
            this.notice = notice;
        }
    }
}
