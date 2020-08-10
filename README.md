# Convert HTML to Accessible PDF

## Development

### Before you start

You'll need to install:

- [Java](https://www.oracle.com/java/technologies/javase-jdk14-downloads.html)
- [Maven](https://maven.apache.org/install.html) (`brew install maven` on OSX)

### Installing dependencies

```sh
mvn install
```

### Building

```sh
mvn package
```

### Running

```
java -jar target/html-to-apdf-1.0.0.jar template.html output.pdf
```