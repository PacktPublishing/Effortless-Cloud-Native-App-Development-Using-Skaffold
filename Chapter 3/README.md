# About Project

This is a simple Spring Boot application which, when accessed via /states or /state?name=statename REST endpoint show
all or specific Indian states and their capitals. This application uses an in-memory H2 database that inserts rows at
the startup and keeps it in memory.

# About Skaffold

> Skaffold handles the workflow for building, pushing and deploying your application.

# How to start project locally

* Install skaffold
  `brew install skaffold`
* Install Docker Desktop for [Mac](https://www.docker.com/products/docker-desktop) for running kubernetes locally
* Install kubectl (Optional for Docker Desktop)
  `brew install kubectl`

`git clone https://github.com/yrashish/indian-states`

`skaffold dev`

# Demo

[![Demo](https://img.youtube.com/vi/KR8DqxaOGBw/2.jpg)](https://www.youtube.com/watch?v=KR8DqxaOGBw)

