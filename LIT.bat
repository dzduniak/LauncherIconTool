REM Set following path to your Inkscape location:
set INKSCAPE="C:\Program Files (x86)\Inkscape\Inkscape.exe"

%INKSCAPE% -e web_hi_res_512.png -w 512 -h 512 %1

mkdir res\drawable-xxxhdpi
%INKSCAPE% -e res\drawable-xxxhdpi\ic_launcher.png -w 192 -h 192 %1

mkdir res\drawable-xxhdpi
%INKSCAPE% -e res\drawable-xxhdpi\ic_launcher.png -w 144 -h 144 %1

mkdir res\drawable-xhdpi
%INKSCAPE% -e res\drawable-xhdpi\ic_launcher.png -w 96 -h 96 %1

mkdir res\drawable-hdpi
%INKSCAPE% -e res\drawable-hdpi\ic_launcher.png -w 72 -h 72 %1

mkdir res\drawable-mdpi
%INKSCAPE% -e res\drawable-mdpi\ic_launcher.png -w 48 -h 48 %1