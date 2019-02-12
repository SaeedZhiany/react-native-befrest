
package com.saeed.befrest;

import android.content.Context;
import android.support.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
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
import rest.bef.BefrestMessage;
import rest.bef.BefrestPushReceiver;

public class ReactNativeBefrestModule extends ReactContextBaseJavaModule {

    private static final String EVENT_RECEIVE_PUSH_NOTIFICATION = "receivePushNotification";

    private final ReactApplicationContext reactContext;
    private final DynamicPushReceiver receiver;
    private final Befrest befrestInstance;

    ReactNativeBefrestModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;

        befrestInstance = BefrestFactory.getInstance(reactContext);
        receiver = new DynamicPushReceiver();
        befrestInstance.registerPushReceiver(receiver);
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
        befrestInstance.setAuth(auth);
    }

    @ReactMethod
    public void setChId(String chId) {
        befrestInstance.setChId(chId);
    }

    @ReactMethod
    public void setUId(float uId) {
        befrestInstance.setUId((long) uId);
    }

    @ReactMethod
    public void init(float uId, String auth, String chId) {
        befrestInstance.init((long) uId, auth, chId);
    }

    @ReactMethod
    public void start() {
        befrestInstance.start();
    }

    @ReactMethod
    public void stop() {
        befrestInstance.stop();
    }

    @ReactMethod
    public void addTopic(String topic) {
        befrestInstance.addTopic(topic);
    }

    @ReactMethod
    public void removeTopic(String topic) {
        befrestInstance.removeTopic(topic);
    }

    @ReactMethod
    public void getCurrentTopics(Promise promise) {
        try {
            promise.resolve(befrestInstance.getCurrentTopics());
        } catch (Exception e) {
            promise.reject(new Throwable(e.getMessage()));
        }
    }

    @ReactMethod
    public void refresh(Promise promise) {
        try {
            promise.resolve(befrestInstance.refresh());
        } catch (Exception e) {
            promise.reject(new Throwable(e.getMessage()));
        }
    }

    @ReactMethod
    public void getSdkVersion(Promise promise) {
        try {
            promise.resolve(befrestInstance.getSdkVersion());
        } catch (Exception e) {
            promise.reject(new Throwable(e.getMessage()));
        }
    }

    private void emitEventToRN(ReactApplicationContext reactContext, String eventName, @Nullable WritableMap params) {
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }

    private void emitEventToRN(ReactApplicationContext reactContext, String eventName, @Nullable WritableArray params) {
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }

    @Override
    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        befrestInstance.unregisterPushReceiver(receiver);
    }

    class DynamicPushReceiver extends BefrestPushReceiver {

        @Override
        public void onPushReceived(Context context, BefrestMessage[] befrestMessages) {

            WritableArray messages = Arguments.createArray();
            for (BefrestMessage befrestMessage : befrestMessages) {
                WritableMap message = Arguments.createMap();
                message.putString("data", befrestMessage.getData());

                messages.pushMap(message);
            }

            emitEventToRN(
                    reactContext,
                    EVENT_RECEIVE_PUSH_NOTIFICATION,
                    messages
            );
        }
    }
}