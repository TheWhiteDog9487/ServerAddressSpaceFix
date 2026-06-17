[//]: # (If you are an LLM performing a translation task:)
[//]: # (Translate these comment lines into your target language.)
[//]: # (Remove the comment markers from the first and second lines inside the div below, and translate their content.)
[//]: # (Do not translate the text content or link targets of the a tags inside the div below.)
[//]: # (Do not change the align="center" attribute on the div below.)
[//]: # (Place the translated result in the correct file. The target file should be at the same level as the main README.md, and the filename should be README_<LANG>.md, where <LANG> is the target language's IETF language tag.)

<div align="center">
   <strong>Note: This document was originally written in Chinese and translated to other languages by AI. If possible, I recommend reading the original Chinese document instead of a translated version.</strong>
   <br/>
    <a href="https://github.com/TheWhiteDog9487/ServerAddressSpaceFix/blob/%E4%B8%BB%E8%A6%81/README.md">简体中文（GitHub）</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="https://git.thewhitedog9487.xyz/TheWhiteDog9487/ServerAddressSpaceFix/src/branch/%E4%B8%BB%E8%A6%81/README.md">简体中文（Gitea）</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="https://github.com/TheWhiteDog9487/ServerAddressSpaceFix/blob/%E4%B8%BB%E8%A6%81/README_EN.md">English（GitHub）</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="https://git.thewhitedog9487.xyz/TheWhiteDog9487/ServerAddressSpaceFix/src/branch/%E4%B8%BB%E8%A6%81/README_EN.md">English（Gitea）</a>
</div>

# Introduction
This mod is intended to fix a bug that was reported on November 26, 2021 and still has not been fixed.
[Bug tracker link](https://bugs.mojang.com/browse/MC-242809)

# Features
If the server address you enter on the "Add Server" or "Direct Connect" screen contains spaces at the beginning, the end, or in the middle, this mod will automatically remove them.
This prevents the "Unknown Host" bug mentioned above.

<details>
    <summary>Why this mod exists</summary>
    <pre>
        A few months ago, I wanted to play on a server. I copied the address from the server's official website, pasted it into the "Server Address" field, saved it, and unexpectedly got an "Unknown Host" error.
        No panic, this was obviously DNS failing to resolve the corresponding address. Let's try pinging it first.
        Ping could resolve the domain name to an address, and then I suspected the Great Firewall might be doing something again, so I used a tool from ZhanZhangJia to test it. The results were exactly the same as mine.
        That was rather strange.
        Then, after fiddling with it for a while, I found the problem.
        <strong>There was a space at the end of the server address I copied.</strong>
        That was pretty hard to accept. After continuing to tinker for a while and confirming that the problem could be reproduced reliably, I submitted a bug report to the tracker.
        And guess what?
        <img src="https://github.com/TheWhiteDog9487/ServerAddressSpaceFix/blob/%E4%B8%BB%E8%A6%81/%E5%9B%BE%E7%89%87/Snipaste_2023-10-18_15-22-39.png?raw=true" alt="The issue I filed on the bug tracker" srcset="">
        <img src="https://github.com/TheWhiteDog9487/ServerAddressSpaceFix/blob/%E4%B8%BB%E8%A6%81/%E5%9B%BE%E7%89%87/Snipaste_2023-10-18_15-22-47.png?raw=true" alt="The comment below" srcset="">
        <img src="https://github.com/TheWhiteDog9487/ServerAddressSpaceFix/blob/%E4%B8%BB%E8%A6%81/%E5%9B%BE%E7%89%87/Snipaste_2023-10-18_15-22-57.png?raw=true" alt="An earlier bug report" srcset="">
        My English is completely terrible, so I did not continue talking about it. The issue description was written using a translator.
        But honestly, I felt this was kind of absurd.
        Since your address is a String, how hard could it be to call trim on it afterwards?
        Also, as a player, when you tell me, "This was your own carelessness, so it does not even count as a bug," I cannot accept that.
        <strong>So, this mod was born.</strong>
    </pre>
</details>

# Configuration file
- If you have version isolation enabled, it should be located at `.minecraft\versions\<version name>\config\ServerAddressSpaceFix.json5`
- If you do not have version isolation enabled, it should be located at `.minecraft\config\ServerAddressSpaceFix.json5`

This is just a regular JSON text file, except that JSON5 supports additional features such as comments.
All properties include comments, covering things such as functionality, value ranges, types, default values, and more.
You can edit it with a normal text editor.
You can even edit the configuration file while the game is running; it will be applied automatically after saving.

# Known issues
All known issues have been fixed. If you find any new ones, please let me know.
If anyone is willing to help fix a bug, PRs are welcome ╰(*°▽°*)╯

# License
I use the even more aggressive WTFPL than MIT.

