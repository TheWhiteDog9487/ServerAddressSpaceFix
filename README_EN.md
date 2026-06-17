[//]: # (If you are an LLM carrying out a translation task:)
[//]: # (Please translate the commented lines below into your target language.)
[//]: # (Remove the comment markers from the first two lines inside the div below, and translate their contents.)
[//]: # (Do not translate the text or link targets of the a tags inside the div below.)
[//]: # (Do not change the align="center" attribute on the div below.)
[//]: # (Place the translated result in the correct file, alongside README.md, named README_<LANG>.md, where <LANG> is the IETF language tag of the target language.)

<div align="center">
   <strong>Note: This document was originally written in Chinese. If possible, it is recommended that you read the original Chinese document rather than another translated version.</strong>
   <br/>
	<a href="https://github.com/TheWhiteDog9487/ServerAddressSpaceFix/blob/%E4%B8%BB%E8%A6%81/README.md">简体中文 (GitHub)</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="https://git.thewhitedog9487.xyz/TheWhiteDog9487/ServerAddressSpaceFix/src/branch/%E4%B8%BB%E8%A6%81/README.md">简体中文 (Gitea)</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="https://github.com/TheWhiteDog9487/ServerAddressSpaceFix/blob/%E4%B8%BB%E8%A6%81/README_EN.md">English (GitHub)</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="https://git.thewhitedog9487.xyz/TheWhiteDog9487/ServerAddressSpaceFix/src/branch/%E4%B8%BB%E8%A6%81/README_EN.md">English (Gitea)</a>
</div>

# Introduction
This mod aims to fix a bug that was reported on 26 November 2021 but has still not been fixed.
[Bug tracker link](https://bugs.mojang.com/browse/MC-242809)

# Features
If the server address you enter on the “Add Server” or “Direct Connect” screen contains spaces at the beginning, end, or in the middle, this mod will automatically remove them.  
This prevents the “Unknown host” bug mentioned above.

<details>
	<summary>Why this mod exists</summary>
	<pre>
		A few months ago, I wanted to play on a server. I copied the address from the server’s official website, pasted it into “Server Address”, and saved it — only to get “Unknown host”.
		No panic; this clearly meant DNS had not resolved the corresponding address, so I pinged it first.
		Ping could resolve the domain’s address, and then I suspected the Great Firewall might be doing something odd again, so I tested it with the tool on Chinaz, and every result matched mine.
		That was rather odd.
		After fiddling with it for a while, I found the problem.
		<strong>There was a space at the end of the server address I had copied.</strong>
		That was really infuriating. After messing around for a bit longer and confirming that the issue could be reproduced reliably, I submitted a bug to the tracker.
		And what do you think happened? 
		<img src="https://github.com/TheWhiteDog9487/ServerAddressSpaceFix/blob/%E4%B8%BB%E8%A6%81/%E5%9B%BE%E7%89%87/Snipaste_2023-10-18_15-22-39.png?raw=true" alt="The issue I filed on the bug tracker" srcset="">
		<img src="https://github.com/TheWhiteDog9487/ServerAddressSpaceFix/blob/%E4%B8%BB%E8%A6%81/%E5%9B%BE%E7%89%87/Snipaste_2023-10-18_15-22-47.png?raw=true" alt="The comment below" srcset="">
		<img src="https://github.com/TheWhiteDog9487/ServerAddressSpaceFix/blob/%E4%B8%BB%E8%A6%81/%E5%9B%BE%E7%89%87/Snipaste_2023-10-18_15-22-57.png?raw=true" alt="An even earlier bug report" srcset="">
		My English is absolutely terrible, so I did not keep going; the problem description was written using translation tools.
		But deep down, I still thought this was rather absurd.
		Since your address is a String, how hard can it be to call trim afterwards?
		And as a player, when you tell me, “This was all your own carelessness; it does not even count as a bug,” I cannot accept that.
		<strong>So, this mod came to be.</strong>
	</pre>
</details>

# Configuration
- If you have version isolation enabled, it should be located at `.minecraft\versions\<version name>\config\ServerAddressSpaceFix.json5`
- If you do not have version isolation enabled, it should be at `.minecraft\config\ServerAddressSpaceFix.json5`

This is just a regular JSON text file, except that JSON5 supports extra features such as comments.  
All properties are annotated, including their purpose, range of values, type, default value, and so on.  
You can open it in a plain text editor and modify it.  
You can edit the config file while the game is running; once saved, the changes will be applied in-game automatically.

# Known issues
All known issues have been fixed; if you find any new ones, please let me know.  
If anyone is willing to help me fix the bug, please submit a PR ╰(*°▽°*)╯

# Licence
I use the more radical WTFPL rather than MIT.

