# TouchDroid

TouchDroid is an Android app that allows users to remotely control a Windows computer via a local network. It emulates input devices such as touchpad and keyboard. To make this possible, the TouchServer app must be installed and running on the Windows OS. TouchServer acts as a mediator between TouchDroid and the host OS, translating input data into commands that the host OS can understand.

An older version of the application is available via [this repository](https://apt.izzysoft.de/fdroid/index/apk/com.akshayaap.touchdroid) and on the [F-Droid](https://f-droid.org/packages/com.akshayaap.touchdroid) repository.

## Technologies

### Desktop Server Application

- C++
- C#

### Android Application

- Java v17
- Android Studio

## Setup

### For Users

1. Download the zip file from the [TouchServer repository](https://www.github.com/vitaminncpp/TouchServer).
2. Install the TouchDroid APK on your Android device.
3. Extract TouchServer.zip to your preferred location on your Windows PC.
4. Run `UI.exe`.
5. You should now be able to control the server.
6. Open the MouseRemote application on your Android device.
7. The app will automatically connect to the server.
8. There will be a touch area, left and right buttons, and a wheel.

Note: **The mobile device and the server must be on the same network.** For more information, see the [documentation](https://www.github.com/vitaminncpp/Documentation).

## Usage

To use the program:

1. Press `Start` from the desktop GUI to start.
2. Press `Stop` from the desktop GUI to stop.
3. You can now easily control your computer using your Android device as a touchpad.

## Screenshots

Some screenshots of the program:

- ***Under progress***

## Donate

If you find this application useful, you can donate to the developer:

- PayPal: [https://paypal.me/akshayaap](https://paypal.me/akshayaap)
- Bitcoin: [bitcoin:1HhM7vudZU7gmooamWNZG8couZdg1eF1Uw](bitcoin:1HhM7vudZU7gmooamWNZG8couZdg1eF1Uw)

## Contributors

- [Akshay Parmar](https://github.com/vitaminncpp) (@vitaminncpp)
- [Saurav Kumar](https://github.com/SKR301) (@SKR301)
