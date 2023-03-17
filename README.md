# TouchDroid

TouchDroid is an Android application that emulates input devices such as a touchpad and keyboard to control a Windows computer via a local network. A [TouchServer](https://www.github.com/Akshayaap/TouchServer) must be running on the Windows operating system to capture data sent by the application from the network and to register appropriate events to the host operating system.

An older version of the application is available via [this repository](https://apt.izzysoft.de/fdroid/index/apk/com.akshayaap.touchdroid) and the [F-Droid repository](https://f-droid.org/packages/com.akshayaap.touchdroid/).

## Table of Contents

- [Technologies](#technologies)
- [Setup](#setup)
- [Working](#working)
- [Screenshots](#screenshots)
- [Contributors](#contributors)

## Technologies

### For Desktop Server Application

- C++
- C#

### For Android Application

- Java v17
- Android Studio

## Setup

### For Users

1. Download the zip file from the [TouchServer repository](https://www.github.com/vitaminncpp/TouchServer).
2. Install the TouchDroid APK for Android.
3. Extract TouchServer.zip to your desired location on your Windows PC.
4. Run `UI.exe`.
5. You can now control the server.
6. Open the MouseRemote application on Android.
7. The app will connect to the server automatically.
8. There will be a touch area, left and right buttons, and a wheel.

Note: **The mobile and server must be on the same network.** For more information, see the [documentation](https://www.github.com/vitaminncpp/Documentation).

## Working

To use the program:

1. Press `Start` from the desktop GUI to start.
2. Press `Stop` from the desktop GUI to stop.
3. You can then easily control your computer by using your phone as a touchpad.

## Screenshots

Some screenshots of the program:

- *Under progress*

## Donate

[https://paypal.me/akshayaap](https://paypal.me/akshayaap)

Bitcoin: [bitcoin:1HhM7vudZU7gmooamWNZG8couZdg1eF1Uw](bitcoin:1HhM7vudZU7gmooamWNZG8couZdg1eF1Uw)

## Contributors

- [@vitaminncpp](https://github.com/vitaminncpp) - Akshay Parmar
- [@SKR301](https://github.com/SKR301) - Saurav Kumar
