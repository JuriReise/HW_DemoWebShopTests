@echo off
echo Освобождение памяти...
wmic process where name="explorer.exe" call setpriority "idle"
echo Готово!
pause
