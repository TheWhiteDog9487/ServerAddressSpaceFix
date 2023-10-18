# 介绍
本模组意在修复一个2021年11月26号被报告但一直未修复的Bug  
[漏洞追踪器链接](https://bugs.mojang.com/browse/MC-242809)

# 为什么会有这个模组
前几个月吧，我想玩一个服务器。从那个服务器的官网把地址复制下来，粘贴到“服务器地址”中保存之后，居然出现了“未知的主机”。  
莫慌，这显然是DNS没查找到对应的地址，先Ping一下。  
Ping能找到域名对应的地址，然后我有怀疑是长城又在搞什么，用站长之家的工具测了一下，所有的结果和我的都是一样的啊。  
这就比较奇怪了。  
然后在折腾了一段时间之后，我发现了问题。  
**我复制到的服务器地址的末尾，有一个空格。**  
这就很难绷了啊，再继续折腾了一段时间，确认问题能够稳定复现之后，我去漏洞追踪器提交了一个Bug。  
结果您猜怎么着？  
![漏洞追踪器上提的问题](./图片/Snipaste_2023-10-18_15-22-39.png)  
![下面的评论](./图片/Snipaste_2023-10-18_15-22-47.png)  
![更早的一个问题报告](./图片/Snipaste_2023-10-18_15-22-57.png)  
我英语完全不行，就没继续说下去了，问题描述都是用翻译写的。  
但是吧，我打心里觉得这事多少有点离谱。  
既然你的地址是String类，那在后面调用一下trim方法很难吗？  
而且，我作为一个玩家，你跟我说，“这都是你自己不小心，这根本就不能算是个Bug“，我是不能接受的。  
**所以，有了这个模组。**  

# 已知问题
- 必须在服务器MOTD被加载出来之后，才能使用刷新按钮，不然被弄掉的空格自己又会回来，我也不知道为什么。

如果有谁愿意帮我把Bug修了，欢迎提交PR╰(*°▽°*)╯

# 开源许可
我用的是比MIT更激进的WTFPL