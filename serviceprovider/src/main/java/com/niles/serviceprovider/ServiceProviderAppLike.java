package com.niles.serviceprovider;

import com.niles.separate.application.AbsApplicationLike;

import java.util.HashMap;

/**
 * Created by Niles
 * Date 2018/11/26 11:32
 * Email niulinguo@163.com
 */
public class ServiceProviderAppLike extends AbsApplicationLike {

    private static ServiceProviderAppLike sInstance;
    private final HashMap<Class, ServiceProvider> mServiceProviders = new HashMap<>();

    public static ServiceProviderAppLike getInstance() {
        return sInstance;
    }

    public <T extends ServiceProvider> void register(Class<T> clazz, T provider) {
        mServiceProviders.put(clazz, provider);
    }

    public <T extends ServiceProvider> T getServiceProvider(Class<T> clazz) {
        //noinspection unchecked
        return (T) mServiceProviders.get(clazz);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }
}
