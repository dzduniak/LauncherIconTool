Launcher Icon Tool
================

Automatically resize image to approperiate versions of launcher icon drawables.

How to use
----------------

If you use Windows just download [executable](https://github.com/mrpyo/LauncherIconTool/raw/master/LIT.exe), put it in easily accessible place (for example desktop) 
and drag and drop image file onto its icon.


SVG files
----------------

If you are creating your icon using vector editing software, there is better way. 

1. First export your image to **SVG** format.
2. Install [Inkspace](http://www.inkscape.org/en/).
3. Then use following script (you can download it [here](), save it on desktop and drag and drop your svg file on it):

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

It will create icons with all required sizes. This methods avoids creation of artifacts due to filtering when scaling large size raster images.
