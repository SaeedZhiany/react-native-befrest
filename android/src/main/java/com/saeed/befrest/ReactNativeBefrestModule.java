
package com.saeed.befrest;

import android.support.annotation.Nullable;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import java.util.HashMap;
import java.util.Map;

import rest.bef.Befrest;
import rest.bef.BefrestFactory;

public class ReactNativeBefrestModule extends ReactContextBaseJavaModule {

    static final String EVENT_RECEIVE_PUSH_NOTIFICATION = "receivePushNotification";

    private final ReactApplicationContext reactContext;

    ReactNativeBefrestModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @javax.annotation.Nullable
    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put(EVENT_RECEIVE_PUSH_NOTIFICATION, EVENT_RECEIVE_PUSH_NOTIFICATION);
        return constants;
    }

    @Override
    public String getName() {
        return "ReactNativeBefrest";
    }

    @ReactMethod
    public void setAuth(String auth) {
        BefrestFactory.getInstance(reactContext).setAuth(auth);
    }

    @ReactMethod
    public void setChId(String chId) {
        BefrestFactory.getInstance(reactContext).setChId(chId);
    }

    @ReactMethod
    public void setUId(long uId) {
        BefrestFactory.getInstance(reactContext).setUId(uId);
    }

    @ReactMethod
    public void init(long uId, String auth, String chId) {
        BefrestFactory.getInstance(reactContext).init(uId, auth, chId);
    }

    @ReactMethod
    public void start() {
        BefrestFactory.getInstance(reactContext).start();
    }

    @ReactMethod
    public void stop() {
        BefrestFactory.getInstance(reactContext).stop();
    }

    @ReactMethod
    public void addTopic(String topic) {
        BefrestFactory.getInstance(reactContext).addTopic(topic);
    }

    @ReactMethod
    public void removeTopic(String topic) {
        BefrestFactory.getInstance(reactContext).removeTopic(topic);
    }

    @ReactMethod
    public void getCurrentTopics(Promise promise) {
        try {
            promise.resolve(BefrestFactory.getInstance(reactContext).getCurrentTopics());
        } catch (Exception e){
            promise.reject(new Throwable(e.getMessage()));
        }
    }

    @ReactMethod
    public void refresh(Promise promise) {
        try {
            promise.resolve(BefrestFactory.getInstance(reactContext).refresh());
        } catch (Exception e){
            promise.reject(new Throwable(e.getMessage()));
        }
    }

    @ReactMethod
    public void getSdkVersion(Promise promise) {
        try {
            promise.resolve(BefrestFactory.getInstance(reactContext).getSdkVersion());
        } catch (Exception e){
            promise.reject(new Throwable(e.getMessage()));
        }
    }

    static void emitEventToRN(ReactApplicationContext reactContext, String eventName, @Nullable WritableMap params) {
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }

    static void emitEventToRN(ReactApplicationContext reactContext, String eventName, @Nullable WritableArray params) {
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }
}