# Swing App Example

This serves to demonstrate how Java Swing is a viable option for creating cross-platform desktop applications in 2022.

This project brings together several things in order to create a modern looking desktop application that can be
distributed. Installers it generates includes only the necessary files in order for the application to run on another
computer, which can be as small as 50mb. It doesn't require end-users to install (or have installed) the Java runtime
and it does't include the full Java runtime.

This example application includes theming, obfuscation, packaging, and generating the installers.

### Disclaimer

I'm new to Swing and still learning Java although my background is many years as a developer using other languages.
Things may not be implemented as cleanly or optimally as by someone more experienced with this tech.

### Notable Libraries Used

- Themes via FlatLaf ([GitHub](https://github.com/JFormDesigner/FlatLaf))
- Packaging via maven-jpackage-template ([GitHub](https://github.com/wiverson/maven-jpackage-template))
- Proguard obfuscation

### Requirements

- This project requires JDK 17+. Earlier versions will not work.
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) is highly recommended. The free Community Edition should work.
- [JFormDesigner](https://www.formdev.com/jformdesigner/) has been used to create the UI screens. Highly recommended.

### Build Installer Requirements

The following dependencies are needed in order to build installers for distributing an app to others. To fully
understand how Java Swing can be used for creating app, I highly recommend creating an installer and installing the
application.

- Windows: install [WIX](https://wixtoolset.org/)
- Ubuntu-based distros: run: ```sudo apt-get install build-essentials```
- Fedora: run: ```sudo dnf install fedora-packager fedora-review```
- macOS: ??? (I don't own a mac)

### Build Installer For Distribution

Using maven, run **install** (Lifecycle) on the OS you wish to create an installer for.

```shell
mvn clean
mvn install
```

### Screenshots

TBD

### Example/Demo

Just clone this repo and run the main method or build a distributable and install it.

### Pull Requests/Contributing

TBD

### License

MIT