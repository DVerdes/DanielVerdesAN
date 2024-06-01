# Getting Started

## First init
```
mvn clean install
```
## Launch database
```
cd *-model
mvn exec:java -Prun_database
```
## Launch backend

We strongly recommend launching the server in debug mode when you are doing active development. To do this, go to the ServerApplication class inside your <code>src/main/java</code> folder.

![Launch in debug](https://i.imgur.com/92VUWTI.gif)

If you are no longer doing active development on the backend (e.g.: you are developing the frontend), you can launch the backend by running the <code>mvn spring-boot:run</code> command. To make sure that you are launching the backend with the source code up to date, you can first run a <code>mvn clean install</code> command.

```
mvn clean install
cd *-boot
mvn spring-boot:run
```
