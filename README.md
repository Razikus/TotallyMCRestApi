# Purpouse
Simplify creating rest api for your Spigot minecraft server.

Basically it allows to create HTTP endpoints for everything you want.

Configuration is simple, plugin is little, and usage is generic.

By default it will embed little HTTP server on port 8888, so you can access endpoints via http://minecraftserverip:8888/endpoint

It supports parameters!


# Installing
Just copy latest release to your plugins folder.

# Usage


# Configuration
config.yml
```
  # Port where server will be listening to
  port: 8888
  # file with endpoints configuration
  calls: calls.json
```

calls.json
```
  [
    {
      "callback": {
        # Points to class that will be used. Some of are build-in, some of are generic. List are included in file.
        "CLASSNAME": "eu.razniewski.totallymcrestapi.defaultCallbacks.PlayersOnlineCallback",
        "DATA": {}
      },
      # Route to endpoint, so it will be accessible via IP:PORT/route
      "route": "/onlinePlayers",
      # Possibilities - GET, DELETE, PUT, POST, 
      "requestType": "GET",
      # If true - only endpoints with ?token=testToken will be avalaible so for example localhost:8888/onlinePlayers?token=testToken
      "tokenEnabled": true,
      # list of tokens that will be good for this endpoint
      "tokens": [
        "testToken"
      ]
    },
    {
      "callback": {
        "CLASSNAME": "eu.razniewski.totallymcrestapi.defaultCallbacks.PlayersNicknamesCallback",
        "DATA": {}
      },
      "route": "/onlinePlayersNickname",
      "requestType": "GET",
      "tokenEnabled": true,
      "tokens": [
        "testToken"
      ]
    },
    {
      "callback": {
        "CLASSNAME": "eu.razniewski.totallymcrestapi.commandCallback.OutputConfigCommandCallback",
        "DATA": {
          # Additional data of that command. {:text} for parameter from request, {%text%} for parameter from additionalParams
          "command": "? {:name}",
          "additionalParams": {}
        }
      },
      "route": "/help/:name",
      "requestType": "GET",
      "tokenEnabled": false,
      "tokens": []
    }
  ]
```

# Security

# Donate

# Building
[![Build Status](https://travis-ci.org/Razikus/TotallyMCRestApi.svg?branch=master)](https://travis-ci.org/Razikus/TotallyMCRestApi)

# Contributing

# To do
- [ ] Reloading plugin
- [ ] More default java endpoints
- [x] Groovy callbacks
