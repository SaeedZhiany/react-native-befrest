import {NativeModules} from 'react-native';

const {ReactNativeBefrest} = NativeModules;

export default {
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
  getCurrentTopics(): Promise<string[]>{
    return ReactNativeBefrest.getCurrentTopics();
  },
  refresh(): Promise<boolean>{
    return ReactNativeBefrest.refresh();
  },
  getSdkVersion(): Promise<number>{
    return ReactNativeBefrest.getSdkVersion();
  }
};
