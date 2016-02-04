#!/usr/bin/env bash

./gradlew stage
java -DPROD_MODE=false -cp ./build/deps/*:./build/libs/* Main