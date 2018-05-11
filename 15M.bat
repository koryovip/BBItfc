@echo off
cd /d %~dp0

set CLASSPATH=.
set CLASSPATH=%CLASSPATH%;.\bin
set CLASSPATH=%CLASSPATH%;.\lib\*

java -Xms32m -Xmx32m -cp %CLASSPATH% apis.All

rem echo END
pause > nul