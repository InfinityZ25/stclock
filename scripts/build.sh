#!/bin/sh
./gradlew build && docker build . -t jcedeno/stclock:latest
