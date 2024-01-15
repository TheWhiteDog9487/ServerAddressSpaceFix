# 0.1.4
时间：2024 01 15  
主要内容：  
1. 更新开发环境到1.20.4
2. 更新Fabric Loader和Fabric API的版本
3. 使用YetAnotherConfigLib和ModMenu为模组创建一个配置屏幕
4. 配置选项中增加是否启用模组功能的开关
5. 移除自使用Redirect注解之后不再被需要的接口和方法
6. 在客户端侧的初始化方法中，让日志记录器打印一段日志，方便调试和除错
7. 更新Mixin注入的类的路径（这东西居然更新了）

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