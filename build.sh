#!/bin/sh
javac -cp "lib/*" \
-d out \
src/com/ineng/utils/*.java \
src/com/ineng/ssr/SSRSubscriber.java
