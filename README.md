
# react-native-befrest

## Getting started

`$ npm install react-native-befrest --save`

### Mostly automatic installation

`$ react-native link react-native-befrest`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-befrest` and add `ReactNativeBefrest.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libReactNativeBefrest.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.saeed.befrest.ReactNativeBefrestPackage;` to the imports at the top of the file
  - Add `new ReactNativeBefrestPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-befrest'
  	project(':react-native-befrest').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-befrest/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-befrest')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `ReactNativeBefrest.sln` in `node_modules/react-native-befrest/windows/ReactNativeBefrest.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Befrest.ReactNativeBefrest;` to the usings at the top of the file
  - Add `new ReactNativeBefrestPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import ReactNativeBefrest from 'react-native-befrest';

// TODO: What to do with the module?
ReactNativeBefrest;
```
  