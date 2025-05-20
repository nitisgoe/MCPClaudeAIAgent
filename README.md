# Project Overview
It is a demo project for basic integration of claude with mcp server. 
MCP server is built on top of Spring Boot and is used to run the claude model locally.
It is a simple project that demonstrates how to set up a MCP server with the necessary dependencies to run the claude model.
It includes the necessary dependencies for the MCP server and web server, as well as a simple configuration file to set up the server.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.5/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.4.5/maven-plugin/build-image.html)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

## System Requirement:
 - java 17 or higher
 - Apache Maven 3.6.3 or later
 - Spring Boot 3.3.x or higher

## Install dependencies
- MCP Server (spring-ai-starter-mcp-server)
- Web (spring-web)
````
        <dependency>
            <groupId>org.springframework.ai</groupId>
            <artifactId>spring-ai-mcp-server-spring-boot-starter</artifactId>
            <version>1.0.0-M6</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
        </dependency>
````

## Running project:
- Build using: ./mvnw clean install
- The above step will create a jar file in the target folder.
- Copy path of the jar file.
- Go to claude configuration file claude_desktop_config.json 
  - settings --> edit configuration or /Library/Application Support/Claude
- paste the below configuration 
```
{
    "mcpServers": {
    "spring-ai-mcp-weather": {
    "command": "java",
    "args": [
    "-Dspring.ai.mcp.server.stdio=true",
    "-jar",
    "/ABSOLUTE/PATH/TO/target/mcp-0.0.1-SNAPSHOT.jar"
    ]
        }
    }
}
```
- Restart the claude desktop app.
- Under tools, you will see 2 weather tools (getWeather and getAlerts)

## How to Use:
- Open Claude desktop app.
- Enter prompt - Tell me alerts in texas
- Claude would use the getAlerts tool to get the alerts in texas 
- Claude format the response in a natural language response

