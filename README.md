This is a Kotlin Multiplatform project targeting Android, iOS.

* [/androidApp](./androidApp/src) is the Android application entry point: the `Activity`,
  the manifest and the launcher icons. It holds no shared code.

* [/sharedLogic](./sharedLogic/src) is for business logic, data and platform abstractions.
  It does **not** depend on Compose, so it compiles and tests without any UI toolchain.

* [/sharedUI](./sharedUI/src) is for the Compose Multiplatform UI shared by both apps.
  It depends on `sharedLogic` and produces the `Shared` framework that the iOS app links against.

  Both shared modules contain the usual source sets:
  - [commonMain](./sharedLogic/src/commonMain/kotlin) is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    the [iosMain](./sharedLogic/src/iosMain/kotlin) folder would be the right place for such calls.

* [/iosApp](./iosApp/iosApp) contains an iOS application. Even if you’re sharing your UI with Compose Multiplatform,
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

* [/build-logic](./build-logic/convention/src/main/kotlin) holds the convention plugins that carry the
  configuration shared by the modules, so each module's build file only declares what is specific to it:
  - `inventario.kmp.library` — SDK levels, JVM target, iOS targets and test wiring for a shared module.
  - `inventario.kmp.compose` — adds Compose Multiplatform on top; only UI modules apply it.
  - `inventario.android.application` — configuration for the Android app module.

### Running the apps

Use the run configurations provided by the run widget in your IDE's toolbar. You can also use these commands and options:

- Android app: `./gradlew :androidApp:assembleDebug`
- iOS app: open the [/iosApp](./iosApp) directory in Xcode and run it from there.

### Running tests

Use the run button in your IDE's editor gutter, or run tests using Gradle tasks:

- Android tests: `./gradlew :sharedLogic:testAndroidHostTest`
- iOS tests: `./gradlew :sharedLogic:iosSimulatorArm64Test`

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
