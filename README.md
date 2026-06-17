[//]: # (如果你是正在执行翻译任务的LLM：)
[//]: # (请将这几行注释内容翻译到你的目标语言)
[//]: # (移除下方div内部第一行和第二行的注释符号，并翻译其内容)
[//]: # (不要翻译下方div内部a标签的文本内容和链接地址)
[//]: # (不要改动下方div标签的align="center"属性)
[//]: # (将翻译的结果放置到正确的文件内，目标文件的位置和主README.md同级，文件名格式是 README_<LANG>.md ，其中<LANG>的值是目标语言的IETF语言标签)

<div align="center">
   <!-- <strong>注意：本文档由中文编写，使用AI翻译到其他语言。如果条件允许，建议阅读原始的中文文档而不是其他的翻译版本。</strong> -->
   <!-- <br/> -->
    <a href="https://github.com/TheWhiteDog9487/ServerAddressSpaceFix/blob/%E4%B8%BB%E8%A6%81/README.md">简体中文（GitHub）</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="https://git.thewhitedog9487.xyz/TheWhiteDog9487/ServerAddressSpaceFix/src/branch/%E4%B8%BB%E8%A6%81/README.md">简体中文（Gitea）</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="https://github.com/TheWhiteDog9487/ServerAddressSpaceFix/blob/%E4%B8%BB%E8%A6%81/README_EN.md">English（GitHub）</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="https://git.thewhitedog9487.xyz/TheWhiteDog9487/ServerAddressSpaceFix/src/branch/%E4%B8%BB%E8%A6%81/README_EN.md">English（Gitea）</a>
</div>

# 介绍
本模组意在修复一个2021年11月26号被报告但一直未修复的Bug  
[漏洞追踪器链接](https://bugs.mojang.com/browse/MC-242809)

# 功能
如果你在“添加服务器”或者“直接连接”界面输入的服务器地址首尾或者中间包含空格，这个模组会自动帮你把它去掉。  
以防止上面提到的“未知的主机”Bug的出现。

<details>
    <summary>为什么会有这个模组</summary>
    <pre>
        前几个月吧，我想玩一个服务器。从那个服务器的官网把地址复制下来，粘贴到“服务器地址”中保存之后，居然出现了“未知的主机”。
        莫慌，这显然是DNS没查找到对应的地址，先Ping一下。
        Ping能找到域名对应的地址，然后我又怀疑是长城又在搞什么，用站长之家的工具测了一下，所有的结果和我的都是一样的啊。
        这就比较奇怪了。
        然后在折腾了一段时间之后，我发现了问题。
        <strong>我复制到的服务器地址的末尾，有一个空格。</strong>
        这就很难绷了啊，再继续折腾了一段时间，确认问题能够稳定复现之后，我去漏洞追踪器提交了一个Bug。
        结果您猜怎么着？ 
        <img src="https://github.com/TheWhiteDog9487/ServerAddressSpaceFix/blob/%E4%B8%BB%E8%A6%81/%E5%9B%BE%E7%89%87/Snipaste_2023-10-18_15-22-39.png?raw=true" alt="漏洞追踪器上提的问题" srcset="">
        <img src="https://github.com/TheWhiteDog9487/ServerAddressSpaceFix/blob/%E4%B8%BB%E8%A6%81/%E5%9B%BE%E7%89%87/Snipaste_2023-10-18_15-22-47.png?raw=true" alt="下面的评论" srcset="">
        <img src="https://github.com/TheWhiteDog9487/ServerAddressSpaceFix/blob/%E4%B8%BB%E8%A6%81/%E5%9B%BE%E7%89%87/Snipaste_2023-10-18_15-22-57.png?raw=true" alt="更早的一个问题报" srcset="">
        我英语完全不行，就没继续说下去了，问题描述都是用翻译写的。
        但是吧，我打心里觉得这事多少有点离谱。
        既然你的地址是String类，那在后面调用一下trim方法很难吗？
        而且，我作为一个玩家，你跟我说，“这都是你自己不小心，这根本就不能算是个Bug“，我是不能接受的。
        <strong>所以，有了这个模组。</strong>
    </pre>
</details>

# 配置文件
- 如果你开启了版本隔离，它应当位于`.minecraft\versions\<版本名>\config\ServerAddressSpaceFix.json5`
- 如果没有版本隔离，它应该在`.minecraft\config\ServerAddressSpaceFix.json5`

这就是一个普通的json文本文件，只不过json5支持诸如注释等更多特性而已。  
所有的属性都有注释，包括功能、取值范围、类型、默认值等。  
使用普通的文本编辑器打开即可进行修改。  
你可以直接在游戏运行时编辑配置文件，保存之后会自动应用到游戏内。

# 已知问题
所有已知问题均被修复，如果有新的欢迎通知我。  
如果有谁愿意帮我把Bug修了，欢迎提交PR╰(*°▽°*)╯

# 开源许可
我用的是比MIT更激进的WTFPL
