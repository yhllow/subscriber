@echo off

pushd %~dp0

java -cp ".\out;.\lib\*" com.ineng.ssr.SSRSubscriber

pause