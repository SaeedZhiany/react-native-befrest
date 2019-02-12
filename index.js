import {NativeModules, DeviceEventEmitter} from 'react-native';

const {ReactNativeBefrest} = NativeModules;

const Befrest = {
  init(
    uId: number,
    auth: string,
    chId: string
  ) {
    ReactNativeBefrest.init(uId, auth, chId);
  },
  setUId(
    uId: number
  ) {
    ReactNativeBefrest.setUId(uId);
  },
  setChId(
    chId: number
  ) {
    ReactNativeBefrest.setChId(chId);
  },
  setAuth(
    auth: string
  ) {
    ReactNativeBefrest.setAuth(auth);
  },
  start() {
    ReactNativeBefrest.start();
  },
  stop() {
    ReactNativeBefrest.stop();
  },
  addTopic(
    topic: string
  ) {
    ReactNativeBefrest.addTopic(topic);
  },
  removeTopic(
    topic: string
  ) {
    ReactNativeBefrest.removeTopic(topic);
  },
  getCurrentTopics(): Promise<string[]> {
    return ReactNativeBefrest.getCurrentTopics();
  },
  refresh(): Promise<boolean> {
    return ReactNativeBefrest.refresh();
  },
  getSdkVersion(): Promise<number> {
    return ReactNativeBefrest.getSdkVersion();
  },
  addListener(eventName: string, callBack: BefrestEventCallBack) {
    DeviceEventEmitter.addListener(eventName, callBack);
  },
  removeListener(eventName: string, callBack: BefrestEventCallBack) {
    DeviceEventEmitter.removeListener(eventName, callBack);
  }
};

export default Befrest;

export type BefrestEventCallBack = (messages: BefrestMessage[]) => void;

export interface BefrestMessage {
  data: string;
  timestamp: string,
}
