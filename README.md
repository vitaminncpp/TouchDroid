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

1. Download the [TouchServer](https://github.com/vitaminncpp/TouchServer) repository's zip file.
2. Install the TouchDroid APK on your Android device.
3. Extract the contents of the TouchServer.zip file to your preferred location on your Windows PC.
4. Run the `UI.exe` file.
5. Now, you can control the server using TouchDroid.
6. Open the TouchDroid app on your Android device.
7. The app will connect to the server automatically.
8. You will see a touch area, left and right buttons, and a wheel on the app interface, which you can use to control the Windows computer remotely.

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
