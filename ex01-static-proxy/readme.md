ex01-static-proxy: 静态代理 代理类是手工创建的 代理的目标类是固定的

####实现步骤
    1. 创建一个接口 定义卖u盘的方法 表示你的厂家和商家做的事情
    2. 创建厂家类 实现1步骤的接口
    3. 创建商家 就是代理 也需要实现步骤1的接口
    4. 创建客户端类 调用商家的方法买一个u盘
