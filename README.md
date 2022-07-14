# Hotel Management System

## Getting Started

```
    git clone https://github.com/hotel_management.git
```
### Enter that directory and open it VS code editor
```
    cd hotel_management
```

###  Open in Vs Code Editor using the terminal
````
    code .
````
#
##  Here is a guideline to help you get started to write Java code in Visual Studio Code.
#
## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.
## Running the project
<br/>

# `Take Note`
>  When your running your app on machine the server address or the host is `localhost` or `127.0.0.1`. But if connected to any network be sure to use internet address then run the server on a different machine but connected on the same network
>  Always start by running the server first then the client.

## Steps to follow when running the project
- Step 1: 
    ```
  cd project/bin
    ```

- Step 2 (For linux users): 
    ```
    rmiregistry
    ```
- (For windows users):
    ```
    start rmiregistry
    ```
- Step 3: jump out of the bin directory and make sure your in the project directory.
    ```
        cd ..
    ```
  
  

- Step 4: Start the hotel server using the command below
  
```
     java -cp ./bin HotelServer
```

- Step 5 : Then start the HotelClient using the command below
```
    java -cp ./bin HotelClient
```

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## Tech Stack
- Java 