#!/usr/bin/env bash
./mvnw clean package && cf push spring-boot-cf-app -p target/spring-boot-cf-app-0.0.1-SNAPSHOT.jar