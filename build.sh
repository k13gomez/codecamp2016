#!/bin/bash
lein do clean, ring uberjar
zip target/build.zip Dockerfile target/codecamp2016.jar
