package com.saeed.befrest;

import android.content.Context;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

import rest.bef.BefrestMessage;
import rest.bef.BefrestPushReceiver;

import static com.saeed.befrest.ReactNativeBefrestModule.EVENT_RECEIVE_PUSH_NOTIFICATION;

public class PushReceiver extends BefrestPushReceiver {
    @Override
    public void onPushReceived(Context context, BefrestMessage[] befrestMessages) {

        final ReactApplicationContext reactContext = new ReactApplicationContext(context);

        WritableArray messages = Arguments.createArray();
        for (BefrestMessage befrestMessage : befrestMessages) {
            WritableMap message = Arguments.createMap();
            message.putString("data", befrestMessage.getData());

            messages.pushMap(message);
        }

        ReactNativeBefrestModule.emitEventToRN(
                reactContext,
                EVENT_RECEIVE_PUSH_NOTIFICATION,
                messages
        );

    }
}
