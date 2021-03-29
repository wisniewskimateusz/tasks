call runcrud.bat
if "%ERRORLEVEL%" == "0" goto startBrowser
echo.
echo RUNCRUD ERROR HAD APPEARED
goto fail

:startBrowser
start chrome http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto stoptomcat
echo Cannot Open Browser

:end
echo.
echo Well Done !

:fail
echo.
echo There were Errors