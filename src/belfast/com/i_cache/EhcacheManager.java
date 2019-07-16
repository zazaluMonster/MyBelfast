package com.i_cache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;
import org.springframework.stereotype.Component;

import java.net.URL;

@Component
public class EhcacheManager {
    private static Cache<String,String> cache;

    static {
        final URL myUrl = EhcacheManager.class.getResource("/cache.xml");
        System.out.println(myUrl.getPath());
        XmlConfiguration xmlConfig = new XmlConfiguration(myUrl);
        CacheManager cacheManager = CacheManagerBuilder.newCacheManager(xmlConfig);
        cacheManager.init();
        cache = cacheManager.getCache("myBelfastCache",String.class,String.class);
        cache.put("myBelfast", "主人，我已到达指定地点");
    }

    public static void addCache(String key,String value){
        cache.put(key,value);

    }

    public static String getCacheValue(String cacheKey){
        return cache.get(cacheKey);
    }

    public static boolean contains(String cacheKey){
        if(cache.containsKey(cacheKey)){
            return true;
        }
        return false;
    }

    public static void removeCache(String key){
        if(cache.containsKey(key)){
            cache.remove(key);
        }
    }


}
