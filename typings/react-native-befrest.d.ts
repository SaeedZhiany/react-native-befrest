declare module 'react-native-befrest' {

  type EventType = 'receivePushNotification';

  function init(
    uId: number,
    auth: string,
    chId: string
  );

  function setUId(
    uId: number
  );

  function setChId(
    chId: string
  );

  function setAuth(
    auth: string
  );

  function start();

  function stop();

  function addTopic(
    topic: string
  );

  function removeTopic(
    topic: string
  );

  function getCurrentTopics(): Promise<string[]>;

  function refresh(): Promise<boolean>;

  function getSdkVersion(): Promise<number>;

  function addListener(eventName: EventType, callBack: BefrestEventCallBack);

  function removeListener(eventName: EventType, callBack: BefrestEventCallBack);

  export type BefrestEventCallBack = (messages: BefrestMessage[]) => void;

  interface BefrestMessage {
    data: string;
    timestamp: string,
  }
}
