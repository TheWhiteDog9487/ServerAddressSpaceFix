# 0.1.3
时间：2023 10 28  
主要内容：这玩意好像不具备特定版本兼容性啊，那我直接改兼容性列表以大版本作为兼容性边界得了，1.20全版本通用一个分支和同一个输出。  
按理来说是不太至于出意外的，但如果真出了意外那我们后面再说。

# 0.1.2
时间：2023 10 28  
主要内容：融合由 JustAlittleWolf 提交的PR，修复刷新按钮的问题。
[PR链接](https://github.com/TheWhiteDog9487/ServerAddressSpaceFix/pull/1)  
然后我把trim方法替换成了更加激进的replace，这样就算是地址中间有空格也没问题。
然后fabric.mod.json中的Homepage属性从Github改成了Modrinth  
并且更改了Gradle构造的输出文件名