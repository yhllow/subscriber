@echo off

title obsidian sync

pushd %~dp0

git pull
git add .
git commit -m "obsidian backup"
git push

pause