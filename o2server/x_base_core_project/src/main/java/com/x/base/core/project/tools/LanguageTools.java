package com.x.base.core.project.tools;

import com.x.base.core.project.config.Config;
import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageTools {

    private static Logger logger = LoggerFactory.getLogger(LanguageTools.class);

    private final static String LANGUAGE_PLATFORM = "language.platform";

    public static String getValue(String key) {
        return getValue(key, null);
    }

    public static String getValue(String key, String locale) {
        String message = null;
        if(StringUtils.isBlank(key)){
            return null;
        }
        try {
            ResourceBundle resourceBundle = null;
            if(StringUtils.isBlank(locale)){
                try {
                    locale = Config.person().getLanguage();
                } catch (Exception e) {
                }
            }
            if(StringUtils.isBlank(locale)){
                resourceBundle = ResourceBundle.getBundle(LANGUAGE_PLATFORM, Locale.getDefault());
            }else if("zh".equalsIgnoreCase(locale) || "zh_CN".equalsIgnoreCase(locale)) {
                resourceBundle = ResourceBundle.getBundle(LANGUAGE_PLATFORM, Locale.SIMPLIFIED_CHINESE);
            }else if(locale.toLowerCase().startsWith("en")) {
                resourceBundle = ResourceBundle.getBundle(LANGUAGE_PLATFORM, Locale.ENGLISH);
            }else if("zh_HK".equalsIgnoreCase(locale) || "zh_TW".equalsIgnoreCase(locale)) {
                resourceBundle = ResourceBundle.getBundle(LANGUAGE_PLATFORM, Locale.TRADITIONAL_CHINESE);
            }else{
                resourceBundle = ResourceBundle.getBundle(LANGUAGE_PLATFORM, Locale.getDefault());
            }
            message = resourceBundle.getString(key);
        } catch (Exception e) {
            logger.print("LanguageTools resourceBundle error:"+e.getMessage());
        }

        return message;
    }

    public static String getValue(String baseName ,String key, String locale) {
        String message = null;
        if(StringUtils.isBlank(key)){
            return null;
        }
        try {
            ResourceBundle resourceBundle = null;
            if(StringUtils.isBlank(locale)){
                try {
                    locale = Config.person().getLanguage();
                } catch (Exception e) {
                }
            }
            if(StringUtils.isBlank(locale)){
                resourceBundle = ResourceBundle.getBundle(baseName, Locale.getDefault());
            }else if("zh".equalsIgnoreCase(locale) || "zh_CN".equalsIgnoreCase(locale)) {
                resourceBundle = ResourceBundle.getBundle(baseName, Locale.SIMPLIFIED_CHINESE);
            }else if(locale.toLowerCase().startsWith("en")) {
                resourceBundle = ResourceBundle.getBundle(baseName, Locale.ENGLISH);
            }else if("zh_HK".equalsIgnoreCase(locale) || "zh_TW".equalsIgnoreCase(locale)) {
                resourceBundle = ResourceBundle.getBundle(baseName, Locale.TRADITIONAL_CHINESE);
            }else{
                resourceBundle = ResourceBundle.getBundle(baseName, Locale.getDefault());
            }
            message = resourceBundle.getString(key);
        } catch (Exception e) {
            logger.print("LanguageTools resourceBundle error:"+e.getMessage());
        }

        return message;
    }
}
